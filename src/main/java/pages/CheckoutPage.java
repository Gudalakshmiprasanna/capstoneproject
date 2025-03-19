package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverinitiation.WebDriverInitiation;

public class CheckoutPage extends WebDriverInitiation {

    // Locators
    private By proceedToCheckoutButton = By.xpath("//*[@id=\"Cart\"]/a");
    private By continueButton = By.xpath("//*[@id=\"Catalog\"]/form/input");
    private By confirmOrderButton = By.xpath("//*[@id=\"Catalog\"]/a");
    private By orderConfirmationMessage = By.xpath("//*[@id=\"Content\"]/ul/li");

    public CheckoutPage(WebDriver driver) {
    	getDriver("chrome");

    }

    public void proceedToCheckout() {
        driver.findElement(proceedToCheckoutButton).click();
        driver.findElement(continueButton).click();
        driver.findElement(confirmOrderButton).click();
    }

    public boolean isPurchaseCompleted() {
        return driver.findElement(orderConfirmationMessage).isDisplayed();
    }
}
