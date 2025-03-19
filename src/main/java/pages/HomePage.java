package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverinitiation.WebDriverInitiation;

public class HomePage extends WebDriverInitiation {
    

    // Locators
    private By pageTitle = By.tagName("title");
    private By searchBox = By.name("keyword");
    private By searchButton = By.name("searchProducts");

    public HomePage(WebDriver driver) {
    	getDriver("chrome");

    }

    public void openHomePage() {
        driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean areImportantLinksVisible() {
        return driver.findElement(By.linkText("Sign In")).isDisplayed();
    }

    public void searchForProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }
}
