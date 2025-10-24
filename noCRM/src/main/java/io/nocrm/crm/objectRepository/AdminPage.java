package io.nocrm.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	WebDriver driver;
	
	@FindBy(partialLinkText = "Pipeline steps")
	private WebElement piplineStepChangeLink;
	
	@FindBy(id = "new-pipeline-btn")
	private WebElement newpipeBtn;
	
	@FindBy(id = "pipeline_name")
	private WebElement pipeNameTextField;
	
	@FindBy(xpath = "//input[@value='Create']")
	private WebElement pipeCreateBtn;
	
	@FindBy(xpath = "//button[contains(.,'Add a step')]")
	private WebElement pipeAddStep;
	
	@FindBy(id = "name_step")
	private WebElement pipeStepNameTextField;
	
	@FindBy(xpath = "//form[@id='new_step']/descendant::input[@value='Save']")
	private WebElement pipeStepSaveBtn;
	
	@FindBy(xpath = "//div[contains(@id,'pipeline-show')]")
	private WebElement pipelineShowView;
	
	public AdminPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getPiplineStepChangeLink() {
		return piplineStepChangeLink;
	}

	public WebElement getNewpipeBtn() {
		return newpipeBtn;
	}

	public WebElement getPipeNameTextField() {
		return pipeNameTextField;
	}

	public WebElement getPipeCreateBtn() {
		return pipeCreateBtn;
	}

	public WebElement getPipeAddStep() {
		return pipeAddStep;
	}

	public WebElement getPipeStepNameTextField() {
		return pipeStepNameTextField;
	}

	public WebElement getPipeStepSaveBtn() {
		return pipeStepSaveBtn;
	}

	public WebElement getPipelineShowView() {
		return pipelineShowView;
	}
	
	
}
