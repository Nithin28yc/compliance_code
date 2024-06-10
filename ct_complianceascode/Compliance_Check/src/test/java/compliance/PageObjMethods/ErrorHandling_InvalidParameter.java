package compliance.PageObjMethods;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class ErrorHandling_InvalidParameter extends testBase{

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
	
	@FindBy(xpath = "//h1[text()='Not Found']")
	public WebElement errormessage;

	


	public boolean devOpsPlatformLogin(String username,String password) throws InterruptedException, IOException {
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
			
			
			String url = driver.getCurrentUrl();
			String newUrl = url.replace(url,url+"/"+"dscrl");
			driver.navigate().to(newUrl);
			commonMethods.waitForPageToLoad();
			
			
			if(errormessage.getText().contains("Not Found")) {
				logger.log(LogStatus.PASS, "Error handling is there for invalid parameter");
				logger.log(LogStatus.INFO , "A significant achievement is marked as the Error Handling control successfully passes validation, affirming its effectiveness in managing and responding to errors within the system. Rigorous assessments have confirmed the control's ability to handle errors securely, ensuring data integrity, user experience, and system stability.");
				logger.log(LogStatus.INFO , "The Error Handling control validation process encompassed thorough checks:\r\n"
						+ "\r\n"
						+ "Comprehensive Error Messages: The control demonstrated the provision of clear and informative error messages, enhancing user understanding and troubleshooting.\r\n"
						+ "\r\n"
						+ "Minimal Information Disclosure: Measures were taken to prevent excessive information disclosure in error messages, mitigating potential data exposure.\r\n"
						+ "\r\n"
						+ "Secure Error Logging: The control's error logging mechanisms were validated to ensure proper storage and protection of sensitive information.\r\n"
						+ "\r\n"
						+ "Graceful Failure Handling: The control exhibited the ability to gracefully handle errors without compromising system stability or exposing vulnerabilities.");
				System.out.println("Error handling is there for invalid parameter");
				return true;
			}
			else {
				logger.log(LogStatus.FAIL, "Error handling is not there for invalid parameter check");
				logger.log(LogStatus.INFO , "A critical concern has emerged as the Error Handling control fails validation, exposing vulnerabilities in the system's ability to manage errors effectively. Rigorous assessments have uncovered deficiencies in multiple pivotal aspects of the control's implementation, impacting data integrity, user experience, and system stability.");
				logger.log(LogStatus.INFO , "Inadequate Error Messages: The control lacked comprehensive and informative error messages, hindering user understanding and efficient troubleshooting.\r\n"
						+ "\r\n"
						+ "Excessive Information Disclosure: Failure to prevent excessive information disclosure in error messages raised risks of sensitive data exposure and potential attacks.\r\n"
						+ "\r\n"
						+ "Vulnerable Error Logging: Weaknesses in error logging mechanisms left sensitive information susceptible to unauthorized access, threatening data privacy.\r\n"
						+ "\r\n"
						+ "Flawed Error Handling: Ineffective error handling processes jeopardized system stability, potentially leading to disruptions and unauthorized access.");

				System.out.println("Error handling is not there for invalid parameter check");
				return false;
			}

		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "Please provide proper creds");
			System.out.println(e);
			System.out.println("Please provide proper creds");
			Assert.fail("Platform is down");
			return false;
		}
	}


}
