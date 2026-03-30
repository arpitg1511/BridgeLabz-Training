package model;

public class Doctor {
	private int id;
	private String name;
	private int specialtyId;
	private String contact;
	private double consultationFee;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getSpecialtyId() {
		return specialtyId;
	}

	public String getContact() {
		return contact;
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	private Doctor(DoctorBulder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.specialtyId = builder.specialtyId;
		this.contact = builder.contact;
		this.consultationFee = builder.consultationFee;
	}

	public Doctor(int id, String name, int specialtyId, String contact, double consultationFee) {
		this.id = id;
		this.name = name;
		this.specialtyId = specialtyId;
		this.consultationFee = consultationFee;
		this.contact = contact;
	}

	public static class DoctorBulder {
		private int id;
		private String name;
		private int specialtyId;
		private String contact;
		private double consultationFee;

		public DoctorBulder(String name, String contact, double consultationFee) {
			this.name = name;
			this.consultationFee = consultationFee;
			this.contact = contact;
		}

		public DoctorBulder setId(int id) {
			this.id = id;
			return this;
		}

		public DoctorBulder setSepcialtyId(int specialtyId) {
			this.specialtyId = specialtyId;
			return this;
		}

		public Doctor build() {
			if (name == null || consultationFee == 0 || contact == null) {
				throw new IllegalArgumentException("Name, DOB, Contact cannot be empty");
			}
			return new Doctor(this);
		}
	}

	@Override
	public String toString() {
		return "Doctor ID: " + id + ", Name: " + name + ", Consultation Fee: " + consultationFee;
	}
}