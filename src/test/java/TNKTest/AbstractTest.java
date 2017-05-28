package TNKTest;

import Pages.Page404;
import com.codeborne.selenide.Configuration;
import helpers.CookieManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

abstract class AbstractTest {
    String baseUrl = System.getProperty("TNKTestUrl", "https://tankionline.com");

    @BeforeClass
    void setUp(){
        Configuration.browser = "chrome";
        open(baseUrl);
        CookieManager.setCookie("TNK_Visit", "1");
        CookieManager.setCookie("cookiePolicy", "true");
    }

    @AfterClass
    void tearDown(){
        closeWebDriver();
    }

    @Test
    public void not404TestWithHeader(){
        Page404 page404 = new Page404();
        page404.header.shouldBe(visible);
        page404.content404.shouldNotBe(visible);
    }

    @Test
    public void not404TestWithoutHeader(){
        Page404 page404 = new Page404();
        page404.content404.shouldNotBe(visible);
    }
}
