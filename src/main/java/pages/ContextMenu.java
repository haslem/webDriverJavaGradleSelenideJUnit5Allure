package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ContextMenu {

//    private By whatIsHere = By.xpath("/html/body/div[3]/a[10]");
//    private By fromHere = By.xpath("/html/body/div[3]/a[1]");
//    private By toHere = By.xpath("/html/body/div[3]/a[2]");
//    private By trip = By.xpath("/html/body/div[3]/a[3]");

    private SelenideElement whatIsHere = $(By.xpath("/html/body/div[3]/a[10]"));
    private SelenideElement fromHere = $(By.xpath("/html/body/div[3]/a[1]"));
    private SelenideElement toHere = $(By.xpath("/html/body/div[3]/a[2]"));
    private SelenideElement trip = $(By.xpath("/html/body/div[3]/a[3]"));


    public PoiDetailPage whatIsHereClick(){
        whatIsHere.click();
        return page(PoiDetailPage.class);
    }

    public PlanningPage fromHereClick(){
        fromHere.click();
        return page(PlanningPage.class);
    }

    public PlanningPage toHereClick(){
        toHere.click();
        return page(PlanningPage.class);
    }

    public PlanningPage trip(){
        trip.click();
        return page(PlanningPage.class);
    }


}
