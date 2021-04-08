package ru.netology.web.test;

import lombok.val;
import org.junit.jupiter.api.Test;
import ru.netology.web.data.DataHelper;
import ru.netology.web.page.LoginPageV2;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MoneyTransferTest {

  @Test
  void shouldTransferMoneyBetweenOwnCardsV2() {
//    open("http://localhost:9999");
//    val loginPage = new LoginPageV2();
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
}



