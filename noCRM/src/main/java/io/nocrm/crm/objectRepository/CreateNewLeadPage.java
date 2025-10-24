package io.nocrm.crm.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import no.nocrm.crm.webDriverUtility.WebDriverUtility;

public class CreateNewLeadPage {
	WebDriver driver;

	@FindBy(id = "lead_lead_content_attributes_title")
	private WebElement leadNameTextField;

	@FindBy(xpath = "//iframe[contains(@title,'Rich Text Area')]")
	private WebElement contactInfoiframe;

	@FindBy(id = "tinymce")
	private WebElement contactInfoTextField;

	@FindBy(xpath = "//input[@value='Create lead']")
	private WebElement createLeadBtn;

	@FindBy(xpath = "//input[contains(@name,'[amount]')]")
	private WebElement amountTextField;

	@FindBy(xpath = "//input[contains(@id,'probability')]")
	private WebElement probabilityTextField;
	
	@FindBy(xpath = "//div[@data-id='duplicate-leads-view']")
	private WebElement duplicateMsg;
	
	@FindBy(xpath = "//a[@class='float-right text-danger']")
	private WebElement duplicateMsgClose;
	
	@FindBy(xpath = "//div[@class='mt-n2']/a[@data-popover-name='status']")
	private WebElement statusLinkLeadPage;
	
	@FindBy(xpath = "//div[@class='mt-n2']/a[@data-popover-name='step']")
	private WebElement stepLinkLeadPage;
	
	@FindBy(xpath = "//div[@class='mt-n2']/a[@data-popover-name='amount']")
	private WebElement amountLinkLeadPage;
	
	@FindBy(xpath = "//div[@class='mt-n2']/a[@data-popover-name='quotes']")
	private WebElement quoteInvoiceLinkLeadPage;
	
	@FindBy(id = "date-picker")
	private WebElement closeDatesel;

	public CreateNewLeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLeadNameTextField() {
		return leadNameTextField;
	}

	public WebElement getContactInfoiframe() {
		return contactInfoiframe;
	}

	public WebElement getContactInfoTextField() {
		return contactInfoTextField;
	}

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public WebElement getAmountTextField() {
		return amountTextField;
	}

	public WebElement getProbabilityTextField() {
		return probabilityTextField;
	}

	public WebElement getDuplicateMsg() {
		return duplicateMsg;
	}

	public WebElement getDuplicateMsgClose() {
		return duplicateMsgClose;
	}
	
	public WebElement getStatusLinkLeadPage() {
		return statusLinkLeadPage;
	}

	public WebElement getStepLinkLeadPage() {
		return stepLinkLeadPage;
	}

	public WebElement getAmountLinkLeadPage() {
		return amountLinkLeadPage;
	}

	public WebElement getQuoteInvoiceLinkLeadPage() {
		return quoteInvoiceLinkLeadPage;
	}

	public WebElement getCloseDatesel() {
		return closeDatesel;
	}

	public void newLeadCreate(String LeadName, String FirstName, String LastName, String Phone, String Email,
			String Type, String Amount, String probabitity) {
		leadNameTextField.sendKeys(LeadName);
		WebDriverUtility wbLib = new WebDriverUtility();
		wbLib.SwitchToFrame(driver, contactInfoiframe);
		contactInfoTextField.click();

		contactInfoTextField.sendKeys(Keys.PAGE_UP);
		contactInfoTextField.sendKeys(Keys.END);
		contactInfoTextField.sendKeys(FirstName);

		contactInfoTextField.sendKeys(Keys.ARROW_DOWN);
		contactInfoTextField.sendKeys(Keys.END);
		contactInfoTextField.sendKeys(LastName);

		contactInfoTextField.sendKeys(Keys.ARROW_DOWN);
		contactInfoTextField.sendKeys(Keys.END);
		contactInfoTextField.sendKeys(Phone);
		
		contactInfoTextField.sendKeys(Keys.ARROW_DOWN);
		contactInfoTextField.sendKeys(Keys.END);
		contactInfoTextField.sendKeys(Email);
		
		contactInfoTextField.sendKeys(Keys.ARROW_DOWN);
		contactInfoTextField.sendKeys(Keys.END);
		contactInfoTextField.sendKeys(Type);

		driver.switchTo().defaultContent();
		
		amountTextField.sendKeys(Keys.END);
		amountTextField.clear();
		amountTextField.sendKeys(Amount);
		probabilityTextField.sendKeys(Keys.END);
		probabilityTextField.clear();
		probabilityTextField.sendKeys(probabitity);
		
		createLeadBtn.click();
	}
}
