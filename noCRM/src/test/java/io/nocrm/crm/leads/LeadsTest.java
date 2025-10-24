package io.nocrm.crm.leads;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.HomePage;
import io.nocrm.crm.objectRepository.LeadsPage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

@Listeners(no.nocrm.crm.listener.ListenerImplimentation.class)
public class LeadsTest extends BaseClass {

	@Test(groups = "smoke")
	public void viewGoalsTest() {

		LeadsPage lp = new LeadsPage(driver);
		HomePage hp = new HomePage(driver);

		/* Click on pipeline view */
		UtilityClassObject.getTest().log(Status.INFO, "Click on Pipeline View link");
		wbLib.mouseMoveOnElement(driver, hp.getLeadsLink());
		lp.getPipelineViewLink().click();

		/* Verify the pipeline page is displayed or not */
		wbLib.waitForPartUrlToShow(driver, "mode=pipe");
		Assert.assertTrue(driver.getCurrentUrl().contains("mode=pipe"), "pipeline View is not displayed");
		Reporter.log("Pipeline View Page is displayed", true);
		UtilityClassObject.getTest().log(Status.PASS, "Pipeline View Page is displayed");
	}
}
