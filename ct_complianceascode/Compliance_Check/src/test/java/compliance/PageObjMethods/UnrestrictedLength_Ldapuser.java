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
import Generic.TestBase.ExcelOp;
import Generic.TestBase.testBase;

public class UnrestrictedLength_Ldapuser extends testBase
{
	private WebDriver driver = BrowserConfig.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 45);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);

	@FindBy(xpath = "//a[@href='#/manage']")
	public WebElement managetab;

	@FindBy(xpath = "//a[@href='#/ldapusers']")
	public WebElement manageLdapUser;

	@FindBy(xpath = "//span[text()='Add LDAP User']")
	public WebElement addLdapuser;

	@FindBy(xpath = "//input[@name='userName']")
	public WebElement Name;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement email;

	@FindBy(xpath = "//*[@id=\"addLdapUserModal\"]/div[2]/div/form/div[2]/div[4]/input")
	public WebElement password;

	@FindBy(id = "confirmpassword")
	public WebElement confirmpassword;

	@FindBy(xpath = "//button[text()='Add User']")
	public WebElement addUser;

	@FindBy(xpath = "//span[@class='errorMessage']")
	public WebElement errMsg;

	@FindBy(xpath ="(//span[@class='errorMessage'])[1]")
	public WebElement msg;
	
	@FindBy(xpath = "//span[text()='Invalid email address']")
	public WebElement Invalidemailmessage;

	@FindBy(xpath = "//span[@title='addLdapUserModal']")
	public WebElement cancelbutton;

	public void Manageplatformtab() throws InterruptedException {

		commonMethods.waitForPageToLoad();
		try {
			logger.log(LogStatus.INFO, "Click on Manage Platform tab");
			System.out.println("Click on Manage Platform tab");
			managetab.click();
			commonMethods.waitForPageToLoad();
			
			logger.log(LogStatus.INFO, "Click on manage LDAP User");
			System.out.println("Click on manage LDAP User");
			manageLdapUser.click();
			commonMethods.waitForPageToLoad();

			logger.log(LogStatus.INFO, "Click on add Ldap User");
			System.out.println("Click on add Ldap User");
			commonMethods.waitForPageToLoad();
		}
		
		catch (Exception e) {
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to Navigate to manage Ldap user page");
			System.out.println("User is not able to Navigate to manage Ldap user page");
			Assert.fail("User is not able to Navigate to manage Ldap user page");
		}
	}
	
	public void verifyName(String Username) {
		try {
			addLdapuser.click();
			logger.log(LogStatus.INFO, "Enter the name of Ldap user");
			System.out.println("Enter the name of Ldap user");
			Name.click();
			Name.sendKeys(Username);
			int length=Username.length();
			char c=Username.charAt(0);
			boolean d=Character.isDigit(c);
			String regex ="(?=.*[!@#$%^&=+])";
			Pattern pattern = Pattern.compile(regex);
			Matcher match = pattern.matcher(Username);
			boolean crt = match.matches();
			commonMethods.waitForPageToLoad();

			if(length<3 || d==true || crt==true )
			{
				String wrongmessage=msg.getText();
				logger.log(LogStatus.FAIL, "Failed to validate the Name of LDAP-User and the wrong message is : "+wrongmessage);
				System.out.println("Failed to validate the Name of LDAP-User and the wrong message is : "+wrongmessage);
				cancelbutton.click();
				commonMethods.waitForPageToLoad();

			}	
			else {
				logger.log(LogStatus.PASS, "Valid Username");
				System.out.println("Valid Username");
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}
		}
		catch (Exception e) {				
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to add the Name of Ldap user");
			System.out.println("User is not able to add the Name of Ldap user");
			Assert.fail("User is not able to add the Name of Ldap user");
		}

	}
	public void verifyEmail(String Email) {
		try {
			addLdapuser.click();
			logger.log(LogStatus.INFO, "Enter the Email of Ldap user");
			System.out.println("Enter the Email of Ldap user");
			email.click();
			email.sendKeys(Email);
		    String value="@";
		    String val=".com";
			commonMethods.waitForPageToLoad();
			if(!(Email.contains(value) &&  Email.contains(val) ))
			{
				String wrongmessage=Invalidemailmessage.getText();
				logger.log(LogStatus.FAIL, "Failed to validate the Email of LDAP-User and the wrong message is : "+wrongmessage);
				System.out.println("Failed to validate the Email of LDAP-User and the wrong message is : "+wrongmessage);
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}	
			else {
				logger.log(LogStatus.PASS, "Valid Email");
				System.out.println("Valid Email");
				cancelbutton.click();
				commonMethods.waitForPageToLoad();
			}
		}
		catch (Exception e) {				
			System.out.println(e);
			logger.log(LogStatus.FAIL, "User is not able to add the Email for Ldap user");
			System.out.println("User is not able to add Email for Ldap user");
			Assert.fail("User is not able to add Email for Ldap user");
		}
		
	}
	
		public void verifypassword(String Password) {
			try {
				addLdapuser.click();
				logger.log(LogStatus.INFO, "Enter the Password of Ldap user");
				System.out.println("Enter the Password of Ldap user");
				password.click();
				password.sendKeys(Password);
				String regex = "^(?=.*[0-9])"
		                + "(?=.*[a-z])(?=.*[A-Z])"
						+ "(?=.*[!@#$%^&=+])"
		                + "(?=\\S+$).{8,20}$";
				commonMethods.waitForPageToLoad();
				Pattern pattern = Pattern.compile(regex);
				
				Matcher match = pattern.matcher(Password);
            
				boolean crt = match.matches();
				System.out.println(crt);

				if(crt==false)
				{
					String wrongmessage=errMsg.getText();
					logger.log(LogStatus.FAIL, "Failed to validate the Password of LDAP-User and the wrong message is : "+wrongmessage);
					System.out.println("Failed to validate the Password of LDAP-User and the wrong message is : "+wrongmessage);
					cancelbutton.click();
					commonMethods.waitForPageToLoad();	
				}	
				else {
					logger.log(LogStatus.PASS, "Valid Password");
					System.out.println("Valid Password");
					cancelbutton.click();
					commonMethods.waitForPageToLoad();	
				}
			}
			catch (Exception e) {				
				System.out.println(e);
				logger.log(LogStatus.FAIL, "User is not able to add Password for Ldap user");
				System.out.println("User is not able to add password for Ldap user");
				Assert.fail("User is not able to add Password for Ldap user");
			}
	}

}





