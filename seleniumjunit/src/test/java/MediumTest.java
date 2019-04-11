import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MediumTest extends WebDriverUtil {

	@Test
	public void mediumLogoExistTest() {
		driver.get("https://medium.com/");
		WebElement icon = driver.findElement(By.cssSelector("svg.svgIcon-use"));
		Assertions.assertTrue(icon.isDisplayed());
	}

	@Test
	public void mediumLoginWithGoogleTest() {
		driver.get("https://medium.com/");
		driver.findElement(By.linkText("Sign in")).click();

		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Welcome back.'])[1]/following::span[2]")).click();
		driver.findElement(By.id("identifierId")).click();
		driver.findElement(By.id("identifierId")).clear();
		driver.findElement(By.id("identifierId")).sendKeys("eli123tcensdkalpasd@gmail.com");

		driver.findElement(By.xpath("//div[@id='identifierNext']/content/span")).click();
		WebElement profileLink = fluentWait(By.linkText("Profile"));
		Assertions.assertTrue(profileLink.isDisplayed());
		profileLink.click();
	}
}
