package compliance.Functional;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Generic.TestBase.BrowserConfig;
import Generic.TestBase.CommonMethods;
import Generic.TestBase.ExcelOp;
import Generic.TestBase.testBase;
import compliance.PageObjMethods.User_Access_Management;
import compliance.PageObjMethods.password_ComplexityKeycloak;

public class UserAccessManagement extends testBase{

	private WebDriver driver = null;
	String parent;
	public String parentHandle = null;
	public static boolean classname;
	
	
	@BeforeClass
	public void initSetUp() throws IOException, InterruptedException {
		
	BrowserConfig.setDriver(browserType, appURL);
	driver=BrowserConfig.getDriver();
	//ExcelOp.loadExcel("TestData");
	
	try {
	if (driver == null)
	System.out.println("---Driver not found---");
	} catch (Exception e) {
	System.out.println(e.getMessage());
	}
	classname = true;
	}
	
	@Test( priority = 1, enabled = true)
	public void User_AccessManagement() throws InterruptedException, IOException {
		CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);
		User_Access_Management check = PageFactory.initElements(driver, User_Access_Management.class);
		boolean flag = check.userAccessManage(testBase.getEnterpriseID(), testBase.getEnterprisePassword(),testBase.getreponame(), testBase.getuname());
		Assert.assertTrue(flag);
	}
	
	@AfterClass
	public void endDriver() {
	//	driver.quit();
	}
}
