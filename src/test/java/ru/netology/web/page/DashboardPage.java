package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
  private SelenideElement heading = $("[data-test-id=dashboard]");
  private SelenideElement increaseBalancebutton1 = $$("[data-test-id=\"action-deposit\"]").first();


  public DashboardPage() {
    heading.shouldBe(visible);
  }

  public MoneyTransferPage getValidDashboardPage(){
      increaseBalancebutton1.click();
      return new MoneyTransferPage();
  }

}
