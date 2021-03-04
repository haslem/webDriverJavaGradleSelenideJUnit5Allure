package base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import pages.*;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

import static com.codeborne.selenide.Browsers.FIREFOX;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    String firefox = System.getProperty("selenide.browser", FIREFOX);

    protected HomePage homePage;
    protected MyMapsPage myMapsPage;
    protected PlanningPage planningPage;
    protected PoiDetailPage poiDetailPage;
    protected Notification notification;
    protected ToolsPage toolsPage;
    protected SavePage savePage;
    protected ContextMenu contextMenu;

//    @BeforeAll
//    public void browser(){
//        Configuration.browser = "firefox";
//    }

//    @BeforeClass
    @BeforeEach
//    @BeforeAll
    public void setUp(){
//        System.out.println("Before each");



        //headless
        //it will work if run from Idea, not through gradle
//        headless = true;


        open("https://mapy.test.dszn.cz/zakladni?x=14.4030680&y=50.0717916&z=16");

        homePage = page(HomePage.class);
        myMapsPage = page(MyMapsPage.class);
        planningPage = page(PlanningPage.class);
        poiDetailPage = page(PoiDetailPage.class);
        notification = page(Notification.class);
        toolsPage = page(ToolsPage.class);
        savePage = page(SavePage.class);
        contextMenu = page(ContextMenu.class);

    }

    @BeforeAll
    public void login(){

        Configuration.browser = firefox;
//        System.out.println("Before all");
        open("https://mapy.test.dszn.cz/zakladni?x=14.4030680&y=50.0717916&z=16");
        homePage = page(HomePage.class);
        myMapsPage = page(MyMapsPage.class);

        homePage.clickLogin();
        myMapsPage.isLoggedIn();
        homePage.clickSearch();
    }


}
