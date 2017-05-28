package TNKTest;

import Pages.Main;
import Pages.News;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

public class NewsPageTest extends AbstractTest {

    @BeforeMethod
    public void init(){
        open(baseUrl);
        Main page = new Main();
        page.mainNews.click();
    }

    @DataProvider(name = "search")
    public Object[][] search(){
        return new Object[][]{
                {"Фонды на 24 часа", 8},
                {"День космонавтики в ТО", 3},
                {"zxvxcvzxvzxcvzxcvzxcvzxc", 0}
        };
    }

    @Test(dataProvider = "search")
    public void searchTest(String q, int newsCount){
        News page = new News();
        page.searchInput.setValue(q);
        page.searchbutton.click();
        Assert.assertEquals(page.searchResutl.size(), newsCount);
    }


    @Test
    public void isNewsPageTest(){
        News page = new News();
        page.mainContent.shouldBe(visible);
        page.sideContent.shouldBe(visible);
        not404TestWithHeader();
    }
}
