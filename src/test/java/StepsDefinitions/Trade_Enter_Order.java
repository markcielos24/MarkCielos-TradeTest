package StepsDefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pageFactory.Trading_PF;

public class Trade_Enter_Order{
	
	WebDriver driver;
	Login_Logout loginlogout;
	Trading_PF tradingpf;
	
	public Trade_Enter_Order (Login_Logout loginlogout) {
		this.loginlogout = loginlogout;
		this.driver = loginlogout.getDriver();
		tradingpf = new Trading_PF(loginlogout);
	
	}
	
	@And("user click TRADE on navigation tab found in top of the homepage")
	public void user_click_TRADE_on_navigation_tab_found_in_top_of_the_homepage() throws InterruptedException {
		
		tradingpf.clickTradeNav();
		Thread.sleep(1000);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		Thread.sleep(20000);
		driver.switchTo().frame(0);
		
	}
	
	@When("user is in Enter Order user will input (.*) in ticker field$")
	public void user_Enter_Order_user_will_input_instrument_market_in_ticker_field(String market) {
		
		tradingpf.setMarket(market);
	
	}
	
	@And("user is in Enter Order user select Side (.*)$")
	public void user_Enter_Order_user_select_Side(String side) {
		
		tradingpf.clickSide(side);
	
	}
	
	@And("user is in Enter Order user select Type (.*)$")
	public void user_Enter_Order_user_select_Type(String type) {
		
		tradingpf.clickType(type);
	
	}
	
	@And("user is in Enter Order user enter Total quantity (.*)$")
	public void user_Enter_Order_user_enter_Total_quantity(int quantity) {
		
		tradingpf.setTotalQuantity(quantity);
	
	}
	
	@And("user is in Enter Order user enter Limit Price (.*)$")
	public void user_Enter_Order_user_enter_Limit_Price(int limit_price) {
		
		tradingpf.setLimitPrice(limit_price);
	
	}
	
	@And("user is in Enter Order user click place (.*) order button$")
	public void user_Enter_Order_user_click_place_order_button(String side_button) {
		
		tradingpf.clickPlaceOrder(side_button);
	
	}
	
}