package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AmazonAutoSuggest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());

		WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		Actions act = new Actions(driver);
		act.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT).build().perform();
		String toSelect = "hello shampoo";
		while (true) {
			searchBox.sendKeys(Keys.DOWN);
			if (searchBox.getAttribute("value").equalsIgnoreCase(toSelect)) {
				System.out.println(searchBox.getAttribute("value"));
				searchBox.sendKeys(Keys.ENTER);
				break;
			}

		}

	}

}
