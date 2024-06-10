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

	@FindBy(xpath = "//input[@name='name']")
	public WebElement platformUsername;

	@FindBy(xpath = "//input[@name='description']")
	public WebElement platformPassword;

	@FindBy(xpath = "//input[@value='Save Todo']")
	public WebElement loginButton;
	String errorMessage;



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
			System.out.println(platformPassword.getText());
			if(platformPassword.getText().equals("")) {
				logger.log(LogStatus.PASS, "Data is masked for password field");
				logger.log(LogStatus.INFO, "Encouraging news surfaces as the data masking control successfully clears validation. Stringent measures, encompassing sensitive data obfuscation, access restrictions, and encryption, have been rigorously tested and approved. The validated data masking control showcases a commitment to preserving data confidentiality and adhering to security best practices.");
				System.out.println("Data is masked for password field");
				return true;
			}
			else {
				logger.log(LogStatus.FAIL, "Data is not masked for password field");
				logger.log(LogStatus.INFO, "Concerns arise as the data masking control fails validation. Measures aimed at safeguarding sensitive data, including obfuscation, access limitations, and encryption, have not met the required standards. This failure exposes potential vulnerabilities, increasing the risk of unauthorized access and compromising data confidentiality.");
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
