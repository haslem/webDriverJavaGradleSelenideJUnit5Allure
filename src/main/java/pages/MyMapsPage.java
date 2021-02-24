package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class MyMapsPage {

    private Notification notification = new Notification();

    private ElementsCollection folders = $$(By.xpath("//ul[@class=\"folders sortable\"]//li"));
    private ElementsCollection folders1 = $$(By.xpath("//ul[@class=\"folders sortable\"]"));
    private SelenideElement createFolder = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[3]/div/div[1]/div[1]/button"));
    private SelenideElement newFolderName = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[3]/div/div[1]/div[5]/div/input"));

    private SelenideElement folderMenu = $(By.xpath("//li[@class=\"folder\"]//div//span[@class=\"opts\"]"));
    //private SelenideElement folderMenu = $(By.xpath("//*[@id=\"mymaps\"]/div[3]/div/ul[1]/li/div/div[2]/span[2]"));

    private SelenideElement shareFolder = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[3]/div/ul[1]/li[1]/div/div[2]/ul/li[1]"));
    private SelenideElement toggleShare = $(By.className("share-slider"));
    private SelenideElement closeShare = $(By.xpath("/html/body/div[2]/div[2]/button"));
    private SelenideElement sharedFolderIcon = $(By.xpath("//li[@class=\"folder\"]//div//div[@class=\"bar public\"]//span[@class=\"public-icon\"]"));

    private ElementsCollection items = $$(By.xpath("//ul[@class=\"items sortable\"]//li"));
    private SelenideElement itemMenu = $(By.xpath("//*[@id=\"mymaps\"]/div[3]/div/ul[2]/li/div[1]/span[3]"));
    private SelenideElement itemShare = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[3]/div/ul[2]/li/ul/li[1]"));
    private SelenideElement sharedItemIcon = $(By.xpath("//li[@class=\"item public\"]//div[@class=\"inner\"]//span[@class=\"public-icon\"]"));

    private SelenideElement folderDelete = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[3]/div/ul[1]/li[1]/div/div[2]/ul/li[4]"));
    private SelenideElement approveDelete = $(By.xpath("/html/body/div[2]/div[2]/div[2]/button[1]"));

    private SelenideElement itemMultiAction = $(By.xpath("//h3[text()=\"Multiple actions\"]"));
    private SelenideElement selectAllItems = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[3]/div/div[1]/div[3]/label"));
    private SelenideElement deleteMultiActions = $(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div/div[3]/div/div[1]/div[3]/button[2]"));

    public void isLoggedIn(){
        //$(By.xpath("//button[@class=\"icon profile\"]")).shouldBe(Condition.visible);
        $(By.xpath("//button[@class=\"icon profile\"]")).shouldBe(Condition.exist);
    }

    public int countFolders(){
        return folders.size();
//        return folders1.size();
    }

    public HomePage createFolder(String newName) {
        createFolder.click();
        //newFolderName.setValue("\"New Created folder\"");
        newFolderName.setValue(newName);
        newFolderName.sendKeys(Keys.ENTER);
        folders.first().should(Condition.text(newName));
        return page(HomePage.class);
    }

    public void shareFolder() {
        folderMenu.click();


        shareFolder.click();

//        toggleShare.click();
//        closeShare.click();
//
//        sharedFolderIcon.shouldBe(Condition.visible);

    }

    public void shareItem() {
        itemMenu.click();
        itemShare.click();
        toggleShare.click();
        closeShare.click();
        sharedItemIcon.shouldBe(Condition.visible);
    }

    public void deleteOneFolder(){

        folderMenu.click();
        folderDelete.click();
        approveDelete.click();
        notification.closeNotification();
    }

    public void deleteFolders(){
        while (countFolders() > 0){
            deleteOneFolder();
            //System.out.println(countFolders());
        }
        folders.shouldHaveSize(0);
    }

    public int countItems(){
        return items.size();
    }

    public void deleteAllItemsInOnce(){
        System.out.println(countItems() + "  before");
        if (countItems() > 0){
//            System.out.println("Inside if");
//            System.out.println(countItems());
            itemMenu.click();

            itemMultiAction.click();
            selectAllItems.click();

            deleteMultiActions.click();
            approveDelete.click();
            notification.closeNotification();
        }
        //System.out.println(countItems() + "  after");
        items.shouldHaveSize(0);
    }



}
