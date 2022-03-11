package myproject.stepdef;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import myproject.core.webfactorydriver;

public class stepdef {
   
	private static final Logger logger = LogManager.getLogger(stepdef.class);
	WebDriver driver;
    String base_url = "http://automationpractice.com";
    int implicit_wait_timeout_in_sec = 20;
    Scenario scn;
	
    @Before
    public void setUp(Scenario scn) throws Exception{
    	this.scn = scn;
    	String browserName = webfactorydriver.getBrowserName();
        driver = webfactorydriver.getWebDriverForBrowser(browserName);
        logger.info("Brower invoke");
    }
    
   @After(order=1)
    public void cleanUp()
   {
        webfactorydriver.quitDriver();
   }

    @After(order=2) 
    public void takeScreenShot(Scenario s) {
      if (!s.isFailed()) {
          TakesScreenshot scrnShot = (TakesScreenshot)driver;
          byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
          scn.attach(data, "image/png","Failed Step Name: " + s.getName());
      }else{
          scn.log("Test case is passed, no screen shot captured");
      }
    }
	
     
    
	@Given("user have valid application URL")
	public void user_navigate_to_url()
	{
		driver.get(base_url);
        String titleofpage =driver.getTitle();
        scn.log("Page title is =  " + titleofpage); 
	}

	@When("user open the url and validate")
	public void user_validate_home_page_url() 
	{
		String expected = "My Store";
        String actual =driver.getTitle();
        Assert.assertEquals("Page Title validation",expected,actual);  
        scn.log("page tile validation successfull " + actual); 
	}
	
	@Then("user navigate to the index page")
	public void result_page_open_then_close() 
	{
		if(driver.getCurrentUrl().equalsIgnoreCase("http://automationpractice.com/index.php"))
		{
	         System.out.println("Test Pass"); 
	    } 
		else 
		{ 
	         System.out.println("Test Failed"); 
	    } 
		
	}
	
	@Given("user open the index page")
	public void user_open_the_index_page() 
	{
	    String indexpageURL = driver.getCurrentUrl();
	    scn.log(indexpageURL);
	}

	@When("Application logo should be visible")
	public void application_logo_should_be_visible() 
	{
		Actions act =new Actions(driver);
		WebElement logopresent = driver.findElement(By.xpath("//img[@class='img-responsive']"));
		act.moveToElement(logopresent).build().perform();
	    scn.log("Logo displyaed");
	    logger.info("Logo displyaed");
	}
	@Then("Logo width as {int} and height as {int}")
	public void logo_width_as_and_height_as(Integer int1, Integer int2) 
	{
	    int width = driver.findElement(By.xpath("//img[@class='img-responsive']")).getSize().getWidth();
	    int height= driver.findElement(By.xpath("//img[@class='img-responsive']")).getSize().getHeight();
	    System.out.println(width);
	    System.out.println(height);
	   
	    //Assert.assertEquals(width, 350);
	   // Assert.assertEquals(height, 99);
	}

	@When("User find the main category list on Index page")
	public void user_find_the_main_category_list_on_index_page() 
	{
	   WebElement tab1=driver.findElement(By.xpath("//a[@title='Women']"));
	   Assert.assertEquals("1st category",true,tab1.isDisplayed());
	   
	   WebElement tab2=driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
	   Assert.assertEquals("2nd category",true,tab2.isDisplayed());
	   
	   WebElement tab3=driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]"));
	   Assert.assertEquals("3rd category",true,tab3.isDisplayed());
	   	         
       scn.log("All 3 categories are displayed");
    }


	@Then("User hover the mouse on main category")
	public void user_find_same_text_on_main_category() throws InterruptedException
	{
		   Actions act =new Actions(driver);
		   WebElement Women=driver.findElement(By.xpath("//a[@title='Women']"));		   
		   act.moveToElement(Women).build().perform();
		   Thread.sleep(2000);
		  
		   WebElement Dresses=driver.findElement(By.xpath("(//a[@title='Dresses'])[2]"));
		   act.moveToElement(Dresses).build().perform();
		   Thread.sleep(2000);
		   
		   WebElement T_shirt=driver.findElement(By.xpath("(//a[@title='T-shirts'])[2]"));
		   act.moveToElement(T_shirt).build().perform();
		   Thread.sleep(2000);
	       scn.log("Mouse hover action done by user");
	}
	
	@When("User Search for product {string}")
	public void user_search_for_product(String product_name) 
	{
	    WebElement searchbox=driver.findElement(By.xpath("//input[@class='search_query form-control ac_input']"));
	    searchbox.sendKeys(product_name);
	    
	    WebElement searchbtn=driver.findElement(By.xpath("//button[@name='submit_search']"));
	    searchbtn.click();
	    scn.log("Displayed search produect information");
	}
	
	@Then("Search Result page is displayed")
	public void search_result_page_is_displayed()
	{
	    String expectedtitle="Search - My Store";
	    String actualtitle = driver.getTitle();
	    Assert.assertEquals("Page valiadtion", expectedtitle,actualtitle);
	    logger.info("Page validate");
	}

	@When("User click on footer link")
	public void user_click_on_footer_link_and_validate() 
	{
		WebElement footerlink = driver.findElement(By.xpath("//li[@class='twitter']/a[@target='_blank']"));
		footerlink.click();
		logger.info("Footerlink will open");
		if(driver.getCurrentUrl().equalsIgnoreCase("seleniumfrmwrk"))
			System.out.println("Test passed");
		else
			System.out.println("Test failed");
	}

	@Then("Twitter account will open in new tab")
	public void twitter_account_will_open_in_new_tab() 
	{
		Set<String> handles = driver.getWindowHandles(); 
        Iterator<String> it = handles.iterator(); 
        String original = it.next();
        String twitterAC = it.next();
        driver.switchTo().window(twitterAC);  
        
        WebDriverWait webDriverWait1 = new WebDriverWait(driver,20);
        WebElement accName=driver.findElement(By.xpath("(//span[contains(text(),'Selenium Framework')])[2]"));
        Assert.assertEquals("Account Name ",true,accName.isDisplayed());
        
        driver.switchTo().window(original);            
      
	}
}
