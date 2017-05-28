package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TNKPage {
    public SelenideElement header = $("div.top-line");

    public SelenideElement playButton = $("div#fightActive");

    public SelenideElement tankiSWF = $("object#TANKI");

}
