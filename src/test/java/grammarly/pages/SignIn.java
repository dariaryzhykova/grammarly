package grammarly.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SignIn {
    SelenideElement email = $("[name=\"email\"]"),
            password = $("[name=\"password\"]"),
            continueButton = $(byText("Continue")),
            signIn = $("[data-qa=\"btnLogin\"]"),
            errorAlert = $("._2GpA5-alertContainer");

    public SelenideElement getErrorAlert() {
        return this.errorAlert;
    }

    public void typeEmail(String userEmail) {
        email.val(userEmail);
    }

    public void typePassword(String userPass) {
        password.val(userPass);
    }

    public void pressContinue() {
        continueButton.click();
    }

    public void pressSignIn() {
        signIn.click();
    }
}
