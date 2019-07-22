package gov.kktc.tuzel.frontend.acceptance.giris;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.kktc.tuzel.frontend.acceptance.WebDriverUtil;
import static gov.kktc.tuzel.frontend.acceptance.WebDriverUtil.serverUrl;

public class AnasayfaStepdefs {

	@When ("^Sirket basvurusu butonuna tiklanir$")
	public void sirketBasvurusuButonunaTiklanir() throws Throwable {
		WebDriverUtil.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Şirket Başvurusu'])[1]/following::div[1]")).click();
	}

	@Then ("^Basarili growl mesajinin ciktigi gorulur$")
	public void basariliGrowlMesajininCiktigiGorulur() throws Throwable {
		WebDriverUtil.fluentWait(By.cssSelector(".ui-growl-image-info")).click();
	}

	@Given ("^\"([^\"]*)\" sayfasina gelinir$")
	public void sayfasinaGelinir(String sayfa) throws Throwable {
		WebDriverUtil.driver.get(serverUrl + "/" + sayfa);
	}

}
