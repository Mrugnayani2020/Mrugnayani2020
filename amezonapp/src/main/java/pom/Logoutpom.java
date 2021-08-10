package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logoutpom {
	private WebDriver driver;
	private Actions act;
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	private WebElement signoff;

	@FindBy(xpath="//span[text()='Sign Out']")
	private WebElement signout;

	public Logoutpom (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void movetoaccount(WebDriver driver)
	{
		act=new Actions(driver);
		act.moveToElement(signoff).perform();		

	}
	public void signoutclick()
	{
		signout.click();
	}



}
