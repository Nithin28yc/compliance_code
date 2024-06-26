package compliance.PageObjMethods;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Generic.TestBase.BrowserConfig;
import Generic.TestBase.CommonMethods;
import Generic.TestBase.testBase;

public class Data_Masking extends testBase{

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

	@FindBy(xpath = "//a[.='Sign Out']")
	public WebElement logoutButton;

	@FindBy(xpath = "//*[@id='invalid']")
	public WebElement loginErrorMessage;

	@FindBy(xpath = "//button[.='Try login']")
	public WebElement tryLoginButton;

	@FindBy(xpath="//button[@value='no']")
	public WebElement click_No;

	@FindBy(xpath="//*[@id=\"DescPop\"]/div[2]/form/div[3]/button")
	public WebElement accept;

	String errorMessage;

	public void ngnixLogin(String Username, String Password) {
		try {
			// String url = driver.getCurrentUrl();
			// System.out.println("url : " +url);
			String urlWithCred = "https://" + username + ":" + password + "@"
					+ testBase.getAppURL().replace("https://", "") + "/jenkinscore/";
			System.out.println(urlWithCred);
			driver.get(urlWithCred);
			commonMethods.waitForPageToLoad();
			logger.log(LogStatus.INFO, "Ngnix login Successful");
			System.out.println("Ngnix login Successful");
			driver.get(testBase.getAppURL());
			commonMethods.waitForPageToLoad();
		} catch (Exception e) {
			logger.log(LogStatus.INFO, "Ngnix login failed");
			System.out.println("Ngnix login failed");
			System.out.println(e);
		}
	}


	public boolean devOpsPlatformLogin(String username,String password) throws InterruptedException {
		commonMethods.waitForPageToLoad();

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

			if(platformPassword.getText().equals("")) {
				logger.log(LogStatus.PASS, "Data is masked for password field");
				System.out.println("Data is masked for password field");
				return true;
			}
			else {
				logger.log(LogStatus.FAIL, "Data is not masked for password field");
				System.out.println("Data is not masked for password field");
				return false;
			}
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Platform is down");
			System.out.println(e);
			System.out.println("Platform is down");
			Assert.fail("Platform is down");
			return false;
		}
	}

}
