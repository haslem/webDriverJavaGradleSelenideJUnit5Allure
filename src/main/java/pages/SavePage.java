package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import help.Help;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class SavePage {

    protected SelenideElement save = $(By.xpath("/html/body/div[2]/div[2]/div[4]/button[1]"));
    protected SelenideElement name = $(By.xpath("//input[@class=\"title\"]"));
    protected SelenideElement folders = $(By.xpath("//div[@class=\"maps-select mymap-folders\"]"));
    private ElementsCollection folderToSave = $$(By.xpath("//li[@class=\"item folder\"]//span[@class=\"title\"]"));

    public PoiDetailPage save(){
        save.click();
        return page(PoiDetailPage.class);
    }

    public void setName(String newName){
        name.setValue(newName);
    }

    public void setFolderToSave(String folderName){
        Help.timeOut(1);
        folders.click();



        for (SelenideElement folder: folderToSave){
//            System.out.println(folder.getText());
            if (folder.getText().equals(folderName)){
                folder.click();
                break;
            }
        }
    }


}
