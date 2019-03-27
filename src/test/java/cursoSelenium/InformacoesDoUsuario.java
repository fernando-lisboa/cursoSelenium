package cursoSelenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InformacoesDoUsuario {

	private WebDriver navegador;
	

	@Before
	public void setUp() throws Exception {

		
		
		// Abrir navegador
		System.setProperty("webdriver.chrome.driver", "/Users/006_fvfx20w1j1wv/Documents/chromedriver");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// NAVEGADOR PARA A PAG DO TASKIT
		navegador.get("http://www.juliodelima.com.br/taskit");
	}

	@Test

	public void adicionarUmaInformacaoDoUsuario() {

		navegador.findElement(By.linkText("Sign in")).click();

		// Identificar o elemento de login

		WebElement formularioSignBox = navegador.findElement(By.id("signinbox"));

		// digitar no campo com name "login"que está dentro do formulário de
		// id"signinbox" o texto "julio0001"

		formularioSignBox.findElement(By.name("login")).sendKeys("julio0001");

		// digitar no campo com name "password"que está dentro do formulário de
		// id"signinbox" o texto "123456"

		formularioSignBox.findElement(By.name("password")).sendKeys("123456");

		// Clicar no link com o texto "SIGN IN"

		navegador.findElement(By.linkText("SIGN IN")).click();

		// Validar que dentro do elemento do class "me" está o texto "Hi, Julio"

		WebElement me = navegador.findElement(By.className("me"));

		String textoElementoMe = me.getText();

		assertEquals("valor encontrado divergente do esperado", "Hi, Julio", textoElementoMe);

		// clicar em um link que possui a class "me"

		navegador.findElement(By.className("me")).click();

		// clicar no link que possui o texto "MORE DATA ABOUT YOU"
		
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
		// clicar no botão através do seu Xpath
		// "//div[@id="moredata"]/div/button[@data-target="addmoredata"]

		navegador.findElement(By.xpath("//div[@id='moredata']/div/button[@data-target='addmoredata']")).click();

		// identificar o formulário onde está o pop ap onde está o formulário de id
		// addmoredata

		WebElement popupAddmoreDate = navegador.findElement(By.id("addmoredata"));

		// na combo de name Type escolher a opçao Phone

		WebElement campoType = popupAddmoreDate.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");

		// colocar no campo de name contact, digitar um telefone "+5511999999999"

		popupAddmoreDate.findElement(By.name("contact")).sendKeys("+5511999999999");

		// clicar no link que contenha o texto SAVE que está na popUp

		popupAddmoreDate.findElement(By.linkText("SAVE")).click();

		// na mensagem de id "toast-container" e validar que a mensagem é "Your contact
		// has been added!"

		WebElement msgPop = navegador.findElement(By.id("toast-container"));

		String mensagemEncontrada = msgPop.getText();

		assertEquals("valor encontrado divergente do esperado", "Your contact has been added!", mensagemEncontrada);

	}

	@After
	public void fecharNavegador(){
		
		navegador.quit();
		
	}

}
