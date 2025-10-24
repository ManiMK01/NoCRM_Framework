package io.nocrm.crm.leads;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.ActionsPage;
import io.nocrm.crm.objectRepository.CreateNewLeadPage;
import io.nocrm.crm.objectRepository.EditPage;
import io.nocrm.crm.objectRepository.LeadsPage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

public class EditLeadsTest extends BaseClass {


	@Test(groups = "integration")
	public void editLeadTest() throws Throwable {
		LeadsPage lp = new LeadsPage(driver);
		CreateNewLeadPage clp = new CreateNewLeadPage(driver);
		ActionsPage actp = new ActionsPage(driver);
		EditPage edp = new EditPage(driver);

		String leadName = eLib.getDataFromExcelFile("NewLead", 1, 0) + jLib.getRandomNumber(1000);
		String firstName = eLib.getDataFromExcelFile("NewLead", 1, 1);
		String lastName = eLib.getDataFromExcelFile("NewLead", 1, 2) + jLib.getRandomNumber(1000);
		String phone = eLib.getDataFromExcelFile("NewLead", 1, 3) + jLib.getNumeric(8);
		String email = eLib.getDataFromExcelFile("NewLead", 1, 4) + jLib.getRandomNumber(1000) + "@gmail.com";
		String type = eLib.getDataFromExcelFile("NewLead", 1, 5);
		String amount = eLib.getDataFromExcelFile("NewLead", 1, 6) + jLib.getNumeric(5);
		String prob = eLib.getDataFromExcelFile("NewLead", 1, 7) + jLib.getNumeric(1);

		UtilityClassObject.getTest().log(Status.INFO, "Click on New link button and enter the credentials");
		lp.getNewLeadLink().click();
		clp.newLeadCreate(leadName, firstName, lastName, phone, email, type, amount, prob);
		System.out.println("============>" + leadName + "<============");
		if (clp.getDuplicateMsg().isDisplayed() == true) {
			clp.getDuplicateMsgClose().click();
		}

		UtilityClassObject.getTest().log(Status.INFO, "Click actions dropdwon and click edit link ");
		Actions act = new Actions(driver);
		wbLib.WaitForElementPresent(driver, lp.getActiondropdown());
		act.moveToElement(lp.getActiondropdown()).click().perform();
		wbLib.WaitForElementPresent(driver, actp.getEditLink());
		actp.getEditLink().click();

		String editLeadName = eLib.getDataFromExcelFile("NewLead", 1, 0) + jLib.getRandomNumber(1000);
		UtilityClassObject.getTest().log(Status.INFO, "Change the lead name");
		edp.getEditLeadNameTF().clear();
		edp.getEditLeadNameTF().sendKeys(editLeadName);
		edp.getEditSveBtn().click();
		wbLib.WaitForElementPresent(driver, lp.getLeadTitle());

		/* Verify new lead is created or not */
		System.out.println("============>" + lp.getLeadTitle().getText() + "<============");
		Assert.assertTrue(lp.getLeadTitle().getText().equals(editLeadName), "The lead is not created");
		Reporter.log("New lead is Modified created", true);
		UtilityClassObject.getTest().log(Status.PASS, "Lead is modified and displayed");

		wbLib.WaitForElementPresent(driver, lp.getLeadCloseBtn());
		lp.getLeadCloseBtn().click();

	}

}
