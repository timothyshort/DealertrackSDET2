package java.labs;

public class ArrayExceptions {

	public static void main(String[] args) {
		/* Handle the exception for accessing an array
		 * that it outside the length of the array
		 * Example: array.length=5; array[10]
		 */
		
		int[] numbers = {10, 5, 2, 5};
		printNumbers(numbers);

	}
	
	public static void printNumbers(int[] nums) {
		for (int i=0; i<nums.length+2; i++) {
			System.out.println(nums[i]);
			try {
				System.out.println(nums[i]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Index out of range");
			}
			
		}
	}

}
