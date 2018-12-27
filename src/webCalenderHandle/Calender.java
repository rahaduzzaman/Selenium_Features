package webCalenderHandle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\QAT\\selenium-drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.path2usa.com/travel-companions");
		
		// We gonna select fabruary 28
		String targetMonth = "February";
		String targetdate = "28";
		
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		
		//scope the object
		WebElement parent = driver.findElement(By.xpath("//div[@class='datepicker-days']")); 
		
		//Select the specific Month
		WebElement monthName = parent.findElement(By.className("datepicker-switch"));
		while(!monthName.getText().contains(targetMonth)) {
			System.out.println(monthName.getText());
			parent.findElement(By.className("next")).click();
		}
		/*
		while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
				.contains(targetMonth)) {
			driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		*/
		//Grab the Date specific date
			
		List<WebElement> days = driver.findElements(By.className("day"));
		
		int count = days.size();
//		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String text = parent.findElements(By.xpath("//td[@class='day']")).get(i).getText();
			if (text.equalsIgnoreCase(targetdate)) {
				parent.findElements(By.xpath("//td[@class='day']")).get(i).click();
				break;
			}
		}
		
	}

}
