package io.nocrm.crm.reports;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.HomePage;
import io.nocrm.crm.objectRepository.StatisticsPage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

/**
 * @author Manikandan
 */

@Listeners(no.nocrm.crm.listener.ListenerImplimentation.class)
public class ReportsTest extends BaseClass {

	@Test(groups = "smoke")
	public void ViewLeadReportsTest() {

		StatisticsPage stp = new StatisticsPage(driver);
		HomePage hp = new HomePage(driver);

		/* Click on statistics Link */
		UtilityClassObject.getTest().log(Status.INFO, "Click on statistics Link");
		wbLib.WaitForElementPresent(driver, hp.getMoreOptionsLink());
		wbLib.mouseMoveOnElement(driver, hp.getMoreOptionsLink());
		hp.getStatisticsLink().click();

		/* Click on Leads Performance Link */
		UtilityClassObject.getTest().log(Status.INFO, " Click on Leads Performance Link ");
		wbLib.ScrollToElement(driver, stp.getLeadReportBtn());
		wbLib.WaitForElementPresent(driver, stp.getLeadReportBtn());
		stp.getLeadReportBtn().click();

		/* Verify with Expected Result Leads page is displayed or not */
		wbLib.waitForPartUrlToShow(driver, "statistics/created");
		Assert.assertTrue(driver.getCurrentUrl().contains("statistics/created"),
				"The Leads Report page is not displayed");
		Reporter.log("Leads Report page is displayed", true);
		UtilityClassObject.getTest().log(Status.PASS, "Leads Report page is displayed");
	}
}
