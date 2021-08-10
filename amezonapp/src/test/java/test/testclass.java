package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import pom.Loginpom;
import pom.Logoutpom;


public class testclass extends Base{
	private WebDriver driver;
	private  Loginpom login;
	private Logoutpom out;
	private SoftAssert  soft;
	@BeforeSuite
	public void beforesuit()
	{
		System.out.println("beforesuit");
	}

	@BeforeTest
	@Parameters("browser")
	public void launchbrowser( String browser)
	{
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=openChromebrowser();
			
		}
		else
		{
			if(browser.equalsIgnoreCase("firefox")) {
				
				driver=openfirefoxbrowser();
			}
		}


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}
	@BeforeClass
	public void maximize()
	{
		login=new  Loginpom(driver);
		soft=new SoftAssert();
		out=new Logoutpom(driver);
	}	
	@BeforeMethod
	public void loginto()
	{
		driver.get("https://www.amazon.in/");

		login.login();
		login.sendemail();
		login.continue1();
		login.sendpassword();
		login.clickonsignin();
	}
	@Test(priority=2)
	public void testA()
	{

		login. homeimprovmentclick();
		String url=driver.getCurrentUrl();

		soft.assertEquals(url,"https://www.amazon.in/gp/browse.html?node=3704992031&ref_=nav_cs_hi_b183765d90844c95b998beab0377167a","url fail");
		/*login.recommendedfoyou();
		soft.assertEquals(text, "//span[@class='a-size-extra-large a-color-base a-text-bold']"," fail");*/

	}
	@Test(priority=1)
	public void testB()
	{
		login.pay();
		String url=driver.getCurrentUrl();
		soft=new SoftAssert();
		soft.assertEquals(url,"https://www.amazon.in/gp/sva/dashboard?ref_=nav_cs_apay_fe0c735739554ca1a7cccf7c41941f2f","url fail");

	}

	@AfterMethod
	public void beforemethod()
	{
		soft.assertAll();

		out.movetoaccount(driver);
		out.signoutclick();
	}

	@AfterClass
	public void afterclass()
	{
		login=null;
		soft=null;
		out=null;

	}
	@AfterTest
	public void closedbrowser()
	{
		driver.close();
	}
	@AfterSuite
	public void aftersuit()
	{
		System.out.println("after suit");

	}





}
