package dev.rvsiyad.HealthTracker.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.rvsiyad.HealthTracker.model.Role;
import dev.rvsiyad.HealthTracker.model.User;
import dev.rvsiyad.HealthTracker.repository.RoleRepository;
import dev.rvsiyad.HealthTracker.repository.UserRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthenticationService {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public User registerUser(String username, String password) {
    String encodedPassword = passwordEncoder.encode(password);
    Role userRole = roleRepository.findByAuthority("USER").get();

    Set<Role> authorities = new HashSet<>();
    authorities.add(userRole);

    return userRepository.save(new User(1l, username, password, encodedPassword, authorities));
  }


  
}
