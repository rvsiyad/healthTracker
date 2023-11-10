package dev.rvsiyad.HealthTracker;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import dev.rvsiyad.HealthTracker.model.Role;
// import dev.rvsiyad.HealthTracker.model.Role;
import dev.rvsiyad.HealthTracker.model.User;
import dev.rvsiyad.HealthTracker.repository.RoleRepository;
// import dev.rvsiyad.HealthTracker.repository.RoleRepository;
import dev.rvsiyad.HealthTracker.repository.UserRepository;

@SpringBootApplication
public class HealthTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(HealthTrackerApplication.class, args);
	}

	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository .save(new Role("ADMIN"));
			roleRepository.save(new Role("User"));
			
			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			User admin = new User(1L, "admin", passwordEncoder.encode("password"), "admin123@gmail.com", roles);
			userRepository.save(admin);
		} ;
	}

}
