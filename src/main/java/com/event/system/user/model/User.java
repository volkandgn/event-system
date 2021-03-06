package com.event.system.user.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import com.event.system.Event;




@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;
	@NotNull
	@NotEmpty(message = "*Please provide an username")
	private String username;
	@NotNull
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	private String password;
//	@NotNull
	private String role;
	private String name;
	private String surname;
	private Long identityNumber;
	@NotEmpty(message = "*Please provide an email")
	private String email;
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@Temporal(TemporalType.DATE)
	private Date entryDate;
	@Temporal(TemporalType.DATE)
	private Date exitDate;
	
//	@ManyToOne
//	@JoinColumn(name="departmentId")
//	private Department department;
	
//	@ManyToMany(mappedBy = "tags")
//	private Set<Event> posts = new HashSet<>();
//	
//	
//	public Set<Event> getPosts() {
//		return posts;
//	}
//	public void setPosts(Set<Event> posts) {
//		this.posts = posts;
//	}
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="registeredUser")
	private Set<Event> registeredEvent;
	
	@OneToMany(mappedBy="createdBy")
	private Set<Event> event;
	
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private Set<Role> roles;
	
	
	
	
	public Set<Event> getRegisteredEvent() {
		return registeredEvent;
	}
	public Set<Event> getEvent() {
		return event;
	}
	public void setEvent(Set<Event> event) {
		this.event = event;
	}
	public void setRegisteredEvent(Set<Event> registeredEvent) {
		this.registeredEvent = registeredEvent;
	}
	
	public User(String username,String password) {
		super();
		this.username = username;
		this.password = password;
//		this.role = role;
	}
	public User(String name,String surname,Long identityNumber,String email,Date birthDate) {
		super();
		this.name = name;
		this.surname = surname;
		this.identityNumber = identityNumber;
		this.email = email;
		this.birthDate = birthDate;
	}
	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(Long identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}