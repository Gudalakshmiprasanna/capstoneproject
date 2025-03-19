package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import driverinitiation.WebDriverInitiation;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.RegistrationPage;
import pages.SearchPage;
import screenshots.ScreenshotCode;

public class JPetStore {
    
    
    WebDriver driver;
    HomePage homePage = new HomePage(driver);
    SearchPage searchPage = new SearchPage(driver);
    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    // Verify Home Page
    @Given("I open the JPetStore home page")
    public void i_open_the_JPetStore_home_page() {
        homePage.openHomePage();
    }

    @Then("I should see the page title as {string}")
    public void i_should_see_the_page_title_as(String title) {
        Assert.assertEquals(homePage.getPageTitle(), title);
    }
  
    @Then("all important links should be visible")
    public void all_important_links_should_be_visible() {
        Assert.assertTrue(homePage.areImportantLinksVisible());
    }

    // Search Functionality
   
    @Given("I am on the JPetStore home page")
    public void i_am_on_the_JPetStore_home_page() {
        homePage.openHomePage();
    }
   
    @When("I search for {string} in the search bar")
    public void i_search_for_in_the_search_bar(String searchQuery) {
        searchPage.searchForProduct(searchQuery);
    }

    @Then("I should see search results related to {string}")
    public void i_should_see_search_results_related_to(String searchQuery) {
        Assert.assertTrue(searchPage.isSearchResultRelevant(searchQuery));
    }

    @Then("I should be able to select a product from search results")
    public void i_should_be_able_to_select_a_product_from_search_results() {
        searchPage.selectFirstProduct();
    }

    @Then("I should be able to verify product details like name, price, and availability")
    public void i_should_be_able_to_verify_product_details_like_name_price_and_availability() {
        Assert.assertTrue(productPage.verifyProductDetails());
    }

    // Product Details Page
    
    @Given("I navigate to a product details page")
    public void i_navigate_to_a_product_details_page() {
        productPage.navigateToProductPage();
    }

    
    @Then("I should see product title, description, price, and image")
    public void i_should_see_product_title_description_price_and_image() {
        Assert.assertTrue(productPage.verifyProductDetails());
    }

    
    @Then("I should be able to add the product to cart")
    public void i_should_be_able_to_add_the_product_to_cart() {
        productPage.addToCart();
    }

   
    // Shopping Cart Functionality
    @Given("I have to login")
    public void i_have_to_login() {
       cartPage.login();
    }
    
    @When("I add a product")
    public void i_add_a_product() {
    	cartPage.addProductstocart();
    }
    
    @Then("navigate to cart page")
    public void navigate_to_cart_page() {
    	cartPage.navigateCartPage();
    }

    @When("I update the quantity of a product")
    public void i_update_the_quantity_of_a_product() throws InterruptedException {
        cartPage.updateProductQuantity(2);
    }

    @Then("the updated quantity should be reflected in the cart")
    public void the_updated_quantity_should_be_reflected_in_the_cart() {
        Assert.assertTrue(cartPage.isQuantityUpdated());
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        checkoutPage.proceedToCheckout();
    }

    @Then("I should be able to complete the purchase process")
    public void i_should_be_able_to_complete_the_purchase_process() {
        Assert.assertTrue(checkoutPage.isPurchaseCompleted());
    }
    
    // User Registration and Login
    
    @Given("I navigate to the registration page")
    public void i_navigate_to_the_registration_page() {
        registrationPage.navigateToRegistrationPage();
    }

   
    @When("I enter the following user details and submit the form:")
    public void i_enter_the_following_user_details_and_submit_the_form() throws InterruptedException, IOException {
    	File f = new File("C:\\Users\\91863\\Desktop\\CapstoneProjectRegistrationCredentials.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook w = new XSSFWorkbook(fis);
        XSSFSheet s = w.getSheetAt(0);
        XSSFRow r=s.getRow(7);
        String username = registrationPage.getCellValue(r.getCell(0));
        String password = registrationPage.getCellValue(r.getCell(1));
        String confirmpass = registrationPage.getCellValue(r.getCell(2));
        String fname = registrationPage.getCellValue(r.getCell(3));
        String lname = registrationPage.getCellValue(r.getCell(4));
        String email = registrationPage.getCellValue(r.getCell(5));
        String phone = registrationPage.getCellValue(r.getCell(6));
        String address1 = registrationPage.getCellValue(r.getCell(7));
        String address2 = registrationPage.getCellValue(r.getCell(8));
        String city = registrationPage.getCellValue(r.getCell(9));
        String state = registrationPage.getCellValue(r.getCell(10));
        String zip = registrationPage.getCellValue(r.getCell(11));
        String country = registrationPage.getCellValue(r.getCell(12));
            
            Thread.sleep(3000);
            registrationPage.registerUser(username, password,confirmpass,fname,lname,email,phone,address1,address2,city,state,zip,country);
            w.close();
    }

    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
        Assert.assertTrue(registrationPage.isRegistrationSuccessful());
    }

    
    @When("I log in with the valid credentials")
    public void i_log_in_with_the_following_credentials() throws InterruptedException, IOException {
    	File f = new File("C:\\Users\\91863\\Desktop\\CapstoneProjectLoginCredentials.xlsx");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook w = new XSSFWorkbook(fis);
        XSSFSheet s = w.getSheetAt(0);
        XSSFRow r=s.getRow(1);
        String username = registrationPage.getCellValue(r.getCell(0));
        String password = registrationPage.getCellValue(r.getCell(1));
            Thread.sleep(3000);
            loginPage.login(username, password);
            w.close();
    }

   
    @Then("I should be successfully logged in")
    public void i_should_be_successfully_logged_in() {
        Assert.assertTrue(loginPage.isLoggedIn());
    }
    
    @After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	        ScreenshotCode.takeScreenshot(driver, scenario.getName());
	    }
	    WebDriverInitiation.closeDriver();	
	}
}
