package links;

import base.BaseTest;
import help.Help;
import login.LoginTest;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.MyMapsPage;


import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;


public class LinksTest extends BaseTest {

//    static HomePage homePage1;
//    static MyMapsPage myMapsPage1;
//    static LoginTest loginTest = new LoginTest();

    @Test
    public void login(){
        System.out.println("Before all");
        homePage.clickLogin();
        myMapsPage.isLoggedIn();
    }

    @Nested
    class allLinks{



//    @Test(dependsOnMethods={"login"})
    @Test
    public void searchLink() throws IOException, UnsupportedFlavorException {

        homePage.search("golf");
        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("Search link");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void measureLink() throws IOException, UnsupportedFlavorException {
        homePage.openTools().clickMeasure();
        poiDetailPage.addMeasure();
        poiDetailPage.share();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("unsaved measure");

        poiDetailPage.save().save();
        notification.closeNotification();
        poiDetailPage.isMyPointsSaved();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("saved measure");
        poiDetailPage.closeMeasure();

    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void markLink() throws IOException, UnsupportedFlavorException {
        homePage.openTools().clickMarks();
        poiDetailPage.addMarks();
        poiDetailPage.share();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("unsaved marks");

        poiDetailPage.save().save();
        notification.closeNotification();
        poiDetailPage.isMyPointsSaved();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("saved marks");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void poiLink() throws IOException, UnsupportedFlavorException {

        homePage.poiHover();
        poiDetailPage.share();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("unsaved poi");


        poiDetailPage.save().save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("saved poi");
    }



//    @Test(dependsOnMethods={"login"})
    @Test
    public void poiChangeNameLink() throws IOException, UnsupportedFlavorException {

        homePage.poiHover();
        poiDetailPage.share();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("unsaved poi renamed");


        poiDetailPage.save();
        savePage.setName("Renamed poi");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("saved poi renamed");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void coorLink() throws IOException, UnsupportedFlavorException {

        //homePage.rightClickAtCenter();
        homePage.moveToRightEdgeRightClick();
        contextMenu.whatIsHereClick();
        poiDetailPage.share();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("unsaved coor");


        poiDetailPage.save();
        savePage.setName("Renamed coor");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("saved coor");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void onePointRoute() throws IOException, UnsupportedFlavorException {

        homePage.planning();
        planningPage.setStart("Prague");

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("one point route");

    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void twoPointRoute() throws IOException, UnsupportedFlavorException {

        homePage.planning();
        planningPage.setStart("Prague");
        planningPage.setEnd("Ostrava");

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("two point route unsaved");



        poiDetailPage.save();
        savePage.setName("two point route");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("two point route saved");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void twoPointRoute1() throws IOException, UnsupportedFlavorException {

        homePage.planning();
        planningPage.setStart("Prague");
        planningPage.setEnd("Mlada Boleslav");
        planningPage.setWalkShort();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("Prague Mlada Boleslav walk short unsaved");


        poiDetailPage.save();
        savePage.setName("Prague Mlada Boleslav");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("Prague Mlada Boleslav walk short");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void twoPointRouteSeveralCountries() throws IOException, UnsupportedFlavorException {

        homePage.planning();
        planningPage.setStart("Prague");
        planningPage.setEnd("Budapest");

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("Prague Budapest auto fast unsaved");


        poiDetailPage.save();
        savePage.setName("Prague Budapest");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("Prague Budapest auto fast saved");
    }

//    @Test(dependsOnMethods={"login"})
    @Test
    public void twoPointRouteSeveralCountriesAvoidOne() throws IOException, UnsupportedFlavorException {

        homePage.planning();
        planningPage.setStart("Prague");
        planningPage.setEnd("Budapest");
        planningPage.avoidSecondCountry();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("Prague Budapest auto fast unsaved no Sk");


        poiDetailPage.save();
        savePage.setName("Prague Budapest");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("Prague Budapest auto fast saved no Sk");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void twoPointRouteSeveralCountriesAvoidAll() throws IOException, UnsupportedFlavorException {

        homePage.planning();
        planningPage.setStart("Prague");
        planningPage.setEnd("Budapest");
        planningPage.avoidAll();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("Prague Budapest auto fast unsaved no pay");


        poiDetailPage.save();
        savePage.setName("Prague Budapest");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("Prague Budapest auto fast saved no pay");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void twoPointRouteSeveralCountriesAvoidSKnoPayHUN() throws IOException, UnsupportedFlavorException {

        homePage.planning();
        planningPage.setStart("Prague");
        planningPage.setEnd("Budapest");
        planningPage.avoidSecondCountry();
        planningPage.avoidThirdCountry();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("Prague Budapest auto fast unsaved");


        poiDetailPage.save();
        savePage.setName("Prague Budapest");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("Prague Budapest auto fast saved");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void tripBikeMax() throws IOException, UnsupportedFlavorException {

        homePage.rightClickAtCenter();
        contextMenu.trip();
        planningPage.tripBike();
        Help.timeOut(2);
        planningPage.setTripDistanceToMax();
        Help.timeOut(2);

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("Prague trip bike max unsaved");


        poiDetailPage.save();
        savePage.setName("Prague trip");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("Prague trip bike max saved");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void tripWalkMin() throws IOException, UnsupportedFlavorException {

        homePage.rightClickAtCenter();
        contextMenu.trip();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("Prague trip walk min unsaved");


        Help.timeOut(2);
        poiDetailPage.save();
        savePage.setName("Prague trip");
        savePage.save();
        notification.closeNotification();
        poiDetailPage.share();
        toolsPage.shareOn();
        toolsPage.copyLink();
        toolsPage.close();
        Help.linkToFile("Prague trip walk min saved");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void baseMap() throws IOException, UnsupportedFlavorException {

        homePage.maxZoom();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("base map");

    }

//    @Test(dependsOnMethods={"login"})
    @Test
    public void aerialMap() throws IOException, UnsupportedFlavorException {

        homePage.maxZoom();
        homePage.setAerialMap();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("aerial map");

    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void aerialMapButton() throws IOException, UnsupportedFlavorException {

        homePage.maxZoom();
        homePage.setAerialMapButton();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("aerial map button");
    }

//    @Test(dependsOnMethods={"login"})
    @Test
    public void historicMap() throws IOException, UnsupportedFlavorException {

        homePage.maxZoom();
        homePage.setHistoricMap();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("historic map");
    }

//    @Test(dependsOnMethods={"login"})
    @Test
    public void trafficMap() throws IOException, UnsupportedFlavorException {

        homePage.maxZoom();
        homePage.setTrafficMap();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("traffic map");
    }

//    @Test(dependsOnMethods={"login"})
    @Test
    public void panorama() throws IOException, UnsupportedFlavorException {

        homePage.panorama();
        Help.timeOut(2);

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("panorama");
    }

//    @Test(dependsOnMethods={"login"})
    @Test
    public void d3() throws IOException, UnsupportedFlavorException {

        homePage.setD3();

        homePage.openTools();
        toolsPage.clickShare();
        toolsPage.copyLink();
        toolsPage.close();

        Help.linkToFile("3D");
    }


//    @Test(dependsOnMethods={"login"})
    @Test
    public void elementsToFolder() throws IOException, UnsupportedFlavorException {

        homePage.myMaps();

        myMapsPage.createFolder("New");
        notification.closeNotification();

        //measure to folder
        homePage.openTools().clickMeasure();
        poiDetailPage.addMeasure();

        poiDetailPage.save();
        savePage.setFolderToSave("New");
        savePage.save();
        poiDetailPage.closeMeasure();


        //marks to folder
        homePage.openTools().clickMarks();
        poiDetailPage.addMarks();

        poiDetailPage.save();
        savePage.setFolderToSave("New");
        savePage.save();


        //poi to folder
        open("https://mapy.cz/zakladni?x=14.4030680&y=50.0717916&z=16");
        homePage.poiHover();

        poiDetailPage.save();
        Help.timeOut(1);
        savePage.setFolderToSave("New");
        savePage.save();


        Help.timeOut(1);


        //coor to folder
        homePage.rightClickAtCenter();
        contextMenu.whatIsHereClick();

        poiDetailPage.save();
        savePage.setFolderToSave("New");
        savePage.save();



        //route to folder
        open("https://mapy.cz/zakladni?x=14.4030680&y=50.0717916&z=16");
        homePage.planning();
        planningPage.setStart("Prague");
        planningPage.setEnd("Ostrava");

        poiDetailPage.save();
        savePage.setFolderToSave("New");
        savePage.save();


        //trip to folder
        open("https://mapy.cz/zakladni?x=14.4030680&y=50.0717916&z=16");
        homePage.rightClickAtCenter();
        contextMenu.trip();

        poiDetailPage.save();
        savePage.setFolderToSave("New");
        savePage.save();


        //share
        open("https://mapy.cz/zakladni?x=14.4030680&y=50.0717916&z=16");
        homePage.myMaps().shareFolder();
        //Help.timeOut(1);
        toolsPage.shareOn();
        toolsPage.copyLink();
        //Help.timeOut(1);
        toolsPage.close();
        Help.linkToFile("folder link");


    }


    }



}
