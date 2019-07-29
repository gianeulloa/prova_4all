package br.com.all.Desafio;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Desafio2 {
	
	public static WebDriver driver;
	
		@BeforeClass
		public static void  CriarDriver(){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Giane\\Desktop\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://shopcart-challenge.4all.com/");
	    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		
		@Test
		public void SelecionaCategoria2() {	 
			driver.findElement(By.id("open-categories-btn")).click();
		 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 	driver.findElement(By.id("category-0")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		driver.findElement(By.id("add-product-0-btn")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		driver.findElement(By.id("add-product-1-btn")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		driver.findElement(By.id("add-product-2-btn")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		driver.findElement(By.id("open-categories-btn")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		driver.findElement(By.id("category-all")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		driver.findElement(By.id("add-product-3-btn")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		 		
	  		driver.findElement(By.cssSelector("#cart-btn")).click();
  			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  			
  			for (int i=0; i<=9; i++) {
  				driver.findElement(By.cssSelector("#add-product-3-qtd > span")).click();
  						
  			}
  			for (int i=0; i<=5; i++) {
  				driver.findElement(By.cssSelector("#remove-product-3-qtd > span")).click();
  						
  			}
  			 			
  			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  			
  			String textoElement0 = driver.findElement(By.cssSelector("#price-total-checkout")).getText();
  	        assertEquals("R$ 36,00", textoElement0);
  			
  			driver.findElement(By.cssSelector("#finish-checkout-button")).click();
  			
  			String textoElement = driver.findElement(By.cssSelector("#root > div.ReactModalPortal > div > div > div > h2")).getText();
  	        assertEquals("Pedido realizado com sucesso!", textoElement);
	  		driver.findElement(By.cssSelector("#root > div.ReactModalPortal > div > div > div > button")).click();
	  		
	  	 }
		
		
		
		@AfterTest
		public void FecharDriver(){
			 driver.close();
			 driver.quit();
		}

}
