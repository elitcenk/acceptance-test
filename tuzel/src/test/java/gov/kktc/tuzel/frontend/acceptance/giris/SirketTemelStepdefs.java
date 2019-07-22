package gov.kktc.tuzel.frontend.acceptance.giris;

import org.openqa.selenium.By;

import cucumber.api.java.en.And;
import gov.kktc.tuzel.frontend.acceptance.WebDriverUtil;

public class SirketTemelStepdefs {

	@And ("^Sirket temel basvurusunda isim olarak \"([^\"]*)\" girilir$")
	public void sirketTemelBasvurusundaIsimOlarakGirilir(String sirketAdi) throws Throwable {
		WebDriverUtil.driver.findElement(By.id("form:tuzelAd")).click();
		WebDriverUtil.driver.findElement(By.id("form:tuzelAd")).clear();
		WebDriverUtil.driver.findElement(By.id("form:tuzelAd")).sendKeys(sirketAdi);
	}

	@And ("^Sirket kaydet tiklanir$")
	public void sirketKaydetTiklanir() throws Throwable {
		WebDriverUtil.driver.findElement(By.id("form:saveSirketButton")).click();
	}

	@And ("^Sirket temel basvurusunda tur secilir$")
	public void sirketTemelBasvurusundaTurSecilir() throws Throwable {
		WebDriverUtil.fluentWait(By.id("form:tuzelTuru_label")).click();
		Thread.sleep(500);
		WebDriverUtil.driver.findElement(By.id("form:tuzelTuru_1")).click();
	}

	@And ("^Sirket temel basvurusunda para birimi secilir$")
	public void sirketTemelBasvurusundaParaBirimiSecilir() throws Throwable {
		WebDriverUtil.fluentWait(By.id("form:paraBirimi_label")).click();
		Thread.sleep(500);
		WebDriverUtil.driver.findElement(By.id("form:paraBirimi_2")).click();
	}
}
