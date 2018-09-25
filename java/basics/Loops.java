package java.basics;

public class Loops {

	public static void main(String[] args) {
		
		// print through 5
		int n=0;
		do {
			System.out.println("Iteration for n");
			n=n+1;
		} while (n<5);
		
		// for
		for (int x=1; x<=5; x++) {
			System.out.println("Iteration for x: " + x);
		}
	}

}
