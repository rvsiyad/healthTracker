package dev.rvsiyad.HealthTracker.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
//define table as "users", user is a reserved word.
@Table(name="users")
public class User implements UserDetails{
	
	// private static final long serialVersionUID = -5865604812420059449L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long userId;
	private String username;
	private String password;
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "user_role_function",
		joinColumns = {@JoinColumn(name = "user_id")},
		inverseJoinColumns = {@JoinColumn(name="role_id")}
		)
	private Set<Role> authorities;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "health_metrics_id")
	private HealthMetrics healthMetrics;

	public User() {
		super();
		this.authorities = new HashSet<Role>();
	}
	
	public User(String emailAddress, String password) {
		this.email = emailAddress;
		this.password = password;
	}
	
	public User(Long userId, String username, String password, String email, Set<Role> authorities) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.authorities = authorities;
		this.healthMetrics = null;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}

	public HealthMetrics getHealthMetrics() {
		return healthMetrics;
	}

	public void setHealthMetrics(HealthMetrics healthMetrics) {
		this.healthMetrics = healthMetrics;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
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
