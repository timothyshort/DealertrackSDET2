package java.labs;

/*
 * Write a function that takes a make, model, and year of a car to return
 * a car title. If the car is over 25 years old, it should print “Antique”
 * Example:
 * Make: BMW
 * Model: 323
 * Year: 2012 (if, 1993, it would say "ANTIQUE")
 */

public class CarTitle {
	
	public static void main(String[] args) {
		// Declare & Initialize variables
		// call function
		String make = "BMW";
		String model = "323";
		int year = 2012;
		System.out.println(printTitle(make, model, year));
	}
	
	public static String printTitle(String make, String model, int year) {
		String antique = isAntique(year);
		return("Make: " + make +
				"\nModel: " + model +
				"\nYear: " + year +
				"\n" + antique);
	}
	
	public static String isAntique(int year) {
		if (2018 - year > 25) {
			return "Antique";
		}
		else {
			return "";
		}
	}

}