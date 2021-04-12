package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV2;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

    @Test
    void shouldTransferMoneyBetweenOwnCards() {

        val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        int expected11 = dashboardPage.getFirstCardBalance();
        int expected22 = dashboardPage.getSecondCardBalance();
        int expected1 = ((dashboardPage.getFirstCardBalance()) + Integer.parseInt(DataHelper.getTransferAmmountInfo().getTransferAmmount()));
        int expected2 = ((dashboardPage.getSecondCardBalance()) - Integer.parseInt(DataHelper.getTransferAmmountInfo().getTransferAmmount()));
        val moneyTransferPage = dashboardPage.getValidDashboardPage1();
        val dashboardPage1 = moneyTransferPage.validTransfer(DataHelper.getSecondCardInfo(), DataHelper.getTransferAmmountInfo());
        int actual1 = dashboardPage1.getFirstCardBalance();
        assertEquals(actual1, expected1);
        int actual2 = dashboardPage1.getSecondCardBalance();
        assertEquals(actual2, expected2);
        val moneyTransferPage1 = dashboardPage.getValidDashboardPage2();
        val dashboardPage2 = moneyTransferPage1.validReturnTransfer(DataHelper.getFirstCardInfo(), DataHelper.getTransferAmmountInfo());
        int actual11 = dashboardPage2.getFirstCardBalance();
        assertEquals(actual11, expected11);
        int actual22 = dashboardPage2.getSecondCardBalance();
        assertEquals(actual22, expected22);


    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsUnderLimit() {

        val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        int expected11 = dashboardPage.getFirstCardBalance();
        int expected22 = dashboardPage.getSecondCardBalance();
        int expected1 = dashboardPage.getFirstCardBalance();
        int expected2 = dashboardPage.getSecondCardBalance();
        val moneyTransferPage = dashboardPage.getValidDashboardPage1();
        val dashboardPage1 = moneyTransferPage.TransferUnderLimit(DataHelper.getSecondCardInfo(), DataHelper.getTransferAmmountInfo());
        int actual1 = dashboardPage1.getFirstCardBalance();
        int actual2 = dashboardPage1.getSecondCardBalance();
        val moneyTransferPage1 = dashboardPage.getValidDashboardPage2();
        val dashboardPage2 = moneyTransferPage1.returnTransferUnderLimit(DataHelper.getFirstCardInfo(), DataHelper.getTransferAmmountInfo());
        int actual11 = dashboardPage2.getFirstCardBalance();
        assertEquals(expected1,actual1);
        assertEquals(expected2,actual2 );

        int actual22 = dashboardPage2.getSecondCardBalance();
        assertEquals(expected11,actual11 );
        assertEquals(expected22,actual22 );


    }

    @Test
    void shouldTransferMoneyBetweenOwnCardsWithFloatAmmount() {

        val loginPage = open("http://localhost:9999", LoginPageV2.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboardPage = verificationPage.validVerify(verificationCode);
        int expected11 = dashboardPage.getFirstCardBalance();
        int expected22 = dashboardPage.getSecondCardBalance();
        float expected1 = ((dashboardPage.getFirstCardBalance()) + Float.parseFloat(DataHelper.getTransferAmmountInfo().getTransferFloatAmmount()));
        float expected2 = ((dashboardPage.getSecondCardBalance()) - Float.parseFloat(DataHelper.getTransferAmmountInfo().getTransferFloatAmmount()));
        val moneyTransferPage = dashboardPage.getValidDashboardPage1();
        val dashboardPage1 = moneyTransferPage.TransferFloatAmount(DataHelper.getSecondCardInfo(), DataHelper.getTransferAmmountInfo());
        int actual1 = dashboardPage1.getFirstCardBalance();
        int actual2 = dashboardPage1.getSecondCardBalance();
        val moneyTransferPage1 = dashboardPage.getValidDashboardPage2();
        val dashboardPage2 = moneyTransferPage1.returnTransferFloatAmmount(DataHelper.getFirstCardInfo(), DataHelper.getTransferAmmountInfo());
        assertEquals(expected1,actual1);
        assertEquals(expected2,actual2 );

        int actual11 = dashboardPage2.getFirstCardBalance();

        int actual22 = dashboardPage2.getSecondCardBalance();
        assertEquals(expected11,actual11 );
        assertEquals(expected22,actual22 );


    }

}



