package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Asha
 * Sorting Page with sorting methods required for the Tests.
 *
 */

public class SortingPage {
	
	WebDriver driver;
	By sort = By.name("sort");
	
	public SortingPage(WebDriver driver){
	    this.driver = driver;
	}
	
	/** Sort's on the Home Page based on the parameter's passed in the test. */
	public void sort(String sortType){
		Select dropdown = new Select (driver.findElement(sort));
		dropdown.selectByValue(sortType);
	}
	
	/** Sort's on the Genre Page based on the parameter's passed in the test. */
	public void sortGenere(String sortGenereType){
		driver.findElement(By.linkText(sortGenereType)).click();		
	}

}
