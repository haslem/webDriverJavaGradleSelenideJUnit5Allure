package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import help.Help;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    private SelenideElement tools = $(By.xpath("//button[@class=\"icon tools\"]"));
    private SelenideElement starSaveButton = $(By.xpath("//*[@id=\"usermarks\"]/div/div[1]/div/div[2]/div[1]/div[1]/button"));
    private SelenideElement saveButton = $(By.xpath("//li[@class=\"item edit-mode active\"]//div[@class=\"view-cont\"]//div[@class=\"buttons\"]//button[@class=\"save-btn\"]"));
    private SelenideElement searchTab = $(By.xpath("/html/body/div/div[2]/div[1]/div/button[1]"));
    private SelenideElement planningTab = $(By.xpath("/html/body/div/div[2]/div[1]/div/button[2]"));
    private SelenideElement myMapsTab = $(By.xpath("/html/body/div/div[2]/div[1]/div/button[3]"));
    private SelenideElement searchInput = $(By.id("input-search"));
    private SelenideElement searchResults = $(By.id("search-results"));
    private SelenideElement hoverPoiDetail = $(By.xpath("//div[@class=\"card-body\"]//span[@class=\"info-part\"]"));

    private SelenideElement zoomIn = $(By.xpath("//button[@title=\"Zoom in\"]"));
    private SelenideElement zoomOut = $(By.xpath("//button[@title=\"Zoom out\"]"));

    private SelenideElement panorama = $(By.xpath("//button[@title=\"Panorama\"]"));

    private SelenideElement d3 = $(By.xpath("//button[@title=\"3D view\"]"));
    private SelenideElement d3Compas = $(By.xpath("//div[@class=\"basic-compass noprint\"]"));

    private SelenideElement changeMap = $(By.xpath("//button[@title=\"Choose another map\"]"));
    private SelenideElement aerialMap = $(By.xpath("//li[@class=\"letecka\"]"));
    private SelenideElement aerialMapButton = $(By.xpath("//button[@title=\"Aerial Map\"]"));
    private SelenideElement historicMap = $(By.xpath("//li[@class=\"19stoleti\"]"));
    private SelenideElement trafficMap = $(By.xpath("//li[@class=\"dopravni\"]"));


    public void clickLogin() {

        // Perform the click operation that opens new window
        $(By.xpath("//*[@id=\"layout-bar\"]/button[3]")).click();


        switchTo().window(1);

        $(By.id("login-username")).setValue("mapytesting10");
        $(By.id("login-password")).setValue("testingmapy");
        $(By.xpath("//button[@type=\"submit\"]")).click();

        switchTo().window(0);

    }


    public ContextMenu rightClickAtCenter(){
        //apparently cursor by default is in the center
        //thats why createItemRightClick need just contextClick and context is in the middle of screen
        //don't know why it's work

        SelenideElement mapa = $(By.id("map"));
        mapa.contextClick();

        return new ContextMenu();
    }

    public void centerMapClick(){
        SelenideElement map = $(By.id("map"));
        actions().moveToElement(map).perform();
    }


    public ToolsPage openTools(){
        try {
            centerMapClick();
        }
        finally {
            tools.click();
            return page(ToolsPage.class);
        }

    }

    public SavePage addMarks(){
//        SelenideElement mapa = $(By.id("map"));
//
//        int xOffset = mapa.getLocation().getX() + mapa.getSize().getWidth() / 2 + 50;
//        int yOffset = mapa.getLocation().getY() + mapa.getSize().getHeight() / 2 + 50;

//        System.out.println(mapa.getLocation().getX());
//        System.out.println(mapa.getLocation().getY());
//        System.out.println(mapa.getSize().getWidth());
//        System.out.println(mapa.getSize().getHeight());



        //actions().moveByOffset(mapa.getLocation().getX() + 2, mapa.getLocation().getY() + 2).perform();
        //actions().click();





        //apparently cursor by default is in the center
        //thats why createItemRightClick need just contextClick and context is in the middle of screen

        for (int i = 0; i < 10; i++){
            actions().moveByOffset(+10,0).click().perform();
        }

        saveButton.click();
        starSaveButton.click();

        return page(SavePage.class);
    }


    public void search(String search){

        searchTab.click();
        searchInput.sendKeys(search);
        searchInput.sendKeys(Keys.ENTER);

        searchResults.shouldBe(Condition.visible);


    }

    public void clickSearch(){

        searchTab.click();
    }

    public void check(){

        SelenideElement mapa = $(By.id("map"));
        System.out.println(Help.elementX(mapa));
        System.out.println(Help.elementY(mapa));
        System.out.println(Help.elementHeight(mapa));
        System.out.println(Help.elementWidth(mapa));

    }

    public void moveToRightEdgeRightClick(){
        SelenideElement map = $(By.id("map"));
        actions().moveToElement(map, Help.elementWidth(map)/2 - 40, 0).contextClick().perform();
    }

    public PoiDetailPage poiHover(){

        SelenideElement mapa = $(By.id("map"));
//        System.out.println(Help.elementX(mapa));
//        System.out.println(Help.elementY(mapa));
//        System.out.println(Help.elementHeight(mapa));
//        System.out.println(Help.elementWidth(mapa));

//        actions().moveByOffset(Help.elementX(mapa) + Help.elementWidth(mapa)/2,
//                Help.elementY(mapa) + Help.elementHeight(mapa)/2).perform();

        actions().moveToElement(mapa).perform();

        hoverPoiDetail.shouldBe(Condition.exist);
        hoverPoiDetail.click();

        return page(PoiDetailPage.class);

    }

    public PlanningPage planning(){
        planningTab.click();
        return page(PlanningPage.class);
    }

    @Step("Open My Maps")
    public MyMapsPage myMaps(){
        myMapsTab.click();
        Help.timeOut(1);
        return page(MyMapsPage.class);
    }

    public void maxZoom(){
        for (int i = 0; i<10; i++){
            zoomIn.click();
        }
    }

    public void minZoom(){
        for (int i = 0; i<5; i++){
            zoomOut.click();
        }
    }

    public void setAerialMap(){
        changeMap.click();
        aerialMap.click();
    }

    public void setAerialMapButton(){
        aerialMapButton.click();
    }

    public void setHistoricMap(){
        changeMap.click();
        historicMap.click();
    }

    public void setTrafficMap(){
        changeMap.click();
        trafficMap.click();
    }

    public void panorama(){
        minZoom();
        panorama.click();
        Help.timeOut(2);
        SelenideElement map = $(By.id("map"));
        map.click();

    }

    public void setD3(){
        d3.click();
        Help.timeOut(5);
    }



}
