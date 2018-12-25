package windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\QAT\\selenium-drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		Actions act = new Actions(driver);
		
		//Capture Webelements
		WebElement loginBtn = driver.findElement(By.xpath("//a[contains(@id,'nav-link-accountList')]"));
		WebElement searchBox = driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox')]"));
		
		//Move To Specific Web element
//		act.moveToElement(loginBtn).build().perform();
		act.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		act.moveToElement(loginBtn).contextClick().build().perform();
		
	}

}
