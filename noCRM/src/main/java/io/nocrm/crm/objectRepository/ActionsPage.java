package io.nocrm.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionsPage {
	WebDriver driver;
	
	@FindBy(partialLinkText = "Assign to...")
	private WebElement assignToLink;
	
	@FindBy(partialLinkText = "Edit")
	private WebElement editLink;
	
	@FindBy(partialLinkText = "Delete")
	private WebElement deleteLink;
	
	@FindBy(partialLinkText = "Create a quote")
	private WebElement createQuoteLink;
	
	@FindBy(partialLinkText = "Create an invoice")
	private WebElement createInvoiceLink;
	
	@FindBy(partialLinkText = "Set a reminder")
	private WebElement setAReminderLink;
	
	@FindBy(id = "date-picker")
	private WebElement dateDropDown;
	
	@FindBy(xpath = "//div[@id='status-submit']//input[@value='Save']")
	private WebElement statusSaveBtn;
	
	@FindBy(xpath = "//div[@class='datepicker-days']")
	private WebElement datePageDisplay;
	
	public ActionsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAssignToLink() {
		return assignToLink;
	}

	public WebElement getEditLink() {
		return editLink;
	}

	public WebElement getDeleteLink() {
		return deleteLink;
	}

	public WebElement getCreateQuoteLink() {
		return createQuoteLink;
	}

	public WebElement getCreateInvoiceLink() {
		return createInvoiceLink;
	}

	public WebElement getSetAReminderLink() {
		return setAReminderLink;
	}

	public WebElement getDateDropDown() {
		return dateDropDown;
	}

	public WebElement getStatusSaveBtn() {
		return statusSaveBtn;
	}

	public WebElement getDatePageDisplay() {
		return datePageDisplay;
	}
	
}
