package java.basics;

public class Logic {
	
	public static void main(String[] args) {
		
		double temperature = 28.5;
		
		// Exercise: if it's raining, add "Bring an umbrella!")
		boolean rain = true;
		
		// if (temperature >= 25 && rain == true) {
		if (temperature >= 25) {
			System.out.println("Wear t-shirt and shorts");
			if (rain==true) {
				System.out.println("Bring an umbrella");
			}
		}
		else if (temperature >= 10) {
			System.out.println("Wear jeans and long-sleeve shirt");
		}
		else {
			System.out.println("Wear coat");
		}
		
	}

}
