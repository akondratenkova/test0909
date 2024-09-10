package org.example.tests;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
import org.example.data.User;
import org.example.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.example.data.Constants.URL;


@Feature("Tests") //-наименование класса(группы тестов), для Allure

public class LoginTest extends BaseTest{

    /*
      аннотации для отчета в Allure
     */
    @Issue(value = "ABC-111") //-номер дефекта в TMS, основная ссылка на задачу прописывается в файле allure.properties
    @Owner(value = "Nastya Kondratenkova")
    @DisplayName("User authorization") //-название теста
    @Description("Test is designed for practice") //-описание теста

    @Test
    @Story("Positive tests") // - аннотация для объединения нескольких тестов в одну группу
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
