package help;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Help {

    public static void timeOut(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String readClipboard() throws IOException, UnsupportedFlavorException {
        return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
    }

    public static void linkToFile(String name) throws IOException, UnsupportedFlavorException {
        FileWriter csvWriter = new FileWriter("new.csv" ,true);
        csvWriter.append("\n" + name + ',');
        csvWriter.append(readClipboard());
        csvWriter.flush();
        csvWriter.close();
    }

    public static int elementX(SelenideElement el){
        return el.getLocation().getX();
    }

    public static int elementY(SelenideElement el){
        return el.getLocation().getY();
    }

    public static int elementWidth(SelenideElement el){
        return el.getSize().getWidth();
    }

    public static int elementHeight(SelenideElement el){
        return el.getSize().getHeight();
    }

}
