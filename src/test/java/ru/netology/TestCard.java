package ru.netology;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestCard {
    public String generateDate(int planningDate) {
        return LocalDate.now().plusDays(planningDate).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }
    @Test
    public void shouldCriticalPathTest() {
        $("[data-test-id=name] input").setValue("Баранов Александл");
        $("[data-test-id=phone] input").setValue("+76666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void useValidNameTest1() {
        $("[data-test-id=name] input").setValue("Вилков Фёдор");
        $("[data-test-id=phone] input").setValue("+76666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void useValidNameTest2() {

        $("[data-test-id=name] input").setValue("Абдул Абд Аль-Мурал");
        $("[data-test-id=phone] input").setValue("+76666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void useValidNameTest3() {

        $("[data-test-id=name] input").setValue("Римский-Корсаков Евгений");
        $("[data-test-id=phone] input").setValue("+76666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=order-success]").shouldHave(
                exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    public void useNoValidNameTest1() {

        $("[data-test-id=name] input").setValue("Igor Brodyaga");
        $("[data-test-id=phone] input").setValue("+76666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void useNoValidNameTest2() {

        $("[data-test-id=name] input").setValue("+79162345678");
        $("[data-test-id=phone] input").setValue("+76666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void useNoValidNameTest3() {

        $("[data-test-id=name] input").setValue("IGOR");
        $("[data-test-id=phone] input").setValue("+76666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    public void useNoValidPhoneTest1() {

        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=phone] input").setValue("86666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void useNoValidPhoneTest2() {

        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=phone] input").setValue("+7916676000");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void useNoValidPhoneTest3() {

        $("[data-test-id=name] input").setValue("Харитонович Александр");
        $("[data-test-id=phone] input").setValue("+76666666666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void useNoValidPhoneTest4() {

        $("[data-test-id=name] input").setValue("Маслов Илья");
        $("[data-test-id=phone] input").setValue("Test");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    public void useEmptyInputTest1() {

        $("[data-test-id=phone] input").setValue("+76666666666");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=name].input_invalid .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }

    @Test
    public void useEmptyInputTest2() {

        $("[data-test-id=name] input").setValue("Илья Пётр");
        $("[data-test-id=agreement]").click();
        $("button.button").click();
        $("[data-test-id=phone].input_invalid .input__sub").shouldHave(
                exactText("Поле обязательно для заполнения"));
    }
}
