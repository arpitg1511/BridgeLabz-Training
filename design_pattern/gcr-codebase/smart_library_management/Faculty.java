package smart_library_management;

class Faculty implements User {

	@Override
	public String getRole() {
		// TODO Auto-generated method stub
		return "Faculty";
	}

	@Override
	public void notify(Book book) {
		System.out.println("Faculty notified: " + book.getTitle());
	}
}