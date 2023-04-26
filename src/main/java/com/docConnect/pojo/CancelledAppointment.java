package com.docConnect.pojo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "CancelledAppointment")
@Component
public class CancelledAppointment {

	@Id
	@Column(name = "appointment_id")
	private int appointmentId;

	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "appointment_id")
    private AppointmentBooking appointment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "cancellation_reason")
    private String cancellationReason;

    @Column(name = "cancelled_date")
    private LocalDateTime cancelledDate;

	public AppointmentBooking getAppointment() {
		return appointment;
	}

	public void setAppointment(AppointmentBooking appointment) {
		this.appointment = appointment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public LocalDateTime getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(LocalDateTime cancelledDate) {
		this.cancelledDate = cancelledDate;
	}

	@Override
	public String toString() {
		return "CancelledAppointment [appointmentId=" + appointmentId + ", appointment=" + appointment + ", doctor="
				+ doctor + ", cancellationReason=" + cancellationReason + ", cancelledDate=" + cancelledDate + "]";
	}

	

	
    // constructors, getters, and setters
    
}
