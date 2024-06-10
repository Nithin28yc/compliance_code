package compliance.Functional;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Generic.TestBase.BrowserConfig;
import Generic.TestBase.CommonMethods;
import Generic.TestBase.ExcelOp;
import Generic.TestBase.testBase;
import compliance.PageObjMethods.UnrestrictedLength_Ldapuser;
import compliance.PageObjMethods.UnrestrictedLength_Customcartridge;
import compliance.PageObjMethods.UnrestrictedLength_Customtool;
import compliance.PageObjMethods.password_Complexity;
import compliance.PageObjMethods.Notice_Privacy;

public class UnrestrictedLength extends testBase{

	private WebDriver driver = null;
	String parent;
	public String parentHandle = null;
	public static boolean classname;


	@BeforeClass
	public void initSetUp() throws IOException, InterruptedException {
		
		BrowserConfig.setDriver(browserType, appURL);
		driver=BrowserConfig.getDriver();
		ExcelOp.loadExcel("Testdata");
		try {
			if (driver == null)
				System.out.println("---Driver not found---");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		classname = true;
	}


	@Test( priority = 0, enabled = true)
	public void unrestrictedLength() throws InterruptedException, IOException {
		CommonMethods commonMethods = PageFactory.initElements(driver, CommonMethods.class);
		Notice_Privacy login = PageFactory.initElements(driver, Notice_Privacy.class);
		//login.ngnixLogin(testBase.getUsername(), testBase.getPassword());
		login.devOpsPlatformLogin(testBase.getUsername(),testBase.getPassword());

	}

	@Test( priority = 1, enabled = true)
	public void nameCheck() throws InterruptedException, IOException {
		UnrestrictedLength_Ldapuser check = PageFactory.initElements(driver, UnrestrictedLength_Ldapuser.class);
		check.Manageplatformtab();
		int nameCount = ExcelOp.getRowCount("name");	
		System.out.println(nameCount);
		for (int row = 1; row <= nameCount; row++) {
			testBase.namevalidation = ExcelOp.ReadExcelData("name", row, "Username");
			check.verifyName(testBase.namevalidation);   
		}
	}
	@Test( priority = 2, enabled = true)
	public void emailCheck() throws InterruptedException, IOException {
		UnrestrictedLength_Ldapuser check1 = PageFactory.initElements(driver, UnrestrictedLength_Ldapuser.class);

		int emailcount1=ExcelOp.getRowCount("Email");

		for (int row = 1; row <= emailcount1; row++) {
			testBase.emailvalidation = ExcelOp.ReadExcelData("Email", row, "email");
			check1.verifyEmail(testBase.emailvalidation);
		}
	}

	@Test( priority = 3, enabled = true)
	public void password() throws InterruptedException, IOException {
		UnrestrictedLength_Ldapuser check2 = PageFactory.initElements(driver, UnrestrictedLength_Ldapuser.class);

		int passcount=ExcelOp.getRowCount("Password");

		for (int row = 1; row <= passcount; row++) {
			testBase.passwordvalidation = ExcelOp.ReadExcelData("Password", row, "password");
			check2.verifypassword(testBase.passwordvalidation);
		}
	}

	@Test( priority = 4, enabled = true)
	public void Toolname() throws InterruptedException, IOException {
		UnrestrictedLength_Customtool check2 = PageFactory.initElements(driver, UnrestrictedLength_Customtool.class);
		check2.Manageuser();
		int passcount=ExcelOp.getRowCount("Toolname");

		for (int row = 1; row <= passcount; row++) {
			testBase.toolnamevalidation = ExcelOp.ReadExcelData("Toolname", row, "toolname");
			check2.verifytoolName(testBase.toolnamevalidation);
		}
	}

	@Test( priority = 5, enabled = true)
	public void Displayname() throws InterruptedException, IOException {
		UnrestrictedLength_Customtool check2 = PageFactory.initElements(driver, UnrestrictedLength_Customtool.class);
		//check2.Manageuser();
		int passcount=ExcelOp.getRowCount("Displayname");

		for (int row = 1; row <= passcount; row++) {
			testBase.displaynamevalidation = ExcelOp.ReadExcelData("Displayname", row, "displayname");
			check2.verifyDisplayName(testBase.displaynamevalidation);
			if(passcount==row) {
				driver.navigate().refresh();
			}
		}

	}


	@Test( priority = 6, enabled = true)
	public void Description() throws InterruptedException, IOException {
		UnrestrictedLength_Customtool check2 = PageFactory.initElements(driver, UnrestrictedLength_Customtool.class);
		//check2.Manageuser();
		int passcount=ExcelOp.getRowCount("Description");

		for (int row = 1; row <= passcount; row++) {
			testBase.descriptionvalidation = ExcelOp.ReadExcelData("Description", row, "description");
			check2.verifyDescription(testBase.descriptionvalidation);
		}
	}


	@Test( priority = 7, enabled = true)
	public void Version() throws InterruptedException, IOException {
		UnrestrictedLength_Customtool check2 = PageFactory.initElements(driver, UnrestrictedLength_Customtool.class);
		check2.Manageuser();
		int passcount=ExcelOp.getRowCount("Version");

		for (int row = 1; row <= passcount; row++) {
			testBase.versionvalidation = ExcelOp.ReadExcelData("Version", row, "version");
			check2.verifyVersion(testBase.versionvalidation);
		}
	}

	@Test( priority = 8, enabled = true)
	public void URL() throws InterruptedException, IOException {
		UnrestrictedLength_Customtool check2 = PageFactory.initElements(driver, UnrestrictedLength_Customtool.class);
		//check2.Manageuser();
		int passcount=ExcelOp.getRowCount("URL");

		for (int row = 1; row <= passcount; row++) {
			testBase.urlvalidation = ExcelOp.ReadExcelData("URL", row, "url");
			check2.verifyURL(testBase.urlvalidation);
		}
	}





	@Test( priority = 9, enabled =true)
	public void custompipelinecartridgename() throws InterruptedException, IOException {
		UnrestrictedLength_Customcartridge check = PageFactory.initElements(driver, UnrestrictedLength_Customcartridge.class);
		//check.Addcustompipeline();
		int cartridgenameCount = ExcelOp.getRowCount("Custompipeline");

		for (int row = 1; row <= cartridgenameCount; row++) {

			testBase.cartridgenamevalidation = ExcelOp.ReadExcelData("Custompipeline", row, "Cartridgename");

			check.verifyCartridgeName(testBase.cartridgenamevalidation);

		}
	}

	@Test( priority = 10, enabled =true)
	public void custompipelineversion() throws InterruptedException, IOException {
		UnrestrictedLength_Customcartridge check = PageFactory.initElements(driver, UnrestrictedLength_Customcartridge.class);
		//check.Addcustompipeline();
		int rowcount = ExcelOp.getRowCount("Pipelineversion");

		for (int row = 1; row <= rowcount; row++) {

			testBase.pipelineversionvalidation = ExcelOp.ReadExcelData("Pipelineversion", row, "pipelineversion");

			check.verifyVersion(testBase.pipelineversionvalidation);

		}
	}

	@Test( priority = 11, enabled =true)
	public void custompipelinename() throws InterruptedException, IOException {
		UnrestrictedLength_Customcartridge check = PageFactory.initElements(driver, UnrestrictedLength_Customcartridge.class);
		//check.Addcustompipeline();
		int cartridgenameCount = ExcelOp.getRowCount("Pipelinename");

		for (int row = 1; row <= cartridgenameCount; row++) {

			testBase.pipelinenamevalidation = ExcelOp.ReadExcelData("Pipelinename", row, "pipelinename");

			check.verifypipelineName(testBase.pipelinenamevalidation);

		}
	}

	@Test( priority = 12, enabled =true)
	public void custompipelinepath() throws InterruptedException, IOException {
		UnrestrictedLength_Customcartridge check = PageFactory.initElements(driver, UnrestrictedLength_Customcartridge.class);
		//check.Addcustompipeline();
		int rowCount = ExcelOp.getRowCount("Pipelinepath");

		for (int row = 1; row <= rowCount; row++) {

			testBase.pipelinepathvalidation = ExcelOp.ReadExcelData("Pipelinepath", row, "pipelinepath");
			testBase.Cartridgenameforpipelinepath = ExcelOp.ReadExcelData("Pipelinepath", row, "cartridgename");

			check.verifypipelinepath(testBase.pipelinepathvalidation,testBase.Cartridgenameforpipelinepath);

		}
	}

	@AfterClass
	public void endDriver() {
//		driver.quit();
	}
}
