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

public class Session_Management extends testBase{
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

	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement logoutButton;

	@FindBy(xpath="//button[@value='no']")
	public WebElement click_No;

	@FindBy(xpath = "//*[@id=\"DescPop\"]/div[2]/form/div[2]/p")
	public WebElement message;

	@FindBy(xpath="//*[@id=\"DescPop\"]/div[2]/form/div[3]/button")
	public WebElement accept;

	@FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div/div/div[1]/div")
	public WebElement devopsTool;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/header/div[2]/div/a/img")
	public WebElement profileBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/h5")
	public WebElement tryLoginMsg;

	public boolean sessionManage(String username, String password) throws InterruptedException {
		commonMethods.waitForPageToLoad();
		SoftAssert softassert = new SoftAssert();
		try {
			wait.until(ExpectedConditions.visibilityOf(platformUsername));
			logger.log(LogStatus.INFO, "Enter Username");
			System.out.println("Enter Username");
			platformUsername.click();
			platformUsername.sendKeys(username);

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

			logger.log(LogStatus.INFO, "Confedential Information - Reminder poup is coming");
			System.out.println("Confedential Information - Reminder poup is coming");
			accept.click();
			commonMethods.waitForPageToLoad();

			softassert.assertEquals(devopsTool.getText(), "DevOps Tools");
			logger.log(LogStatus.INFO, "Clicking on profile icon to logout");
			System.out.println("Clicking on profile icon to logout");
			profileBtn.click();
			commonMethods.waitForPageToLoad();

			logger.log(LogStatus.INFO, "Clicking on Sign Out button");
			System.out.println("Clicking on Sign Out button");
			logoutButton.click();
			commonMethods.waitForPageToLoad();

			logger.log(LogStatus.INFO, "Clicking on browser back button");
			System.out.println("Clicking on browser back button");
			driver.navigate().back();
			commonMethods.waitForPageToLoad();

			if(tryLoginMsg.getText().contains("Please try logging in again.")) {
				Assert.assertEquals(tryLoginMsg.getText(), "We're sorry, the page you requested could not be found in our server. Please try logging in again.");
				//			loginButton.click();
				logger.log(LogStatus.INFO, tryLoginMsg.getText() );
				logger.log(LogStatus.PASS, "Application Passed the Unsecure Session Management Vulnerability");
				System.out.println("Application Passed the Unsecure Session Management Vulnerability");
				return true;
			}
			else {
				logger.log(LogStatus.FAIL, "Application Failed the Unsecure Session Management Vulnerability");
				System.out.println("Application Failed the Unsecure Session Management Vulnerability");
				return false;
			}
		}
		catch(Exception e) {
			logger.log(LogStatus.FAIL, "Application Failed the Unsecure Session Management Vulnerability");
			System.out.println("Application Failed the Unsecure Session Management Vulnerability");
			return false;
		}
	}
}
