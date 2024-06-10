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
import Generic.TestBase.testBase;
import compliance.PageObjMethods.Data_Minimization;

public class DataMinimization extends testBase{
	private WebDriver driver = null;
	String parent;
	public String parentHandle = null;
	public static boolean classname;


	@BeforeClass
	public void initSetUp() throws IOException, InterruptedException {

		BrowserConfig.setDriver(browserType, appURL);
		driver=BrowserConfig.getDriver();
//		ExcelOp.loadExcel("Testdata");

		try {
			if (driver == null)
				System.out.println("---Driver not found---");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		classname = true;
	
	}

	@Test( priority = 0, enabled = true)
	public void Data_minimization() throws InterruptedException, IOException {
		CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);
		Data_Minimization login = PageFactory.initElements(driver, Data_Minimization.class);
		//login.ngnixLogin(testBase.getUsername(), testBase.getPassword());
		boolean flag =login.devOpsPlatformLogin(testBase.getUsername(), testBase.getPassword());
		Assert.assertTrue(flag);
	}
	
	@AfterClass
	public void endDriver() {
		//	driver.quit();
	}
}
