package snowy_test;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
public class TestBase {
    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://snowqueen.ru/";
        Configuration.holdBrowserOpen = true;
    }

}
