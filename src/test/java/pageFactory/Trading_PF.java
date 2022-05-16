package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import StepsDefinitions.Login_Logout;

public class Trading_PF {
	
//	@FindBy(xpath = "//nav//*/a/span[text()=\"Trade\"]")
	@FindBy(xpath = "//a[contains(@href, '/trade')]")
	WebElement webelem_TradeNav;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/input[@name=\"instrumentmarket\"]")
	WebElement input_Market;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/label[text()=\"Buy\"]")
	WebElement label_Buy;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/label[text()=\"Sell\"]")
	WebElement label_Sell;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/label[text()=\"Limit\"]")
	WebElement label_Limit;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/label[text()=\"Market\"]")
	WebElement label_Market;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/label[text()=\"FAK\"]")
	WebElement label_FAK;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/input[@name=\"total_quantity\"]")
	WebElement input_quantity;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/input[@name=\"price\"]")
	WebElement input_price;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/button[text()=\"Place Buy Order\"]")
	WebElement place_order_Buy_button;
	
	@FindBy(xpath="//*[@id=\"885\"]//*/button[text()=\"Place Sell Order\"]")
	WebElement place_order_Sell_button;
	
	public	Trading_PF(Login_Logout loginlogout) {
		PageFactory.initElements(loginlogout.getDriver(), this);
	}
			
	public void clickTradeNav() {
		webelem_TradeNav.click();		
	}
	
	public void setMarket(String market) {
		input_Market.clear();
		input_Market.sendKeys(market);
	}
	
	public void clickSide(String side) {
		switch (side.toUpperCase()) {
			case "BUY":
				label_Buy.click();
				break;
			case "SELL":
				label_Sell.click();
				break;
		}		
	}
	
	public void clickType(String type) {
		switch (type.toUpperCase()) {
			case "LIMIT":
				label_Limit.click();
				break;
			case "MARKET":
				label_Market.click();
				break;
			case "FAK":
				label_FAK.click();
				break;
		}		
	}
	
	public void setTotalQuantity(int quantity) {
		input_quantity.sendKeys(String.valueOf(quantity));
	}
	
	public void setLimitPrice(int price) {
		input_price.sendKeys(String.valueOf(price));
	}
	
	public void clickPlaceOrder(String side_button) {
		switch (side_button.toUpperCase()) {
			case "BUY":
				place_order_Buy_button.click();
				break;
			case "SELL":
				place_order_Sell_button.click();
				break;
		}		
	}
	
}