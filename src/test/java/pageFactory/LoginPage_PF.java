package pageFactory;

import org.openqa.selenium.WebDriver;
//import java.util.List;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {

	@FindBy(id="email")
	WebElement input_username;

	@FindBy(id="password")
	WebElement input_password;
	
	@FindBy(xpath="//*/button/span[text()=\"Login\"]")
	WebElement button_Login;

	WebDriver driver;
	
	public LoginPage_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String username) {
		input_username.sendKeys(username);		
	}
	
	public void setPassword(String password) {
		input_password.sendKeys(password);;		
	}
	
	public void clickLogin() {
		button_Login.click();	
	}
	
}
