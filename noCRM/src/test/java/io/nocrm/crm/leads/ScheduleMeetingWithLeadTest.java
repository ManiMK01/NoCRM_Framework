package io.nocrm.crm.leads;

import java.text.DateFormatSymbols;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.ActionsPage;
import io.nocrm.crm.objectRepository.CreateNewLeadPage;
import io.nocrm.crm.objectRepository.LeadsPage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

@Listeners(no.nocrm.crm.listener.ListenerImplimentation.class)
public class ScheduleMeetingWithLeadTest extends BaseClass {

	@Test(groups = "system")
	public void scheduleMeetingWithLeadTest() throws Throwable {

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

		UtilityClassObject.getTest().log(Status.INFO, " Click on New lead button and enter the datas ");
		lp.getNewLeadLink().click();
		clp.newLeadCreate(leadName, firstName, lastName, phone, email, type, amount, prob);

		if (clp.getDuplicateMsg().isDisplayed() == true) {
			clp.getDuplicateMsgClose().click();
		}
		
		UtilityClassObject.getTest().log(Status.INFO, "Click on actions drop down ");
		Thread.sleep(4000);
		wbLib.WaitForElementToBeClick(driver, lp.getActiondropdown());
		wbLib.mouseMoveOnElement(driver, lp.getActiondropdown());
		lp.getActiondropdown().click();

		UtilityClassObject.getTest().log(Status.INFO, "Click on set a reminder");
		actp.getSetAReminderLink().click();
		actp.getDateDropDown().click();
		wbLib.WaitForElementPresent(driver, actp.getDatePageDisplay());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String monAndYear = "October 2025";
		String date = "29";
		for (;;) {
			try {
				WebElement dates = driver.findElement(By.xpath("//th[.='" + monAndYear
						+ "']/ancestor::div[@class='datepicker-days']//td[contains(@class, 'day') and not(contains(@class, 'disabled')) and .='"
						+ date + "']"));
				Thread.sleep(3000);
				wbLib.WaitForElementToBeClick(driver, dates);
				js.executeScript("arguments[0].click();", dates);
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//div[@class='datepicker-days']//ancestor::th[@class='next']")).click();
			}
		}
		wbLib.WaitForElementPresent(driver, actp.getStatusSaveBtn());
		actp.getStatusSaveBtn().click();
		lp.getLeadCloseBtn().click();
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();

		int monthNumber = 0;
		for (int i = 0; i < months.length; i++) {
			if (months[i].equalsIgnoreCase(monAndYear.split(" ")[0])) {
				monthNumber = i + 1;
				break;
			}
		}
		String year = monAndYear.split(" ")[1];
		String formattedMonth = String.format("%02d", monthNumber);
		String expectedDate = date + "/" + formattedMonth + "/" + year;

		/* Verify with actual date with selected date */ 
		String actualDate = driver.findElement(By.id("date-picker")).getText();
		Assert.assertEquals(actualDate, expectedDate, " Selected date mismatch! ");
		Reporter.log(" Selected date verified: " + actualDate, true);

		UtilityClassObject.getTest().log(Status.PASS, "Scheduled Meeting With Lead ");
	}
}
