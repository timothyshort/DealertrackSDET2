package java.labs;

/*
 * Write a function that takes an array of numbers less than 10,
 * then for each number, count to 10.
 * Example:
 * [6,8] should print 7,8,9 and 9
 */
public class Counting {

	public static void main(String[] args) {
		int[] numbers = {6, 8, 2};
		printNumbersThrough10(numbers);
	}
	
	public static void printNumbersThrough10(int[] numbers) {
		// Iterate through the data set
		System.out.println("There are " + numbers.length + " values in the array");
		
		for (int n : numbers) {
			System.out.println("");
			for (int i=n+1; i<10; i++) {
				System.out.println(i);
			}
		}
	}

}
