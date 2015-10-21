package AutoDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class macroFunctionality {
	

	public static void subjectList(WebDriver dr)
	{
		dr.findElement(By.cssSelector("#rtbMain > div > div > div > ul > li:nth-child(14) > a > span > span > span > img")).click();
		//clicked on subjectlist button
		
	}
	
	public static void subjectQuickView(WebDriver dr, WebElement mFrame, WebElement lPane)
	{
		//Entered in subjectQuickView
		dr.findElement(By.cssSelector("#rtbMain > div > div > div > ul > li:nth-child(17) > a > span > span > span > img")).click();
		
		//Clicked on subjectQuickView button
		
		dr.switchTo().defaultContent();		
		dr.switchTo().frame(mFrame); //switching to parent frame
		dr.switchTo().frame(lPane); //switching to left frame
		
		dr.findElement(By.cssSelector("#frmLeftPane > div:nth-child(7) > table > tbody > tr:nth-child(1) > td:nth-child(2) > img")).click();
	}
	
	public static void createNewSubject(WebDriver dr, String study, String site, WebElement mFrame, WebElement cFrame) throws InterruptedException
	{
		dr.switchTo().defaultContent();		
		dr.switchTo().frame(mFrame);
		dr.switchTo().frame(cFrame);  //switching to center frame
		
		dr.findElement(By.cssSelector("#rtbMain > div > div > div > ul > li:nth-child(1) > a > span > span > span > img")).click();
		
		dr.switchTo().defaultContent();
		WebElement macroBaseFrame = dr.findElement(By.xpath("//iframe[contains(@name,'rwmgrMacroBase')]"));
		dr.switchTo().frame(macroBaseFrame);
		
		//locating study list
		Select selectStudy = new Select(dr.findElement(By.id("lstStudies")));
		selectStudy.selectByVisibleText(study); 
		//study selected
		
		Thread.sleep(1000); //wait for Ajax panel to populate corresponding sites
		
		Select selectSite = new Select(dr.findElement(By.id("lstSites"))); //locating site list
		selectSite.selectByVisibleText(site); //site selected
		
		dr.findElement(By.name("btnOK")).click();
			
		//Schedule grid opens
		
		dr.switchTo().defaultContent();
		dr.switchTo().frame(mFrame); //switching to parent frame
		dr.switchTo().frame(cFrame);  //switching to child frame
		
		Actions action = new Actions(dr);
		WebElement eForm = dr.findElement(By.cssSelector("#imgEnabled"));
		action.moveToElement(eForm);
		action.contextClick(eForm).build().perform();
		dr.findElement(By.linkText("Open...")).click();
		//clicked on open
	}
	
	public static void EnterSubjectData (WebDriver dr) throws InterruptedException
	{
		List<WebElement> textBoxList = dr.findElements(By.xpath("//input[contains(@name, 'txt1')]"));
		
		textBoxList.get(0).sendKeys("t"); //eForm date
		textBoxList.get(0).sendKeys(Keys.TAB);
		
		textBoxList.get(1).sendKeys("456"); //Subject number
		textBoxList.get(1).sendKeys(Keys.TAB);
		
		textBoxList.get(2).sendKeys("JB"); //Subject initials
		
		textBoxList.get(3).sendKeys("Jason"); //Surname of clinician
		textBoxList.get(3).sendKeys(Keys.TAB);
		
		textBoxList.get(4).sendKeys("Bourne"); //First name of clinician
		textBoxList.get(4).sendKeys(Keys.TAB);
		
		dr.findElement(By.xpath("//input[contains(@name, 'dpk1')]")).sendKeys("t"); //Date of birth
		dr.findElement(By.xpath("//input[contains(@name, 'dpk1')]")).sendKeys(Keys.TAB);
		
		dr.findElement(By.xpath("//input[contains(@name, 'rbl1')]")).click(); //Gender
		
		//click on save button
		dr.findElement(By.cssSelector("#rtbMain > div > div > div > ul > li:nth-child(5) > a > span > span > span > img")).click();
		Thread.sleep(2000);
		//New subject created				
	}
}