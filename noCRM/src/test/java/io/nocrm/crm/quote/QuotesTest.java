package io.nocrm.crm.quote;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.ActionsPage;
import io.nocrm.crm.objectRepository.CreateNewLeadPage;
import io.nocrm.crm.objectRepository.HomePage;
import io.nocrm.crm.objectRepository.LeadsPage;
import io.nocrm.crm.objectRepository.QuotesPage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

@Listeners(no.nocrm.crm.listener.ListenerImplimentation.class)
public class QuotesTest extends BaseClass {

	@Test(groups = "system")
	public void CheckQuoteTest() throws Throwable {
		LeadsPage lp = new LeadsPage(driver);
		CreateNewLeadPage clp = new CreateNewLeadPage(driver);
		ActionsPage actp = new ActionsPage(driver);
		QuotesPage qp = new QuotesPage(driver);
		HomePage hp = new HomePage(driver);

		/* Lead details */
		String leadName = eLib.getDataFromExcelFile("NewLead", 1, 0) + jLib.getRandomNumber(1000);
		String firstName = eLib.getDataFromExcelFile("NewLead", 1, 1);
		String lastName = eLib.getDataFromExcelFile("NewLead", 1, 2) + jLib.getRandomNumber(1000);
		String phone = eLib.getDataFromExcelFile("NewLead", 1, 3) + jLib.getNumeric(8);
		String email = eLib.getDataFromExcelFile("NewLead", 1, 4) + jLib.getRandomNumber(1000) + "@gmail.com";
		String type = eLib.getDataFromExcelFile("NewLead", 1, 5);
		String amount = eLib.getDataFromExcelFile("NewLead", 1, 6) + jLib.getNumeric(5);
		String prob = eLib.getDataFromExcelFile("NewLead", 1, 7) + jLib.getNumeric(1);
		
		/* lead Quote details */
		String address = eLib.getDataFromExcelFile("Client", 1, 1);
		String vatNum = eLib.getDataFromExcelFile("Client", 1, 2);
		String description = eLib.getDataFromExcelFile("Client", 1, 3);
		String qty = eLib.getDataFromExcelFile("Client", 1, 4);
		String price = eLib.getDataFromExcelFile("Client", 1, 5);
		String tax = eLib.getDataFromExcelFile("Client", 1, 6);
		
		/* Create new lead */
		UtilityClassObject.getTest().log(Status.INFO, "Create new lead");
		lp.getNewLeadLink().click();
		clp.newLeadCreate(leadName, firstName, lastName, phone, email, type, amount, prob);

		if (clp.getDuplicateMsg().isDisplayed()) {
			clp.getDuplicateMsgClose().click();
		}

		/* Click on actions link and click create quote */
		UtilityClassObject.getTest().log(Status.INFO, "Click on actions link and click create quote");
		wbLib.WaitForElementToBeClick(driver, lp.getActiondropdown());
		lp.getActiondropdown().click();
		wbLib.WaitForElementPresent(driver, actp.getCreateQuoteLink());
		actp.getCreateQuoteLink().click();
		qp.createQuote(address, vatNum, description, qty,price, tax);
		lp.getLeadCloseBtn().click();
		wbLib.mouseMoveOnElement(driver, hp.getLeadsLink());
		lp.getQuotesLink().click();

		/* Verify quote is created or not */
		String newQuoteId = driver.findElement(By.xpath("//td[@class='whitespace-nowrap border-top']/following::a[.='"+leadName+"']")).getText();
		Assert.assertTrue(newQuoteId.equals(leadName), "Quote is not created");
		Reporter.log("Quote bill is created",true);
		UtilityClassObject.getTest().log(Status.PASS, "Quotes is created");

	}

}
