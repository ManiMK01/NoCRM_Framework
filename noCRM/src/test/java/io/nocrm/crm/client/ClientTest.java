package io.nocrm.crm.client;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.nocrm.crm.objectRepository.ClientsPage;
import io.nocrm.crm.objectRepository.HomePage;
import io.nocrm.crm.objectRepository.NewClientPage;
import no.nocrm.crm.base.BaseClass;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;

@Listeners(no.nocrm.crm.listener.ListenerImplimentation.class)
public class ClientTest extends BaseClass {
	@Test(groups = "integration")
	public void viewingClientTest() throws Throwable {

		HomePage hp = new HomePage(driver);
		NewClientPage ncp = new NewClientPage(driver);
		ClientsPage cp = new ClientsPage(driver);
		
		/* Click on New client button */ 
		UtilityClassObject.getTest().log(Status.INFO, "Click on New client button");
		wbLib.mouseMoveOnElement(driver, hp.getClientsLink());
		hp.getNewClientLink().click();
		String leadName = eLib.getDataFromExcelFile("NewLead", 1, 0) + jLib.getRandomNumber(1000);
		String VATNumber = eLib.getDataFromExcelFile("ClientAddress", 1, 0);
		String BillingAddress = eLib.getDataFromExcelFile("ClientAddress", 1, 1);
		String DeliveryAddress = eLib.getDataFromExcelFile("ClientAddress", 1, 2);
		
		/* Enter the credentials  and click on save button */
		UtilityClassObject.getTest().log(Status.INFO, "Enter the credentials  and click on save button");
		ncp.createClient(leadName, VATNumber,BillingAddress,DeliveryAddress);
		
		/* Click on clients link and open client folder */
		UtilityClassObject.getTest().log(Status.INFO, "Click on clients link and open client folder");
		wbLib.WaitForElementPresent(driver, hp.getClientsLink());
		hp.getClientsLink().click();
		cp.getClientLink().click();
		wbLib.WaitForElementPresent(driver, cp.getClientPageFolder());
		cp.findClientFolder(leadName);
		WebElement actName = driver.findElement(By.xpath("//span[@title='"+leadName+"']"));
		wbLib.WaitForElementPresent(driver, actName);
		
		/* Verify client is created or not */
		Assert.assertEquals(leadName, actName.getText(), "Client is not created");
		Reporter.log(leadName+" Client is Created",true);
		UtilityClassObject.getTest().log(Status.PASS, "New Client is Created and displayed in Clients folder");
		
	}
}
