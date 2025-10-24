package io.nocrm.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsPage {
	WebDriver driver;
	
	@FindBy(partialLinkText = "New client folder")
	private WebElement newClientLink;
	
	@FindBy(partialLinkText = "Client folders")
	private WebElement clientLink;
	
	@FindBy(xpath = "//div[@data-placement='right']")
	private WebElement filterDropDown;
	
	@FindBy(partialLinkText = "Won amount")
	private WebElement wonAmountLink;
	
	@FindBy(partialLinkText = "Alive leads amount")
	private WebElement aliveLeadsAmountLink;
	
	@FindBy(partialLinkText = "Creation date")
	private WebElement createionDateLink;
	
	@FindBy(partialLinkText = "Last update")
	private WebElement lastUpdateLink;
	
	@FindBy(partialLinkText = "Number of leads")
	private WebElement numberOfLeadsLink;
	
	@FindBy(partialLinkText = "Number of To-Do leads")
	private WebElement numOfToDoLeadsLink;
	
	
	@FindBy(partialLinkText = "Number of Standby leads")
	private WebElement numOfStandByLeadsLink;
	
	@FindBy(partialLinkText = "Number of Won leads")
	private WebElement numOfWonLeadsLink;
	
	@FindBy(partialLinkText = "Number of alive leads")
	private WebElement numOfAliveLeadsLink;
	
	@FindBy(partialLinkText = "Invoices")
	private WebElement invoicesLink;
	
	@FindBy(xpath = "//div[contains(@class,'page-location page-location')]")
	private WebElement clientPageFolder;
	
	public ClientsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getNewClientLink() {
		return newClientLink;
	}

	public WebElement getFilterDropDown() {
		return filterDropDown;
	}

	public WebElement getWonAmountLink() {
		return wonAmountLink;
	}

	public WebElement getAliveLeadsAmountLink() {
		return aliveLeadsAmountLink;
	}

	public WebElement getCreateionDateLink() {
		return createionDateLink;
	}

	public WebElement getLastUpdateLink() {
		return lastUpdateLink;
	}

	public WebElement getNumberOfLeadsLink() {
		return numberOfLeadsLink;
	}

	public WebElement getNumOfToDoLeadsLink() {
		return numOfToDoLeadsLink;
	}

	public WebElement getNumOfStandByLeadsLink() {
		return numOfStandByLeadsLink;
	}

	public WebElement getNumOfWonLeadsLink() {
		return numOfWonLeadsLink;
	}

	public WebElement getNumOfAliveLeadsLink() {
		return numOfAliveLeadsLink;
	}

	public WebElement getInvoicesLink() {
		return invoicesLink;
	}

	public WebElement getClientLink() {
		return clientLink;
	}

	public WebElement getClientPageFolder() {
		return clientPageFolder;
	}

	public void clickInvoices() {
		Actions act = new Actions(driver);
		HomePage hp = new HomePage(driver);
		act.moveToElement(hp.getClientsLink()).perform();
		
	}
	
	public void findClientFolder(String clientName) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//a[contains(.,'"+clientName+"')]")));
	}
}
