package myFirstEasyTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestOfPertolTwitter {

	WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void SetUp(@Optional("firefox") String browser) {
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}

	@Test
	// Switch between Windows
	public void testNimgo() {
		driver.navigate().to("http://roku.com/");
		WebElement twitterButton = driver.findElement(By.xpath(".//i[@class='glyphicon glyphicon-twitter']"));
		twitterButton.click();
		String currentWindow = driver.getWindowHandle();
		System.out.println("CURRENT WINDOW" + currentWindow);
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(".//button[@class='user-actions-follow-button js-follow-btn follow-button btn']"))
				.click();
		driver.close();
		driver.switchTo().window(currentWindow);
		driver.findElement(By.xpath("//button[@class='signin-button']")).click();

	}

	/*
	 * @Test public void fuelAverage() {
	 * driver.navigate().to("https://www.ukr.net/ua/"); WebElement fuleTab =
	 * driver.findElement(By.xpath(".//li[@id='fuel']")); fuleTab.click();
	 * String val1 =
	 * driver.findElement(By.xpath(".//ul[@class='fuels']/li[1]/div[2]")).
	 * getText(); String val2 =
	 * driver.findElement(By.xpath(".//ul[@class='fuels']/li[2]/div[2]")).
	 * getText(); String val3 =
	 * driver.findElement(By.xpath(".//ul[@class='fuels']/li[3]/div[2]")).
	 * getText(); System.out.println(val1); System.out.println(val2);
	 * System.out.println(val3); Integer val1_int =
	 * Integer.parseInt(val1.substring(0, 1)); Integer val2_int =
	 * Integer.parseInt(val2.substring(0, 1)); Integer val3_int =
	 * Integer.parseInt(val3.substring(0, 1));
	 * 
	 * if (val1_int > 25 && val2_int > 25 && val3_int > 25) { Assert.fail(
	 * "Price is high"); } else { System.out.println("Price is good"); }
	 * 
	 * try { Thread.sleep(2500); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * System.out.println();
	 * 
	 * }
	 * 
	 */

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}