package com.docConnect.pojo;

import java.util.Set;
import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Patient")
@Component
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "age")
	private int age;

	@Column(name = "gender")
	private String gender;

	@OneToMany(mappedBy = "patient")
	private Set<AppointmentBooking> appointments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<AppointmentBooking> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<AppointmentBooking> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", age=" + age
				+ ", gender=" + gender + "]";
	}

}
