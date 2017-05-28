package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Page404 extends TNKPage {
    public SelenideElement content404 = $("div.content__404");
}
