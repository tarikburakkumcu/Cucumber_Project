package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US001Step {

    MainPage mainPage=new MainPage();

    @When("kullanici hotel sayfasına gider")
    public void kullanici_hotel_sayfasına_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));

    }

    @When("homeLink görünürlüğü kontrol edildi")
    public void görünürlüğü_kontrol_edildi() {
              mainPage.homeLink.isDisplayed();

    }

    @When("Sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();
    }
    @And("roomsLink görünürlüğü kontrol edildi")
    public void roomslinkGörünürlüğüKontrolEdildi() {
        mainPage.roomsLink.isDisplayed();

    }

    @And("restaurantLink görünürlüğü kontrol edildi")
    public void restaurantlinkGörünürlüğüKontrolEdildi() {
        mainPage.restaurantLink.isDisplayed();

    }


    @And("aboutLink görünürlüğü kontrol edildi")
    public void aboutlinkGörünürlüğüKontrolEdildi() {
        mainPage.aboutLink.isDisplayed();

    }

    @And("blogLink görünürlüğü kontrol edildi")
    public void bloglinkGörünürlüğüKontrolEdildi() {
        mainPage.blogLink.isDisplayed();

    }

    @And("contactLink görünürlüğü kontrol edildi")
    public void contactlinkGörünürlüğüKontrolEdildi() {
        mainPage.contactLink.isDisplayed();

    }

    @And("loginLink görünürlüğü kontrol edildi")
    public void loginlinkGörünürlüğüKontrolEdildi() {
        mainPage.loginLink.isDisplayed();
    }
}
