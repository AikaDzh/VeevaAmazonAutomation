package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonProductPage {

    public AmazonProductPage(){

        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//div[@data-component-id='29']//img[@class='s-image']")
    public WebElement firstJava12Book;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='nav-cart-icon nav-sprite']")
    public WebElement cartIcon;

    @FindBy(id = "sc-subtotal-label-activecart")
    public WebElement actualResult;

}
