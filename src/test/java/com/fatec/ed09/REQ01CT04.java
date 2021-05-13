package com.fatec.ed09;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

public class REQ01CT04 {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void rEQ01CT04() {
//	  System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
//		driver = new ChromeDriver();
//		js = (JavascriptExecutor) driver;
//		vars = new HashMap<String, Object>();
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(800, 860));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		espera(1000);
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("12345");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("Tanenbaum");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("Sistemas Operacionais");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("ISBN deve ter 4 caracteres",
				driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText());
	}

	public void espera(int tem) {
		try {
			Thread.sleep(tem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
