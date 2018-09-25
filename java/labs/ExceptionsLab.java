package java.labs;


public class ExceptionsLab {
	  public static void main(String[] args) {

	    System.out.println("Today's date is: ");

	    String name= "hey";
	    String course = "Java";
	    int cohort = 2;

	    printName(name);
	    printClass(course, cohort);
	  
	  }

	  private static void printClass(String course, int cohort) {
	    System.out.println("Welcome to " + course + " training");
	    System.out.println("Cohort: " + cohort);
	  }

	  public static String printName(String name) {
	    return ("My name is " + name);
	    
	  }
}