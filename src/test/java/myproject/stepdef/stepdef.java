package myproject.stepdef;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
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

import myproject.pageobject.MyStoreHomepage;


public class stepdef {
   
	private static final Logger logger = LogManager.getLogger(stepdef.class);
	WebDriver driver;
    String base_url = null;
    int implicit_wait_timeout_in_sec = 20;
    Scenario scn;
    
    MyStoreHomepage myStorePageObject;
    
    @Before
    public void setUp(Scenario scn) throws Exception{
    	this.scn = scn;
    	String browserName = webfactorydriver.getBrowserName();
        driver = webfactorydriver.getWebDriverForBrowser(browserName);
        logger.info("Browser invoke");
        
        myStorePageObject = new MyStoreHomepage(driver);
        
           }
    
   @After(order=1)
    public void cleanUp()
   {
        webfactorydriver.quitDriver();
   }

    @After(order=2) 
    public void takeScreenShot(Scenario s) {
      if (s.isFailed()) {
          TakesScreenshot scrnShot = (TakesScreenshot)driver;
          byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
          scn.attach(data, "image/png","Failed Step Name: " + s.getName());
      }else{
          scn.log("Test case is passed, no screen shot captured");
      }
    }
	
    @Given("user have valid {string}")
    public void user_have_valid(String urlName) 
    {
        Assert.assertNotEquals(0, urlName.length());
        this.base_url = urlName;
        
    }


    @When("user open the application")
    public void user_open_the_application() 
    {
    	webfactorydriver.navigateToTheUrl(this.base_url);
    	scn.log("User navigate to application");
    }
    
    @Then("user should be redirected to index page of application")
    public void user_should_be_redirected_to_index_page_of_application() 
    {
        String redirectedUrl = webfactorydriver.getCurrentAppUrl();
        Assert.assertNotEquals("The application doesnot redirected to url ", this.base_url, redirectedUrl);
        scn.log("User redirected to index page");
    }

      
    @Then("Application logo should be visible")
    public void application_logo_should_be_visible() 
    {
        myStorePageObject.getVisbilityOfLogo();
        scn.log("Application logo should be visible");
        
    }
    
    @Then("Logo width should be {string} and height should be {string}")
    public void logo_width_should_be_and_height_should_be(String width, String height) 
    {
       int actualWidth = myStorePageObject.getLogoWidth();
       int actualHeight =myStorePageObject.getLogoHeight();
       
       assertEquals("Width not match ", actualWidth, Integer.parseInt(width));
       assertEquals("Height not match ", actualHeight, Integer.parseInt(height));
       
       scn.log("Compare the application logo width and height");
    }

    
    @Then("user should validate that main category count should be {string}")
    public void user_should_validate_that_main_category_count_should_be(String count)
    {
        int actualCount = myStorePageObject.getOptionCount();
        System.out.println("The actaul count = " + actualCount);
        assertEquals("count not match ", actualCount, Integer.parseInt(count));
        scn.log("Validate the main category and actual count is -" + actualCount);
    }
    
    @Then("user should be validate category as below")
    public void user_should_be_validate_category_as(List<String> Cat_Name ) 
    {
        for(int i = 1;i<Cat_Name.size();i++)
        {
        	Assert.assertEquals("Catgory not found " + Cat_Name.get(i) + " " , true,myStorePageObject.getVisibilityOfElement(Cat_Name.get(i)));
        }
    }
  
    @When("User Search for product {string}")
    public void user_search_for_product(String product_name)
    {
        myStorePageObject.enterTextIntoSearchFiled(product_name);
        scn.log("User search for product - " + product_name);
    }
    
    @Then("Search Result page is displayed")
    public void search_result_page_is_displayed() 
    {
        myStorePageObject.getVisibilityofResult();
        scn.log("The Search result page should display");
    }

       
    @When("user clicks on footerlink Twitter")
    public void user_clicks_on_footerlink_twitter() 
    {
        myStorePageObject.clickontwitterlink();
    }
    
    @Then("user should be validate new tab opens with url {string}")
    public void user_should_be_validate_new_tab_opens_with_url(String Exp_url_name) 
    {
       myStorePageObject.switchToTwittertab();
       String newUrl = myStorePageObject.getNewpageURL();
       System.out.println("The new url = " + newUrl);
       System.out.println("The Excpeted url name = " +Exp_url_name);
       if(newUrl.contains(Exp_url_name))
       {
    	   System.out.println("The Twitter url match");
       }
       else
       {
    	   System.out.println("The Twitter url does not match");
       }
       //assertEquals("New Twitter URL does not match",true,newUrl.contains(url_name));
    }
    
    @Then("account name should be {string}")
    public void account_name_should_be(String name) 
    {
        
        assertEquals("Account name does not match",true,myStorePageObject.getvisibilityOfAccountname(name));
    }

}
