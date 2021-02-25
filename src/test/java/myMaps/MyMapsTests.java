package myMaps;

import base.BaseTest;
import org.junit.jupiter.api.Test;

public class MyMapsTests extends BaseTest {

    @Test
    public void ass(){
        ;
    }

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

}
