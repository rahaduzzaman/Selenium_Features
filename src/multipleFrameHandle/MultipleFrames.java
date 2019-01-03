package multipleFrameHandle;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\QAT\\selenium-drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/recaptcha/api2/demo");
		
		int fnumber = findFrameNumber(driver, By.xpath("//*[@id=\"recaptcha-anchor\"]/div[5]"));
		driver.switchTo().frame(fnumber);
		driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[5]")).click();
		
	}
	
	public static int findFrameNumber(WebDriver driver, By by) {
		int i;
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		
		for(i=0; i<frameCount; i++) {
			
			driver.switchTo().frame(i);
			int count = driver.findElements(by).size();
			
			if(count>0) {
				break;
			} else {
				System.out.println("Continue Looping");
			}
		}
		driver.switchTo().defaultContent();
		return i;
		
	}
}
