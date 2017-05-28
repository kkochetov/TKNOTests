package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class News extends TNKPage {
    public SelenideElement mainContent = $("div.content__main");
    public SelenideElement sideContent = $("div.content__side");

    public SelenideElement searchInput = $("input.stext");
    public SelenideElement searchbutton = $("input.ssubmit");

    public ElementsCollection searchResutl = $$("div.search_result");

}
