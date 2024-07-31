package StepDefinition;

import PageFactory.CartPage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import Utils.ConfigReader;
import Utils.ElementUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.util.Properties;

public class ScenarioPassant {
WebDriver driver;
LoginPage login ;
HomePage home;
CartPage Cart;
Properties prop;
ConfigReader configReader;

ElementUtils element;

    @Given("Je me rends sur le site SwagLabs")
    public void je_me_rends_sur_le_site_swag_labs() {
        driver = new EdgeDriver();
        element=new ElementUtils(driver);
        login = new LoginPage(driver);
        configReader = new ConfigReader();
        prop = configReader.ConfigurationManager();

      driver.manage().window().maximize();
      driver.get(configReader.GetUrl());


    }
    @When("Je saisie le username")
    public void je_saisie_le_username() throws InterruptedException {

        Thread.sleep(3000);

       login.setUsername(configReader.Getusername());
    }
    @When("Je saisie le password")
    public void je_saisie_le_password() {
       login.setPassword(configReader.Getpassword());

    }
    @When("Je clique sur le bouton Login")
    public void je_clique_sur_le_bouton_login() throws InterruptedException {
        Thread.sleep(3000);
        login.clickLoginButton();
    }
    @Then("La page des produit s affichent")
    public void la_page_des_produit_s_affichent() {
        element.Confirmation("https://www.saucedemo.com/inventory.html");

    }
    @When("Je clique sur le bouton Add to cart du produit BackPack")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_back_pack() throws InterruptedException {
        home=new HomePage(driver);
       Thread.sleep(3000);
       home.ClickAddButton1();

    }
    @When("Je clique sur le bouton Add to cart du produit T-Shirt")
    public void je_clique_sur_le_bouton_add_to_cart_du_produit_t_shirt() throws InterruptedException {
        Thread.sleep(3000);
        home=new HomePage(driver);
       home.ClickAddButton2();
    }
    @Then("Les produit s ajoutent dans le panier")
    public void les_produit_s_ajoutent_dans_le_panier() {
       element.Exist("Remove");
    }
    @When("Je clique sur l icone panier")
    public void je_clique_sur_l_icone_panier() {
       home.ClickPannier();
    }
    @When("Je clique sur le bouton remove")
    public void je_clique_sur_le_bouton_remove() throws InterruptedException {
        Thread.sleep(3000);
        Cart=new CartPage(driver);
       Cart.RemoveButtonClick();
    }
    @Then("Le produit sera supprimé du panier")
    public void le_produit_sera_supprimé_du_panier() {
     element.Exist("Sauce Labs Backpack");
    }


    @When("Je clique sur le bouton checkout")
    public void je_clique_sur_le_bouton_checkout() throws InterruptedException {
        Thread.sleep(5000);
        Cart=new CartPage(driver);
        element = new ElementUtils(driver);
       element.Scrolling(800);
        Cart.ClickCheckoutButton();
    }
    @When("Je rempli le username")
    public void je_rempli_le_username() {
       Cart.setFirstname("Emna");
    }
    @When("Je saisie le lastname")
    public void je_saisie_le_lastname() {
      Cart.setLastname("Emnaa");
    }
    @When("Je saisie le code postal")
    public void je_saisie_le_code_postal() {
      Cart.setZipCode("4444");
    }
    @When("je clique sur le bouton continue")
    public void je_clique_sur_le_bouton_continue() {
       Cart.ClickContinuerButton();
    }
    @Then("une page overview s affiche")
    public void une_page_overview_s_affiche() {
       element.Exist("Checkout: Overview");
    }
    @When("je clique sur le bouton finish")
    public void je_clique_sur_le_bouton_finish() throws InterruptedException {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        Thread.sleep(3000);
        element.FooterScrolling();

       Cart.ClickFinishButton();

       Thread.sleep(5000);
    }
    @Then("une page Checkout:Complete s affiche")
    public void une_page_checkout_complete_s_affiche() {
       element.Exist("Checkout: Complete!");
    }



    @When("Je clique sur le menu burger")
    public void je_clique_sur_le_menu_burger() throws InterruptedException {
        Thread.sleep(3000);
        home.ClickMenuBurger();
    }
    @When("Je clique surle bouton Logout")
    public void je_clique_surle_bouton_logout() throws InterruptedException {
       Thread.sleep(3000);
       home.ClickLogout();
    }
    @Then("Je me redirige vers la page d authentification {string}")
    public void je_me_redirige_vers_la_page_d_authentification(String string) {
        String URLCurrent=driver.getCurrentUrl();
        Assert.assertEquals(URLCurrent,"https://www.saucedemo.com/");
    }

}
