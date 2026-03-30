package model;

public class Specialty {
	private int id;
	private String name;

	public Specialty(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Specialty(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}