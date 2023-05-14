package snowy_test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
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
            "Рассрочка, Рассрочка и кредит",
            "Адреса магазинов, Адреса магазинов «Снежная Королева»",
            "Где мой заказ?, Где мой заказ?"
    })
    @ParameterizedTest(name = "тестирование раздела {0}")
    @DisplayName("Тест для проверки внутренних наименований разделов")
    @Tags({@Tag("CRITICAL"), @Tag("WEB")})
    void officeHeadButtonTest(String razdel, String result) {

        Selenide.open("");
        $$x("//div//a").findBy(Condition.text(razdel)).click();
        $("div").shouldHave(Condition.text(result));
    }

    static Stream<Arguments> sideMenuTest() {
        return Stream.of(
                Arguments.of(List.of("Оплата", "Доставка", "Условия возврата", "Как зарезервировать товар в магазине онлайн", "Как сделать заказ?", "Публичная оферта", "Королевский Клуб - Дисконтная программа", "Королевский Клуб - Бонусная программа", "Защита информации", "Где мой заказ?","Таблица размеров","Сервис Tax Free"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "тестирование отображения разделов в боковом меню")
    @DisplayName("Тест для проверки отображения разделов в боковом меню")
    @Tags({@Tag("CRITICAL"), @Tag("WEB")})
    void sideMenuTest(List<String> result) {

        Selenide.open("shipping/tracking");
        $$x("//ul[@class = 'm0 p0']/li/a")
                .filter(Condition.visible).shouldHave(CollectionCondition.containExactTextsCaseSensitive(result));
    }

    @ValueSource(strings = {
            "Рассрочка",
            "Адреса магазинов",
            "Где мой заказ?",
            "Акции",
            "Lookbook"
    }
    )
    @ParameterizedTest(name = "тестирование кнопки {0} на странице снежная королева")
    @DisplayName("Тест для проверки внутренних наименований разделов")
    @Tags({@Tag("CRITICAL"), @Tag("WEB")})
    void promotionTest(String razdel) {

        Selenide.open("https://snowqueen.ru/");
        $$x("//div[@class = 'header__top_navigation--right flex between-xs middle-xs']/div/a").findBy(Condition.text(razdel)).click();
        $("div").shouldHave(Condition.text(razdel));
    }
}
