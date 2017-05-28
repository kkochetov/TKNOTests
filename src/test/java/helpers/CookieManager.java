package helpers;

import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CookieManager {
    public static void setCookie(String name, String value){
        getWebDriver().manage().addCookie(new Cookie(name,value));
    }

    public static void deleteCookie(String name){
        getWebDriver().manage().deleteCookieNamed(name);
    }

    public static Cookie getCookieNamed(String name){
        return getWebDriver().manage().getCookieNamed(name);
    }

}
