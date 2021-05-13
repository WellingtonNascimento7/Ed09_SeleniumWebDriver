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

public class REQ06CT01 {
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
	public void rEQ06CT01() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1616, 876));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("maria");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("456");
		driver.findElement(By.cssSelector("button")).click();
		espera(1000);
		driver.findElement(By.linkText("Empréstimo")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1237");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("1236");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("Emprestimo registrado", driver.findElement(By.cssSelector(".text-danger")).getText());
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).clear();
		driver.findElement(By.id("isbn")).sendKeys("1236");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).clear();
		driver.findElement(By.id("ra")).sendKeys("1111");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("Livro/Aluno não localizado ou existe emprestimo em aberto",
				driver.findElement(By.cssSelector(".text-danger")).getText());
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).clear();
		driver.findElement(By.id("ra")).sendKeys("1236");
		assertEquals("Livro/Aluno não localizado ou existe emprestimo em aberto",
				driver.findElement(By.cssSelector(".text-danger")).getText());
	}
	
	public void espera(int tem) {
		try {
			Thread.sleep(tem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
