package io.nocrm.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 
	WebDriver driver;
	
	@FindBy(xpath = "//a[contains(.,'Cold prospects')]")
	private WebElement prospectsLink;
	
	@FindBy(xpath = "//a[contains(.,'Leads')]")
	private WebElement leadsLink;
	
	@FindBy(xpath = "//a[contains(.,'Clients')]")
	private WebElement clientsLink;
	
	@FindBy(xpath = "//a[@class='nav-link rel']")
	private WebElement moreOptionsLink;
	
	@FindBy(partialLinkText = "new-lead-btn")
	private WebElement newLeadBtn;
	
	@FindBy(id = "nav-search")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//span[@class='nav-username cursor-default']")
	private WebElement profileOpt;
	
	@FindBy(partialLinkText = "Log out")
	private WebElement logoutLink;
	
	@FindBy(partialLinkText = "Dashboard")
	private WebElement dashBoardLink;
	
	@FindBy(partialLinkText = "Statistics")
	private WebElement statisticsLink;
	
	@FindBy(partialLinkText = "Activity feed")
	private WebElement activityLink;
	
	@FindBy(partialLinkText = "Tools")
	private WebElement toolsLink;
	
	@FindBy(partialLinkText = "Admin panel")
	private WebElement adminLink;
	
	@FindBy(partialLinkText = "New client folder")
	private WebElement newClientLink;
	
	@FindBy(xpath = "//a[@data-id='notif-center']")
	private WebElement notificationIcon;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProspectsLink() {
		return prospectsLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getClientsLink() {
		return clientsLink;
	}

	public WebElement getMoreOptionsLink() {
		return moreOptionsLink;
	}

	public WebElement getNewLeadBtn() {
		return newLeadBtn;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getProfileOpt() {
		return profileOpt;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public WebElement getDashBoardLink() {
		return dashBoardLink;
	}

	public WebElement getStatisticsLink() {
		return statisticsLink;
	}

	public WebElement getActivityLink() {
		return activityLink;
	}

	public WebElement getToolsLink() {
		return toolsLink;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getNewClientLink() {
		return newClientLink;
	}

	public WebElement getNotificationIcon() {
		return notificationIcon;
	}

	public void logout() {
		profileOpt.click();
		logoutLink.click();
	}
	
	public void leadsOpt() {
		Actions act = new Actions(driver);
		act.moveToElement(leadsLink).perform();
	}
	
	public void clickAdmin() {
		profileOpt.click();
		adminLink.click();
	}
}
