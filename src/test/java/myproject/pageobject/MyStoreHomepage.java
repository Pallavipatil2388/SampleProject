package myproject.pageobject;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyStoreHomepage
{
	private static final Logger logger = LogManager.getLogger(MyStoreHomepage.class);
	WebDriver driver;
     
	 private By applogo = By.xpath("//img[@class ='logo img-responsive']");
	 private By menuOption =By.xpath("//ul[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li");
	 private By searchbox = By.xpath("//input[@type = 'text']");
	 private By searchbtn = By.xpath("//button[@name='submit_search']");
	 private By footerlink = By.xpath("//li[@class='twitter']/a[@target='_blank']");
     private By accountname = By.xpath("(//span[contains(text(),'Selenium Framework')])[2]");
	
     //private By searchbox = By.xpath("//input[@class='search_query form-control ac_input']");  
	 //private By searchresult = By.xpath("//*[@id='index']/div[2]/ul/li/strong");
	 //private By searchbtn = By.xpath("//button[@name='submit_search']");

	public MyStoreHomepage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void getVisbilityOfLogo()
	{
		//return driver.findElement(applogo2).isDisplayed();
		WebElement logovisible = driver.findElement(applogo);
		Assert.assertEquals("Logo not displayed",true,logovisible.isDisplayed());
	}

	public int getLogoWidth() 
	{
		int  width = driver.findElement(applogo).getSize().getWidth();
		System.out.println("Actaul width = " +width);
	    return width;
	}

	public int getLogoHeight()
	{
		int height = driver.findElement(applogo).getSize().getHeight();
		System.out.println("Actual height - " +height);
		return height;
	}

	public int getOptionCount() 
	{
		return driver.findElements(menuOption).size();
	}

	public boolean getVisibilityOfElement(String ele) 
	{
		String path = "(//a[@title='"+ele+"'])[2]";
		System.out.println("The path - " + path);
		WebElement WE = driver.findElement(By.xpath(path));
		Actions act = new Actions(driver);
    	act.moveToElement(WE).build().perform();
		return WE.isDisplayed();
		
	}

	public void enterTextIntoSearchFiled(String product_name) 
	{
		WebElement ele = driver.findElement(searchbox);
		ele.sendKeys(product_name);
		driver.findElement(searchbtn).click();	
	}

	public void getVisibilityofResult() 
	{
		WebDriverWait wait = new WebDriverWait(driver,60);
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchresult));
		String expectedtitle="Search - My Store";
	    String actualtitle = driver.getTitle();
	    Assert.assertEquals("Page valiadtion", expectedtitle,actualtitle);
		//return true;
	}

	public void clickontwitterlink() 
	{
		driver.findElement(footerlink).click();
		
	}

	public void switchToTwittertab() 
	{
		Set<String> handles = driver.getWindowHandles(); 
        Iterator<String> it = handles.iterator(); 
        String original = it.next();
        String twitterAC = it.next();
        driver.switchTo().window(twitterAC);  
        
        WebDriverWait webDriverWait1 = new WebDriverWait(driver,10);
        
     }

	public String getNewpageURL() 
	{
		return driver.getCurrentUrl();
	}

	public boolean getvisibilityOfAccountname(String name) 
	{
		String path = "(//span[contains(text(),'"+name+"')])[2]";
		WebElement WE = driver.findElement(By.xpath(path));
		return WE.isDisplayed();
		
	}

	
	 
}
