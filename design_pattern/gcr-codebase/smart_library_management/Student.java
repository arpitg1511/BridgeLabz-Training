package smart_library_management;


public class Student implements User {

	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "Student";
	}

	@Override
	public void notify(Book book) {
		System.out.println("Student notified: " + book.getTitle());
	}

}