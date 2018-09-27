package playground;

import org.testng.annotations.Test;

import utilities.Data;

import org.testng.annotations.DataProvider;

public class NewAccountExcel {
  @Test(dataProvider = "newAccountData")
  public void test(String firstName, String lastName, String gender, String email, String password,
		  String phoneNumber, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
	  
	  System.out.println(firstName + " " + lastName);
  }

  @DataProvider
  public Object[][] newAccountData() {
    return Data.getExcel("C:\\DealerTrackTraining\\2018\\TestData\\NewAccountData.xlsx");
  }
}
