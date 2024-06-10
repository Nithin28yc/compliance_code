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

public class Testing_MFA extends testBase{
	private WebDriver driver = BrowserConfig.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 45);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);

	@FindBy(xpath = "//div[text()='Sign in']")
	public WebElement word;

	@FindBy(xpath = "//*[@id=\"i0116\"]")
	public WebElement enterpriseId;

	@FindBy(xpath = "//*[@id=\"idSIButton9\"]")
	public WebElement next;

	@FindBy(xpath = "//*[@id=\"i0118\"]")
	public WebElement enterprisePass;

	@FindBy(id ="idSIButton9")
	public WebElement signIn;

	@FindBy(id ="passwordError")
	public WebElement passErr;

	@FindBy(xpath = "//*[@id=\"idDiv_SAOTCAS_Title\"]")
	public WebElement text;

	@FindBy(xpath = "//a[@id='signInAnotherWay']")
	public WebElement signOtherWay;

	@FindBy(xpath = "//*[@id=\"idDiv_SAOTCS_Proofs\"]/div[4]/div/div/div[2]/div")
	public WebElement call;

	@FindBy(xpath = "//*[@id=\"mywprivacy\"]/div/h6")
	public WebElement cookieheading;

	public boolean verify_MFA(String enterpriseID, String enterprisePassword) throws InterruptedException{
		SoftAssert softassert = new SoftAssert();
		try {
			wait.until(ExpectedConditions.visibilityOf(enterpriseId));
			softassert.assertEquals(word.getText(), "Sign in");
			logger.log(LogStatus.INFO, "Entering the Enterprise Id");
			System.out.println("Entering the Enterprise Id");
			enterpriseId.sendKeys(enterpriseID);
			commonMethods.waitForPageToLoad();
			next.click();

			wait.until(ExpectedConditions.visibilityOf(enterprisePass));			
			logger.log(LogStatus.INFO, "Entering the Enterprise password");
			System.out.println("Entering the Enterprise password");
			enterprisePass.sendKeys(enterprisePassword);
			commonMethods.waitForPageToLoad();
			System.out.println("Clicking on SignIn button");
			signIn.click();
			commonMethods.waitForPageToLoad();
			wait.until(ExpectedConditions.visibilityOf(text));
			//				if(code.getText().equals("Enter code")) {
			try {
				if(text.getText().contains("Approve sign in request")) {
//					wait.until(ExpectedConditions.visibilityOf(signOtherWay));
//					logger.log(LogStatus.INFO, "Clicking on SignIn another way");
//					System.out.println("Clicking on SignIn another way");
//					signOtherWay.click();
//					commonMethods.waitForPageToLoad();

					logger.log(LogStatus.INFO, "Authenticator needs a approve code from the mobile");
					System.out.println("Authenticator needs a approve code from the mobile");

					logger.log(LogStatus.FAIL, "MFA has not been approved by user");
					System.out.println("MFA has not been approved by user");
					return false;
				}
				else {
					logger.log(LogStatus.FAIL, "Multifactor authentication is not been implemented");
					System.out.println("Multifactor authentication is not been implemented");
					return false;
				}
			}
			catch(Exception e) {
				logger.log(LogStatus.FAIL, "Multifactor authentication is not been implemented");
				System.out.println("Multifactor authentication is not been implemented");
				return false;
			}

		}
		catch (Exception e) {
			logger.log(LogStatus.FAIL, "Please provide proper credenials to check MFA");
			System.out.println("Please provide proper credenials to check MFA");
			System.out.println(e);
			return false;
		}
	}
}
