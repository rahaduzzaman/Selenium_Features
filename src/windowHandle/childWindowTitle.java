package windowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class childWindowTitle {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\QAT\\selenium-drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://accounts.google.com/signin/v2/identifier?hl=en&passive=true&continue=https%3A%2F%2Fwww.google.co.in%2F&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

		driver.findElement(By.linkText("Privacy")).click();

		System.out.println("Before Switching");
		System.out.println(driver.getTitle());

		Set<String>ids=driver.getWindowHandles();

		Iterator<String> it=ids.iterator();

		String parentid=it.next();

		String childid=it.next();

		driver.switchTo().window(childid);

		System.out.println("After Switching");

		System.out.println(driver.getTitle());  // Child window title is not getting.

		driver.switchTo().window(parentid);

		System.out.println("Switching Back to Parent");

		System.out.println(driver.getTitle());
		
		
	}
	
}
