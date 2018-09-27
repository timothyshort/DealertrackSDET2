package playground;

import org.testng.annotations.Test;

import utilities.Data;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class LoginCSV {
  @Test(dataProvider = "loginTestData")
  public void loginTest(String email, String password) {
	  System.out.println("Email: " + email);
	  System.out.println("Password: " + password);
  }

  @DataProvider
  public ArrayList<String[]> loginTestData() {
    return Data.getCSV("C:\\DealerTrackTraining\\2018\\TestData\\LoginData.txt");
  }
}
