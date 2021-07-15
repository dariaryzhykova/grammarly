package grammarly.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ContactUs {
    SelenideElement visitSupportPageButton = $(byText("Visit Support Page"));

    public void pressVisitSupportPageButton() {
        visitSupportPageButton.click();
    }

}
