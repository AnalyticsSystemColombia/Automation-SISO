package tests;

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

public class Test_login extends conectDriver {
	
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
		Thread.sleep(2000);
		Actions a = new Actions(driver); 
		a.moveToElement(driver.findElement(By.xpath("//span[normalize-space()=\"Configuración\"]"))).build().perform();
		driver.findElement((By.xpath("//span[normalize-space()=\"Configuración\"]"))).click();
		driver.findElement((By.xpath("//a[normalize-space()=\"Categorias\"]"))).click();
		driver.findElement(By.cssSelector("button[onclick=\"openModal();\"]")).click();
		WebElement txtcateNomb = driver.findElement(By.id("txtcateNomb"));
		txtcateNomb.sendKeys("Gafas");
		WebElement txtcateDesc = driver.findElement(By.xpath("//textarea[@id=\"txtcateDesc\"]"));
		txtcateDesc.sendKeys("Gafas importadas");
		Thread.sleep(2000);
	}
	
	///https://www.youtube.com/watch?v=5kQm0vAH4Aw&t=77s

}
