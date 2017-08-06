package com.event.system;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;


import org.springframework.format.annotation.DateTimeFormat;

import com.event.system.user.model.User;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="event_id")
	private Long eventId;
	private String eventName;
	private String description;
	private String shortDescription;
	private String location;
	private Long guestLimit;
	private String paidOrFree;
	private String eventType;
	private double price;
	



	// @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	@Temporal(TemporalType.DATE)
	private Date eventDate;

	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	private Date startHour;
	
//	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL
////        {
////                
////                CascadeType.PERSIST
////        }
//			)
//	@JoinTable(name = "event_user", joinColumns = @JoinColumn(name = "event_id",updatable = false), inverseJoinColumns = @JoinColumn(name = "user_id",updatable = false))
//	private Set<User> registeredUser;

	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private Set<User> registeredUser;
	
	@ManyToOne
	private User createdBy;
	

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Set<User> getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(Set<User> registeredUser) {
		this.registeredUser = registeredUser;
	}
	


	public Date getStartHour() {
		return startHour;
	}

	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}

	public Long getGuestLimit() {
		return guestLimit;
	}

	public void setGuestLimit(Long guestLimit) {
		this.guestLimit = guestLimit;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getPaidOrFree() {
		return paidOrFree;
	}

	public void setPaidOrFree(String paidOrFree) {
		this.paidOrFree = paidOrFree;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
