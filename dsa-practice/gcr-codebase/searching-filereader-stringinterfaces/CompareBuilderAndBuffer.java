import java.util.*;
public class CompareBuilderAndBuffer {
	public static void main(String[] args) {
		StringBuilder sbd = new StringBuilder();
		StringBuffer sbr = new StringBuffer();
		
		long sbdTime = System.nanoTime();
		for(int i = 0; i < 1000000; i++) {
			sbd.append("hello");
		}
		
		System.out.println("Time taken by Builder is : " + (System.nanoTime() - sbdTime));
		
		long sbrTime = System.nanoTime();
		for(int i = 0; i < 1000000; i++) {
			sbr.append("hello");
		}
		
		System.out.println("Time taken by Buffer is : " + (System.nanoTime() - sbrTime));
	}
}
