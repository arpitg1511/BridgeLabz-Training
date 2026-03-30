
class CstException extends Exception{
	
	public CstException(String msg) {
		super(msg);
	}
	
	
}

public class CustomException {
	public static void main(String[] args) {
		
		try {
			throw new CstException("This is a custom Exception");
		} catch (CstException e) {
			System.out.println(e);
		} finally {
			System.out.println("Finally block executed");
		}
	}
}
