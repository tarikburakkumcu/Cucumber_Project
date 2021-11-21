//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.DefaultPage;
import pages.LoginPage;
import pages.MainPage;

public class ReusableMethods {
    public ReusableMethods() {
    }

    public static void login() {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = new LoginPage();
        goToUrl();
        mainPage.loginLink.click();
        if (!Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("loginUrl"))) {
            goToUrl();
            mainPage.loginLink.click();
        }

        loginPage.usernameBox.sendKeys(ConfigReader.getProperty("validUserName"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("validPassword"));
        loginPage.loginButton.click();
    }

    public static void goToUrl() {
        Driver.getDriver().get(ConfigReader.getProperty("mainUrl"));
    }

    public static void hotelRooms() {
        DefaultPage defaultPage = new DefaultPage();
        defaultPage.hotelManagementLinki.click();
        defaultPage.hotelRoomsLinki.click();
    }

    public static void waitFor(int sec) {
        try {
            Thread.sleep((long)(sec * 1000));
        } catch (InterruptedException var2) {
            var2.printStackTrace();
        }

    }

    public static void scrollTo(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        waitFor(2);
    }

}

