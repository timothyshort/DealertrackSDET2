package testframeworks;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class SampleTest {
  @Test(dataProvider = "dp")
  public void parameterizedTest(String email, String password) {
	  System.out.println("Executing TestNG test with DataProvider");
	  System.out.println("EMAIL: " + email);
	  System.out.println("PASSWORD: " + password);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "tim@testemail.com", "password" },
      new Object[] { "badmeail@mail.com", "badpassword" },
    };
  }
}
