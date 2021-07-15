package grammarly.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Support {
    SelenideElement search = $("#query");

    public void typeSearch(String text) {
        search.val(text).pressEnter();
    }
}
