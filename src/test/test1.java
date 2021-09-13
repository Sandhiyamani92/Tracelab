package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;



import pageobjectmodel.Registeration;

public class test1 extends Registeration {

	
	
	
	public test1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\Tr\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://etherscan.io/register");
		Registeration reg = PageFactory.initElements(driver, Registeration.class);
		System.out.println(System.getProperty("user.dir"));
		reg.validationoffields(driver);
		reg.Validationoferrormsg();
		reg.creationofAccount(driver);
		
	
		
		
				

	}

}
