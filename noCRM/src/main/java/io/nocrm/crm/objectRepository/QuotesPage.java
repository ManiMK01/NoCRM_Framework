package io.nocrm.crm.objectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuotesPage {
	WebDriver driver;
	
	@FindBy(id = "bill_client_address")
	private WebElement clientAddressTextField;
	
	@FindBy(partialLinkText = "View")
	private WebElement viewBtn;
	
	@FindBy(id = "bill_client_vat_number")
	private WebElement vatNumber;
	
	@FindBy(xpath = "//input[@name='bill_line[text]']")
	private WebElement discriptionTextField;
	
	@FindBy(xpath = "//input[@name='bill_line[quantity]']")
	private WebElement qualityTextField;
	
	@FindBy(xpath = "//input[@name='bill_line[unit_price]']")
	private WebElement priceTextField;
	
	@FindBy(xpath = "//input[@name='bill_line[tax_value]']")
	private WebElement taxTextField;
	
	@FindBy(xpath = "//a[@data-turbo-method='delete']")
	private WebElement deleteIcon;
	
	@FindBy(partialLinkText = "Add a line")
	private WebElement addALineBtn;
	
	@FindBy(id = "bill_currency_id")
	private WebElement currencyTypeSel;
	
	@FindBy(xpath = "//div[@class='modal-content']/ancestor::div[@id='modal']/descendant::button")
	private WebElement quoteCloseBtn;
	
	public QuotesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getClientAddressTextField() {
		return clientAddressTextField;
	}

	public WebElement getVatNumber() {
		return vatNumber;
	}

	public WebElement getDiscriptionTextField() {
		return discriptionTextField;
	}

	public WebElement getQualityTextField() {
		return qualityTextField;
	}

	public WebElement getPriceTextField() {
		return priceTextField;
	}

	public WebElement getTaxTextField() {
		return taxTextField;
	}

	public WebElement getDeleteIcon() {
		return deleteIcon;
	}

	public WebElement getAddALineBtn() {
		return addALineBtn;
	}

	public WebElement getCurrencyTypeSel() {
		return currencyTypeSel;
	}

	public WebElement getQuoteCloseBtn() {
		return quoteCloseBtn;
	}
	
	public WebElement getViewBtn() {
		return viewBtn;
	}
	
	@FindBy(xpath = "//div[@data-controller='bill-lines']/..")
	private WebElement descriptab;
	

	public WebElement getDescriptab() {
		return descriptab;
	}

	public void createQuote(String Address, String VATNum, String Description, String Qty, String Price, String Tax) throws Throwable {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 Actions act = new Actions(driver);   
		    js.executeScript("arguments[0].value='"+Address+"'", clientAddressTextField);
		    js.executeScript("arguments[0].value='"+VATNum+"'", vatNumber);
		    
		    Thread.sleep(1000);
		    js.executeScript("arguments[0].scrollIntoView(true);", descriptab);
		    
		    act.moveToElement(discriptionTextField).click().perform();
		    js.executeScript("arguments[0].value='"+Description+"'", discriptionTextField);
		    
		    act.moveToElement(qualityTextField).click().perform();
		    act.sendKeys(Keys.DELETE).perform();
		    js.executeScript("arguments[0].value='"+Qty+"'", qualityTextField);
		    
		    act.moveToElement(priceTextField).click().perform();
		    act.sendKeys(Keys.DELETE).perform();
		    act.sendKeys(Keys.DELETE).perform();
		    act.sendKeys(Keys.DELETE).perform();
		    act.sendKeys(Keys.DELETE).perform();
		    js.executeScript("arguments[0].value='"+Price+"'", priceTextField);
		    
		    act.moveToElement(taxTextField).click().perform();
		    Thread.sleep(1000);
		    js.executeScript("arguments[0].value='"+Tax+"'", taxTextField);
		    js.executeScript("arguments[0].click()", viewBtn);
		    
		    Thread.sleep(2000);
		    quoteCloseBtn.click();
		
		
	}
}
