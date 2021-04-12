package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MoneyTransferPage {
    private SelenideElement amountField = $("[data-test-id=\"amount\"] .input__control");
    private SelenideElement fromField = $("[data-test-id=\"from\"] .input__control");
    private SelenideElement transferButton = $("[data-test-id=\"action-transfer\"]");

    public MoneyTransferPage(){amountField.shouldBe(visible);}

    public DashboardPage validTransfer(DataHelper.SecondCardInfo secondCardInfo, DataHelper.TransferAmmountInfo transferAmmountInfo){
        amountField.setValue(transferAmmountInfo.getTransferAmmount());
        fromField.setValue(secondCardInfo.getSecondCardInfo());
        transferButton.click();
        return new DashboardPage();

    }

    public DashboardPage TransferUnderLimit(DataHelper.SecondCardInfo secondCardInfo, DataHelper.TransferAmmountInfo transferAmmountInfo) {
        amountField.setValue(transferAmmountInfo.getTransferAmmountUnderLimit());
        fromField.setValue(secondCardInfo.getSecondCardInfo());
        transferButton.click();
        return new DashboardPage();
    }

    public DashboardPage TransferFloatAmount(DataHelper.SecondCardInfo secondCardInfo, DataHelper.TransferAmmountInfo transferAmmountInfo){
        amountField.setValue(transferAmmountInfo.getTransferFloatAmmount());
        fromField.setValue(secondCardInfo.getSecondCardInfo());
        transferButton.click();
        return new DashboardPage();

    }


    public DashboardPage validReturnTransfer(DataHelper.FirstCardInfo firstCardInfo, DataHelper.TransferAmmountInfo transferAmmountInfo){
        amountField.sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME), Keys.BACK_SPACE);
        amountField.setValue(transferAmmountInfo.getTransferAmmount());
        fromField.sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME), Keys.BACK_SPACE);
        fromField.setValue(firstCardInfo.getFirstCardInfo());
        transferButton.click();
        return new DashboardPage();
    }

    public DashboardPage returnTransferUnderLimit(DataHelper.FirstCardInfo firstCardInfo, DataHelper.TransferAmmountInfo transferAmmountInfo){
        amountField.sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME), Keys.BACK_SPACE);
        amountField.setValue(transferAmmountInfo.getTransferAmmountUnderLimit());
        fromField.sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME), Keys.BACK_SPACE);
        fromField.setValue(firstCardInfo.getFirstCardInfo());
        transferButton.click();
        return new DashboardPage();
    }

    public DashboardPage returnTransferFloatAmmount(DataHelper.FirstCardInfo firstCardInfo, DataHelper.TransferAmmountInfo transferAmmountInfo){
        amountField.sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME), Keys.BACK_SPACE);
        amountField.setValue(transferAmmountInfo.getTransferFloatAmmount());
        fromField.sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME), Keys.BACK_SPACE);
        fromField.setValue(firstCardInfo.getFirstCardInfo());
        transferButton.click();
        return new DashboardPage();
    }




}
