package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class PlanningPage {

    //private ElementsCollection routeItem = $$(By.xpath("//ul[@class=\"folders sortable\"]//li"));
    private ElementsCollection routeItem = $$(By.xpath("//div[@class=\"cont\"]/input"));
    private ElementsCollection types = $$(By.xpath("//div[@class=\"route-buttons\"]/button[@type=\"button\"]"));
    private SelenideElement createFolder = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[3]/div/div[1]/div[1]/button"));
    private SelenideElement type = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[4]/div"));
    private ElementsCollection shortTourist = $$(By.xpath("//ul[@class=\"params-select-popup\"]/li"));
    private ElementsCollection routeItemSubtitle = $$(By.xpath("//p[@class=\"subtitle icon-move\"]"));

    private ElementsCollection tollsCheckboxes = $$(By.xpath("//li[@class=\"checkbox-item\"]"));
    private SelenideElement tolls = $(By.xpath("//div[@class=\"toll\"]"));
    private SelenideElement tollsAvoidAll = $(By.xpath("//div[@class=\"avoid-all checkbox-item\"]"));

    private ElementsCollection tripTypes = $$(By.xpath("//div[@class=\"route-buttons\"]/button[@type=\"button\"]"));
    private SelenideElement tripDistance = $(By.xpath("//span[@class=\"circuit-bar-button\"]"));
    private SelenideElement tripDistancePlusButton = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/button[2]"));


    public void setStart(String start){
        routeItem.first().setValue(start);
        routeItem.first().sendKeys(Keys.ENTER);
        routeItemSubtitle.first().should(Condition.empty.negate());
//        String textAttr = routeItemSubtitle.first().getText();

    }

    public void setEnd(String end){
        routeItem.last().setValue(end);
        routeItem.last().sendKeys(Keys.ENTER);
        routeItemSubtitle.last().should(Condition.empty.negate());
    }

    public void setWalkShort(){
        types.get(3).click();
        type.click();
        shortTourist.get(0).click();
    }

    public void avoidSecondCountry(){
        tolls.click();
        tollsCheckboxes.get(1).click();
        tolls.click();
    }

    public void avoidThirdCountry(){
        tolls.click();
        tollsCheckboxes.get(2).click();
        tolls.click();
    }

    public void avoidAll(){
        tolls.click();
        tollsAvoidAll.click();
        tolls.click();
    }

    public void tripBike(){
        tripTypes.get(1).click();
    }

    public void setTripDistanceToMax(){
        actions().dragAndDrop(tripDistance, tripDistancePlusButton).perform();
    }


}
