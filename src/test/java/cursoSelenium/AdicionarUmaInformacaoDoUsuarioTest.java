package cursoSelenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import cursoSelenium.common.Web;
import pages.LoginPage;

public class AdicionarUmaInformacaoDoUsuarioTest {

	private WebDriver navegador;
	
	private String phone ="+5511999988888";
	private String senha ="123456";
	private String login ="julio0001";
	
	
	
	@Before
	public void setUp() {
		navegador = Web.crateBrowsersteck();
	}
	
	
	@Test
	
	public void InformacoesDoUsuario() {
		
		
		String mensagemEncontrada =  new LoginPage(navegador)
		.clicarSignIn()
		.clicarLogin(login)
		.clicarSenha(senha)
		.clicarLoginButon()
		.clicarMe()
		.clicarParaAddInfo()
		.insereDados(phone)
		.clicarNoBotaoSalvar()
		.resgataMensagem();
		
		
	assertEquals("valor encontrado divergente do esperado", "Your contact has been added!", mensagemEncontrada);
		
		
	}

	@After
	public void teardown() {

		navegador.quit();
	}

}
