package model;

import java.time.LocalDate;

public class Visit {

	private int id;
	private int appointmentId;
	private LocalDate visitDate;
	private String diagnosis;
	private String notes;

	public Visit(int appointmentId, LocalDate visitDate, String diagnosis, String notes) {
		this.appointmentId = appointmentId;
		this.visitDate = visitDate;
		this.diagnosis = diagnosis;
		this.notes = notes;
	}

	public Visit(int id, int appointmentId, LocalDate visitDate, String diagnosis, String notes) {
		this(appointmentId, visitDate, diagnosis, notes);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public LocalDate getVisitDate() {
		return visitDate;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public String getNotes() {
		return notes;
	}

	@Override
	public String toString() {
		return "Visit id:" + id + ", Appointment Id:" + appointmentId + ", Visit Date:" + visitDate + ", Diagnosis:"
				+ diagnosis;
	}
}