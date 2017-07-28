package com.event.system;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String eventForm(Model model) {
		
		return "login";
	}

}
