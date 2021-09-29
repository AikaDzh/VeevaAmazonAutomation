package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.AmazonHomePage;
import pages.AmazonProductPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class AmazonValidationSteps {

    AmazonHomePage amazonHomePage = new AmazonHomePage();
    AmazonProductPage amazonProductPage = new AmazonProductPage();

    @Before
    public void setUp() {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Method runs before scenario.");
    }

    @Given("user navigates to amazon application")
    public void user_navigates_to_amazon_application() {

        driver.get(ConfigReader.getProperty("AmazonURL"));
    }

    @When("user searches for {string}")
    public void user_searches_for(String item) {

        amazonHomePage.searchBox.sendKeys(item+ Keys.ENTER);
    }
    @And("user selects the first item in the list and adds it to the cart")
    public void user_selects_the_first_item_in_the_list_and_adds_it_to_the_cart(){
        amazonProductPage.firstJava12Book.click();
        amazonProductPage.addToCartButton.click();
        amazonProductPage.cartIcon.click();
    }

    @Then("user validates that item is added to the cart")
    public void user_validates_that_item_is_added_to_the_cart(){
        String expectedResult = "Subtotal (1 item): $34.99";
        String actualResult = amazonProductPage.actualResult.getText();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @After
    public void tearDown(Scenario scenario){
        WebDriver  driver = Driver.getDriver();
        // taking screenshot for our report for failed scenario
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        driver.quit();
        System.out.println("Method runs after scenario.");

    }
}
