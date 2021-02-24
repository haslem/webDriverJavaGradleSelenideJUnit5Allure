package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Notification {

    private SelenideElement closeNotification = $(By.xpath("//ul[@class=\"notifications\"]//li//button"));
    private SelenideElement notificationWindow = $(By.xpath("//ul[@class=\"notifications\"]//li"));

    public void closeNotification(){
        closeNotification.click();
        notificationWindow.shouldNot(Condition.visible);
    }

    public void isNotification(){
        notificationWindow.shouldNot(Condition.visible);
    }

}
