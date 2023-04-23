package com.docConnect.pojo;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Component
public class AppointmentBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "appointment_date")
    private Date appointmentDate;

    @Column(name = "appointment_time")
    private Time appointmentTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Time getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

//	@Override
	public String toString() {
		return "AppointmentBooking [id=" + id + ", doctor=" + doctor + ", patient=" + patient + ", appointmentDate="
				+ appointmentDate + ", appointmentTime=" + appointmentTime + "]";
	}

    // getters and setters
	
    
}
