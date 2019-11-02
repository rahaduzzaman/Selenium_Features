package sauceLabsTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsTest {
//	https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
//	https://wiki.saucelabs.com/display/DOCS/Getting+Started+with+Selenium+for+Automated+Website+Testing
	
	public static final String USERNAME = "rahad";
	public static final String ACCESS_KEY = "c3dc3187-bb3d-4023-985f-f5438d529741";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
//		MutableCapabilities sauceOptions = new MutableCapabilities();
//
//		ChromeOptions browserOptions = new ChromeOptions();
//		browserOptions.setExperimentalOption("w3c", true);
//		browserOptions.setCapability("platformName", "Windows 7");
//		browserOptions.setCapability("browserVersion", "51.0");
//		browserOptions.setCapability("sauce:options", sauceOptions);
		
		DesiredCapabilities caps = DesiredCapabilities.chrome();

		caps.setCapability("platform", "Windows 7");

		caps.setCapability("version", "51.0");
		
//		Create the WebDriver Instance
		WebDriver driver = new RemoteWebDriver(new URL(URL),caps);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
	}

}
