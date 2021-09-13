package pageobjectmodel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Registeration {

	public WebDriver driver;



	public Registeration(WebDriver driver) {
		this.driver=driver;
	}




	@FindBy(id="ContentPlaceHolder1_txtUserName")
	WebElement Username;

	@FindBy(id="ContentPlaceHolder1_txtEmail")
	WebElement Emailaddress;

	@FindBy(id="ContentPlaceHolder1_txtPassword")
	WebElement password;

	@FindBy(id="ContentPlaceHolder1_txtPassword2")
	WebElement confirmpassword;

	@FindBy(id="ContentPlaceHolder1_btnRegister")
	WebElement CreateanAccount;

	@FindBy(xpath="//*[@id='ContentPlaceHolder1_maindiv']/div[4]/div/label/..//input")
	WebElement Termscondition;

	@FindBy(id="ContentPlaceHolder1_SubscribeNewsletter")
	WebElement newsletter;

	@FindBy(id="ContentPlaceHolder1_txtUserName-error")
	WebElement usrerror;


	@FindBy(id="ContentPlaceHolder1_txtEmail-error")
	WebElement mailerror;

	@FindBy(xpath="//span[@class='text-warning']")
	WebElement pwdweak;

	@FindBy(xpath="//span[@style='color:brown']")
	WebElement pwdmedium;

	@FindBy(id="ContentPlaceHolder1_txtPassword2-error")
	WebElement pwddoesntmatch;

	@FindBy(id="ctl00$ContentPlaceHolder1$MyCheckBox-error")
	WebElement errorterms;

	@FindBy(id="ContentPlaceHolder1_txtPassword-error")
	WebElement pwdlength;

	@FindBy(id="passstrength")
	WebElement pwdstrong;

	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successmsg;


	public void msg(String passmsg,String failmsg,WebElement element,String validation)
	{
		if(element.getText().equals(validation))
		{
			System.out.println(passmsg);
		}
		else 
			System.out.println(failmsg);
	}


	public void validationoffields(WebDriver driver) {

		try {

			if(Username.getAttribute("placeholder").equals("Username has to be from 5 to 30 characters in length, only alphanumeric characters allowed."))
			{System.out.println("place holder displayed for username");

			}
			else 
				System.out.println("Fail to display for username");


			if(Emailaddress.getAttribute("placeholder").equals("A confirmation code will be sent to this address"))
				System.out.println("place holder displayed for email");
			else 
				System.out.println("Fail to display for email");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

	public void Validationoferrormsg()
	{
		try {

			//username
			Username.sendKeys("abc");
			msg("error msg displayed for username","failed to display error msg for username",usrerror,"Username is invalid.");


			//email address
			Emailaddress.sendKeys("gtyu");

			msg("error msg displayed for emailaddress","failed to display error msg for emailaddress",mailerror,"Please enter a valid email address.");


			//to check password length
			password.sendKeys("gtyu");

			msg("error msg displayed for length","failed to display error msg for length",pwdlength,"Your password must be at least 5 characters long.");



			//to check for weak
			password.clear();
			password.sendKeys("werty");

			msg("msg is displayed for weak","fail to display msg weak",pwdweak,"Strength: Weak!");


			//to check for med
			password.clear();
			password.sendKeys("qwert@123");

			msg("msg is displayed for Medium","fail to display msg Medium",pwdmedium,"Strength: Medium!");



			//to check for strong
			password.clear();
			password.sendKeys("Qwert@123");

			msg("msg is displayed for Strong","fail to display msg Strong",pwdstrong,"Strength: Strong!");


			// password doesnt match
			password.clear();
			password.sendKeys("qwert@123");
			confirmpassword.sendKeys("qwert");

			msg("msg is displayed as pwd doesnt match","fail to display msg pwd doesnt match",pwddoesntmatch,"Password does not match, please check again.");



			//to check terms,condition

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
			jse.executeScript("arguments[0].click();", CreateanAccount);

			msg("msg is displayed for terms & conditions ","fail to display msg for terms & condition",errorterms,"Please accept our Terms and Conditions.");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	public void creationofAccount(WebDriver driver)
	{
		try {
			Username.clear();
			Username.sendKeys("njhfghgughu");
			password.clear();
			password.sendKeys("qwerty@123");
			confirmpassword.clear();
			confirmpassword.sendKeys("qwerty@123");
			Emailaddress.clear();
			Emailaddress.sendKeys("qwerty89@gmail.com");

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,250)");
			jse.executeScript("arguments[0].click();", Termscondition);
			jse.executeScript("arguments[0].click();", newsletter);


			JFrame     f=new JFrame(); 
			JOptionPane.showMessageDialog(f,"Please enter the Captcha.");  

			jse.executeScript("arguments[0].click();", CreateanAccount);

			msg("Acc created","Fail to create the account",successmsg,"Your account has been successfully registered and pending for email verification.");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}







}
