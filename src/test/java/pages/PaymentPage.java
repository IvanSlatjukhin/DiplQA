package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage {
    private final ElementsCollection fields = $$(".input__control");
    private final SelenideElement numberField = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthField = $("[placeholder='08']");
    private final SelenideElement yearField = $("[placeholder='22']");
    private final SelenideElement ownerField = fields.get(3);
    private final SelenideElement cvvField = $("[placeholder='999']");

    private final SelenideElement continueButton = $(byText("Продолжить"));

    private final SelenideElement successNotification = $(byText("Операция одобрена Банком."));
    private final SelenideElement failNotification = $(byText("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement wrongFormatMessage = $(byText("Неверный формат"));
    private final SelenideElement wrongTermMessage = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement cardExpiredMessage = $(byText("Истёк срок действия карты"));
    private final SelenideElement fieldFillRequiredMessage = $(byText("Поле обязательно для заполнения"));

    public void fillForm(DataHelper.CardValidInformationModel info) {
        numberField.setValue(info.getNumber());
        monthField.setValue(info.getMonth());
        yearField.setValue(info.getYear());
        ownerField.setValue(info.getOwner());
        cvvField.setValue(info.getCvv());
        continueButton.click();
    }

    public void waitIfSuccessMessage() {
        successNotification.should(visible, Duration.ofMillis(15));
    }

    public void waitIfFailMessage() {
        failNotification.should(visible, Duration.ofMillis(15));
    }

    public void waitIfWrongFormatMessage() {
        wrongFormatMessage.should(visible, Duration.ofMillis(10));
    }

    public void waitIfWrongTermMessage() {
        wrongTermMessage.should(visible, Duration.ofMillis(10));
    }

    public void waitIfCardExpiredMessage() {
        cardExpiredMessage.should(visible, Duration.ofMillis(10));
    }

    public void waitIfShouldFillFieldMessage() {
        fieldFillRequiredMessage.should(visible, Duration.ofMillis(10));
    }

}