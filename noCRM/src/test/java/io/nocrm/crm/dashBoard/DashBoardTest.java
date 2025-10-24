package io.nocrm.crm.dashBoard;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.HomePage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

@Listeners(no.nocrm.crm.listener.ListenerImplimentation.class)
public class DashBoardTest extends BaseClass {
	
	@Test(groups = "smoke")
	public void viewDashBoardTest() {

		/* Click on dash board link */
		HomePage hp = new HomePage(driver);
		hp.getMoreOptionsLink().click();
		hp.getDashBoardLink().click();

		/* Verify with Actual result Dash board is displayed or Not */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains("dashboard"));
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "The dashboard is not displayed");
		Reporter.log("DashBoard page is displayed", true);
		UtilityClassObject.getTest().log(Status.PASS, "DashBoard is displayed");
	}

}
