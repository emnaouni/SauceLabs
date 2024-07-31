package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy (xpath ="//*[@data-test='shopping-cart-link'] ")
    WebElement ButttonPannier;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement AddButton1;

    @FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement AddButton2;

    @FindBy (id = "react-burger-menu-btn")
    WebElement menuBurger;

    @FindBy(xpath = "//*[@data-test='logout-sidebar-link']")
    WebElement Logout;


    public void ClickAddButton1() {
        AddButton1.click();
    }
    public  void ClickAddButton2() {
        AddButton2.click();
    }

    public  void ClickPannier() {
        ButttonPannier.click();
    }
    public  void ClickMenuBurger() {
        menuBurger.click();
    }
    public  void ClickLogout() {
        Logout.click();
    }

    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
