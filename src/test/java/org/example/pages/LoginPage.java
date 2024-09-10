package org.example.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement emailForm = $x("//input[@id='user[email]']");
    private final SelenideElement passwordForm = $x("//input[@id='user[password]']");
    private final SelenideElement confirmRememberMe = $x("//input[@id='user[remember_me]']");
    private final SelenideElement signInButton = $x("//button[@type='submit']");

    public LoginPage(String url) {
        Selenide.open(url);
    }

    @Step("Entering user data and confirming authorization")
    public void logIn(String email, String password){

        emailForm.sendKeys(email);
        passwordForm.sendKeys(password);
        confirmRememberMe.isSelected();
        signInButton.click();
    }
}
