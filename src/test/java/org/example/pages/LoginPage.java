package org.example.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private final SelenideElement emailForm = $x("//input[@id='user[email]']");
    private final SelenideElement passwordForm = $x("//input[@id='user[password]']");
    private final SelenideElement confRememb = $x("//input[@id='user[remember_me]']");
    private final SelenideElement signInButton = $x("//button[@type='submit']");

    public LoginPage(String url) {
        Selenide.open(url);
    }

    public void logIn(String email, String password){

        emailForm.sendKeys(email);
        passwordForm.sendKeys(password);
        confRememb.isSelected();
        signInButton.click();
    }
}
