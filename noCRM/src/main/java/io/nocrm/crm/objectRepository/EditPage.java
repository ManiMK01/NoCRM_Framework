package io.nocrm.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//input[@data-field='title']")
	private WebElement editLeadNameTF;
	
	@FindBy(xpath = "//iframe[contains(@title,'Rich Text Area')]")
	private WebElement editContactFrame;
	
	@FindBy(xpath = "//button[.='Save']")
	private WebElement editSveBtn;
	
	@FindBy(xpath = "//button[@data-action='cancel-edit']")
	private WebElement editCancelBtn;
	
	public EditPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getEditLeadNameTF() {
		return editLeadNameTF;
	}

	public WebElement getEditContactFrame() {
		return editContactFrame;
	}

	public WebElement getEditSveBtn() {
		return editSveBtn;
	}

	public WebElement getEditCancelBtn() {
		return editCancelBtn;
	}
	
	@FindBy(xpath = "//p[@class='lead mb-0 lead-title']")
	private WebElement leadTitleTextMsg;

	public WebElement getLeadTitleTextMsg() {
		return leadTitleTextMsg;
	}
	
}
