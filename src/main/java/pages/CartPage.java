package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverinitiation.WebDriverInitiation;

public class CartPage extends WebDriverInitiation {
   

    // Locators
    private By quantityField = By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[5]/input");
    private By updateButton = By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[3]/td[1]/input");
    private By removeButton = By.xpath("//*[@id=\"Cart\"]/form/table/tbody/tr[2]/td[8]/a");
    private By signin = By.xpath("//*[@id=\"MenuContent\"]/a[2]");
    private By username = By.name("username");
    private By password = By.name("password");
    private By signon = By.name("signon");
    private By cartlogo = By.xpath("//*[@id=\"MenuContent\"]/a[1]/img");
    private By menuItem = By.xpath("//*[@id=\"QuickLinks\"]/a[1]/img");
    private By item = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[1]/a");
    private By addtocart = By.xpath("//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[5]/a");
    
    
    public CartPage(WebDriver driver) {
    	getDriver("chrome");

    }

    public void login() {
        driver.get("https://petstore.octoperf.com/actions/Cart.action?viewCart=");
        driver.findElement(signin).click();
        driver.findElement(username).sendKeys("ram");
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys("ram123");
        driver.findElement(signon).click();
        }

    public void updateProductQuantity(int quantity) throws InterruptedException {
        driver.findElement(quantityField).clear();
        Thread.sleep(3000);
        driver.findElement(quantityField).sendKeys(String.valueOf(quantity));
        Thread.sleep(3000);
        driver.findElement(updateButton).click();
    }

    public boolean isQuantityUpdated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantityField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Cart']/form/table/tbody/tr[2]/td[5]/input")));
        
        String actualValue = quantityField.getAttribute("value");
       
        return actualValue.equals("2");
    }
   
    public void addProductstocart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuItem));
        menu.click();

        WebElement selectedItem = wait.until(ExpectedConditions.elementToBeClickable(item));
        selectedItem.click();

        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(addtocart));
        addToCartBtn.click();
    }

	public void navigateCartPage() {
		driver.findElement(cartlogo).click();
	}
	
	
}
