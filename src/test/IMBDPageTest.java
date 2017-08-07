package test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;

import pages.HomePage;
import pages.AbstractPage;
import pages.SortingPage;

/**
 * @author Asha
 * Test class
 *
 */

public class IMBDPageTest {
	WebDriver driver;
	
	/** Used for Home Page Sorting. */
	String ranking = "rk:ascending";
	String imdbRating = "ir:descending";
	String releaseDate = "us:descending";
	String numberofRatings = "nv:descending";
	String yourRating = "ur:descending";
	
	/** Used for Genre Page Sorting. */
	String popularity = "Popularity";
	String alphabetical = "Alphabetical";
	String rating = "IMDb Rating";
	String numOfVotes = "Number of Votes";
	String boxOffice = "US Box Office";
	String runtime = "Runtime";
	String year = "Year";
	String relDate = "Release Date";
	
		
   @Test
	public void Test01_HomePage() {
	   
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String baseUrl = "http://www.imdb.com/chart/top"; 
		driver.get(baseUrl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header")));

		/** Checks if at least one movie is displayed on the Home Page
		 * after WebSite has been launched */
		AbstractPage abstractPage = new AbstractPage(driver);
		boolean ranking = abstractPage.checkIfMovieDIsplayed();
		Assert.assertTrue(ranking);
		
	}
	
	@Test
	public void Test02_HomePageSorting() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String baseUrl = "http://www.imdb.com/chart/top"; 
		driver.get(baseUrl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header")));	
		
		/** Sort's on Release date, IMDB Rating, Number of Ratings 
		 * and Your Rating on Home Page.
		 * Checks if at least one movie is displayed for the selected sorting type. */
		SortingPage sortingPage = new SortingPage(driver);
		sortingPage.sort(releaseDate);
		AbstractPage abstractPage = new AbstractPage(driver);
		boolean releaseDates = abstractPage.checkIfMovieDIsplayed();
		Assert.assertTrue(releaseDates);
	
		sortingPage.sort(imdbRating);
		boolean imdbRatings = abstractPage.checkIfMovieDIsplayed();
		Assert.assertTrue(imdbRatings);
		
		sortingPage.sort(numberofRatings);
		boolean numberRatings = abstractPage.checkIfMovieDIsplayed();
		Assert.assertTrue(numberRatings);
		
		sortingPage.sort(yourRating);
		boolean yourRatings = abstractPage.checkIfMovieDIsplayed();
		Assert.assertTrue(yourRatings);
	
	}
	
	
	@Test
	public void Test03_SortingOnWesternGenre() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String baseUrl = "http://www.imdb.com/chart/top"; 
		driver.get(baseUrl);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("header")));	
		
		/** Scroll's the page down. */
		AbstractPage abstractPage = new AbstractPage(driver);
		abstractPage.scrollDown();
		
		/** Select's Western Genre. */
		HomePage homePage = new HomePage(driver);	
		homePage.selectGenere("Western");
		SortingPage sortingPage = new SortingPage(driver);
		
		/** Sort's based on Popularity, Alphabetical, Rating, Number of Votes,
		 * Box Office, Run Time year and Release Dates on Genre Page. 
		 * Checks if at least one movie is displayed for each sorting type. */
		
		sortingPage.sortGenere(popularity);
    	boolean popularity = abstractPage.checkIfMovieDIsplayedOnGenere();
		Assert.assertTrue(popularity);
		
		sortingPage.sortGenere(alphabetical);
		boolean alphabetical = abstractPage.checkIfMovieDIsplayedOnGenere();
		Assert.assertTrue(alphabetical);
		
		sortingPage.sortGenere(rating);
		boolean rating = abstractPage.checkIfMovieDIsplayedOnGenere();
		Assert.assertTrue(rating);
		
		sortingPage.sortGenere(numOfVotes);
		boolean numOfVotes = abstractPage.checkIfMovieDIsplayedOnGenere();
		Assert.assertTrue(numOfVotes);
		
		sortingPage.sortGenere(boxOffice);
		boolean boxOffice = abstractPage.checkIfMovieDIsplayedOnGenere();
		Assert.assertTrue(boxOffice);
		
		sortingPage.sortGenere(runtime);
		boolean runtime = abstractPage.checkIfMovieDIsplayedOnGenere();
		Assert.assertTrue(runtime);
		
		sortingPage.sortGenere(year);
		boolean year = abstractPage.checkIfMovieDIsplayedOnGenere();
		Assert.assertTrue(year);
		
		sortingPage.sortGenere(relDate);
		boolean relDate = abstractPage.checkIfMovieDIsplayedOnGenere();
		Assert.assertTrue(relDate);
		
	}
	
	/** Terminates the browser after each test. */
	@AfterTest
     public void terminateBrowser(){
         driver.close();
     }

}
