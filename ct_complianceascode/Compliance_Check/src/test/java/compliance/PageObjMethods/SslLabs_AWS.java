package compliance.PageObjMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Generic.TestBase.BrowserConfig;
import Generic.TestBase.CommonMethods;
import Generic.TestBase.testBase;
import io.appium.java_client.functions.ExpectedCondition;

public class SslLabs_AWS extends testBase {

	private WebDriver driver = BrowserConfig.getDriver();
	CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);
	WebDriverWait wait = new WebDriverWait(driver, 200);
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchtab;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement submitbutton;

	@FindBy(xpath = "//a[contains(text(),'Clear cache')]")
	public WebElement clear;

	@FindBy(xpath = "//*[@id='multiTable']/tbody/tr[3]/td[2]/span[3]")
	public WebElement server;
	
	@FindBy(xpath = "//a[contains(text(),'Ignore Certificate Mismatch ')]")
	public WebElement ignorecertificate;

	@FindBy(xpath = "//table[@id='multiTable']/tbody/tr[3]/td[2]/span[1]")
	public WebElement firstlink;

	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/text()")
	public WebElement sslReport;

	@FindBy(xpath = "//*[@id='gradeA']")
	public WebElement SSLgrade;

	@FindBy(xpath = "//*[@id=\"page\"]")
	public WebElement content;

	@FindBy(xpath = "//*[@id=\"main\"]/div[5]/div[3]/div[2]/table[1]/tbody/tr[2]/td[1]")
	public WebElement TLSVersion;

	@FindBy(xpath = "//*[@id=\"main\"]/div[5]/div[3]/div[2]/table[1]/tbody/tr[2]/td[2]")
	public WebElement TLSyes;

	@FindBy(xpath = "//a[contains(text(),'Scan Another')]")
	public WebElement ScanAnotherlink;

	@FindBy(xpath = "//span[@class='url']")
	public WebElement urllink;

	@FindBy(xpath = "//span[contains(text(),'Ready')]")
	public WebElement Ready;

	public boolean searchAllurl(String scanurl) throws InterruptedException {
		//		commonMethods.waitForPageToLoad();
		logger.log(LogStatus.INFO, "Passing the url for ssl scan");
		System.out.println("Passing the url for ssl scan");	
		searchtab.click();
		searchtab.sendKeys(scanurl);

		logger.log(LogStatus.INFO, "Clicking on submit button");
		System.out.println("Clicking on submit button");
		submitbutton.click();

		wait.until(ExpectedConditions.visibilityOf(clear));
		if(clear.getText().equals("Clear cache")) {

			try {
				commonMethods.waitForPageToLoad();

				logger.log(LogStatus.INFO, "Clicking on first server ip to get result");
				System.out.println("Clicking on first server ip to get result");
				firstlink.click();

				commonMethods.waitForPageToLoad();
				logger.log(LogStatus.INFO, "Overall rating of the url for SSL check is "+SSLgrade.getText());
				System.out.println("Overall rating of the url for SSL check is "+SSLgrade.getText());

				//System.out.println(content.getText());
				String currentUrl = driver.getCurrentUrl();
				logger.log(LogStatus.INFO, "Details: "+currentUrl);
				System.out.println("Details: "+currentUrl);
				TLSVersion.click();
				if (TLSVersion.getText().equals("TLS 1.2")) {
					if (TLSyes.getText().equals("Yes")) {
						logger.log(LogStatus.PASS, "The TLS Version is :" + TLSVersion.getText() + " which is as expected.");
						logger.log(LogStatus.INFO, "Rigorous assessments confirm the SSL implementation's effectiveness in safeguarding data transmission and protecting against potential vulnerabilities.");
						logger.log(LogStatus.INFO, "The successful validation of the SSL control underscores a steadfast commitment to data security and adherence to industry standards. Continued vigilance, regular monitoring, and periodic assessments are recommended to sustain this validation outcome, ensuring ongoing protection against potential threats and maintaining a secure online environment aligned with cybersecurity best practices.");
						logger.log(LogStatus.INFO, "Confirming the implementation of Perfect Forward Secrecy (PFS) in conjunction with TLS 1.2 to enhance data protection against potential key compromise.");
						System.out.println("The TLS Version is :" + TLSVersion.getText() + " which is as expected.");
						return true;
					}
					else {
						logger.log(LogStatus.FAIL, "TLS Version is not as expected");
						logger.log(LogStatus.INFO, "A critical situation unfolds as the SSL (Secure Sockets Layer) control fails validation, unveiling vulnerabilities within the SSL implementation. This failure raises concerns about potential data breaches and inadequate security measures.");
						logger.log(LogStatus.INFO, "Confirming that secure SSL/TLS protocol versions are in use, avoiding vulnerabilities associated with outdated or insecure protocols. Verifying SSL/TLS configurations align with industry best practices, including disabling weak ciphers and enforcing secure protocols");
						logger.log(LogStatus.INFO, "Verifying that SSL certificates are not expired, avoiding disruptions in secure communication due to outdated certificates.");
						logger.log(LogStatus.INFO, "Checking for correct HTTP Strict Transport Security (HSTS) header implementation to ensure consistent HTTPS usage and prevent downgrade attacks");
						System.out.println("TLS Version is not as expected");
						return false;
					}
				}
				else {
					return false;
				}

			}

			catch(Exception e) {
				System.out.println(e);
				logger.log(LogStatus.FAIL, "No secure protocols supported- - the server responded with plain-text HTTP on HTTPS port");
				System.out.println("No secure protocols supported- - the server responded with plain-text HTTP on HTTPS port");
				return false;
			}
		}
		else {
			logger.log(LogStatus.FAIL, "Certificate not valid for domain name: The grade is T");
			System.out.println("Certificate not valid for domain name: The grade is T");
			return false;
		}
	}
}
//		try {
//
//			if (driver.findElement(By.xpath("//a[contains(text(),'Ignore Certificate Mismatch ')]")).isDisplayed()) {
//
//				logger.log(LogStatus.INFO, "Ignore Certificate Mismatch alert has been notified");
//				System.out.println("Ignore Certificate Mismatch alert has been notified");
//
//				ignorecertificate.click();
//				Thread.sleep(140000);
//
//				logger.log(LogStatus.INFO, "Clicked on the first server link");
//				System.out.println("Clicked on the first server link");
//
//				firstlink.click();
//
//			}
//		} catch (Exception e) {
//			System.out.println("Error:" + e);
//			logger.log(LogStatus.INFO, "The Server IP is already loaded , So it directly needs to click the Server IP link");
//			System.out.println("The Server IP is already loaded , So it directly needs to click the Server IP link");
//		}
//		
//		try {
//			if (driver.findElement(By.xpath("//a[contains(text(),'Scan Another')]")).isDisplayed()) {
//
//				Thread.sleep(6000);
//				logger.log(LogStatus.INFO, "Scan Another is Displayed and Server Ip is already loaded which is as expected. ");
//				System.out.println("Scan Another is Displayed and Server Ip is already loaded which is as expected. ");
//
//				firstlink.click();
//			}
//		} catch (Exception e) {
//			System.out.println("Error:" + e);
//			logger.log(LogStatus.INFO, "The Server IP is not loaded as it needs permission to 'Ignore Certificate Mistmatch' ");
//			System.out.println("The Server IP is not loaded as it needs permission to 'Ignore Certificate Mistmatch' ");
//		}
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//		System.out.println("Server link has opened");
//		logger.log(LogStatus.INFO, "Server link has opened");
//
//		Thread.sleep(10000);

//		String TLSvalue = YESdata.getText();
//		System.out.println(TLSvalue);
//
//		String TLSversion = TLSdata.getText();
//		System.out.println(TLSversion);
//
//		if (TLSversion.equals("TLS 1.2")) {
//			logger.log(LogStatus.PASS, "The TLS Version is :" + TLSversion + " which is as expected.");
//			System.out.println("The TLS Version is " + TLSversion + " which is as expected.");
//
//			if (TLSvalue.equals("Yes")) {
//
//				logger.log(LogStatus.PASS, "The TLS Version is: " + TLSversion + " and the value is " + TLSvalue
//						+ " which is as expected.");
//				System.out.println("The TLS Version is: " + TLSversion + " and the value is " + TLSvalue
//						+ " which is as expected.");
//
//			} else {
//				logger.log(LogStatus.FAIL, "TLS Value is :" + TLSvalue);
//				System.out.println("The TLS Value is " + TLSvalue);
//			}
//		} else {
//			logger.log(LogStatus.FAIL, "The selected value for the above TLS Version is :" + TLSversion);
//			System.out.println("The selected value for the above TLS Version is : " + TLSversion);
//
//		}

// urllink.click();
// System.out.println("Clicked on url");
//
// ScanAnotherlink.click();



