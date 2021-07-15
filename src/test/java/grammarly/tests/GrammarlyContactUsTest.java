package grammarly.tests;

import com.codeborne.selenide.Condition;
import grammarly.pages.ContactUs;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GrammarlyContactUsTest extends BaseTest {

    final static String GRAMMARLY_CONTACT_US = "https://www.grammarly.com/contact";

    @Test
    @Description("Check if the \"Contact Us\" title is exist and correct")
    @DisplayName("Verify title grammarly about")
    void verifyHeaderTitleTest() {
        step("Open url: " + GRAMMARLY_CONTACT_US, () ->
                open(GRAMMARLY_CONTACT_US)
        );

        step("check label \"Contact Us\"", () -> {
            $(byText("Contact Us")).shouldBe(Condition.visible);
        });
    }

    @Test
    @Description("Check if the \"Visit Support Page\" button works")
    @DisplayName("Verify \"Visit Support Page\"")
    void verifyVisitSupportPageButton() {
        step("Open url: " + GRAMMARLY_CONTACT_US, () ->
                open(GRAMMARLY_CONTACT_US)
        );

        step("Check if the \"Visit Support Page\" button works", () -> {
            String expectedText = "Hi! How can we help?";
            ContactUs contactUs = new ContactUs();
            contactUs.pressVisitSupportPageButton();
            $(".search-title").shouldHave(Condition.text(expectedText));
        });
    }
}
