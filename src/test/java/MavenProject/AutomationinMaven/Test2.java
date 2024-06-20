package MavenProject.AutomationinMaven;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.base.CharMatcher;

// Test Case 2 : To verify if able to enter the list of todos in Textfield and 
//verify the total count of todos to the entered list by the user


public class Test2 {
	 WebDriver driver;
	  Scanner obj = new Scanner(System.in);
	  @Test(priority=0)
	  public void testTextfield() 
	  {
		  System.out.println("Ënter the count of todos planned");
		  int limit = obj.nextInt();
		  String todoslist[] = new String[limit];
		  int Actualtodoscount = todoslist.length;
		  System.out.println("Ënter the todos for the day");
		  for (int i=0;i<Actualtodoscount;i++)
		  {
			  todoslist[i]  = obj.next();
			  WebElement textBox = driver.findElement(By.xpath("//input[@placeholder = 'What needs to be done?']"));
			  textBox.sendKeys(todoslist[i]);
			  textBox.sendKeys(Keys.RETURN);
		  }
		  
		 String textItemscount = driver.findElement(By.xpath("//span [@class='todo-count']")).getText();
		 String ExpectedtodosCount= CharMatcher.digit().retainFrom(textItemscount);
		 Assert.assertEquals(Actualtodoscount, Integer.parseInt(ExpectedtodosCount));
		  System.out.println("Total count matches the entered list by user - Assert passed");
		
		    	  
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  driver  = new EdgeDriver();
		  driver.get("https://todomvc.com/examples/react/dist/#/");
	  }
	  @AfterMethod
	  public void afterMethod() throws InterruptedException {
		 Thread.sleep(3000);
		 driver.quit();
	  }
	  
	  
}
