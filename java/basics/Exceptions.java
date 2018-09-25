package java.basics;

public class Exceptions {

	public static void main(String[] args) {
		System.out.println("Starting program");
		divideNumbers(5,0);
		System.out.println("Closing program");
	}
	
	public static void divideNumbers(int a, int b) {
		System.out.println("Dividing numbers");
		try {
			System.out.println(a/b);
		} catch (ArithmeticException e) {
			System.out.println("Cannot divide by zero!");
		}
	}

}
