package StepsDefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import javax.imageio.ImageIO;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.cucumber.java.en.*;
import pageFactory.LoginPage_PF;
import utils.Constants;

public class Login_Logout {
	
	private WebDriver driver;
	String projectpath = System.getProperty("user.dir");
	
	LoginPage_PF loginpagepf;
	
	public WebDriver getDriver(){
	    return driver;
	}
	
	@Given("browser is open using (.*)$")
	public void browser_is_open_using(String browsername) {
		
		if(browsername.toUpperCase().contentEquals("CHROME")){
//			JOptionPane.showMessageDialog(null, "Chrome", browsername, JOptionPane.INFORMATION_MESSAGE);
			System.setProperty("webdriver.chrome.driver", projectpath+"/src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}	
		else {
//			JOptionPane.showMessageDialog(null, "Firefox", browsername, JOptionPane.INFORMATION_MESSAGE);
			System.setProperty("webdriver.gecko.driver", projectpath+"/src/test/resources/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));	
 		driver.manage().window().maximize();
 		
	}
	
	@And("user is on login page (.*)$")
	public void user_is_on_login_page(String environment_name) {
		switch (environment_name) {
			case "SIT1":
				driver.get(Constants.SIT1); 
				break;
			default:
				driver.get("https://trade.pdax.ph/signin");
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));	
	}
	
	@And("user login using proper credentials (.*)$")
	public void user_login_using_proper_credentials(String env_user) throws InterruptedException {

		loginpagepf = new LoginPage_PF(driver);
		switch (env_user) {
			case "SIT1_User01":
				loginpagepf.setUserName(Constants.SIT1_User01_name);
				loginpagepf.setPassword(Constants.SIT1_User01_password);
				loginpagepf.clickLogin();
				break;
			default:
				loginpagepf.setUserName("not found");
				loginpagepf.setPassword("not found");
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));	
	}
	
	@And("user take screenshot and close browser")
	public void user_take_screenshot_and_close_browser() throws IOException {
		
		String fileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
		Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		ImageIO.write(s.getImage(),"PNG",new File(projectpath+"/src/test/resources/screenshots/" + fileName));
		
		driver.close();
		driver.quit();
		
	}
	
}