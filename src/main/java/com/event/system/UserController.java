package com.event.system;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.event.system.user.model.User;
import com.event.system.user.model.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public String userRegistration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public String userRegistration(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {

		User userExists = userService.findUserByUsername(user.getUsername());

		if (userExists != null) {
			bindingResult.rejectValue("username", "error.user",
					"There is already a user registered with the username provided");
		}

		if (bindingResult.hasErrors()) {
			return "registration";
		} else {
			model.addAttribute("successMessage", "User has been registered successfully");
			userRepository.save(user);
			return "registration";
		}
	}

}
