package br.com.all.Desafio;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Desafio {
	
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
		 public void SelecionaCategoria() {	 
		 	driver.findElement(By.id("open-categories-btn")).click();
		 	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 	driver.findElement(By.id("category-1")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		driver.findElement(By.id("add-product-4-btn")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		driver.findElement(By.id("add-product-5-btn")).click();
	  		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  		driver.findElement(By.cssSelector("#cart-btn")).click();
  			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  			for (int i=0; i<=4; i++) {
  			driver.findElement(By.cssSelector("#add-product-4-qtd")).click();
  			driver.findElement(By.cssSelector("#add-product-5-qtd")).click();
  			
  			}
  			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
