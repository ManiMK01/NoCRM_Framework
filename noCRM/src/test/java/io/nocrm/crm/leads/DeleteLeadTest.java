package io.nocrm.crm.leads;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.ActionsPage;
import io.nocrm.crm.objectRepository.CreateNewLeadPage;
import io.nocrm.crm.objectRepository.LeadsPage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

public class DeleteLeadTest extends BaseClass {

	@Test(groups = "integration")
	public void deleteLeadTest() throws Throwable {

		LeadsPage lp = new LeadsPage(driver);
		CreateNewLeadPage clp = new CreateNewLeadPage(driver);
		ActionsPage actp = new ActionsPage(driver);

		String leadName = eLib.getDataFromExcelFile("NewLead", 1, 0) + jLib.getRandomNumber(1000);
		String firstName = eLib.getDataFromExcelFile("NewLead", 1, 1);
		String lastName = eLib.getDataFromExcelFile("NewLead", 1, 2) + jLib.getRandomNumber(1000);
		String phone = eLib.getDataFromExcelFile("NewLead", 1, 3) + jLib.getNumeric(8);
		String email = eLib.getDataFromExcelFile("NewLead", 1, 4) + jLib.getRandomNumber(1000) + "@gmail.com";
		String type = eLib.getDataFromExcelFile("NewLead", 1, 5);
		String amount = eLib.getDataFromExcelFile("NewLead", 1, 6) + jLib.getNumeric(5);
		String prob = eLib.getDataFromExcelFile("NewLead", 1, 7) + jLib.getNumeric(1);

		/* Click on new lead button and enter the credentials */
		UtilityClassObject.getTest().log(Status.INFO, "Click on new lead button and enter the credentials");
		lp.getNewLeadLink().click();
		clp.newLeadCreate(leadName, firstName, lastName, phone, email, type, amount, prob);

		if (clp.getDuplicateMsg().isDisplayed() == true) {
			clp.getDuplicateMsgClose().click();
		}
		Actions act = new Actions(driver);
		Thread.sleep(3000);
		wbLib.WaitForElementToBeClick(driver, lp.getActiondropdown());
		act.moveToElement(lp.getActiondropdown()).click().perform();

		/* Click on delete button */
		UtilityClassObject.getTest().log(Status.INFO, "Click on delete button");
		wbLib.WaitForElementPresent(driver, actp.getDeleteLink());
		actp.getDeleteLink().click();
		lp.getYesBtn().click();

		/* Verify the lead is deleted */
		List<WebElement> actLeadName = driver.findElements(By.xpath("//td[@class='border-top td-title  ']"));
		Assert.assertTrue(actLeadName.isEmpty(), leadName + " lead is not deleted");
		Reporter.log(leadName + " Lead is deleted", true);
		UtilityClassObject.getTest().log(Status.PASS, "lead is deleted and don't show in leads page");

	}
}
