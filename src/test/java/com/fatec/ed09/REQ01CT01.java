package com.fatec.ed09;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class REQ01CT01 {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	
//	se Colocar so o before e importar o junit.Before funciona
//	@BeforeEach
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

//	@AfterEach
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void rEQ01CT01() {		
		vars = new HashMap<String, Object>();
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(800, 860));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1237");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("Tanenbaum");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("Sistemas Operacionais");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera(2000);
		assertEquals("Lista de livros", driver.findElement(By.cssSelector(".panel-title")).getText());
	}

	public void espera(int tem) {
		try {
			Thread.sleep(tem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
