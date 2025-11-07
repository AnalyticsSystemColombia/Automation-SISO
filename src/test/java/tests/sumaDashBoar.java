package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import configuracion.conectDriver;

import org.testng.annotations.BeforeMethod;

import java.io.ObjectInputStream.GetField;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sumaDashBoar extends conectDriver {
	
	
	
	@Test
	
	public void test_initSesion() throws InterruptedException
	{
		WebElement element = driver.findElement(By.id("txtEmail"));
		element.sendKeys("harold_uruena@yahoo.com");
		
		System.out.println("Ingresar correo del usuario");
		
		WebElement element2 = driver.findElement(By.id("txtPassword"));
		element2.sendKeys("Wonica123");
		System.out.println("Ingresar password");
		
		System.out.println("Hacer click en 	INICIO SESION");
		driver.findElement(By.id("buttom")).click();
		driver.navigate().to("http://localhost/Proyectos/SISO//dashboard");
		//Pruebas para categoría
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(2000);
		
		List <WebElement> values = driver.findElements(By.cssSelector(".table.table-striped.table-sm td:nth-child(4)"));
		 int totalSum=0;
		 for(int i=0; i<values.size(); i++) 
		 {
			 String amounString  = values.get(i).getText();
			 Double price = getFormatterAmount(amounString);
			 totalSum = totalSum + Integer.parseInt(values.get(i).getText());
		 }
		System.out.println(totalSum);
		Thread.sleep(1000);
	}
	public Double getFormatterAmount(String amount) 
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	///https://www.youtube.com/watch?v=5kQm0vAH4Aw&t=77s

}
