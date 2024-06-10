package compliance.PageObjMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
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

public class password_ComplexityKeycloak extends testBase{
	
	private WebDriver driver = BrowserConfig.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 90);
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);
	
	@FindBy(xpath = "//input[@name='username']")
	public WebElement platformUsername;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement platformPassword;

	@FindBy(xpath = "//*[text()='Login']")
	public WebElement loginButton;
	
//	@FindBy(xpath="//button[@value='no']")
//	public WebElement click_No;
//	
//	@FindBy(xpath="//*[@id=\"DescPop\"]/div[2]/form/div[3]/button")
//	public WebElement accept;
//	
//	@FindBy(xpath = "//*[@id=\"DescPop\"]/div[2]/form/div[1]")
//	public WebElement heading;
	
	@FindBy(xpath = "//a[text()='Manage Platform']")
	public WebElement managetab;
	
//	@FindBy(xpath = "//a[@href='#/ldapusers']")
//	public WebElement manageLdapUser;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div/div[2]/a/span[1]")
	public WebElement manageKeycloakuser;
	
	@FindBy(xpath = "//a[text()='Administration Console ']")
	public WebElement adminConsole;
	
	@FindBy(id = "username")
	public WebElement keycloakuname;
	
	@FindBy(id = "password")
	public WebElement keycloakpassword;
	
	@FindBy(id = "kc-login")
	public WebElement keycloaklogin;
	
	@FindBy(xpath = "//*[@id=\"view\"]/div[2]/div[3]/ul/li[2]/a")
	public WebElement Users;
	
	@FindBy(xpath = "//*[@id=\"view\"]/div[1]/ol/li[1]/a")
	public WebElement Users_tab;
	
	@FindBy(id = "viewAllUsers")
	public WebElement viewAllUsers;
	
	@FindBy(id = "createUser")
	public WebElement addUser;
	
	@FindBy(id = "username")
	public WebElement user_name;
	
	@FindBy(id = "email")
	public WebElement Email;
	
	@FindBy(id = "firstName")
	public WebElement firstName;
	
	@FindBy(id = "lastName")
	public WebElement lastName;
	
	@FindBy(xpath ="//*[@id=\"view\"]/div[1]/form/div/div[1]/button[1]")
	public WebElement saveBtn;
	
	@FindBy(xpath ="/html/body/div[2]/div")
	public WebElement saveMsg;
	
	@FindBy(xpath = "//a[text()='Credentials']")
	public WebElement credentials;
	
	@FindBy(id = "newPas")
	public WebElement passwordValue;
	
	@FindBy(id = "confirmPas")
	public WebElement confirmpassword;
	
	@FindBy(xpath = "//span[text()='ON']")
	public WebElement temporaryField;
	
	@FindBy(xpath = "//button[text()='Set Password']")
	public WebElement setPassword;
	
	@FindBy(xpath = "//button[text()='Set password']")
	public WebElement setpassword;
	
	@FindBy(xpath = "/html/body/div[2]/div")
	public WebElement setpasswordMsg;
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div[3]/button[2]")
	public WebElement delete;
	
	public void addingKeycloakUser(String username,String password,String keycloakUserName,String keycloakPassword, String uname, String email,String firstName,String lastName, String newPassword) throws InterruptedException {
		SoftAssert softassert = new SoftAssert();
		commonMethods.waitForPageToLoad();
		try {
//			wait.until(ExpectedConditions.visibilityOf(platformUsername));
			commonMethods.setInputById("username", username);
			logger.log(LogStatus.INFO, "Enter Username");
			System.out.println("Enter Username");
			
//			platformUsername.click();
//			platformUsername.sendKeys(username);
			
//			wait.until(ExpectedConditions.visibilityOf(platformPassword));
			commonMethods.setInputById("password", password);
			logger.log(LogStatus.INFO, "Enter Password");
			System.out.println("Enter password");
			
			
//			platformPassword.click();
//			platformPassword.sendKeys(password);
			commonMethods.waitForPageToLoad();
//			loginButton.click();
			commonMethods.ClickOnButtonByText("Login");
			logger.log(LogStatus.INFO, "Clicking on Login button");
			System.out.println("Clicking on Login button");
			commonMethods.waitForPageToLoad();
//			click_No.click();
//			commonMethods.waitForPageToLoad();
//			
//			softassert.assertEquals(heading.getText(), "Confidential Information – Reminder");
//			accept.click();
//			commonMethods.waitForPageToLoad();

//			driver.navigate().to("https://awschecks.continuoustestplatform.com/mywizardplatform/#/manage");

			driver.navigate().to("https://awschecks.continuoustestplatform.com/mywizardplatform/#/manage");

//			Thread.sleep(50000);
			
			commonMethods.setInputById("username", username);
			logger.log(LogStatus.INFO, "Enter Username");
			System.out.println("Enter Username");
			
			commonMethods.setInputById("password", password);
			logger.log(LogStatus.INFO, "Enter Password");
			System.out.println("Enter password");
			
			commonMethods.ClickOnButtonByText("Login");
			logger.log(LogStatus.INFO, "Clicking on Login button");
			System.out.println("Clicking on Login button");
			commonMethods.waitForPageToLoad();
			
			commonMethods.ClickOnLinkText("Manage Platform");
			logger.log(LogStatus.INFO, "Click on Manage Platform tab");
			System.out.println("Click on Manage Platform tab");

	//		managetab.click();
			commonMethods.waitForPageToLoad();
			
			commonMethods.ClickByTagWithText("span", "Manage Keycloak Users to authenticate and authorize...");
			logger.log(LogStatus.INFO, "Click on Keycloak User");
			System.out.println("Click on manage Keycloak User");
//			manageKeycloakuser.click();
//			commonMethods.waitForPageToLoad();
			
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			wait.until(ExpectedConditions.visibilityOf(adminConsole));
			logger.log(LogStatus.INFO, "Click on Administration Console");
			System.out.println("Click on Administration Console");
			adminConsole.click();
			commonMethods.waitForPageToLoad();
			
			wait.until(ExpectedConditions.visibilityOf(keycloakuname));
			logger.log(LogStatus.INFO, "Enter Keycloak Username");
			System.out.println("Enter Keycloak Username");
			keycloakuname.sendKeys(keycloakUserName);
			
			logger.log(LogStatus.INFO, "Enter Keycloak Password");
			System.out.println("Enter Keycloak Password");
			keycloakpassword.sendKeys(keycloakPassword);
			
			logger.log(LogStatus.INFO, "Click on Login button");
			System.out.println("Click on Login button");
			keycloaklogin.click();
			
			wait.until(ExpectedConditions.visibilityOf(Users));
			logger.log(LogStatus.INFO, "Clicking on Users tab in Keycloak");
			System.out.println("Clicking on Users tab in Keycloak");
		    Users.click();
			
		    wait.until(ExpectedConditions.visibilityOf(addUser));
			logger.log(LogStatus.INFO, "Clicking on add user");
			System.out.println("Clicking on add user");
		    addUser.click();
		    
		    wait.until(ExpectedConditions.visibilityOf(user_name));
			logger.log(LogStatus.INFO, "Entering username");
			System.out.println("Entering username");
		    user_name.sendKeys(uname);
		    
			logger.log(LogStatus.INFO, "Entering eamil");
			System.out.println("Entering email");
		    Email.sendKeys(email);

		    logger.log(LogStatus.INFO, "Entering first name");
			System.out.println("Entering first name");
		    this.firstName.sendKeys(firstName);
		    
		    logger.log(LogStatus.INFO, "Entering last name");
			System.out.println("Entering last name");
		    this.lastName.sendKeys(lastName);
		    commonMethods.waitForPageToLoad();
		    logger.log(LogStatus.INFO, "Clickng on save button");
			System.out.println("Clickng on save button");
		    saveBtn.click();
		    wait.until(ExpectedConditions.visibilityOf(saveMsg));
		    System.out.println(saveMsg.getText());
		    commonMethods.waitForPageToLoad();
		    wait.until(ExpectedConditions.visibilityOf(credentials));
			logger.log(LogStatus.INFO, "Clicking on credentials tab");
			System.out.println("Clicking on credentials tab");
		    credentials.click();
		    
		    wait.until(ExpectedConditions.visibilityOf(passwordValue));
			logger.log(LogStatus.INFO, "Entering the password");
			System.out.println("Entering the password");
			
			String regex = "^(?=.*[0-9])"
	                + "(?=.*[a-z])(?=.*[A-Z])"
					+ "(?=.*[!@#$%^&=+])"
	                + "(?=\\S+$).{8,20}$";
			
			Pattern pattern = Pattern.compile(regex);
			Matcher match = pattern.matcher(newPassword);
			
			boolean crt = match.find();
			System.out.println(crt);
			if(crt == false){
				passwordValue.click();
				passwordValue.sendKeys(newPassword);
				commonMethods.waitForPageToLoad();
				logger.log(LogStatus.INFO, "Entering the password for confirmation");
				System.out.println("Entering the password for confirmation");
				confirmpassword.sendKeys(newPassword);
				
				logger.log(LogStatus.INFO, "Turning off tempaorary field");
				System.out.println("Turning off tempaorary field");
				temporaryField.click();
				commonMethods.waitForPageToLoad();
				
				setPassword.click();
				commonMethods.waitForPageToLoad();
				setpassword.click();
				wait.until(ExpectedConditions.visibilityOf(setpasswordMsg));
				System.out.println(setpasswordMsg.getText());
				logger.log(LogStatus.FAIL, "Please enter correct combination of password");
				System.out.println("Please enter correct combination of password");
				
				Users_tab.click();
				commonMethods.waitForPageToLoad();
				viewAllUsers.click();
				commonMethods.waitForPageToLoad();
				List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"user-table\"]/tbody/tr"));
				commonMethods.waitForPageToLoad();
				System.out.println("Number of rows:" + rows.size());
				commonMethods.waitForPageToLoad();
				
				for(int i=1; i<rows.size(); i++) {
					WebElement name = driver.findElement(By.xpath("//*[@id=\"user-table\"]/tbody/tr["+i+"]/td[2]"));
					String getName = name.getText();
					if(getName.equals(uname.toLowerCase())) {
						System.out.println(getName);
						logger.log(LogStatus.INFO, "Click on delete user");
						System.out.println("Click on delete user");
						WebElement deleteBtn = driver.findElement(By.xpath("//*[@id=\"user-table\"]/tbody/tr["+i+"]/td[8]"));
						deleteBtn.click();
						commonMethods.waitForPageToLoad();
						delete.click();
					}
				}

			}
			else {
//				passwordValue.click();
				passwordValue.sendKeys(newPassword);
				commonMethods.waitForPageToLoad();
			
				logger.log(LogStatus.INFO, "Entering the password for confirmation");
				System.out.println("Entering the password for confirmation");
				confirmpassword.sendKeys(newPassword);
				commonMethods.waitForPageToLoad();

				logger.log(LogStatus.INFO, "Turning off tempaorary field");
				System.out.println("Turning off tempaorary field");
				temporaryField.click();
				commonMethods.waitForPageToLoad();
				
				setPassword.click();
				commonMethods.waitForPageToLoad();
				setpassword.click();
				
				wait.until(ExpectedConditions.visibilityOf(setpasswordMsg));
				System.out.println(setpasswordMsg.getText());
				logger.log(LogStatus.PASS, "User added with password complexity");
				System.out.println("User added with password complexity");
			}
		}
		
		catch (Exception e) {
			System.out.println(e);
			logger.log(LogStatus.INFO, "User is not able to add user");
			System.out.println("User is not able to add user");
			Assert.fail("User is not able to add user");
		}
	}

}
