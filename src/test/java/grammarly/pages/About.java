package grammarly.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class About {
    SelenideElement title = $("h2");

    public void checkTitle(String expectedTitle){
        title.shouldHave(Condition.text(expectedTitle));
    }
}
