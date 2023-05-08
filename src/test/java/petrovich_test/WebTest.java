package petrovich_test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;

public class WebTest extends TestBase{

    @CsvSource(value = {
            "Доставка, Доставка",
            "Возврат, Возврат",
            "Акции, Акции"
    })
    @ParameterizedTest(name="тестирование раздела сайта {0}")
    @DisplayName("Тест для проверки наименовании разделов сайта")
    @Tag("WEB")
    void officeHeadButtonTest(String razdel, String result) {
        $(".pt-btn-text___PwESa").setValue(String.valueOf(request));
        $(".css-9uy14h").click();
    }
}
