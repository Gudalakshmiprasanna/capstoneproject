package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverinitiation.WebDriverInitiation;

public class ProductPage extends WebDriverInitiation{
   
    // Locators
    private By productTitle = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[3]");
    private By productPrice = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[4]");
    private By addToCartButton = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a");
   

    public ProductPage(WebDriver driver) {
    	getDriver("chrome");

    }

    public boolean verifyProductDetails() {
        return driver.findElement(productTitle).isDisplayed() && driver.findElement(productPrice).isDisplayed();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }


    public void navigateToProductPage() {
        driver.get("https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01");
    }
}
