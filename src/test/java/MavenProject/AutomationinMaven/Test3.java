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
import org.testng.annotations.Test;

import com.google.common.base.CharMatcher;

//Test Case 3 : Locate the checkbox element
//Check if the checkbox is Selected or Not
//Select or Deselect a Checkbox
//Test Case 4: Validate the click actions "All,Active,Complted,Clear completed"
//Chcek if able to delete Checkbox

public class Test3 {
	 WebDriver driver;
	 int actualTodoscount;
	 boolean condition = false;
	  Scanner obj = new Scanner(System.in);
	  @Test(priority=0)
	  public void testCheckbox() throws InterruptedException 
	  {
		  driver  = new EdgeDriver();
		  driver.get("https://todomvc.com/examples/react/dist/#/");
		  System.out.println("Ënter the limit");
		  int limit = obj.nextInt();
		  String todoslist[] = new String[limit];
		  actualTodoscount = todoslist.length;
		  System.out.println("Ënter the todos list");
		  for (int i=0;i<actualTodoscount;i++)
		  {
			  todoslist[i]  = obj.next();
			  WebElement textBox = driver.findElement(By.xpath("//input[@placeholder = 'What needs to be done?']"));
			  textBox.sendKeys(todoslist[i]);
			  textBox.sendKeys(Keys.RETURN);
		  }
		  String itemscountLeft = driver.findElement(By.xpath("//span [@class='todo-count']")).getText();
		  String expectedTodosCount =  ExpectedTodoscount(itemscountLeft);
		 Assert.assertEquals(actualTodoscount, Integer.parseInt(expectedTodosCount));
		  System.out.println("Total count matches the entered list by user - Assert passed");
		WebElement checkbox = driver.findElement(By.xpath("//input[@data-testid = 'todo-item-toggle']"));	
		 checkbox.click();  
		  Assert.assertEquals(true, checkbox.isSelected());
		  System.out.println("Checkbox is selected – Assert passed");
		  Thread.sleep(3000);
		  checkbox.click();  
		  Assert.assertEquals(false, checkbox.isSelected()); 
		  System.out.println("Checkbox is not selected – Assert passed");
		  Thread.sleep(1000);                                             //Validate the click actions "All,Active,Compelted,Clear completed"
		  driver.findElement(By.xpath("//a[@href= '#/completed']")).click(); //Compelted
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[@href= '#/active']")).click(); //Active
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//a[@href= '#/']")).click(); //All
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[@class= 'clear-completed']")).click(); // Clear completed
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[@data-testid = 'todo-item-button']")).click(); //Chcek if able to delete Checkbox
		  
		  if (Integer.parseInt(expectedTodosCount) < actualTodoscount ) {
			  condition =true;
			}
		  Assert.assertTrue(condition, "Actual count is less than total count - Assert passed");
	  }
	    
	  @Test
	  public String ExpectedTodoscount(String expectedCount) {
 String expectedTodosCount= CharMatcher.digit().retainFrom(expectedCount);
 return expectedTodosCount;
	  }
	 
}
