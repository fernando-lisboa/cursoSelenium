package cursoSelenium.common;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuxiliarCurso {

	private static WebDriver navegador;
	

	public static WebDriver abreNavegador()throws Exception {

		// Abrir navegador
		System.setProperty("webdriver.chrome.driver", "/Users/006_fvfx20w1j1wv/Documents/chromedriver");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// NAVEGADOR PARA A PAG DO TASKIT
		navegador.get("http://www.juliodelima.com.br/taskit");
		
		return navegador;
	}

	public static WebDriver getNavegador() {
		return navegador;
	}

	public static void setNavegador(WebDriver navegador) {
		AuxiliarCurso.navegador = navegador;
	}

	public static WebDriver cadastraTelefone(String phone) throws Exception {

		navegador.findElement(By.linkText("Sign in")).click();

		WebElement formularioSignBox = navegador.findElement(By.id("signinbox"));

		formularioSignBox.findElement(By.name("login")).sendKeys("julio0001");

		formularioSignBox.findElement(By.name("password")).sendKeys("123456");

		navegador.findElement(By.linkText("SIGN IN")).click();

		navegador.findElement(By.className("me")).click();

		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

		navegador.findElement(By.xpath("//div[@id='moredata']/div/button[@data-target='addmoredata']")).click();

		WebElement popupAddmoreDate = navegador.findElement(By.id("addmoredata"));

		WebElement campoType = popupAddmoreDate.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");
		
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		popupAddmoreDate.findElement(By.name("contact")).sendKeys(phone);

		popupAddmoreDate.findElement(By.linkText("SAVE")).click();
		
		WebElement msgPop = navegador.findElement(By.id("toast-container"));

		WebDriverWait espera = new WebDriverWait(navegador, 10);

		espera.until(ExpectedConditions.stalenessOf(msgPop));
		
		return navegador;
	}
	
	public static WebDriver excluiDadosPhone()throws Exception {
		
		
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//identificar o numero de telefonea ser apagado e o botão excluir
		navegador.findElement(By.xpath("//span[text()='+5511951001999']/following-sibling::a")).click();
		
		//confimaro o a exclusão
		
		navegador.switchTo().alert().accept();
		
		
		WebElement msgPop = navegador.findElement(By.id("toast-container"));
		
		String mensagemEncontrada = msgPop.getText();
		
		assertEquals("valor encontrado divergente do esperado", "Rest in peace, dear email!", mensagemEncontrada);
		
		WebDriverWait espera = new WebDriverWait(navegador, 10);
		
		espera.until(ExpectedConditions.stalenessOf(msgPop));
		
		navegador.findElement(By.linkText("Logout")).click();
		
		return navegador;
	}

	public static WebDriver tearDown() throws Exception{

		navegador.close();
		return navegador;

	}
}
