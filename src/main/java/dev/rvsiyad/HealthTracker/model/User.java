package dev.rvsiyad.HealthTracker.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;

@Builder
@Entity
//define table as "users", user is a reserved word.
@Table(name="users")
public class User implements UserDetails{
	
	private static final long serialVersionUID = -5865604812420059449L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String username;
	private String password;
	private String email;
	private LocalDate userStartDate;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy= "user")
	private List<HealthMetrics> healthDetails = new ArrayList<>();
	
	public User() {
		
	}
	
	public User(String emailAddress, String password) {
		this.email = emailAddress;
		this.password = password;
	}
	
	public User(Long userId, String username, String password, String email, LocalDate userStartDate,
			List<HealthMetrics> healthDetails, Role role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.userStartDate = userStartDate;
		this.healthDetails = healthDetails;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailAddress() {
		return email;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.email = emailAddress;
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

	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}	
}
