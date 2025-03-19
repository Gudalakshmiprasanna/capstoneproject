package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverinitiation.WebDriverInitiation;

public class SearchPage extends WebDriverInitiation{
   
    // Locators
    private By searchBox = By.name("keyword");  // Ensure this matches the actual search bar locator
    private By searchButton = By.name("searchProducts");
    private By searchResults = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a");

    public SearchPage(WebDriver driver) {
    	getDriver("chrome");

    }

    // ✅ Add this missing method
    public void searchForProduct(String product) {
    	
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(searchButton).click();
    }

    public boolean isSearchResultRelevant(String product) {
        return driver.findElement(searchResults).getText().toLowerCase().contains(product.toLowerCase());
    }

    public void selectFirstProduct() {
        driver.findElement(By.xpath("(//a[contains(@href,'Product')])[1]")).click();
    }
}
