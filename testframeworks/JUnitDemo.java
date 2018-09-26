package testframeworks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitDemo {
	
	@Before
	public void setUp() {
		// Intializing browser
		// Fetching test data
		System.out.println("Initializing Browser");
		System.out.println("Fetching test data");
	}
	
	@Test
	public void testDemo() {
		System.out.println("Sample test");
		
		// Assertions
		String expectedValue = "success";
		String actualValue = "success";
		Assert.assertEquals(expectedValue, actualValue);
		
		actualValue = "fail";
		// Assert.assertTrue(expectedValue.contains(actualValue));
	}
	
	// Exercise:
	// Implement the after (tearDown) method
	// Write another test

}
