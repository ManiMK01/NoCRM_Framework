package io.nocrm.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	WebDriver driver;
	
	@FindBy(xpath = "//span[.='All leads']")
	private WebElement allLeadslink;
	
	@FindBy(xpath = "//span[.='All my leads']")
	private WebElement allMyLeadsLink;
	
	@FindBy(xpath = "//span[contains(.,'Pipeline view')]")
	private WebElement pipelineViewLink;
	
	@FindBy(xpath = "//span[contains(.,'To do')]")
	private WebElement todoLink;
	
	@FindBy(xpath = "//span[contains(.,'Standby')]")
	private WebElement standByLink;
	
	@FindBy(xpath = "//span[contains(.,'Starred')]")
	private WebElement starredLink;
	
	@FindBy(xpath = "//a[.='Quotes']")
	private WebElement quotesLink;
	
	@FindBy(id = "new-lead-btn")
	private WebElement newLeadLink;
	
	@FindBy(id = "nav-goals")
	private WebElement goalsicon;
	
	@FindBy(xpath = "//button[@id='full-modal-close']")
	private WebElement leadCloseBtn;
	
	@FindBy(xpath = "//div[@class='max-w-sm px-3']")
	private WebElement goalsPopup;
	
	@FindBy(xpath = "//button[.='Yes']")
	private WebElement yesBtn;
	
	@FindBy(partialLinkText = "Actions")
	private WebElement actiondropdown;
	
	@FindBy(xpath = "//p[contains(@class,'lead-title')]")
	private WebElement leadTitle;
	
	@FindBy(xpath = "//div[@class='mr-2 btn btn-sm btn-outline-secondary']")
	private WebElement pipeViewDropDown;
	
	public LeadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAllLeadslink() {
		return allLeadslink;
	}

	public WebElement getAllMyLeadsLink() {
		return allMyLeadsLink;
	}

	public WebElement getPipelineViewLink() {
		return pipelineViewLink;
	}

	public WebElement getTodoLink() {
		return todoLink;
	}

	public WebElement getStandByLink() {
		return standByLink;
	}

	public WebElement getStarredLink() {
		return starredLink;
	}

	public WebElement getQuotesLink() {
		return quotesLink;
	}

	public WebElement getNewLeadLink() {
		return newLeadLink;
	}

	public WebElement getGoalsicon() {
		return goalsicon;
	}

	public WebElement getGoalsPopup() {
		return goalsPopup;
	}

	public WebElement getLeadCloseBtn() {
		return leadCloseBtn;
	}

	public WebElement getYesBtn() {
		return yesBtn;
	}

	public WebElement getActiondropdown() {
		return actiondropdown;
	}

	public WebElement getLeadTitle() {
		return leadTitle;
	}

	public WebElement getPipeViewDropDown() {
		return pipeViewDropDown;
	}
	
	
	
}
