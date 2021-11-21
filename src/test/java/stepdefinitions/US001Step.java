package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.MainPage;
import utilities.ConfigReader;
import utilities.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ReusableMethods;


public class US001Step {

    MainPage mainPage=new MainPage();
    ReusableMethods reusableMethods=new ReusableMethods();

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

    @And("homeLink tıklar")
    public void homelinkTıklar() {
        mainPage.homeLink.click();
    }

    @When("roomsLink tıklar")
    public void rooms_link_tıklar() {
        mainPage.roomsLink.click();
    }

    @When("restaurantLink tıklar")
    public void restaurant_link_tıklar() {
        mainPage.restaurantLink.click();
    }

    @When("aboutLink tıklar")
    public void about_link_tıklar() {
        mainPage.aboutLink.click();
    }

    @When("blogLink tıklar")
    public void blog_link_tıklar() {
        mainPage.aboutLink.click();
    }

    @When("contactLink tıklar")
    public void contact_link_tıklar() {
        mainPage.contactLink.click();
    }

    @When("loginLink tıklar")
    public void login_link_tıklar() {
        mainPage.loginLink.click();
    }

    @And("CHECK-IN DATE elementine tiklanir ve giris tarihi icin secim yapilir.")
    public void checkINDATEElementineTiklanirVeGirisTarihiIcinSecimYapilir() {
     mainPage.checkInDateText.isDisplayed();
    }

    @And("CHECK-OUT DATE elementine tiklanir ve cikis tarihi icin secim yapilir.")
    public void checkOUTDATEElementineTiklanirVeCikisTarihiIcinSecimYapilir() {
        mainPage.checkOutDateText.isDisplayed();
    }

    @And("ROOM elementine tiklanir ve dropdown menuden uygun, room type secilir.")
    public void roomElementineTiklanirVeDropdownMenudenUygunRoomTypeSecilir() {
        mainPage.roomText.isDisplayed();
    }

    @And("CUSTOMER elemtine tiklanir ve dropdown menuden yetiskin kisi sayisi sacilir.")
    public void customerElemtineTiklanirVeDropdownMenudenYetiskinKisiSayisiSacilir() {
        mainPage.customerText.isDisplayed();
    }

    @And("Kullanici uygun kriterleri sectikten sonra Check Availabilitybutonuna tiklar.")
    public void kullaniciUygunKriterleriSectiktenSonraCheckAvailabilitybutonunaTiklar() {
        mainPage.checkInDateUpdate.click();
        int randomDayForIn = (int) (Math.random()*((mainPage.availableDays.size()-1)+1)) +1 ;
        String selectedDayForIn = mainPage.availableDays.get(randomDayForIn-1).getText();
        Driver.getDriver().findElement(By.xpath(mainPage.randomSelectedDayForIn(randomDayForIn))).click();

        // Otelden cikis tarihini secme (Gunu birlik yahut daha fazla. Giris tarihinden onceki gunler elendi.)

        mainPage.checkOutDateUpdate.click();
        int randomDayForOut = (int) (Math.random()*((mainPage.availableDays.size()-randomDayForIn)+1)) + randomDayForIn;
        String selectedDayForOut = mainPage.availableDays.get(randomDayForOut-1).getText();
        Driver.getDriver().findElement(By.xpath(mainPage.randomSelectedDayForOut(randomDayForOut))).click();

        //Oda tipi secme

        Select select = new Select(mainPage.roomTypeDropdown);
        int randomSelectionForRoomType= (int) (Math.random()* (((select.getOptions().size()-1)-1)+1))+ 1;
        select.selectByIndex(randomSelectionForRoomType);
        String selectedRoomType = select.getAllSelectedOptions().get(0).getText();

        // Kalacak yetiskin sayisini secme

        select = new Select(mainPage.adultCountDropdown);
        int randomSelectionForAdultCount= (int) (Math.random()*(((select.getOptions().size()-1)-1)+1))+ 1;
        select.selectByIndex(randomSelectionForAdultCount);
        String selectedAdultCount = select.getAllSelectedOptions().get(0).getText();


        mainPage.checkAvailabilityButton.click();

        // Secilen tercihleri dogrulama
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

       Driver.getDriver().findElement(By.xpath(mainPage.selectedInDateControl(selectedDayForIn))).isEnabled();
       Driver.getDriver().findElement(By.xpath(mainPage.selectedOutDateControl(selectedDayForOut))).isEnabled();
       select = new Select(mainPage.roomTypeDropdown);
       wait.until(ExpectedConditions.visibilityOf(select.getFirstSelectedOption())).getText();

       select = new Select(mainPage.adultCountDropdown);
       wait.until(ExpectedConditions.visibilityOf(select.getFirstSelectedOption())).getText();
    }

    @And("Main Page'de ilgili bolum gorulene kadar scrolldown yapilir.")
    public void mainPageDeIlgiliBolumGoruleneKadarScrolldownYapilir() {
        ReusableMethods.goToUrl();
        ReusableMethods.scrollTo(mainPage.welcomeToOurHotelPart);
       mainPage.welcomeToOurHotelPart.isDisplayed();
    }

    @And("Main Page'de ourRooms bolum gorulene kadar scrolldown yapilir.")
    public void mainPageDeOurRoomsBolumGoruleneKadarScrolldownYapilir() {
        ReusableMethods.scrollTo(mainPage.ourRoomsPart);
    }

    @And("Our Rooms bolumundeki birinciden altinci oda secenegine kadar tiklanir.")
    public void ourRoomsBolumundekiBirincidenAltinciOdaSecenegineKadarTiklanir() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        for (int i = 0; i < mainPage.ourRoomsPartRoomNames.size(); i++) {

            String roomName = wait.until(ExpectedConditions.visibilityOf(mainPage.ourRoomsPartRoomNames.get(i))).getText();
            Driver.getDriver().findElement(By.xpath("(//a[.='View Room Details '])["+(i+1)+"]")).click();
            mainPage.getOurRoomsPartSelectedRoomName.getText();
            Driver.getDriver().navigate().back();
        }
    }
    @And("Main Page'de yorum bolum gorulene kadar scrolldown yapilir.")
    public void mainPageDeYorumBolumGoruleneKadarScrolldownYapilir() {
        ReusableMethods.scrollTo(mainPage.customerCommentPart);
    }

    @And("Musteri yorumlari bolumunde bulunan bes slider butonuna sirasiyla tiklanir.")
    public void musteriYorumlariBolumundeBulunanBesSliderButonunaSirasiylaTiklanir() {
        mainPage.customerCommentPart.isDisplayed();
        String previousComment = "";
        for (int i = 0; i < mainPage.customerCommentSliderButtons.size(); i++) {
            mainPage.customerCommentSliderButtons.get(i).click();
            mainPage.activeCustomerComment.getText();
            previousComment = mainPage.activeCustomerComment.getText();
            ReusableMethods.waitFor(1);
        }
    }


    @And("Main Page'de blog bolum gorulene kadar scrolldown yapilir.")
    public void mainPageDeBlogBolumGoruleneKadarScrolldownYapilir() {
        ReusableMethods.scrollTo(mainPage.recentBlogPart);
        mainPage.recentBlogPart.isDisplayed();
    }

    @And("Recent Blog bolumundeki birinciden altinci blog yazisina kadar tiklanir.")
    public void recentBlogBolumundekiBirincidenAltinciBlogYazisinaKadarTiklanir() {
        for (int i = 0; i < mainPage.recentBlogPartBlogs.size(); i++) {
           mainPage.recentBlogPartBlogs.get(i).isDisplayed();
        }
    }

    @And("Main Page'de instagram bolum gorulene kadar scrolldown yapilir.")
    public void mainPageDeInstagramBolumGoruleneKadarScrolldownYapilir() {
        ReusableMethods.scrollTo(mainPage.instagramPart);
    }

    @And("Instagram bolumundeki fotograflara sirasiyla tiklanir Next ve Previous elementlerine tiklanir.")
    public void ınstagramBolumundekiFotograflaraSirasiylaTiklanirNextVePreviousElementlerineTiklanir() {
        for (int i = 0; i < mainPage.instagramPartPictures.size(); i++) {
            String nameOfPictures= mainPage.instagramPartPictures.get(i).getAttribute("style");
            nameOfPictures = nameOfPictures.substring(nameOfPictures.indexOf("/"),nameOfPictures.indexOf(")")-1);
            mainPage.instagramPartPictures.get(i).click();
            WebElement selectedPicture = Driver.getDriver().findElement(By.xpath("//img[@src='"+nameOfPictures+"']"));
            selectedPicture.isDisplayed();
            mainPage.instagramPartEscButton.click();
        }
    }

    @And("Main Page'de sayfanin sonuna kadar scrolldown yapilir.")
    public void mainPageDeSayfaninSonunaKadarScrolldownYapilir() {
        ReusableMethods.scrollTo(mainPage.footerPart);
        mainPage.footerPartConcortHotel.isDisplayed();
        mainPage.footerPartUsefulLinks.isDisplayed();
        mainPage.footerPartPrivacy.isDisplayed();
        mainPage.footerPartHaveAQuestions.isDisplayed();


    }
}
