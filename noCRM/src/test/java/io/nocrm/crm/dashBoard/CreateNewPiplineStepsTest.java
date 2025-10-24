package io.nocrm.crm.dashBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.AdminPage;
import io.nocrm.crm.objectRepository.HomePage;
import io.nocrm.crm.objectRepository.LeadsPage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

@Listeners(no.nocrm.crm.listener.ListenerImplimentation.class)
public class CreateNewPiplineStepsTest extends BaseClass {
	
	@Test(groups = "system")
	public void createNewPiplineStepsTest() throws InterruptedException {
		
		HomePage hp = new HomePage(driver);
		AdminPage ap = new AdminPage(driver);
		LeadsPage lp = new LeadsPage(driver);
		
		/* Click on admin page */
		UtilityClassObject.getTest().log(Status.INFO, "Click on admin page");
		hp.getProfileOpt().click();
		hp.getAdminLink().click();
		
		/* Click on pipeline step and click on new pipe button */
		UtilityClassObject.getTest().log(Status.INFO, "Click on pipeline step and click on new pipe button");
		String PipeLineName = "Build_Stage"+jLib.getRandomNumber(100);
		ap.getPiplineStepChangeLink().click();
		ap.getNewpipeBtn().click();
		ap.getPipeNameTextField().sendKeys(PipeLineName);
		ap.getPipeCreateBtn().click();
		Thread.sleep(4000);

		/* Click on add pipe and enter the data */
		UtilityClassObject.getTest().log(Status.INFO, "Click on add pipe and enter the data");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ap.getPipeAddStep());
		ap.getPipeStepNameTextField().clear();
		ap.getPipeStepNameTextField().sendKeys("New");
		js.executeScript("arguments[0].click();", ap.getPipeStepSaveBtn());
		wbLib.WaitForElementPresent(driver, ap.getPipeAddStep());
		
		js.executeScript("arguments[0].click();", ap.getPipeAddStep());
		ap.getPipeStepNameTextField().clear();
		ap.getPipeStepNameTextField().sendKeys("Demo");
		js.executeScript("arguments[0].click();", ap.getPipeStepSaveBtn());
		wbLib.WaitForElementPresent(driver, ap.getPipeAddStep());

		js.executeScript("arguments[0].click();", ap.getPipeAddStep());
		ap.getPipeStepNameTextField().clear();
		ap.getPipeStepNameTextField().sendKeys("Negotiation");
		js.executeScript("arguments[0].click();", ap.getPipeStepSaveBtn());
		wbLib.WaitForElementPresent(driver, ap.getPipeAddStep());

		js.executeScript("arguments[0].click();", ap.getPipeAddStep());
		ap.getPipeStepNameTextField().clear();
		ap.getPipeStepNameTextField().sendKeys("Deal");
		js.executeScript("arguments[0].click();", ap.getPipeStepSaveBtn());
		wbLib.WaitForElementPresent(driver, ap.getPipeAddStep());

		
		/* click on pipeline view */
		UtilityClassObject.getTest().log(Status.INFO, "Click on pipeline view ");
		wbLib.mouseMoveOnElement(driver, hp.getLeadsLink());
		wbLib.mouseMoveOnElement(driver, lp.getPipelineViewLink());
		lp.getPipelineViewLink().click();
		lp.getPipeViewDropDown().click();
		
		/* Verify the new pipe line */
		boolean newPipe = driver.findElement(By.xpath("//a[.='"+PipeLineName+"']")).isDisplayed();
		Thread.sleep(4000);
		Assert.assertTrue(newPipe, "The New PipeLine is not Created");
		Reporter.log(PipeLineName +" New PipeLine is displayed",true);
		UtilityClassObject.getTest().log(Status.PASS, "New pipeLine is Created");
	}
}
