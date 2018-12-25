package windowHandle;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenLinksOnTabs {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\QAT\\selenium-drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//	Step 1 - Goto the link
		driver.get("https://qaclickacademy.com/practice.php");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//	Step 2 - Limiting Webdriver Scoop
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//	Step 3 - Limiting Webdriver Scoop
		WebElement columnDriver = driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		//	Step 4 - Click on each link and open it in new tab 
		for(int i = 0; i < columnDriver.findElements(By.tagName("a")).size(); i++ ) {
			
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER); // Hold the CTRL key Down
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab); // apply ctrl+click in each link so it opened in seperate tab
			Thread.sleep(2000L);
			
		} // Opens all Links
		
		//	Step 5 - Get titles of each opened links/tabs
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> it = allWindows.iterator();
		
		while(it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
//		driver.switchTo().defaultContent();
		
		
	}

}
