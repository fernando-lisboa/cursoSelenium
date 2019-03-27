package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddMoreDateAboutForm extends BasePage {

	public AddMoreDateAboutForm(WebDriver navegador) {
		super(navegador);
		// TODO Auto-generated constructor stub
	}


	public AddMoreDateAboutForm insereDados(String phone) {

		navegador.findElement(By.xpath("//div[@id='moredata']/div/button[@data-target='addmoredata']")).click();

		WebElement campoType = navegador.findElement(By.id("addmoredata")).findElement(By.name("type"));
		new Select(campoType).selectByVisibleText("Phone");

		navegador.findElement(By.id("addmoredata")).findElement(By.name("contact")).sendKeys(phone);
		return this;
	}

	public PageMe clicarNoBotaoSalvar() {
		
		navegador.findElement(By.id("addmoredata"))
		.findElement(By.linkText("SAVE")).click();

		return new PageMe(navegador);

	}



}
