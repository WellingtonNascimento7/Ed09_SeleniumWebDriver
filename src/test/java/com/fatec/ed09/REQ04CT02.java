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

public class REQ04CT02 {
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
	public void rEQ04CT02() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(800, 860));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("maria");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("456");
		driver.findElement(By.cssSelector("button")).click();
		espera(1000);
		driver.findElement(By.linkText("Alunos")).click();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("12345");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("aaaaaaaaaaaaaaaaaaa51caracteresaaaaaaaaaaaaaaaaaaaa");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("aaaaaaaaaaaaaaaaaaa51caracteresaaaaaaaaaaaaaaaaaaaa");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("12345678912");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("RA deve ter 4 caracteres",
				driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText());
		assertEquals("Nome deve ter entre 1 e 50 caracteres",
				driver.findElement(By.cssSelector(".row:nth-child(3) .text-danger")).getText());
		assertEquals("E-mail deve ter entre 1 e 50 caracteres",
				driver.findElement(By.cssSelector(".row:nth-child(4) > .form-group > .text-danger")).getText());
		assertEquals("CEP deve ter 8 caracteres",
				driver.findElement(By.cssSelector(".row:nth-child(2) > .col-md-8 > .text-danger")).getText());
	}

	public void espera(int tem) {
		try {
			Thread.sleep(tem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
