package io.nocrm.crm.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import no.nocrm.crm.webDriverUtility.WebDriverUtility;

public class NewClientPage {
	WebDriver driver;
	
	@FindBy(id = "client_name")
	private WebElement clientName;
	
	@FindBy(id = "client-desc_ifr")
	private WebElement clientInfoIframeTextField;
	
	@FindBy(id = "tinymce")
	private WebElement clientContInfoTextField;
	
	@FindBy(xpath = "//input[@value='Create client folder']")
	private WebElement clientCreateBtn;
	
	public NewClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getClientName() {
		return clientName;
	}

	public WebElement getClientInfoIframeTextField() {
		return clientInfoIframeTextField;
	}

	public WebElement getClientContInfoTextField() {
		return clientContInfoTextField;
	}

	public WebElement getClientCreateBtn() {
		return clientCreateBtn;
	}
	
	public void createClient(String ClientName, String VAT, String BillAddress, String DeliveryAddress) {
		clientName.sendKeys(ClientName);
		WebDriverUtility wbLib = new WebDriverUtility();
		wbLib.SwitchToFrame(driver, clientInfoIframeTextField);
		clientContInfoTextField.click();

		clientContInfoTextField.sendKeys(Keys.PAGE_UP);
		clientContInfoTextField.sendKeys(Keys.END);
		clientContInfoTextField.sendKeys(VAT);

		clientContInfoTextField.sendKeys(Keys.ARROW_DOWN);
		clientContInfoTextField.sendKeys(Keys.END);
		clientContInfoTextField.sendKeys(BillAddress);
		
		clientContInfoTextField.sendKeys(Keys.ARROW_DOWN);
		clientContInfoTextField.sendKeys(Keys.END);
		clientContInfoTextField.sendKeys(DeliveryAddress);
		
		driver.switchTo().defaultContent();
		clientCreateBtn.click();
		
	}
	
	
}
