package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy( id = "remove-sauce-labs-backpack")
    WebElement RemoveButton;

    @FindBy (id = "checkout")
    WebElement CheckoutButton;

    @FindBy (id = "first-name")
    WebElement Firstname;

    @FindBy(id = "last-name")
    WebElement Lastname;

    @FindBy (id = "postal-code")
    WebElement ZipCode;

    @FindBy (id = "continue")
    WebElement ContinuerButton;

    @FindBy(id = "finish")
    WebElement FinishButton;

    public  void  ClickCheckoutButton(){
        CheckoutButton.click();
    }

    public void setFirstname(String firstname) {
        Firstname.sendKeys(firstname);
    }
    public void setLastname(String lastname) {
        Lastname.sendKeys(lastname);
    }
    public void setZipCode(String zipCode) {
        ZipCode.sendKeys(zipCode);
    }
    public void ClickContinuerButton(){
        ContinuerButton.click();
    }
    public void ClickFinishButton(){
        FinishButton.click();
    }

    public void RemoveButtonClick() {
        RemoveButton.click();
    }
    WebDriver driver;
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
