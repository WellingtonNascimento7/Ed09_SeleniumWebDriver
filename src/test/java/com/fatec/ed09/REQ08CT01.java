package com.fatec.ed09;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class REQ08CT01 {
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
	public void rEQ08CT01() {
		driver.get("https://ts-scel.herokuapp.com/logout");
		driver.manage().window().setSize(new Dimension(1616, 876));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("joao");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("222");
		driver.findElement(By.cssSelector("button")).click();
		assertEquals("Invalid username and password.", driver.findElement(By.cssSelector("body > div")).getText());
		assertEquals("LOGIN\nNão cadastrado? Crie uma conta", driver.findElement(By.cssSelector("form")).getText());
		
	}

	public void espera(int tem) {
		try {
			Thread.sleep(tem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
