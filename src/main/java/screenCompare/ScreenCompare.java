package screenCompare;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenCompare {

    public static void main (String[] args) throws IOException {
//        try {
//            BufferedImage reference = ImageIO.read(new File("C:/my/proj/TAU/webDriverJavaGradleSelenideJUnit5Allure/screenshots/reference/1.png"));
//        }
//        catch (IOException e){
//            System.out.println("IO exception");
//        }

    BufferedImage reference = ImageIO.read(new File("C:/my/proj/TAU/webDriverJavaGradleSelenideJUnit5Allure/screenshots/reference/1.png"));
    BufferedImage current = ImageIO.read(new File("C:/my/proj/TAU/webDriverJavaGradleSelenideJUnit5Allure/screenshots/current/3.png"));

    ImageDiffer imgDiff = new ImageDiffer();
    ImageDiff diff = imgDiff.makeDiff(reference,current);

    diff.getDiffImage();
    ImageIO.write(diff.getDiffImage(), "png", new File("C:/my/proj/TAU/webDriverJavaGradleSelenideJUnit5Allure/screenshots/reference/1_diff.png"));
    ImageIO.write(diff.getMarkedImage(), "png", new File("C:/my/proj/TAU/webDriverJavaGradleSelenideJUnit5Allure/screenshots/reference/1_marked.png"));
    System.out.println("Start");
    }

}





