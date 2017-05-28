package TNKTest;

import com.galenframework.api.Galen;
import org.testng.annotations.*;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static java.util.Arrays.asList;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LayoutTest extends AbstractTest{
   private String baseUrl = System.getProperty("TNKTestUrl", "https://tankionline.com");

    @DataProvider(name = "specsDataProvider")
    private Object[][] specsDataProvider(){
        return new Object[][] {
                {baseUrl, "res/specs/header.spec"},
                {baseUrl+"/ru/404/", "res/specs/404.spec"}
        };
    }

    @Test(dataProvider = "specsDataProvider")
    public void specTest(String url, String specPath) throws IOException {
        open(url);
        Galen.checkLayout(getWebDriver(), specPath, asList("fullhd"));
    }
}
