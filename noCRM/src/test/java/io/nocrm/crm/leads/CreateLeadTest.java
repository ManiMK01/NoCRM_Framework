package io.nocrm.crm.leads;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.CreateNewLeadPage;
import io.nocrm.crm.objectRepository.LeadsPage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

public class CreateLeadTest extends BaseClass {

	@Test(groups = "smoke")
	public void createNewLeadTest() throws Throwable {

		LeadsPage lp = new LeadsPage(driver);
		CreateNewLeadPage clp = new CreateNewLeadPage(driver);

		String leadName = eLib.getDataFromExcelFile("NewLead", 1, 0) + jLib.getRandomNumber(1000);
		String firstName = eLib.getDataFromExcelFile("NewLead", 1, 1);
		String lastName = eLib.getDataFromExcelFile("NewLead", 1, 2) + jLib.getRandomNumber(1000);
		String phone = eLib.getDataFromExcelFile("NewLead", 1, 3) + jLib.getNumeric(8);
		String email = eLib.getDataFromExcelFile("NewLead", 1, 4) + jLib.getRandomNumber(1000) + "@gmail.com";
		String type = eLib.getDataFromExcelFile("NewLead", 1, 5);
		String amount = eLib.getDataFromExcelFile("NewLead", 1, 6);
		String prob = eLib.getDataFromExcelFile("NewLead", 1, 7);

		/* Click on new lead button and enter credentials */
		UtilityClassObject.getTest().log(Status.INFO, "Click on new lead button and enter credentials");
		lp.getNewLeadLink().click();
		clp.newLeadCreate(leadName, firstName, lastName, phone, email, type, amount, prob);
		wbLib.WaitForElementPresent(driver, lp.getLeadCloseBtn());

		/* Verify new lead is created or not */
		Assert.assertTrue(lp.getLeadTitle().getText().equals(leadName), "The lead is not created");
		Reporter.log("New lead is created", true);
		UtilityClassObject.getTest().log(Status.PASS, "New Lead is Created and displayed");

		if (clp.getDuplicateMsg().isDisplayed()) {
			clp.getDuplicateMsgClose().click();
			Thread.sleep(3000);
		}
		wbLib.WaitForElementToBeClick(driver, lp.getLeadCloseBtn());
		lp.getLeadCloseBtn().click();
		
	}
}
