package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageMe extends BasePage {

	public PageMe(WebDriver navegador) {
		super(navegador);
	}
	
	
	
	public AddMoreDateAboutForm clicarParaAddInfo() {
		
		navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
		
		return new AddMoreDateAboutForm(navegador); 
	}

}
