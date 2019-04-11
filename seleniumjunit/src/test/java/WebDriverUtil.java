import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WebDriverUtil {

	protected static WebDriver driver;
	private static boolean isFirefox = true;

	@BeforeAll
	public static void setUp() throws Exception {
		if(isFirefox){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
		} else {
			driver = new HtmlUnitDriver(true);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * Fuent wait for locator. Check every 5 seconds for 60 seconds
	 * @param locator
	 * @return
	 */
	protected WebElement fluentWait(final By locator) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.of(60, ChronoUnit.SECONDS)).pollingEvery(Duration.of(5, ChronoUnit.SECONDS)).ignoring(NoSuchElementException.class);
		return wait.until(driver -> driver.findElement(locator));
	}

	@AfterEach
	public void cleanUp() {
		driver.manage().deleteAllCookies();
	}

	@AfterAll
	public static void tearDown() {
		driver.close();
	}
}
