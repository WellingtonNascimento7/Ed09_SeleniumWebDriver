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

public class REQ09CT01 {
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

	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}

	@Test
	public void rEQ09CT01() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(800, 860));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		espera(1000);
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("1235");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("João da Silva");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("joao_sil@gmail.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("08223000");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera(2000);
		assertEquals("Lista de alunos", driver.findElement(By.id("titulopagina")).getText());
		driver.findElement(By.linkText("Voltar")).click();
		driver.findElement(By.linkText("Alunos")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
		vars.put("win4294", waitForWindow(2000));
		driver.switchTo().window(vars.get("win4294").toString());
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).clear();
		driver.findElement(By.id("nome")).sendKeys("João Silva");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("joao_sil123@gmail.com");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera(2000);
		driver.findElement(By.linkText("Excluir")).click();
	}

	public void espera(int tem) {
		try {
			Thread.sleep(tem);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
