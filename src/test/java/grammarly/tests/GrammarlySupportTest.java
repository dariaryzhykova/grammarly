package grammarly.tests;

import com.codeborne.selenide.Condition;
import grammarly.pages.Support;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GrammarlySupportTest extends BaseTest {

    final static String GRAMMARLY_SEARCH = "https://www.grammarly.com/contact";

    @Test
    @Description("Check if the \"Search\" works")
    @DisplayName("Verify \"search\" works")
    void verifySearch() {
        step("Open url: " + GRAMMARLY_SEARCH, () ->
                open(GRAMMARLY_SEARCH)
        );

        step("Check if the \"Search\" works", () -> {
            String text = "Where can I find a receipt for my business account?";
            Support support = new Support();
            support.typeSearch(text);
            $(".article-header").shouldHave(Condition.text(text));

        });
    }
}
