package no.nocrm.crm.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.nocrm.crm.dataBaseUtility.DataBaseUtility;
import io.nocrm.crm.objectRepository.HomePage;
import io.nocrm.crm.objectRepository.LoginPage;
import no.nocrm.crm.fileUtility.ExcelFileUtility;
import no.nocrm.crm.fileUtility.File_Utility;
import no.nocrm.crm.fileUtility.JsonFileUtility;
import no.nocrm.crm.webDriverUtility.JavaUtility;
import no.nocrm.crm.webDriverUtility.UtilityClassObject;
import no.nocrm.crm.webDriverUtility.WebDriverUtility;

/**
 * @author Manikandan
 */
public class BaseClass {

	public DataBaseUtility dbLib = new DataBaseUtility();
	public File_Utility fLib = new File_Utility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JsonFileUtility jsLib = new JsonFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wbLib = new WebDriverUtility();
	public UtilityClassObject ucLib = new UtilityClassObject();

	public WebDriver driver;
	public static WebDriver sDriver;
	public JavascriptExecutor js = (JavascriptExecutor) sDriver;

	@BeforeSuite(groups = { "smoke", "system", "integration"})
	public void configBS() {
		dbLib.getDbconnection();
	}

	@Parameters("browser")
	@BeforeClass(groups = { "smoke", "system", "integration" })
	public void configBC() throws Throwable {
		String BROWSER = System.getProperty("browser", fLib.getDataFromPropertyFile("browser"));

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver = driver;
		driver.manage().window().maximize();
		wbLib.WaitForPageLoad(driver);
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "smoke", "system", "integration" })
	public void configBM() throws Throwable {
		String URL = System.getProperty("url", fLib.getDataFromPropertyFile("url"));
		String USERNAME = System.getProperty("username", fLib.getDataFromPropertyFile("username"));
		String PASSWORD = System.getProperty("password", fLib.getDataFromPropertyFile("password"));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = { "smoke", "system", "integration" })
	public void configAM() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smoke", "system", "integration" })
	public void configAC() {
		driver.quit();
	}

	@AfterSuite(groups = { "smoke", "system", "integration" })
	public void configAS() {
		dbLib.closeDbconnection();
	}
}
