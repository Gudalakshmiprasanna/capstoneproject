package screenshots;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotCode {
	public static void takeScreenshot(WebDriver driver, String testName) {
        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = "C:\\Users\\91863\\Desktop\\Phase2\\JPetStore\\Screenshots" + testName + "_" + timestamp + ".png";
            File destFile = new File(filePath);
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot captured: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot");
        }
    }
}
