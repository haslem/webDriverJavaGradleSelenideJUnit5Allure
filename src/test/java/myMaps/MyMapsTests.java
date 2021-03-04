package myMaps;

import base.BaseTest;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyMapsTests extends BaseTest {


    @Test
    public void deleteFolders(){
        homePage.myMaps();
        myMapsPage.deleteFolders();
    }

    @Test
    public void deleteAllItemsInOnce(){
        homePage.myMaps();
        myMapsPage.deleteAllItemsInOnce();
    }


    @Test
    public void createItemRightClick(){
        homePage.rightClickAtCenter().whatIsHereClick();
        poiDetailPage.save().save();
        notification.closeNotification();
        poiDetailPage.closePoiDetail();
    }

    @DisplayName("Create measurement")
    @Test
    public void measure(){
        homePage.openTools().clickMeasure();
        poiDetailPage.addMeasure();
        poiDetailPage.save().save();
        notification.closeNotification();
        poiDetailPage.isMyPointsSaved();
        poiDetailPage.closeMeasure();
    }


}
