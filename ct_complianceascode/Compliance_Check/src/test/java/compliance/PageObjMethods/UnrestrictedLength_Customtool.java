package compliance.PageObjMethods;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Generic.TestBase.BrowserConfig;
import Generic.TestBase.CommonMethods;
import Generic.TestBase.testBase;

public class UnrestrictedLength_Customtool  extends testBase{


	private WebDriver driver = BrowserConfig.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 45);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);

	@FindBy(xpath = "//a[@href='#/manage']")
	public WebElement managetab;

	@FindBy(xpath = "(//a[@href='#/manage##'])[1]")
	public WebElement addcustomtool;

	@FindBy(xpath = "//input[@name='Name']")
	public WebElement toolname;

	@FindBy(xpath = "(//span[@class='errorMessage'])[1]")
	public WebElement Invalidtoolnamemessage;

	@FindBy(xpath = "//input[@name='Display_Name']")
	public WebElement displayname;

	@FindBy(xpath = "(//span[@class='errorMessage'])[2]")
	public WebElement Invalidisplaynamemessage;

	@FindBy(xpath = "//input[@name='Desc']")
	public WebElement desc;

	@FindBy(xpath = "(//span[@class='errorMessage'])[1]")
	public WebElement descinvalidmessage;


	@FindBy(xpath = "//span[text()='Yes']")
	public WebElement interfacebutton;


	@FindBy(xpath = "//input[@name='Url']")
	public WebElement url;


	@FindBy(xpath = "(//span[@class='errorMessage'])[3]")
	public WebElement Urlinvalidmessage;

	@FindBy(xpath = "//input[@name='Version']")
	public WebElement version;

	@FindBy(xpath = "(//span[@class='errorMessage'])[2]")
	public WebElement Versioninvalidmessage;




	@FindBy(xpath = "//span[@title='addCustomToolundefined']")
	public WebElement cancelbutton;

	public void Manageuser() throws InterruptedException {

		commonMethods.waitForPageToLoad();
		try {
			logger.log(LogStatus.INFO, "Click on Manage Platform tab");
			System.out.println("Click on Manage Platform tab");
			managetab.click();
			commonMethods.waitForPageToLoad();

			logger.log(LogStatus.INFO, "Click on Addcustom tool");
			System.out.println("Click on Addcustom tool");
			commonMethods.waitForPageToLoad();
		}
		catch (Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to navigate to Addcustomtool");
			System.out.println("User is not able to navigate to Addcustomtool");
			Assert.fail("User is not able to navigate to Addcustomtool");
		}

	}

	public void verifytoolName(String Toolname) {
		try {
			addcustomtool.click();
			logger.log(LogStatus.INFO, "Enter the Toolname");
			System.out.println("Enter the Toolname");
			toolname.click();
			toolname.sendKeys(Toolname);
			int length=Toolname.length();
			char c=Toolname.charAt(0);
			boolean d=Character.isDigit(c);
			System.out.println(d);


			//String regex =  "(?=.*[!@#$%^&=+])";

			//String regex="(?=^.{3,}$)"+"^[A-Za-z]+"+"^(?=.*[!@#$%^&=+])"
			Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");

			Matcher match = pattern.matcher(Toolname);
			boolean crt = match.find();
			System.out.println(crt);
			commonMethods.waitForPageToLoad();

			if( length>=3 && d==false && crt==false )
			{
				logger.log(LogStatus.PASS, "Valid Toolname");
				System.out.println("Valid Toolname");
				toolname.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}	

			else {

				String wrongmessage=Invalidtoolnamemessage.getText();
				logger.log(LogStatus.FAIL, "Failed  to validate the Toolname and the wrong message is : "+wrongmessage);
				System.out.println("Failed  to validate the Toolname and the wrong message is : "+wrongmessage);
				toolname.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}

		}
		catch (Exception e) {				
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to add Toolname");
			System.out.println("User is not able to add Toolname");
			Assert.fail("User is not able to add Toolname");
		}

	}



	public void verifyDisplayName(String Displayname) {
		try {
			addcustomtool.click();
			logger.log(LogStatus.INFO, "Enter the Displayname");
			System.out.println("Enter the Displayname");
			displayname.click();
			displayname.sendKeys(Displayname);
			int length=Displayname.length();
			char c=Displayname.charAt(0);
			boolean d=Character.isDigit(c);
			System.out.println(d);
			Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");

			Matcher match = pattern.matcher(Displayname);
			boolean crt = match.find();
			System.out.println(crt);
			commonMethods.waitForPageToLoad();

			if( length>=3 && d==false && crt==false )
			{
				logger.log(LogStatus.PASS, "Valid Displayname");
				System.out.println("Valid Displayname");
				displayname.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}	

			else {

				String wrongmessage=Invalidisplaynamemessage.getText();
				logger.log(LogStatus.FAIL, "Failed  to validate the Displayname and the wrong message is : "+wrongmessage);
				System.out.println("Failed  to validate the Displayname and the wrong message is : "+wrongmessage);
				displayname.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}

		}
		catch (Exception e) {				
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to add Displayname");
			System.out.println("User is not able to add Displayname");
			Assert.fail("User is not able to add Displayname");
		}
		
	}
	
	public void verifyDescription(String Description) {
		try {
			//driver.navigate().refresh();
			addcustomtool.click();
			logger.log(LogStatus.INFO, "Enter the Description");
			System.out.println("Enter the Description");
			desc.click();
			desc.sendKeys(Description);
			int length=Description.length();
			char c=Description.charAt(0);
			boolean d=Character.isDigit(c);
			System.out.println(d);
			Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");

			Matcher match = pattern.matcher(Description);
			boolean crt = match.find();
			System.out.println(crt);
			commonMethods.waitForPageToLoad();

			if( length>=55 && d==false && crt==false )
			{
				logger.log(LogStatus.PASS, "Valid Description");
				System.out.println("Valid Description");
				desc.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}	

			else {

				String wrongmessage=descinvalidmessage.getText();
				logger.log(LogStatus.FAIL, "Failed to validate the Description and the wrong message is : "+wrongmessage);
				System.out.println("Failed to validate the Description and the wrong message is : "+wrongmessage);
				desc.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}

		}
		catch (Exception e) {				
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to add Description");
			System.out.println("User is not able to add Description");
			Assert.fail("User is not able to add Description");
		}
	}


	public void verifyURL(String URL) {
		try {
			addcustomtool.click();
			logger.log(LogStatus.INFO, "Enter the URL");
			System.out.println("Enter the URL");
			interfacebutton.click();
			commonMethods.waitForPageToLoad();
			url.click();
			url.sendKeys(URL);


			Pattern p = Pattern.compile("(https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|www\\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\\.[^\\s]{2,}|https?:\\/\\/(?:www\\.|(?!www))[a-zA-Z0-9]+\\.[^\\s]{2,}|www\\.[a-zA-Z0-9]+\\.[^\\s]{2,})");

			Matcher m = p.matcher(URL);
			boolean correct = m.find();
			System.out.println(correct);
			commonMethods.waitForPageToLoad();

			if(correct==true )
			{
				logger.log(LogStatus.PASS, "Valid URL");
				System.out.println("Valid URL");
				url.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}	

			else {

				String wrongmessage=Urlinvalidmessage.getText();
				logger.log(LogStatus.FAIL, "Failed to validate the URL and the wrong message is : "+wrongmessage);
				System.out.println("Failed to validate the URL and the wrong message is : "+wrongmessage);
				url.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}

		}
		catch (Exception e) {				
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to add URL");
			System.out.println("User is not able to add URL");
			Assert.fail("User is not able to add URL");
		}
	}


	public void verifyVersion(String Version) {
		try {
			addcustomtool.click();
			logger.log(LogStatus.INFO, "Enter the Version");
			System.out.println("Enter the Version");
			version.click();
			version.sendKeys(Version);
			int length=Version.length();

			Pattern pattern = Pattern.compile("[0-9]{1,4}+\\.+[0-9]{1,4}+\\.+[0-9]{1,4}");

			Matcher match = pattern.matcher(Version);
			boolean crt = match.find();

			commonMethods.waitForPageToLoad();
			Pattern pattern1 = Pattern.compile("[0-9]{1,3}+\\.+[0-9]{1,3}+\\.+[0-9]{1,3}");

			Matcher match1 = pattern1.matcher(Version);
			boolean crt1 = match1.find();

			Pattern pattern2 = Pattern.compile("^[0-9]");
			Matcher match2 = pattern2.matcher(Version);
			boolean crt2 = match2.find();
			
			if(crt==true)
			{
				logger.log(LogStatus.PASS, "Valid Version");
				System.out.println("Valid Version");
				version.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}

			else if(crt1==true)
			{
				logger.log(LogStatus.PASS, "Valid Version");
				System.out.println("Valid Version");
				version.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}
			else if(crt2==true && length<=3) {
				logger.log(LogStatus.PASS, "Valid Version");
				System.out.println("Valid Version");
				version.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}
			else {

				String wrongmessage=Versioninvalidmessage.getText();
				logger.log(LogStatus.FAIL, "Failed to validate the Version and the wrong message is : "+wrongmessage);
				System.out.println("Failed to validate the Version and the wrong message is : "+wrongmessage);
				version.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}

		}
		catch (Exception e) {				
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to add Version");
			System.out.println("User is not able to add Version");
			Assert.fail("User is not able to add Version");
		}

	}
}
















