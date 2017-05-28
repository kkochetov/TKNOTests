package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Main extends TNKPage {
    public SelenideElement mainNews = $("div.visual__container");

    public SelenideElement videoPrevButton = $("button.video-block__button.prev");
    public SelenideElement videoNextButton = $("button.video-block__button.next");

    public SelenideElement newsBlock = $("div.news-block");
    public SelenideElement newsPrevButton = $("button.news-block__button.prev");
    public SelenideElement newsNextButton = $("button.news-block__button.next");

    public SelenideElement youTubeIframe = $("iframe.video-block__youtube-container");

    public SelenideElement cookiePolicy = $("div.cookie-policy");
    public SelenideElement cookiePolicyLink = $("div.cookie-policy a");
    public SelenideElement cookiePolicyOk = $("div.cookie-policy div.cookie-ok");


}
