package com.cybage.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedback_id;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private Users user;
	
	@NotNull
	@NotEmpty(message = "Feedback should not empty")
	private String feedbackDetails;
	
	@NotNull
	private int rating;

	public Feedback() {
		super();
	}

	public Feedback(int feedback_id, Users user,
			@NotNull @NotEmpty(message = "Feedback should not empty") String feedbackDetails, @NotNull int rating) {
		super();
		this.feedback_id = feedback_id;
		this.user = user;
		this.feedbackDetails = feedbackDetails;
		this.rating = rating;
	}

	public int getFeedback_id() {
		return feedback_id;
	}

	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getFeedbackDetails() {
		return feedbackDetails;
	}

	public void setFeedbackDetails(String feedbackDetails) {
		this.feedbackDetails = feedbackDetails;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Feedback [feedback_id=" + feedback_id + ", user=" + user + ", feedbackDetails=" + feedbackDetails
				+ ", rating=" + rating + "]";
	}
	
	

}
