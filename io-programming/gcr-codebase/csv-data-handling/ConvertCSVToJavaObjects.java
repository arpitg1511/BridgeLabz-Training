import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Student {
	int id;
	String name;
	int age;
	int marks;

	public Student(int id, String name, int age, int marks) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return id + " : " + name + " : " + age + " : " + marks;
	}
}

public class ConvertCSVToJavaObjects {

	public static void main(String[] args) {
		String fileName = "students.csv";
		List<Student> students = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Student s = new Student(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),
						Integer.parseInt(data[3]));
				students.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Student student : students) {
			System.out.println(student);
		}
	}

}
