package dev.rvsiyad.HealthTracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rvsiyad.HealthTracker.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
