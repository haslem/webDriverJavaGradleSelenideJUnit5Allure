package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ToolsPage {

    private SelenideElement marks = $(By.xpath("/html/body/div/div[5]/div/div[5]"));
    private SelenideElement measure = $(By.xpath("/html/body/div/div[5]/div/div[6]"));

    private SelenideElement share = $(By.xpath("//span[@class=\"share-item-title sht-link\"]"));
    private SelenideElement shareToggle = $(By.className("share-slider"));
    private SelenideElement copyLink = $(By.xpath("//button[@class=\"copy\"]"));
    private SelenideElement close = $(By.xpath("//button[@class=\"close\"]"));



    public void clickMarks(){
        marks.click();
    }

    public void clickMeasure(){
        measure.click();
    }

    public void clickShare(){
        share.click();
    }

    public void shareOn(){
        shareToggle.click();
    }

    public void close(){
        close.click();
    }

    public void copyLink(){
        copyLink.click();
    }


}
