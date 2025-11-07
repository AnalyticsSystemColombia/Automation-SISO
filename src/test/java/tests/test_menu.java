package tests;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test_menu {
	WebDriver driver;
	String PATH_DRIVER = "C://Users//user//eclipse-workspace//IntroduccionSelenium//src//chrome//chromedriver.exe";
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
	@Test
	public void test_menu() throws InterruptedException
	{
		WebElement element = driver.findElement(By.id("txtEmail"));
		element.sendKeys("harold_uruena@yahoo.com");
		WebElement element2 = driver.findElement(By.id("txtPassword"));
		element2.sendKeys("Wonica123");
		driver.findElement(By.id("buttom")).click();
		driver.navigate().to("http://localhost/Proyectos/SISO//dashboard");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver=driver.findElement(By.xpath("(//ul[@class='app-menu'])[1]"));// Limiting webdriver scope
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement coloumndriver=footerdriver.findElement(By.xpath("(//ul[@class='app-menu'])[1]"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());
		for(int i=0;i<coloumndriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
		}
		Set<String> abc=driver.getWindowHandles();
		Iterator<String> it=abc.iterator();
		while(it.hasNext())
		{
		   driver.switchTo().window(it.next());
		   System.out.println(driver.getTitle());
		}
	}
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
}
