package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Asha
 * This is the Home Page of the IMDB WebSite.
 *
 */

public class HomePage {
	WebDriver driver;
	By sort = By.name("sort");
	
	public HomePage(WebDriver driver){
	    this.driver = driver;
	}
		
	/** Select different Genre types on the home page by passing parameters. */
	public void selectGenere(String genereType){
		driver.findElement(By.linkText(genereType)).click();	
	}
	
}