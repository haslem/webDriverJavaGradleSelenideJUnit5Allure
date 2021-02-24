package base;

import org.junit.jupiter.api.BeforeEach;
import pages.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class BaseTest {

    protected HomePage homePage;
    protected MyMapsPage myMapsPage;
    protected PlanningPage planningPage;
    protected PoiDetailPage poiDetailPage;
    protected Notification notification;
    protected ToolsPage toolsPage;
    protected SavePage savePage;
    protected ContextMenu contextMenu;

//    @BeforeClass
    @BeforeEach
    public void setUp(){


        //Configuration.browser = "firefox";

        //headless
        //it will work if run from Idea, not through gradle
//        headless = true;


        open("https://mapy.cz/zakladni?x=14.4030680&y=50.0717916&z=16");

        homePage = page(HomePage.class);
        myMapsPage = page(MyMapsPage.class);
        planningPage = page(PlanningPage.class);
        poiDetailPage = page(PoiDetailPage.class);
        notification = page(Notification.class);
        toolsPage = page(ToolsPage.class);
        savePage = page(SavePage.class);
        contextMenu = page(ContextMenu.class);


    }
}
