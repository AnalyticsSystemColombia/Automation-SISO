package configuracion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import configuracion.conectDriver;

import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class conectDriver {
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

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
