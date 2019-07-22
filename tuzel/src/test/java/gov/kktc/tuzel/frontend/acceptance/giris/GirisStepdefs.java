package gov.kktc.tuzel.frontend.acceptance.giris;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.kktc.tuzel.frontend.acceptance.WebDriverUtil;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GirisStepdefs {

	@Given ("^Browser acilir$")
	public void browserAcilir() throws Throwable {
		WebDriverUtil.createWebDriver(true);
	}

	@Given ("^Giriş sayfasına gelinir$")
	public void girisSayfasinaGelinir() throws Throwable {
		WebDriverUtil.driver.get(WebDriverUtil.oauthServerUrl + "/landing.jsf");
		WebDriverUtil.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='İletişim'])[1]/following::span[1]")).click();
	}

	@When ("^Kullanıcı adı \"([^\"]*)\" ve parola \"([^\"]*)\" girilir$")
	public void kullaniciAdiVeParolaGirilir(String kullaniciAdi, String parola) throws Throwable {
		WebDriverUtil.driver.findElement(By.id("tabview:j_username_proxy")).clear();
		WebDriverUtil.driver.findElement(By.id("tabview:j_username_proxy")).sendKeys(kullaniciAdi);
		WebDriverUtil.driver.findElement(By.id("tabview:j_password_proxy")).clear();
		WebDriverUtil.driver.findElement(By.id("tabview:j_password_proxy")).sendKeys(parola);
	}

	@And ("^Girişe basılır$")
	public void giriseBasilir() throws Throwable {
		WebDriverUtil.driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='*'])[2]/following::span[2]")).click();
	}

	@Then ("^Tuzel sayfasına başarıyla girildiği görülür$")
	public void tuzelSayfasinaBasariylaGirildigiGorulur() throws Throwable {
		assertFalse(WebDriverUtil.driver.getCurrentUrl().startsWith(WebDriverUtil.oauthServerUrl));
	}

	@Then ("^Giriş sayfasında kalındığı görülür$")
	public void girisSayfasindaKalindigiGorulur() throws Throwable {
		assertTrue(WebDriverUtil.driver.getCurrentUrl().startsWith(WebDriverUtil.oauthServerUrl));
	}
}
