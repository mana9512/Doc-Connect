package com.docConnect.pojo;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "DoctorAvailability")
@Component
public class DoctorAvailability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "availability_id")
	private int availabilityId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;

	@Column(name = "available_date")
	private Date availableDate;

	@Column(name = "available_time")
	private Time availableTime;

	public int getAvailabilityId() {
		return availabilityId;
	}

	public void setAvailabilityId(int availabilityId) {
		this.availabilityId = availabilityId;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Date getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}

	public Time getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(Time availableTime) {
		this.availableTime = availableTime;
	}

	@Override
	public String toString() {
		return "DoctorAvailability [availabilityId=" + availabilityId + ", doctor=" + doctor.getName()
				+ ", availableDate="
				+ availableDate + ", availableTime=" + availableTime + "]";
	}

	// getters and setters

}
