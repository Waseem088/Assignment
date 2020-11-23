package mavenProject.CodingAssignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base {
public static WebDriver driver;
public Properties properties;

	public WebDriver initializeDriver() throws IOException
	{
	
	properties=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Eclipse\\eclipse-jee-2019-06-R-win32-x86_64\\Practise code_eclipse moved to diff location\\CodingAssignment\\resourses\\config.properties");
	properties.load(fis);
	String browserName=properties.getProperty("browser");
	
	
	
	if(browserName.equals("chrome"))
	{

		System.setProperty("webdriver.chrome.driver", "C:\\Eclipse\\eclipse-jee-2019-06-R-win32-x86_64\\Practise code_eclipse moved to diff location\\CodingAssignment\\resourses\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		driver=new FirefoxDriver();
		//firefox code
	}
	
	else if(browserName.equals("IE"))
	{
		
	}
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	
	}
	
	
}