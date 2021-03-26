package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement amountField = $("[data-test-id=\"amount\"] .input__control");
    private SelenideElement fromField = $("[data-test-id=\"from\"]");
    private SelenideElement transferButton = $("[data-test-id=\"action-transfer\"]");

    public MoneyTransferPage(){amountField.shouldBe(visible);}

    public DashboardPage validTransfer(DataHelper.CardInfo cardInfo){
        amountField.setValue("500");
        fromField.setValue(cardInfo.getCard2());
        transferButton.click();
        return new DashboardPage();
    }




}
