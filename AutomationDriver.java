package assignment;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AutomationDriver {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Documents\\Qualitest download thing\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php ");
		AutomationDriver.exercise1(driver);
		AutomationDriver.exercise2(driver);
		AutomationDriver.exercise3(driver);
		AutomationDriver.exercise4(driver);
		AutomationDriver.exerciseFourPointOne(driver);
		AutomationDriver.exerciseFourPointTwo(driver);
		AutomationDriver.exercise5(driver);
		AutomationDriver.exercise6(driver);
		AutomationDriver.exercise7(driver);
		AutomationDriver.exercise8(driver);
		AutomationDriver.exercise9(driver);
    }

	public static void exercise1(WebDriver driver) throws InterruptedException 
	{
		//Selecting the “Radio1” radio button
		driver.findElement(By.xpath("//input[@value='radio1']")).click();//1st radio button clicked
		Thread.sleep(500);
		System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());//verifing whether radiobutton1 is selected or not
		Assert.assertTrue(true);
				
		//Selecting the “Radio2” radio button
		driver.findElement(By.xpath("//input[@value='radio2']")).click();//2nd radio button clicked
		Thread.sleep(500);
		System.out.println(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());//verifing whether radiobutton2 is selected or not
		Assert.assertTrue(true);
				
		//Selecting the “Radio3” radio button
		driver.findElement(By.xpath("//input[@value='radio3']")).click();//3rd radio button clicked
		Thread.sleep(500);
		System.out.println(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());//verifing whether radiobutton3 is selected or not
		Assert.assertTrue(true);
	}
	public static void exercise2(WebDriver driver) throws InterruptedException
	{
		// Typing “United States” in the “Select Countries” input field in the “Suggestions Class” example.
			driver.findElement(By.id("autocomplete")).sendKeys("United States");
			Thread.sleep(2000L);
			Actions a=new Actions(driver);
			//Navigating to the “United States Minor Outlying Islands” item and clicking it. 
			a.moveToElement(driver.findElement(By.xpath("//div[text()='United States Minor Outlying Islands']"))).build().perform();
			Thread.sleep(1000L);
			List<WebElement> options =driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
			for(WebElement option:options)
			   {
					if(option.getText().equalsIgnoreCase("United States Minor Outlying Islands"))
					{
						option.click();
						Thread.sleep(1000L);
						break;
					}
				}
	}
	public static void exercise3(WebDriver driver) throws InterruptedException 
	{
		// Clicking the dropdown pane 
		driver.findElement(By.id("dropdown-class-example")).click();
		// Click on “Option1” 
		WebElement staticdropdown=driver.findElement(By.id("dropdown-class-example"));//object creation
		Select dropdown=new Select(staticdropdown);
		dropdown.selectByIndex(1);
	    Thread.sleep(1000L);
		//Verifing “Option1” is now the selected item in the dropdown pane
		System.out.println(dropdown.getFirstSelectedOption().getText());
				
				
		dropdown.selectByIndex(2);//// Click on “Option2”
	    Thread.sleep(1000L);
		//Verify “Option2” is now the selected item in the dropdown pane
		System.out.println(dropdown.getFirstSelectedOption().getText());
				
		dropdown.selectByIndex(3);// Click on “Option3”
		Thread.sleep(1000L);
		//Verify “Option3” is now the selected item in the dropdown pane
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}
	public static void exercise4(WebDriver driver) throws InterruptedException
	{
		// Clicking the checkbox “Option1” in the “Checkbox Example” 
		driver.findElement(By.id("checkBoxOption1")).click();
		Thread.sleep(1000L);
		//verify option1  checked off.
		System.out.println(	driver.findElement(By.id("checkBoxOption1")).isSelected());//it display the  check box1 is checked
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());//it verifies its true or false
				
		//Deselect “Option1” 
		driver.findElement(By.id("checkBoxOption1")).click();
		Thread.sleep(1000L);
		//verify option1  is unchecked.
		System.out.println(	driver.findElement(By.id("checkBoxOption1")).isSelected());//it display the  check box1 is unchecked
				
		// Clicking the checkbox “Option2” in the “Checkbox Example” 
		driver.findElement(By.id("checkBoxOption2")).click();
		Thread.sleep(1000L);
		//verify option1  checked off.
		System.out.println(	driver.findElement(By.id("checkBoxOption2")).isSelected());//it display the  check box2 is checked
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption2")).isSelected());//it verifies its true or false
						
		//Deselect “Option2” 
		driver.findElement(By.id("checkBoxOption2")).click();
		Thread.sleep(1000L);
		//verify option2  is unchecked.
		System.out.println(	driver.findElement(By.id("checkBoxOption2")).isSelected());//it display the  check box2 is unchecked
				
		// Clicking the checkbox “Option3” in the “Checkbox Example” 
		driver.findElement(By.id("checkBoxOption3")).click();
		Thread.sleep(1000L);
		//verify option3  checked off.
		System.out.println(	driver.findElement(By.id("checkBoxOption3")).isSelected());//it display the  check box3 is checked
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption3")).isSelected());//it verifies its true or false
						
		//Deselect “Option3” 
		driver.findElement(By.id("checkBoxOption3")).click();
		Thread.sleep(500L);
		//verify option3  is unchecked.
		System.out.println(	driver.findElement(By.id("checkBoxOption3")).isSelected());//it display the  check box3 is unchecked
	}
	public static void exerciseFourPointOne(WebDriver driver) throws InterruptedException
	{
		//Select all of the checkboxes and verify that all the checkboxes have been selected.
		//selecting all the check box
		List<WebElement>Checkboxes=driver.findElements(By.cssSelector("input[type='checkbox']"));
		int i;
		int size=Checkboxes.size();
		for( i=0;i<size;i++)
			{
				Checkboxes.get(i).click();
				Thread.sleep(200L);
				 System.out.println(Checkboxes.get(i).isSelected());//verifing  all the checkboxes have been selected.
			}
		        Assert.assertTrue(true);
	}
	public static void exerciseFourPointTwo(WebDriver driver) throws InterruptedException 
	{
		 //Deselect all the checkboxes
		List<WebElement>Checkboxes=driver.findElements(By.cssSelector("input[type='checkbox']"));
		int i;
		int size=Checkboxes.size();
        for( i=0;i<size;i++)
		{
        	Thread.sleep(200L);
			Checkboxes.get(i).click();
		    System.out.println(Checkboxes.get(i).isSelected());
		}
        Assert.assertTrue(true);
	}
	public static void exercise5(WebDriver driver) throws InterruptedException
	{
		// Clicking on the “Open Window” button 
		// Clicking on the “Open Window” button 
				driver.findElement(By.id("openwindow")).click();//parent to child
				//logic to fetch the driver scope to child id/
				Set<String> windows = driver.getWindowHandles(); //[parentid,childid]
				//iterator is the method which will fetch all the ids of parent and child window/
				Iterator<String>it = windows.iterator();
				//calling with the iterator object which will grab parent id/
				String parentId = it.next();
				//calling with the iterator object which will grab child id/
				String childId = it.next();
				driver.switchTo().window(childId);//switch to child window
				System.out.println(driver.getTitle());//Verifing that the child window has popped up on the screen
				 Thread.sleep(500l);
				driver.close();
				driver.switchTo().window(parentId);//switch back to origninal window
				Thread.sleep(1000L);
				System.out.println(driver.getTitle());//Verifing that the orginal window has popped up on the screen
	}
	public static void exercise6(WebDriver driver) throws InterruptedException
	{
		//Clicking on the “Open Tab” button.
		driver.findElement(By.id("opentab")).click();
		Set<String> window = driver.getWindowHandles(); //[parentid,childid,subchildId] it grab the id in the all window opened
		Iterator<String>it = window.iterator();// access the ids
		String parentId = it.next();//grab the ids
		String childId = it.next();
		driver.switchTo().window(childId);//switch to child window
		System.out.println(driver.getTitle());
		Thread.sleep(2000L);
		driver.close();
		Thread.sleep(1000L);
		driver.switchTo().window(parentId);//switch to parent window
		System.out.println(driver.getTitle());
	}
	public static void exercise7(WebDriver driver) throws InterruptedException
	{
		//Entering the name in enter your name field
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("name")).sendKeys("Kushalappa");
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();//clicking on alert button
		Thread.sleep(1000L);
		System.out.println(driver.switchTo().alert().getText());//verifing arrert message is displayed or not
		driver.switchTo().alert().accept();//clicking on ok button that is alert message
		Thread.sleep(1000L);
	}
	public static void exercise8(WebDriver driver) throws InterruptedException
	{
		//Scrolling down the page until the “Web Table” is visible.
		JavascriptExecutor js =(JavascriptExecutor)driver;//creating javascriptExecutor object to tell selinium to run java code
		js.executeScript("window.scrollBy(0,600)");//movement of window
		Thread.sleep(500);
		//Verify that  row in the table contains content
		WebElement table=driver.findElement(By.id("product"));
		List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());
		Thread.sleep(1000L);
	}
	public static void exercise9(WebDriver driver) throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(500L);
	    js.executeScript("window.scrollBy(0,500)");
	    Thread.sleep(2000L);
		Actions a=new Actions(driver);// we have to create a class
		a.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).build().perform();
		Thread.sleep(1000L);
		a.moveToElement(driver.findElement(By.tagName("a"))).build().perform();
		Thread.sleep(1000L);
		a.moveToElement(driver.findElement(By.tagName("a"))).click().build().perform();
	}
	
	
}
