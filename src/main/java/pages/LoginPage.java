package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import driverinitiation.WebDriverInitiation;

public class LoginPage extends WebDriverInitiation{
   

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.name("signon");
    private By logoutLink = By.linkText("Sign Out");
    private By signinLink = By.xpath("//*[@id=\"MenuContent\"]/a[2]");

    public LoginPage(WebDriver driver) {
        getDriver("chrome");
        
    }

    public void login(String username,String password) throws InterruptedException {
    	driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    	driver.findElement(signinLink).click();
    	driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(passwordField).clear();
        Thread.sleep(1000);
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(loginButton).click();
        Thread.sleep(1000);
    }

    public boolean isLoggedIn() {
        return driver.findElement(logoutLink).isDisplayed();
    }
}
