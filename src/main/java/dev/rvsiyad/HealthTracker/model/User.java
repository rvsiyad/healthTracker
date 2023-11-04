package dev.rvsiyad.HealthTracker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
//define table as "users", user is a reserved word.
@Table(name="users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String username;
	private String password;
	private String emailAddress;
	private LocalDate userStartDate;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy= "user")
	private List<HealthMetrics> healthDetails = new ArrayList<>();
	
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
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
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public LocalDate getUserStartDate() {
		return userStartDate;
	}
	
	public void setUserStartDate(LocalDate userStartDate) {
		this.userStartDate = userStartDate;
	}
	
	public List<HealthMetrics> getHealthDetails() {
		return healthDetails;
	}
	
	public void setHealthDetails(List<HealthMetrics> healthDetails) {
		this.healthDetails = healthDetails;
	}	
}
