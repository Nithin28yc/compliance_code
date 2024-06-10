package compliance.PageObjMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import Generic.TestBase.BrowserConfig;
import Generic.TestBase.CommonMethods;
import Generic.TestBase.testBase;

public class RBAC extends testBase{
	private WebDriver driver = BrowserConfig.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 45);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);

	@FindBy(xpath = "//input[@name='username']")
	public WebElement platformUsername;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement platformPassword;

	@FindBy(xpath = "//*[text()='Login']")
	public WebElement loginButton;

	@FindBy(xpath="//button[@value='no']")
	public WebElement click_No;

	@FindBy(xpath="//*[@id=\"DescPop\"]/div[2]/form/div[3]/button")
	public WebElement accept;
	
	@FindBy(xpath = "//*[@id=\"DescPop\"]/div[2]/form/div[1]")
	public WebElement heading;
	
	@FindBy(xpath = "//a[@href='#/manage']")
	public WebElement managetab;

	@FindBy(xpath = "//a[@href='#/manage-pvc']")
	public WebElement managepvc;
	
	@FindBy(xpath = "//div[text()='Manage PVC']")
	public WebElement managepvcText;


	public boolean rolebase(String username,String password) throws InterruptedException {
		commonMethods.waitForPageToLoad();
		SoftAssert softassert = new SoftAssert();
		try {

			wait.until(ExpectedConditions.visibilityOf(platformUsername));
			logger.log(LogStatus.INFO, "Enter Username");
			System.out.println("Enter Username");
			platformUsername.click();
			platformUsername.sendKeys(username);
			commonMethods.waitForPageToLoad();

			wait.until(ExpectedConditions.visibilityOf(platformPassword));
			logger.log(LogStatus.INFO, "Enter Password");
			System.out.println("Enter password");
			platformPassword.click();
			platformPassword.sendKeys(password);
			commonMethods.waitForPageToLoad();
			loginButton.click();
			commonMethods.waitForPageToLoad();
			click_No.click();
			commonMethods.waitForPageToLoad();
			
			softassert.assertEquals(heading.getText(), "Confidential Information – Reminder");
			logger.log(LogStatus.INFO, "Confidential popup is coming");
			System.out.println("Confidential popup is coming");
			accept.click();
			commonMethods.waitForPageToLoad();

			try {
				softassert.assertEquals(managetab.getText(), "Manage Platform");
				logger.log(LogStatus.INFO, "Click on Manage Platform tab");
				System.out.println("Click on Manage Platform tab");
				managetab.click();
				commonMethods.waitForPageToLoad();
	
				Assert.assertTrue(managepvcText.getText().contains("PVC"));
				logger.log(LogStatus.INFO, "Click on Manage PVC tab");
				System.out.println("Click on Manage PVC tab");
				managepvc.click();
				commonMethods.waitForPageToLoad();
				logger.log(LogStatus.PASS, "Logged in user is Admin-user");
				System.out.println("Logged in user is Admin-user");
				return true;

			}catch (Exception e) {
				System.out.println(e);
				logger.log(LogStatus.FAIL, "Logged in user is NonAdmin-user");
				System.out.println("Logged in user is NonAdmin-user");
				return false;

			}
		}
		catch(Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, "Platform is down");
			System.out.println("Platform is down");
			return false;
		}
	}
}
