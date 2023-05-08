package petrovich_test;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
public class TestBase {
    @BeforeEach
    void setUp() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://rf.petrovich.ru//";
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 3000;
        Configuration.holdBrowserOpen = true;


    }
}
