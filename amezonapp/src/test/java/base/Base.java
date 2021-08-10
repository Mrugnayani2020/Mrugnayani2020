package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public static WebDriver openChromebrowser()
	{
		System.setProperty("webdriver.chrome.driver","\\C:\\Users\\rahul jadhav\\selenium\\chromedriver.exe\\");
		 WebDriver driver=new ChromeDriver();
		 return driver;
	}
public static WebDriver openfirefoxbrowser()
{
	System.setProperty("webdriver.gecko.driver","C:\\Users\\rahul jadhav\\geckodriver\\geckodriver.exe");
	 WebDriver driver=new FirefoxDriver();
	 return driver;
	
	}
}
