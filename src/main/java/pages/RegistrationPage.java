package pages;

import java.time.Duration;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverinitiation.WebDriverInitiation;

public class RegistrationPage extends WebDriverInitiation{
   
    // Locators
    private By signinLink = By.xpath("//*[@id=\"MenuContent\"]/a[2]");
    private By registerLink = By.xpath("//*[@id=\"Catalog\"]/a");
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By confirmPasswordField = By.name("repeatedPassword");
    private By firstNameField = By.name("account.firstName");
    private By lastNameField = By.name("account.lastName");
    private By emailField = By.name("account.email");
    private By phoneField = By.name("account.phone");
    private By address1Field = By.name("account.address1");
    private By address2Field = By.name("account.address2");
    private By cityField = By.name("account.city");
    private By stateField = By.name("account.state");
    private By zipField = By.name("account.zip");
    private By countryField = By.name("account.country");
    private By registerButton = By.name("newAccount");
    private By checkbox1 = By.name("account.listOption");
    private By checkbox2 = By.name("account.bannerOption");

    public RegistrationPage(WebDriver driver) {
    	getDriver("chrome");

    }

    public void navigateToRegistrationPage() {
    	driver.get("https://petstore.octoperf.com/actions/Catalog.action");
    	driver.findElement(signinLink).click();
        driver.findElement(registerLink).click();
    }

    public void registerUser(String username,String password,String confirmpass,String fname,String lname,String email,String phone,String address1,String address2,String city,String state,String zip,String country) throws InterruptedException {
        driver.findElement(usernameField).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(confirmPasswordField).sendKeys(confirmpass);
        Thread.sleep(1000);
        driver.findElement(firstNameField).sendKeys(fname);
        Thread.sleep(1000);
        driver.findElement(lastNameField).sendKeys(lname);
        Thread.sleep(1000);
        driver.findElement(emailField).sendKeys(email);
        Thread.sleep(1000);
        driver.findElement(phoneField).sendKeys(phone);
        Thread.sleep(1000);
        driver.findElement(address1Field).sendKeys(address1);
        Thread.sleep(1000);
        driver.findElement(address2Field).sendKeys(address2);
        Thread.sleep(1000);
        driver.findElement(cityField).sendKeys(city);
        Thread.sleep(1000);
        driver.findElement(stateField).sendKeys(state);
        Thread.sleep(1000);
        driver.findElement(zipField).sendKeys(zip);
        Thread.sleep(1000);
        driver.findElement(countryField).sendKeys(country);
        Thread.sleep(1000);
        driver.findElement(checkbox1).click();
        Thread.sleep(1000);
        driver.findElement(checkbox2).click();
        Thread.sleep(1000);
        driver.findElement(registerButton).click();
        Thread.sleep(1000);
    }

    public boolean isRegistrationSuccessful() {
        return driver.findElement(signinLink).isDisplayed();
    }
    public String getCellValue(XSSFCell cell) {
        if (cell == null) {
            return ""; // Handle null cells
        }
        
        if (cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((long) cell.getNumericCellValue()); 
        } else {
            return ""; 
        }
    }
}
