package myMaps;

import base.BaseTest;
import org.junit.jupiter.api.Test;

public class MyMapsTests extends BaseTest {


    @Test
    public void login(){
        homePage.clickLogin();
        myMapsPage.isLoggedIn();

//        LoginTest loginTests = new LoginTest();
//        loginTests.testLogin();
    }

//    @Test(dependsOnMethods={"login"})
    public void createItemRightClick(){
        homePage.rightClickAtCenter().whatIsHereClick();
        poiDetailPage.save().save();
        notification.closeNotification();
        poiDetailPage.closePoiDetail();
    }

//    @Test(dependsOnMethods={"login"})
    public void createFolder(){
        myMapsPage.createFolder("blhbnv");
        notification.closeNotification();
    }

//    @Test(dependsOnMethods={"login", "createFolder"})
    public void shareFolder(){
        myMapsPage.shareFolder();
    }

//    @Test(dependsOnMethods={"login", "createItemRightClick"})
    public void shareItem(){
        myMapsPage.shareItem();
    }

//    @Test (dependsOnMethods={"login"}, priority = 1)
    public void deleteFolders(){
        homePage.myMaps();
        myMapsPage.deleteFolders();
    }

//    @Test (dependsOnMethods={"login"}, priority = 1)
    public void deleteAllItemsInOnce(){
        homePage.myMaps();
        myMapsPage.deleteAllItemsInOnce();
    }

//    @Test (dependsOnMethods={"login", "createItemRightClick"})
    public void myMarks() {
        homePage.openTools().clickMarks();
        homePage.addMarks().save();
        notification.closeNotification();
        poiDetailPage.isMyPointsSaved();
        poiDetailPage.closeMyPoints();
    }

//    @Test (dependsOnMethods={"login", "createItemRightClick"})
//    @Test (dependsOnMethods={"login"})
    public void measure(){
        homePage.openTools().clickMeasure();
        poiDetailPage.addMeasure();
        poiDetailPage.save().save();
        notification.closeNotification();
        poiDetailPage.isMyPointsSaved();
        poiDetailPage.closeMeasure();
    }




}
