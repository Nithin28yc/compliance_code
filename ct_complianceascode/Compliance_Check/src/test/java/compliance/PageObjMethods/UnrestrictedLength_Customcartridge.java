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

public class UnrestrictedLength_Customcartridge extends testBase {
	private WebDriver driver = BrowserConfig.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 45);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);

	@FindBy(xpath = "//a[@href='#/manage']")
	public WebElement managetab;

	@FindBy(xpath = "//div[text()='Add Custom Pipeline']")
	public WebElement addcustompipeline;
	
	@FindBy(xpath = "(//a[@href='#/manage##'])[2]")
	public WebElement addcustompipelinetool;
	

	@FindBy(xpath = "//input[@name='Cartridge_Name']")
	public WebElement cartridgename;
	
	@FindBy(xpath = "(//input[@name='Version'])[2]")
	public WebElement pipversion;
	
	@FindBy(xpath = "(//span[@class='errorMessage'])[3]")
	public WebElement invalidversionmessage;
	
	@FindBy(xpath = "//input[@name='Pipeline_name']")
	public WebElement pipelinename;
	
	@FindBy(xpath = "//input[@name='Path']")
	public WebElement pipelinepath;
	
	@FindBy(xpath = "//button[text()='Verify']")
	public WebElement Verifybutton;
	
	
	@FindBy(xpath = "(//span[@class='errorMessage'])[2]")
	public WebElement errormessage;
	
	
	@FindBy(xpath = "(//span[@class='errorMessage'])[4]")
	public WebElement errormessage1;
	
	@FindBy(xpath = "//p[@id='noPath']")
	public WebElement pipelinepatherrormessage;
	

	@FindBy(xpath = "//span[@title='addCustomCartridgeundefined']")
	public WebElement cancelbutton;


	public void Addcustompipeline() throws InterruptedException {

		commonMethods.waitForPageToLoad();
		try {
			logger.log(LogStatus.INFO, "Click on Manageplatform tab");
			System.out.println("Click on Manageplatform tab");
			managetab.click();
			commonMethods.waitForPageToLoad();

			logger.log(LogStatus.INFO, "Click on Addcustompipeline ");
			System.out.println("Click on Addcustompipeline");
			
			commonMethods.waitForPageToLoad();

		}
		catch (Exception e) {
			System.out.println(e);
			logger.log(LogStatus.INFO, "User is not able to navigate to custompipeline page");
			System.out.println("User is not able to navigate to custompipeline page");
			Assert.fail("User is not able to navigate to custompipeline page");
		}

	}

	public void verifyCartridgeName(String Cartridgename) {
		try {
			addcustompipelinetool.click();
			String message="Minimum 3 characters, name must start with alphabets,only '_' is allowed as special character";

			logger.log(LogStatus.INFO, "Enter the Cartridgename ");
			System.out.println("Enter the Cartridgename");

			cartridgename.click();
			cartridgename.sendKeys(Cartridgename);
			
			int length=Cartridgename.length();
			char c=Cartridgename.charAt(0);
			boolean d=Character.isDigit(c);
			
			commonMethods.waitForPageToLoad();
			
			Pattern pattern = Pattern.compile("[^a-zA-Z0-9_ ]");
			Matcher match = pattern.matcher(Cartridgename);
			boolean crt = match.find();
			System.out.println(crt);
			commonMethods.waitForPageToLoad();

			if(length>=3 && d==false && crt==false)
			{
				logger.log(LogStatus.PASS, "Valid Cartridgename");
				System.out.println("Valid Cartridgename");
				cartridgename.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}
			else {
				String wrongmessage=errormessage.getText();
				logger.log(LogStatus.FAIL, "Failed to validate the Cartridgename the wrong message is : "+wrongmessage);
				System.out.println("Failed to validate the Cartridgename the wrong message is : "+wrongmessage);
				cartridgename.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
				
			}
		
		}
		catch (Exception e) {				
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to add cartridgename");
			System.out.println("User is not able to add cartridgename");
			Assert.fail("User is not able to add cartridgename");
		}

	}
	public void verifyVersion(String pipelineversion) {
		try {
			addcustompipelinetool.click();
			logger.log(LogStatus.INFO, "Enter the Version");
			System.out.println("Enter the Version");
			pipversion.click();
			pipversion.sendKeys(pipelineversion);
			int length=pipelineversion.length();

			Pattern pattern = Pattern.compile("[0-9]{1,4}+\\.+[0-9]{1,4}+\\.+[0-9]{1,4}");

			Matcher match = pattern.matcher(pipelineversion);
			boolean crt = match.find();

			commonMethods.waitForPageToLoad();
			Pattern pattern1 = Pattern.compile("[0-9]{1,3}+\\.+[0-9]{1,3}+\\.+[0-9]{1,3}");

			Matcher match1 = pattern1.matcher(pipelineversion);
			boolean crt1 = match1.find();

			Pattern pattern2 = Pattern.compile("^[0-9]");
			Matcher match2 = pattern2.matcher(pipelineversion);
			boolean crt2 = match2.find();
			
			if(crt==true)
			{
				logger.log(LogStatus.PASS, "Valid Version");
				System.out.println("Valid Version");
				pipversion.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}

			else if(crt1==true)
			{
				logger.log(LogStatus.PASS, "Valid Version");
				System.out.println("Valid Version");
				pipversion.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}
			else if(crt2==true && length<=3) {
				logger.log(LogStatus.PASS, "Valid Version");
				System.out.println("Valid Version");
				pipversion.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}
			else {

				String wrongmessage=invalidversionmessage.getText();
				logger.log(LogStatus.FAIL, "Failed to validate the Version the wrong message is : "+wrongmessage);
				System.out.println("Failed to validate the Version the wrong message is : "+wrongmessage);
				pipversion.clear();
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




public void verifypipelineName(String Pipelinename) {
	try {
		addcustompipelinetool.click();
		

		logger.log(LogStatus.INFO, "Enter the Pipeline name ");
		System.out.println("Enter the Pipeline name");

		pipelinename.click();
		pipelinename.sendKeys(Pipelinename);
		
		int length=Pipelinename.length();
		char c=Pipelinename.charAt(0);
		boolean d=Character.isDigit(c);
		
		commonMethods.waitForPageToLoad();
		
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9_ ]");
		Matcher match = pattern.matcher(Pipelinename);
		boolean crt = match.find();
		commonMethods.waitForPageToLoad();

		if(length>=3 && d==false && crt==false)
		{
			logger.log(LogStatus.PASS, " Valid Pipeline Name ");
			System.out.println("Valid Pipeline Name");
			pipelinename.clear();
			cancelbutton.click();
			commonMethods.waitForPageToLoad();
		}
		else {
			String wrongmessage=errormessage1.getText();
			logger.log(LogStatus.FAIL, "Failed to validate the Pipelinename the wrong message is : "+wrongmessage);
			System.out.println("Failed to validate the Pipelinename the wrong message is : "+wrongmessage);
			pipelinename.clear();
			cancelbutton.click();
			commonMethods.waitForPageToLoad();
			
		}
	
	}
	catch (Exception e) {				
		System.out.println(e);
		logger.log(LogStatus.FAIL, "User is not to add Pipeline name");
		System.out.println("User is not able to add Pipeline name");
		Assert.fail("User is not able to add Pipeline name");
	}

	
}
	
	public void verifypipelinepath(String Pipelinepath,String Cartridgename) {
		try {
			String Pipelinepathname="Dev_Workspace/job/"+Cartridgename+"/job/BuildJob/";
		
			addcustompipelinetool.click();
			logger.log(LogStatus.INFO, "Enter the Pipeline Path ");
			System.out.println("Enter the name of Pipeline Path");

			pipelinepath.click();
			pipelinepath.sendKeys(Pipelinepath);
			Verifybutton.click();
			commonMethods.waitForPageToLoad();
			
			

			if(Pipelinepathname.equals(Pipelinepath))
			{
				logger.log(LogStatus.PASS, " Valid Pipelinepath");
				System.out.println("Valid Pipelinepath");
				pipelinepath.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}
			else {
				String wrongmessage=pipelinepatherrormessage.getText();
				logger.log(LogStatus.FAIL, "Failed to validate the Pipelinepath the wrong message is : "+wrongmessage);
				System.out.println("Failed to validate the Pipelinepath the wrong message is : "+wrongmessage);
				pipelinepath.clear();
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
				
			}
		
		}
		catch (Exception e) {				
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to add pipelinepath ");
			System.out.println("User is not able to add pipelinepath");
			Assert.fail("User is not able to add pipelinepath ");
		}
	
}

}




















