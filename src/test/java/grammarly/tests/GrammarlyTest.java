package grammarly.tests;

import com.github.javafaker.Faker;
import grammarly.helpers.DriverUtils;
import grammarly.pages.About;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class GrammarlyTest extends BaseTest{

    final static String GRAMMARLY_ABOUT = "https://www.grammarly.com/about";
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            organization = faker.medical().hospitalName(),
            howCanWeHelp = "I would like product information",
            tellUsComment = faker.medical().symptoms();

    @Test
    @Description("Check if the \"To improve lives by improving communication\" title is exist and correct")
    @DisplayName("Verify title grammarly about")
    void verifyHeaderTitleTest() {
        step("open: " + GRAMMARLY_ABOUT, () ->
                open(GRAMMARLY_ABOUT)
        );

        step("check label \"To improve lives by improving communication\"", () -> {
            String expectedText = "To improve lives by improving communication";
            About about = new About();
            about.checkTitle(expectedText);
        });
    }

    @Test
    @Description("Console has to be without errors")
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
        step("Open url:" + GRAMMARLY_ABOUT, () ->
                open(GRAMMARLY_ABOUT)
        );

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
