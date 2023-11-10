package dev.rvsiyad.HealthTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HealthMetrics {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long healthMetricId;
	private int weight;
	private int height;
	private int age;
	private String gender;

		public HealthMetrics() {
		}

	public HealthMetrics(int weight, int height, int age, String gender) {
		this.weight = weight;
		this.height = height;
		this.age = age;
		this.gender = gender;
	}

	public Long getHealthMetricId() {
		return healthMetricId;
	}

	public void setHealthMetricId(Long healthMetricId) {
		this.healthMetricId = healthMetricId;
	}

	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
}
