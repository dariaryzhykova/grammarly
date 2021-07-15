package grammarly.tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import grammarly.pages.SignIn;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class GrammarlySignInTest {

    final static String GRAMMARLY_SIGNIN = "https://www.grammarly.com/signin";
    Faker faker = new Faker();
    String email = faker.internet().emailAddress(),
            password = faker.internet().password();

    @Test
    @Description("Check if non-existent user could not log in")
    @DisplayName("Verify \"search\" works")
    void verifySearch() {
        step("Open url: " + GRAMMARLY_SIGNIN, () ->
                open(GRAMMARLY_SIGNIN)
        );

        step("Check if the \"Search\" works", () -> {
            String expectedText = "Your password is incorrect or this account doesn’t exist. Please";
            SignIn signIn = new SignIn();
            signIn.typeEmail(email);
            signIn.pressContinue();
            signIn.typePassword(password);
            signIn.pressSignIn();
            signIn.getErrorAlert().shouldBe(Condition.visible);
            signIn.getErrorAlert().shouldHave(Condition.text(expectedText));
        });
    }
}
