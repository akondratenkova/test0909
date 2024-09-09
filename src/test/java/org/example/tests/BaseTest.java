package org.example.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

abstract public class BaseTest {
    public static void setUp(){
        WebDriverManager.chromedriver();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 5000;
    }

    @BeforeAll
    public static void init(){
        setUp();
    }

    @AfterAll
    public static void tearDown(){
        Selenide.closeWebDriver();
    }

}
