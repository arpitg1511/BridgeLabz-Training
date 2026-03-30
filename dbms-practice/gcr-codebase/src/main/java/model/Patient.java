package model;

import java.time.LocalDate;

public class Patient {
	private int id;
	private String name;
	private LocalDate dob;
	private String contact;
	private String address;
	private String bloodGroup;

	private Patient(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.dob = builder.dob;
		this.contact = builder.contact;
		this.address = builder.address;
		this.bloodGroup = builder.bloodGroup;
	}

	public Patient(int id, String name, LocalDate dob, String contact, String address, String bloodGroup) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.contact = contact;
		this.address = address;
		this.bloodGroup = bloodGroup;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getContact() {
		return contact;
	}

	public String getAddress() {
		return address;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public static class Builder {
		private int id;
		private String name;
		private LocalDate dob;
		private String contact;
		private String address;
		private String bloodGroup;

		public Builder(String name, LocalDate dob, String contact) {
			this.name = name;
			this.dob = dob;
			this.contact = contact;
		}

		public Builder id(int id) {
			this.id = id;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder bloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
			return this;
		}

		public Patient build() {
			if (name == null || dob == null || contact == null) {
				throw new IllegalArgumentException("Name, DOB, Contact cannot be empty");
			}
			return new Patient(this);
		}
	}

	@Override
	public String toString() {
		return "Patient id:	" + id + ", Name: " + name + ", DOB: " + dob + " , Contact number: " + contact
				+ ", Address: " + address + ", Blood Group: " + bloodGroup;
	}

}