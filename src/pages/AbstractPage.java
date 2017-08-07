package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
	
/**
 * @author Asha
 * Abstract Page with Assert methods used in different tests.
 *
 */

public class AbstractPage {
	WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	/** Checks if at least one move has been displayed in the Home page after Sorting. */
	public boolean checkIfMovieDIsplayed() {
		By movieDisplayed = By.xpath("//*[@id='main']/div/span/div/div/div[3]/table/tbody/tr[1]");
		int count = driver.findElements(movieDisplayed).size();
		assert driver.findElement(movieDisplayed).isDisplayed();
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/** Checks if at least one move has been displayed in the Genre page after Sorting. */
	public boolean checkIfMovieDIsplayedOnGenere() {
		By movieDisplayed = By.xpath("//*[@id='main']/div/div/div[3]/div[2]");
		int count = driver.findElements(movieDisplayed).size();
		assert driver.findElement(movieDisplayed).isDisplayed();
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	/** Scroll's the page down. */
	public void scrollDown() {
		JavascriptExecutor jsx = (JavascriptExecutor) driver;
		jsx.executeScript("window.scrollBy(0,750)", "");
	}
}
