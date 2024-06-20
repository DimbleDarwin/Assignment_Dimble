package MavenProject.AutomationinMaven;

import java.util.Scanner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Test Case 1: To check the heading of the Application is correct


public class Test1 {
	  WebDriver driver;
	  boolean actual;
	  boolean expected = true;
	  Scanner obj = new Scanner(System.in);
	  @Test(dataProvider = "dp")
	  public void testHeading(String heading) 
	  {
		  
          
		  String expected = heading;
		  String actual = driver.findElement(By.xpath("//header[@class = 'header']/h1")).getText();
		  Assert.assertEquals(actual,expected);
		  System.out.println("Heading is expected - Assert passed");
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  driver  = new EdgeDriver();
		  driver.get("https://todomvc.com/examples/react/dist/#/");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  driver.quit();
	  }
	  
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	       { "todos" },
	    };
	  }
}
