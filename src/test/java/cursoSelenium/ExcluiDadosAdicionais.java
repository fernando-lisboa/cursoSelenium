package cursoSelenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cursoSelenium.common.AuxiliarCurso;
import cursoSelenium.common.Generator;
import cursoSelenium.common.Screenshot;

public class ExcluiDadosAdicionais {

	private static WebDriver navegador;
	
	private String enderecoArquivo = "/Users/006_fvfx20w1j1wv/Documents/testes/Screenshot";
	private String ct = "excluir dados de contato";
	
	
	String phone = "+5511951001999";
	
	
	@Before

	public void cadastroDadosParaSerTestado() throws Exception {

		AuxiliarCurso.abreNavegador();
		
		AuxiliarCurso.cadastraTelefone(phone);

	}

	@Test

	public void excluirDados() throws Exception {
		
		
		
		System.out.println("Abrindo navegador...");
		navegador = AuxiliarCurso.getNavegador();
		
		navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// identificar o numero de telefonea ser apagado e o botão excluir
		System.out.println("excluindo um contato...");

		navegador.findElement(By.xpath("//span[text()='+5511951001999']/following-sibling::a")).click();

		// confimaro o a exclusão

		navegador.switchTo().alert().accept();
		System.out.println("Contato excluido com sucesso...");

		WebElement msgPop = navegador.findElement(By.id("toast-container"));

		String mensagemEncontrada = msgPop.getText();
		
		assertEquals("valor encontrado divergente do esperado", "Rest in peace, dear phone!", mensagemEncontrada);
		
		Screenshot.tirar(navegador, enderecoArquivo + Generator.dataHoraParaArquivo()+ct+".png");
		System.out.println("Mensagem de exclusão validada com sucesso");
		
		System.out.println("Aguardando msg parar de ser exibida...");
		
		WebDriverWait espera = new WebDriverWait(navegador, 10);

		espera.until(ExpectedConditions.stalenessOf(msgPop));

		navegador.findElement(By.linkText("Logout")).click();
		System.out.println("Fechando navegador...");

		System.out.println("Excluido com sucesso");

	}

	public static WebDriver getNavegador() {
		return navegador;
	}

	public static void setNavegador(WebDriver navegador) {
		ExcluiDadosAdicionais.navegador = navegador;
	}

	@After

	public void fechaNavegador() throws Exception {

		 AuxiliarCurso.tearDown();
	}

}
