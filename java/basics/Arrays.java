package java.basics;

public class Arrays {

	public static void main(String[] args) {
		// Creating a array data structure
		String[] cities = {"New York", "Toronto", "Columbus"};
		
		
		System.out.println("There are " + cities.length + " in the array.");
		
		for (int i=0; i<=2; i++) {
			System.out.println(cities[i]);
		}
		
		cities[0] = "San Francisco";
		System.out.println("");
		for (int i=0; i<cities.length; i++) {
			System.out.println(cities[i]);
		}
		
		cities[2] = "Cleveland";
		System.out.println("");
		for (String city: cities) {
			System.out.println(city);
		}
	}

}
