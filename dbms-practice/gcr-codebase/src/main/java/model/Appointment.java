package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

	private int id;
	private int patientId;
	private int doctorId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private String status;

	public Appointment(int patientId, int doctorId, LocalDate appointmentDate, LocalTime appointmentTime,
			String status) {
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
	}

	public Appointment(int id, int patientId, int doctorId, LocalDate appointmentDate, LocalTime appointmentTime,
			String status) {
		this(patientId, doctorId, appointmentDate, appointmentTime, status);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getPatientId() {
		return patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}

	public String getStatus() {
		return status;
	}

	public String toString() {
		return "Appointment ID:" + id + ", Patient Id:" + patientId + ", Doctor Id:" + doctorId + ", Date:"
				+ appointmentDate + ", Time:" + appointmentTime + ", Status='" + status;
	}
}