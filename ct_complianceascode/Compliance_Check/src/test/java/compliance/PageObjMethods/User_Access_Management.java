package compliance.PageObjMethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Generic.TestBase.BrowserConfig;
import Generic.TestBase.CommonMethods;
import Generic.TestBase.testBase;

public class User_Access_Management extends testBase{
	private WebDriver driver = BrowserConfig.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 90);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);
	ExtentSparkReporter sparkReport;
	ExtentReports reports;
	ExtentTest testLog;
	@FindBy(xpath = "//*[@id=\"i0116\"]")
	public WebElement enterpriseId;

	@FindBy(xpath = "//*[@id=\"idSIButton9\"]")
	public WebElement next;

	@FindBy(xpath = "//*[@id=\"i0118\"]")
	public WebElement enterprisePass;

	@FindBy(xpath = "//*[@id='signInAnotherWay']")
	public WebElement signOtherWay;

	@FindBy(xpath = "//*[@id=\"idDiv_SAOTCS_Proofs\"]/div[4]/div/div/div[2]/div")
	public WebElement call;

	@FindBy(xpath = "//*[@id=\"dashboard-container\"]/div[2]/div/div[1]/h3")
	public WebElement repoSearch;

	@FindBy(xpath = "//*[@id=\"dashboard-container\"]/div[2]/div/div[1]/div/div/input")
	public WebElement search;

	@FindBy(xpath = "//*[@id='quick-search-repository-172926']/div/strong/mark")
	public WebElement ct_demodocrepo;

	@FindBy(xpath = "//*[@id=\"aui-sidebar-content\"]/div/div[2]/button")
	public WebElement expand;

	@FindBy(xpath = "//*[@id='aui-page-panel-content-body']/div/div/nav/div/ul[2]/li[1]/a")
	public WebElement branchPermision;

	@FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li/div/div")
	public WebElement user;

	@FindBy(xpath = "//*[@id=\"user-permissions-table\"]/thead/tr[2]/th/form/div/div[2]/button[1]")
	public WebElement branchPermissionBtn;

	@FindBy(xpath = "//a[text()='Read']")
	public WebElement read;

	public boolean userAccessManage(String enterpriseID, String enterprisePassword,String reponame, String uname) throws InterruptedException {
		commonMethods.waitForPageToLoad();
		try {
			wait.until(ExpectedConditions.visibilityOf(enterpriseId));
			logger.log(LogStatus.INFO, "Entering the Enterprise Id");
			System.out.println("Entering the Enterprise Id");
			enterpriseId.sendKeys(enterpriseID);
			commonMethods.waitForPageToLoad();

			next.click();
			commonMethods.waitForPageToLoad();
			wait.until(ExpectedConditions.visibilityOf(enterprisePass));
			logger.log(LogStatus.INFO, "Entering the Enterprise password");
			System.out.println("Entering the Enterprise password");
			enterprisePass.sendKeys(enterprisePassword);
			commonMethods.waitForPageToLoad();
			next.click();

			wait.until(ExpectedConditions.visibilityOf(signOtherWay));
			logger.log(LogStatus.INFO, "Clicking on SignIn another way");
			System.out.println("Clicking on SignIn another way");
			signOtherWay.click();
			commonMethods.waitForPageToLoad();

			logger.log(LogStatus.INFO, "Calling to the moblie to approve signIn");
			System.out.println("Calling to the moblie to approve signIn");
			call.click();
			commonMethods.waitForPageToLoad();
			
			commonMethods.setInputById("quick-search", reponame);

     		commonMethods.waitForPageToLoad();
			logger.log(LogStatus.INFO, "Searching for the required repository");
			System.out.println("Searching for the required repository");
			commonMethods.ClickByTagWithText("mark",reponame);
			logger.log(LogStatus.INFO, "Clicking on the required repository");
			System.out.println("Clicking on the required repository");

			commonMethods.waitForPageToLoad();
			expand.click();

			commonMethods.ClickByTagWithText("span", "Repository settings");
			//		wait.until(ExpectedConditions.visibilityOf(setting));
			logger.log(LogStatus.INFO, "Clicking on Repository settings");
			System.out.println("Clicking on Repository settings");
			//			setting.click();
			//			commonMethods.waitForPageToLoad();

			//			wait.until(ExpectedConditions.visibilityOf(branchPermision));
			commonMethods.ClickOnLinkContainingText("Repository permissions");
			logger.log(LogStatus.INFO, "Clicking on Repository Permission");
			System.out.println("Clicking on Repository Permission");
			//			branchPermision.click();
			commonMethods.waitForPageToLoad();

			commonMethods.ClickInputByType("text");
			commonMethods.setInputById("s2id_autogen1", uname);
			commonMethods.waitForPageToLoad();
			user.click();
			branchPermissionBtn.click();
			commonMethods.waitForPageToLoad();
			System.out.println("Selecting Read access");
			System.out.println(read.getText());
			if(read.getText().equals("Read")) {
				logger.log(LogStatus.PASS, "Giving only the required Read permission to the repository");
				System.out.println("Giving only the required Read permission to the repository");
				commonMethods.ClickOnButtonByText("Add");
				return true;
			}
			else {
				logger.log(LogStatus.FAIL, "User is given differnt access to the repository");
				System.out.println("User is given differnt access to the repository");
				return false;
			}
		}
		catch(Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, "Authentication failed");
			System.out.println("Authentication failed");
			return false;
		}

	}

}
