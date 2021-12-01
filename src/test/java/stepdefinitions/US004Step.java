package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.DefaultPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004Step {

    ReusableMethods reusableMethods=new ReusableMethods();
    DefaultPage defaultPage=new DefaultPage();

    @When("anasayfadan login yapılarak istenen sayfaya gidildi")
    public void anasayfadan_login_yapılarak_istenen_sayfaya_gidildi() {
        reusableMethods.login();
    }
    @When("hotel management linkine tıklandı")
    public void hotel_management_linkine_tıklandı() {
        defaultPage.hotelManagementLinki.click();
    }
    @When("hotel list linkine tıklandı")
    public void hotel_list_linkine_tıklandı() {
        defaultPage.hotelListLink.click();
    }
    @When("addHotel  linkine tıklandı")
    public void add_hotel_linkine_tıklandı() {
        defaultPage.addHotelLink.click();
    }


    @And("Code name adress phone ve mail kutuları doldurulur")
    public void codeNameAdressPhoneVeMailKutularıDoldurulur() {
        defaultPage.addHotelCodeKutusu.sendKeys("1453");
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).
                sendKeys("Fatih Otel").
                sendKeys(Keys.TAB).
                sendKeys("Fatih Caddesi Fetih Sok No:145/3 Fatih/İstanbul").
                sendKeys(Keys.TAB).
                sendKeys("05514531453").
                sendKeys(Keys.TAB).
                sendKeys("fatih1453@gmail.com").perform();
    }

    @And("{string} dropdown butonuna tıklayıp Grup seçiniz")
    public void dropdownButonunaTıklayıpGrupSeçiniz(String arg0) {
        Select select = new Select(defaultPage.idGroupHotelEkle);
        select.selectByVisibleText("Hotel Type2");
    }

    @And("Otel kayıt butonuna tıklandı")
    public void otelKayıtButonunaTıklandı() {
        defaultPage.addHotelSaveButonu.click();
    }

    @And("Hotel was inserted successfully yazısının görünürlüğü test edildi")
    public void hotelWasInsertedSuccessfullyYazısınınGörünürlüğüTestEdildi() {
        ReusableMethods.waitFor(2);

        String addHotelExpectedAlertYazisi="Hotel was inserted successfully";
        String addHotelActualAlertYazisi= Driver.getDriver().findElement(By.xpath("//div[@class='bootbox-body']")).getText();

        Assert.assertEquals(addHotelExpectedAlertYazisi,addHotelActualAlertYazisi);
    }

    @And("Ok butonuna tıklandı")
    public void okButonunaTıklandı() {
        defaultPage.okButonu.click();
    }

    @And("Hotel List  menüsüne tıklandı")
    public void hotelListMenüsüneTıklandı() {
        ReusableMethods.waitFor(1);
        Actions actions1=new Actions(Driver.getDriver());
        actions1.
                sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(1);

        //otel list linkini tıklayın

        defaultPage.hotelListLink.click();
    }

    @And("Kayıt oldugumuz id numarası kutucuga girildi")
    public void kayıtOldugumuzIdNumarasıKutucugaGirildi() {
        defaultPage.otelListidCheck.sendKeys("2434");
    }

    @And("Yönetici olarak otel tipi konusunda secim yapıldı")
    public void yöneticiOlarakOtelTipiKonusundaSecimYapıldı() {
        Select select1 = new Select(defaultPage.idGroupSearch);
        select1.selectByVisibleText("Hotel Type2");
        defaultPage.hotelSearchButton.click();
    }

    @And("Yönetici olarak unique bir kaydın yapıldıgı dogrulandı")
    public void yöneticiOlarakUniqueBirKaydınYapıldıgıDogrulandı() {
        String addHotelExpectedResult="|Found total 1 records";
        String addHotelActualResult= Driver.getDriver().findElement(By.xpath("//*[text()='Found total 1 records']")).getText();

        Assert.assertEquals(addHotelExpectedResult,addHotelActualResult);
    }
}
