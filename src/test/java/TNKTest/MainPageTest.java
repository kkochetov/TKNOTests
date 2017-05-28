package TNKTest;

import Pages.Main;
import Pages.TNKPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.CookieManager.*;

public class MainPageTest extends AbstractTest {

    @BeforeMethod
    public void init(){
        open(baseUrl);
    }

    @DataProvider(name = "links")
    //собираем все a из хедера и футера для теста их на 404
    private Object[][] links(){
        ElementsCollection headerLinks = $$("div.top-line a");
        ElementsCollection footerLinks = $$("nav.main-footer__nav a");

        Object[][] result = new Object[headerLinks.size()+footerLinks.size()][1];

        for (int i = 0; i < headerLinks.size(); i++){
            result[i][0] = headerLinks.get(i);
        }

        for (int i = 0; i < footerLinks.size(); i++){
            result[i + headerLinks.size()][0] = footerLinks.get(i);
        }

        return result;
    }

    @Test(dataProvider = "links")
    public void headerAndFooterLinksTest(SelenideElement link){
        link.getCoordinates().inViewPort();
        link.click();
        not404TestWithHeader();
    }


    @Test
    public void playButtonTest(){
        TNKPage page = new TNKPage();
        page.playButton.click();
        page.tankiSWF.shouldBe(visible);
        not404TestWithoutHeader();
    }

    @Test
    public void videoBlockButtonsTest(){
        Main page = new Main();
        page.videoPrevButton.shouldNotBe(visible);
        page.videoNextButton.click();
        page.videoPrevButton.shouldBe(visible);
        page.videoNextButton.shouldBe(visible);
        page.videoPrevButton.click();
        page.videoPrevButton.shouldNotBe(visible);
        //отсутствие next не проверяю, так как хз, сколько видео на прод сайте
    }

    @Test
    public void videoBlockTest(){
        Main page = new Main();
        String firstSrc = page.youTubeIframe.getAttribute("src").intern();
        page.videoNextButton.click();
        String secondSrc = page.youTubeIframe.getAttribute("src").intern();
        Assert.assertNotEquals(firstSrc, secondSrc);
        page.videoPrevButton.click();
        String thirdSrc = page.youTubeIframe.getAttribute("src").intern();
        Assert.assertEquals(firstSrc, thirdSrc);
    }

    @Test
    public void BigNewsBlockTest(){
        Main page = new Main();
        page.mainNews.shouldBe(visible);
        page.mainNews.click();
        not404TestWithHeader();
    }

    @Test
    public void NewsBlockTest(){
        Main page = new Main();
        page.newsBlock.getCoordinates().inViewPort();
        page.newsPrevButton.shouldNotBe(visible);
        page.newsNextButton.click();
        page.newsPrevButton.shouldBe(visible);
        page.newsNextButton.shouldBe(visible);
        page.newsPrevButton.click();
        page.newsPrevButton.shouldNotBe(visible);
        //отсутствие next не проверяю, так как хз, сколько новостей на прод сайте
    }

    @Test
    public void CookiesBlockLinkTest(){
        deleteCookie("cookiePolicy");
        open(baseUrl);
        Main page = new Main();
        page.cookiePolicy.shouldBe(visible);
        page.cookiePolicyLink.click();
        not404TestWithHeader();
    }

    @Test
    public void CookiesBlockOkTest(){
        deleteCookie("cookiePolicy");
        open(baseUrl);
        Main page = new Main();
        page.cookiePolicy.shouldBe(visible);
        page.cookiePolicyOk.click();
        open(baseUrl);
        page.cookiePolicy.shouldNotBe(visible);
        Assert.assertEquals(getCookieNamed("cookiePolicy").getValue().intern(), "true".intern());
    }

}
