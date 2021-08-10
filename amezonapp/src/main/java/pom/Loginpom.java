package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpom {
	private WebDriver driver;
	@FindBy(xpath="//a[@data-nav-role='signin']")
	private WebElement login;

	@FindBy(xpath="//input[@type='email']")
	private WebElement email;

	@FindBy(xpath="//input[@id='continue']")
	private WebElement continue1;

	@FindBy(xpath="//input[@type='password']")
	private WebElement password;

	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement signin;
	

	@FindBy(xpath="//a[text()='Home Improvement']")
	private WebElement homeimprovment;	
	/*@FindBy(xpath="//span[@class='a-size-extra-large a-color-base a-text-bold']")
	private WebElement recommended;*/
	@FindBy(xpath="//a[text()='Amazon Pay']")
	private WebElement amezonpay;

	public Loginpom(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void login()
	{
		login.click();
	}
	public void sendemail()
	{
		email.sendKeys("mrugnayanikshirsagar@gmail.com");
	}
	public void continue1()
	{
		continue1.click();
	}
	public void sendpassword()
	{
		password.sendKeys("piyurahul191");
	}
	public void clickonsignin()
	{
		signin.click();
	}
	public void  homeimprovmentclick()
	{
		 homeimprovment.click();

	}
	/*public void recommendedfoyou()
	{
		String text=recommended.getText();
	}*/
public void pay()
{
	amezonpay.click();
	}



}
