package mavenProject.CodingAssignment;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Phase1 extends Base{

  @BeforeTest
  public void initialize() throws IOException 
  {
	driver=initializeDriver();
	   
  }
	
  @Test
  public void openBlog_WheatherPage() {
    
	driver.get(properties.getProperty("url"));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='searchBox']")).sendKeys("Bengaluru");
	
	// identify elements with text()
	String City= "Bengaluru, ";
	String Temp= "Temp in Degrees: 27";
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//div[normalize-space()='Bengaluru']")).click();
	
    List<WebElement> l= driver.findElements(By.cssSelector("div.leaflet-popup-content:nth-child(1) > div"));
    // verify list size
    if ( l.size() > 0 ){
       System.out.println("Text: " + City + Temp + " is present. ");
    } else {
       System.out.println("Text: " + City + Temp +" is not present. ");
    }
 }
	 
  @AfterTest
  public void afterClass() {	
  driver.quit();
  }


}
