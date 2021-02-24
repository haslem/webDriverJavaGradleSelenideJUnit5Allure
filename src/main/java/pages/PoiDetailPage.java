package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class PoiDetailPage {

    protected SelenideElement save = $(By.xpath("//div[@title=\"Save\"]"));
    protected SelenideElement whereSaved = $(By.className("content-mymaps-place"));
    private SelenideElement notificationWindow = $(By.xpath("//ul[@class=\"notifications\"]//li"));
    private SelenideElement close = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[2]/button"));

    private SelenideElement whereMyPointsSaved = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div/div[1]/p/a"));
    private SelenideElement closeMyPoints = $(By.xpath("//*[@id=\"usermarks\"]/div/div[1]/div/div[1]/button"));

    private SelenideElement quitMeasure = $(By.xpath("/html/body/div/div[3]/button"));

    private SelenideElement closeMeasure = $(By.className("exit-btn"));
    private SelenideElement closeMeasureWindow = $(By.className("btn btn-error"));
    private ElementsCollection closeMeasureWindowButtons = $$(By.xpath("//div[@class=\"buttons count-2\"]/button"));

    private SelenideElement shareButton = $(By.xpath("//div[@title=\"Share\"]"));

    private SelenideElement lastMarkName = $(By.xpath("//li[@class=\"item edit-mode active\"]/div[@class=\"view-cont\"]/input[@class=\"title-input\"]"));

    private SelenideElement saveMark = $(By.xpath("//li[@class=\"item edit-mode active\"]/div[@class=\"view-cont\"]/div[@class=\"buttons\"]/button[@class=\"save-btn\"]"));

    public SavePage save(){
        save.click();
        return page(SavePage.class);
    }

    public ToolsPage share(){
        shareButton.click();
        return page(ToolsPage.class);
    }

    public void isSaved(){
        whereSaved.shouldBe(Condition.visible);
    }

    public void closePoiDetail(){
        notificationWindow.shouldNot(Condition.visible);
        close.click();
    }

    public void isMyPointsSaved(){
        whereMyPointsSaved.shouldBe(Condition.visible);
    }

    public void closeMyPoints(){
        notificationWindow.shouldNot(Condition.visible);
        closeMyPoints.click();
    }

    public void addMeasure(){
//        SelenideElement mapa = $(By.id("map"));
//        mapa.click();
//
//        int xOffset = mapa.getLocation().getX() + mapa.getSize().getWidth() / 2 + 80;
//        int yOffset = mapa.getLocation().getY() + mapa.getSize().getHeight() / 2 + 80;
//        actions().moveByOffset(xOffset, yOffset).click().perform();


        for (int i = 0; i < 10; i++){
            actions().moveByOffset(30,0).click().perform();
        }


        quitMeasure.click();

//        save.click();
//
//        return page(SavePage.class);
    }

    public void closeMeasure(){
        notificationWindow.shouldNotBe(Condition.visible);
        closeMeasure.click();
        closeMeasureWindowButtons.get(0).click();
        //System.out.println(closeMeasureWindow1.size());
        //closeMeasureWindow.click();
    }


    public void addMarks(){
        SelenideElement mapa = $(By.id("map"));
        mapa.click();
        for (int i = 0; i < 10; i++){
            actions().moveByOffset(0,20).click().perform();
        }

//        for (int i = 0; i < 10; i++){
//            actions().moveByOffset(0,20).click().perform();
//        }

        lastMarkName.setValue("Last mark");
        saveMark.click();

    }



}
