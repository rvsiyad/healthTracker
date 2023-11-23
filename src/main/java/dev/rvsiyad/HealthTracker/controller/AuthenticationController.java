package dev.rvsiyad.HealthTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.rvsiyad.HealthTracker.DTO.LoginResponseDTO;
import dev.rvsiyad.HealthTracker.DTO.RegistrationDTO;
import dev.rvsiyad.HealthTracker.model.User;
import dev.rvsiyad.HealthTracker.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody RegistrationDTO registrationDTO) {
		return authenticationService.registerUser(registrationDTO.getUsername(), registrationDTO.getPassword());
	}
	
	@PostMapping("/login")
	public LoginResponseDTO loginUser(@RequestBody RegistrationDTO registrationDTO) {
		return authenticationService.loginUser(registrationDTO.getUsername(), registrationDTO.getPassword());
	}
}
