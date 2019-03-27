package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageForm extends BasePage {

	public LoginPageForm(WebDriver navegador) {
		super(navegador);
	}

	public LoginPageForm clicarLogin(String login) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(login);

		return this;

	}

	public LoginPageForm clicarSenha(String senha) {
		navegador.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(senha);

		return this;

	}
	
	//sempre que for mudar de pagina, a assinatura do método tem que ser o nome da proxima pagina 
	public SecretePage clicarLoginButon() {
		navegador.findElement(By.linkText("SIGN IN")).click();
		
		return new SecretePage(navegador);
	}

}
