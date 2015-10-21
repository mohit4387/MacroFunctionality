package AutoDemo;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class BusinessKeys {

	public static void Launch (WebDriver ff, String url) 
	{
		ff.get(url);

	}
	
	public static void versionVerification(WebDriver ff, String version)
	{
		if (ff.findElement(By.id("lblProductVersion")).getText().equalsIgnoreCase(version))
		{
			System.out.println("AS EXPECTED: Version is " + version);
		}
		else
		{
			System.out.println("FAIL: Version mismatch. Visible version on login screen is " + ff.findElement(By.id("lblProductVersion")).getText());
		}
	}
	
	public static void copyrightMessage(WebDriver ff, String copyrightMsg)
	{
		if (ff.findElement(By.id("lblProductInfo")).getText().equalsIgnoreCase(copyrightMsg))
		{
			System.out.println("AS EXPECTED: Copyright message matches");
		}
		else
		{
			System.out.println("FAIL: Copyright mesage doesn't match. Visible copyright message is " + ff.findElement(By.id("lblProductInfo")).getText());
		}
	}
	
	public static void Login (WebDriver ff, String username, String password) 
	{
		ff.findElement(By.id("txtUserId")).sendKeys(username);
		ff.findElement(By.id("txtPassword")).sendKeys(password);
		ff.findElement(By.id("btnLogin")).click();

	}
	
	
	public static void SelectDB (WebDriver ff, String dbName, String ButtonName)
	{		
		List<WebElement> dbList = ff.findElements(By.className("rlbText"));
		for (int i = 0; i<dbList.size(); i++)
		{
			if (dbList.get(i).getText().equalsIgnoreCase(dbName))
			{
				dbList.get(i).click();
				ff.findElement(By.name(ButtonName)).click();
				break;				
			}
		}
		
	}
	
	
	public static void fileMenu(WebDriver ff) throws InterruptedException
	{
		ff.findElement(By.cssSelector("#rmnuMain > ul > li.rmItem.rmFirst > a > span > u")).click();
		
		String itemText = ff.findElement(By.linkText("New Subject")).getText();
		Assert.assertEquals("New Subject", itemText);
		
		itemText = ff.findElement(By.linkText("Print")).getText();
		Assert.assertEquals("Print", itemText);
		
		itemText = ff.findElement(By.linkText("Log Out")).getText();
		Assert.assertEquals("Log Out", itemText);
	}
	
	public static void viewMenu(WebDriver ff)
	{
		ff.findElement(By.cssSelector("#rmnuMain > ul > li:nth-child(2) > a > span > u")).click();
		
		String itemText = ff.findElement(By.linkText("Home")).getText();
		Assert.assertEquals("Home", itemText);
		
		itemText = ff.findElement(By.linkText("Subject List")).getText();
		Assert.assertEquals("Subject List", itemText);
		
		itemText = ff.findElement(By.linkText("Subjects QuickView")).getText();
		Assert.assertEquals("Subjects QuickView", itemText);
		
		itemText = ff.findElement(By.linkText("Schedule QuickView")).getText();
		Assert.assertEquals("Schedule QuickView", itemText);
		
		itemText = ff.findElement(By.linkText("Symbols and Function Keys")).getText();
		Assert.assertEquals("Symbols and Function Keys", itemText);
		
		itemText = ff.findElement(By.linkText("Search Panel")).getText();
		Assert.assertEquals("Search Panel", itemText);
	}
	
	public static void toolsMenu(WebDriver ff)
	{
		ff.findElement(By.cssSelector("#rmnuMain > ul > li:nth-child(3) > a > span > u")).click();
		
		String itemText = ff.findElement(By.linkText("Change Password...")).getText();
		Assert.assertEquals("Change Password...", itemText);
		
		itemText = ff.findElement(By.linkText("Database Lock Administration...")).getText();
		Assert.assertEquals("Database Lock Administration...", itemText);
		
		itemText = ff.findElement(By.linkText("Batch Validation...")).getText();
		Assert.assertEquals("Batch Validation...", itemText);
		
		itemText = ff.findElement(By.linkText("Options...")).getText();
		Assert.assertEquals("Options...", itemText);
		
		itemText = ff.findElement(By.linkText("Administrator Options...")).getText();
		Assert.assertEquals("Administrator Options...", itemText);		
	}
	
	public static void helpMenu(WebDriver ff)
	{
		ff.findElement(By.cssSelector("#rmnuMain > ul > li:nth-child(4) > a > span > u")).click();
		
		String itemText = ff.findElement(By.linkText("Index")).getText();
		Assert.assertEquals("Index", itemText);
	}
	
	public static void toolbarCheck (WebDriver ff)
	{
		String buttonClassName = ff.findElement(By.xpath("//*[@id=\"rtbMain\"]/div/div/div/ul/li[2]")).getAttribute("class");
		Assert.assertEquals("rtbItem rtbBtn rtbDisabled", buttonClassName);			
	}
}