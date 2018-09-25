package java.basics;

public class Functions {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 25;
		
		// addNumbers(a, b);
		int sum = addTwoNumbers(a, b);
		System.out.println(sum);
	}
	
	public static int addTwoNumbers(int num1, int num2) {
		System.out.println("This function will add two numbers and return the sum");
		int sum = num1 + num2;
		return sum;
	}
	
	public static void addNumbers(int num1, int num2) {
		System.out.println("This function will add two numbers");
		int sum = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + sum);
	}

}
