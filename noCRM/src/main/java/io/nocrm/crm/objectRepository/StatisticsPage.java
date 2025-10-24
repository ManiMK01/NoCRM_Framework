package io.nocrm.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatisticsPage {
	WebDriver driver;
	
	@FindBy(xpath = "//img[@alt='Company performance']/ancestor::a")
	private WebElement companyPerformanceBtn;
	
	@FindBy(xpath = "//img[@alt='Team performance']/ancestor::a")
	private WebElement teamPerformanceBtn;
	
	@FindBy(xpath = "//img[@alt='Lead performance']/ancestor::a")
	private WebElement leadReportBtn;
	
	@FindBy(xpath = "//img[@alt='Forecast']/ancestor::a")
	private WebElement forecastReportBtn;
	
	@FindBy(xpath = "//img[contains(@alt,'Pipeline')]/ancestor::a")
	private WebElement pipelineReportBtn;
	
	@FindBy(xpath = "//img[@alt='Sales goals']/ancestor::a")
	private WebElement goalsLink;
	
	public StatisticsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCompanyPerformanceBtn() {
		return companyPerformanceBtn;
	}

	public WebElement getTeamPerformanceBtn() {
		return teamPerformanceBtn;
	}

	public WebElement getLeadReportBtn() {
		return leadReportBtn;
	}

	public WebElement getForecastReportBtn() {
		return forecastReportBtn;
	}

	public WebElement getPipelineReportBtn() {
		return pipelineReportBtn;
	}

	public WebElement getGoalsLink() {
		return goalsLink;
	}
	
	
}
