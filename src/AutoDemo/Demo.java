package AutoDemo;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;



public class Demo {


	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer_x64_2.47.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BusinessKeys.Launch(driver,"http://172.17.6.1/macro/");
		
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        
		driver.switchTo().window(newTab.get(1));
		driver.manage().window().maximize();
		
		BusinessKeys.versionVerification(driver, "4.4.0.6563");
		BusinessKeys.copyrightMessage(driver, "Powered by InferMed Macro.Copyright 2015.");
		BusinessKeys.Login(driver, "rde", "macrotm");
		
		Thread.sleep(2000);
		
		if (driver.getTitle().equalsIgnoreCase("MACRO Database Choice"))
		{
			BusinessKeys.SelectDB(driver, "AUTOTEST", "btnOk"); 
		}
		
		driver.switchTo().defaultContent();
		
		final WebElement mainFrame = driver.findElement(By.id("ifrmMainContent"));
		driver.switchTo().frame(mainFrame); //switching to parent frame
		
		final WebElement leftFrame = driver.findElement(By.id("leftPane"));
		final WebElement centerFrame = driver.findElement(By.id("centerPane"));
		//final WebElement rightFrame = driver.findElement(By.id("rightPane"));
		driver.switchTo().frame(centerFrame);  //switching to child frame
		
		//BusinessKeys.clickRootMenus(driver);
		
		
		BusinessKeys.fileMenu(driver);
		System.out.println("File menu OK");
		
		BusinessKeys.viewMenu(driver);
		System.out.println("View menu OK");
		
		BusinessKeys.toolsMenu(driver);
		System.out.println("Tools menu OK");
		
		BusinessKeys.helpMenu(driver);
		System.out.println("Help menu OK");
		
		macroFunctionality.subjectList(driver);
		
		macroFunctionality.subjectQuickView(driver, mainFrame, leftFrame);                                                                     
		
		macroFunctionality.createNewSubject(driver, "Demostudy40", "oqsite", mainFrame, centerFrame);
		
		macroFunctionality.EnterSubjectData(driver);
		
		driver.quit();
	}
}