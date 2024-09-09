package org.example.tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.example.data.User;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.example.data.Constants.URL;


public class LoginTest extends BaseTest{

    @Test
    public void FillForm(){
        Selenide.open(URL);

        Faker faker = new Faker();
        User email = User.builder()
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .build();

        User password = User.builder()
                .password(faker.internet().password())
                .build();

        LoginPage loginPage = new LoginPage(URL);
        loginPage.logIn(email.getEmail(), password.getPassword());

    }
}
