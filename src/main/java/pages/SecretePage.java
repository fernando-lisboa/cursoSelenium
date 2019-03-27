package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretePage extends LoginPageForm {

	public SecretePage(WebDriver navegador) {
		super(navegador);
		
	}

	public PageMe clicarMe() {
		
		navegador.findElement(By.className("me")).click();
		
		return new PageMe(navegador);
	}
	
	

}
