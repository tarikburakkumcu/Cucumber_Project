package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;
import utilities.ConfigReader;

public class US003Step {
    MainPage mainPage=new MainPage();
    LoginPage loginPage=new LoginPage();
    RegisterPage registerPage=new RegisterPage();
    Faker faker=new Faker();
    @When("login linkine tiklar")
    public void login_linkine_tiklar() {
        mainPage.loginLink.click();
    }

    @And("Login sayfasındaki creat a new account butonuna tiklandi")
    public void loginSayfasındakiCreatANewAccountButonunaTiklandi() {
        loginPage.creatButton.click();
    }


    @And("Register sayfasına ulasıldı ve Kullanıcı adı gönderildi")
    public void registerSayfasınaUlasıldıVeKullanıcıAdıGönderildi() {
        registerPage.regPasswordText.sendKeys(ConfigReader.getProperty("regPassword"));
    }

    @And("Password gönderildi")
    public void passwordGönderildi() {
        registerPage.regPasswordText.sendKeys(ConfigReader.getProperty("regPassword"));
    }

    @And("Email gönderildi")
    public void emailGönderildi() {
        registerPage.regEmailText.sendKeys(ConfigReader.getProperty("regEmail"));
    }

    @And("İsim-soyisim gönderildi")
    public void i̇simSoyisimGönderildi() throws InterruptedException {
        Thread.sleep(1000);
        registerPage.regFullNameText.sendKeys(ConfigReader.getProperty("regFullName"));
    }

    @And("Telefon gönderildi")
    public void telefonGönderildi() throws InterruptedException {
        Thread.sleep(1000);
        registerPage.regPhoneNoText.sendKeys(ConfigReader.getProperty("regPhoneNo"));
    }

    @And("SSN gönderildi")
    public void ssnGönderildi() {
        registerPage.regSSNText.sendKeys(ConfigReader.getProperty("regSSN"));
    }

    @And("Ehliyet gönderildi")
    public void ehliyetGönderildi() {
        registerPage.regDrivingLicenseText.sendKeys(ConfigReader.getProperty("regDrivingLicense"));
    }

    @And("Ülke seçildi")
    public void ülkeSeçildi() {
        Select select=new Select(registerPage.regCountryText);
        select.selectByVisibleText(ConfigReader.getProperty("regCountry"));
    }

    @And("Eyalet seçildi")
    public void eyaletSeçildi() {
        Select select1=new Select(registerPage.regStateText);
        select1.selectByVisibleText(ConfigReader.getProperty("regState"));
    }

    @And("Adres gönderildi")
    public void adresGönderildi() {
        registerPage.regAddressText.sendKeys(ConfigReader.getProperty("regAddress"));
    }

    @And("Meslek gönderildi")
    public void meslekGönderildi() {
        registerPage.regWorkingSectorText.sendKeys(ConfigReader.getProperty("regWorkingSector"));
    }

    @And("Doğum tarihi gönderildi")
    public void doğumTarihiGönderildi() {
        registerPage.regBirthDateText.sendKeys(ConfigReader.getProperty("regBirthDate"));
    }

    @And("Save Buttonuna tiklandi")
    public void saveButtonunaTiklandi() {
        registerPage.regSaveButton.click();
    }

    @And("Alert içindeki başarı ile kaydedildi mesajı görüldü")
    public void alertIçindekiBaşarıIleKaydedildiMesajıGörüldü() {
        Assert.assertTrue(registerPage.regAlertMessage.isDisplayed());
    }

    @And("Ok Buttonuna tiklandi")
    public void okButtonunaTiklandi() {
        registerPage.regOkButton.click();
    }

    @And("Register sayfasına ulasıldı ve Faker clasından üretilen  Kullanıcı adı gönderildi")
    public void registerSayfasınaUlasıldıVeFakerClasındanÜretilenKullanıcıAdıGönderildi() {

        registerPage.regUserNameText.sendKeys(faker.name().username());
    }

    @And("Faker clasından üretilen Password gönderildi")
    public void fakerClasındanÜretilenPasswordGönderildi() {
        registerPage.regPasswordText.sendKeys(ConfigReader.getProperty("regPassword"));
    }

    @And("Faker clasından üretilen Email gönderildi")
    public void fakerClasındanÜretilenEmailGönderildi() {
        registerPage.regEmailText.sendKeys(faker.internet().emailAddress());
    }

    @And("Faker clasından üretilen İsim-soyisim gönderildi")
    public void fakerClasındanÜretilenİsimSoyisimGönderildi() {
        registerPage.regFullNameText.sendKeys(faker.name().fullName());
    }

    @And("Faker clasından üretilen Telefon gönderildi")
    public void fakerClasındanÜretilenTelefonGönderildi() {
        registerPage.regPhoneNoText.sendKeys(faker.phoneNumber().cellPhone());
    }
}
