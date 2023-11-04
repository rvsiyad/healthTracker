package dev.rvsiyad.HealthTracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Activity {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long activityId;
	private String exercise;
	private int lenghtOfTime;
	private String intensity;
	@ManyToOne(optional = false)
	private User user;
	
	
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public String getExercise() {
		return exercise;
	}
	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	public int getLenghtOfTime() {
		return lenghtOfTime;
	}
	public void setLenghtOfTime(int lenghtOfTime) {
		this.lenghtOfTime = lenghtOfTime;
	}
	public String getIntensity() {
		return intensity;
	}
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
