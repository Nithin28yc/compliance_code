package Generic.TestBase;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
//adding crossbrowser change, testng name 
public class BrowserConfig extends testBase{
	public static WebDriver driver;
	static String driverPath = "./Drivers_Jars";
	
	
	
	//Public function called by every page object to get driver post configuring browser executable and launching the URL passed through testng.xml
	public static WebDriver getDriver() 
	{
		return driver;
	}
	
	//Private function to set browser executable and to launch URL based on browsertype and URL passed through testng.xml
	public static void setDriver(String browserType, String appURL) throws MalformedURLException, InterruptedException 
	{
		switch (browserType) 
		{
		case "chrome":
			
			  if(osystem.equals("Windows 11"))
			{
				//local run
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				
//				prefs = {"download.default_directory" : "C:\Tutorial\down"};
//				options.add_experimental_option("prefs",prefs);
//				driver = webdriver.Chrome(executable_path='./chromedriver',chrome_options=options);
				
				System.out.println("testing chrome locally");
				System.out.println("Launching google chrome..");
				
				System.setProperty("webdriver.chrome.driver", driverPath+"/chromedriver.exe");

				driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.navigate().to(appURL);
				break;
				
			}
			
			else
			{
				 //Jenkins run on platform
		           System.out.println("testing chrome through desired capabilities");
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					System.out.println("capabilities set to selenium grid");
					capabilities.setBrowserName("chrome");
					System.out.println("chrome browser set");
					capabilities.setPlatform(Platform.WIN10);
					System.out.println("Win10 set");
					driver = new RemoteWebDriver(new URL("http://selenium-node-chrome:5555/wd/hub"), capabilities);
					//driver = new RemoteWebDriver(new URL("http://10.225.216.75:4444/wd/hub"), capabilities);
					System.out.println("RemoteWebdriver set");
					//driver.manage().window().maximize();
					driver.navigate().to(appURL);
					break;
					
			}
		   
			
			
		case "firefox":	
			  if(osystem.equals("Windows 11"))
			 {
				//local run
					System.out.println("Launching mozilla firefox..");
					System.setProperty("webdriver.gecko.driver", driverPath+"/geckodriver.exe");
					driver=new FirefoxDriver();
					driver.manage().window().maximize();
					driver.navigate().to(appURL); 
					break;
			 }
			 
			 else
			 {
				//Jenkins run
					FirefoxProfile firefoxProfile = new FirefoxProfile();			
					firefoxProfile.setAcceptUntrustedCertificates(true);
					firefoxProfile.setPreference("layers.acceleration.disabled", true);
					DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
					desiredCapabilities.setCapability(FirefoxDriver.PROFILE, firefoxProfile);
					driver = new RemoteWebDriver(new URL("http://selenium-node-firefox:5555/wd/hub"), desiredCapabilities);
					System.out.println("launching firefox driver");
					System.out.println("RemoteWebdriver set");
					//driver.manage().window().maximize();
					driver.navigate().to(appURL);
					break;
					 
			 }
			
			
		default:
			  if(osystem.equals("Windows 11"))
			{
				//local run
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				System.out.println("testing chrome locally");
				System.out.println("Launching google chrome..");
				System.setProperty("webdriver.chrome.driver", driverPath+"/chromedriver.exe");
				driver=new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.navigate().to(appURL);
				break;
				
			}
			
			else
			{
				 //Jenkins run on platform
		           System.out.println("testing chrome through desired capabilities");
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					System.out.println("capabilities set to selenium grid");
					capabilities.setBrowserName("chrome");
					System.out.println("chrome browser set");
					capabilities.setPlatform(Platform.WIN10);
					System.out.println("Win10 set");
					driver = new RemoteWebDriver(new URL("http://selenium-node-chrome:5555/wd/hub"), capabilities);
					//driver = new RemoteWebDriver(new URL("http://10.225.216.75:4444/wd/hub"), capabilities);
					System.out.println("RemoteWebdriver set");
					//driver.manage().window().maximize();
					driver.navigate().to(appURL);
					break;
					
					
			}
		   
			
			
		}
	}



}

