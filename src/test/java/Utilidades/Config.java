package Utilidades;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Config {
	protected WebDriver driver;
	String PATH_DRIVER = "C://Users//user//eclipse-workspace//test_SISO//src//test//resources//WebDriver//chromedriver.exe";
	String TIPO_DRIVER = "webdriver.chrome.driver";
	String URL = "http://localhost/Proyectos/SISO//login";
	
	@BeforeMethod
	public void setUp() 
	{
		
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
	    driver =new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}

}
