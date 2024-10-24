package tests.day2;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMakinasi {


    AndroidDriver<AndroidElement> driver;
    AppiumDriver<MobileElement> appiumDriver;
    IOSDriver<IOSElement> iosDriver;

    @Test
    public void hesapMakinasiTesti() throws MalformedURLException {
        // Kullanici gerekli kurulumlari yapar
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 4"); // cihaz ismi


        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); // ios / android

        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); // cihazin isletim sistemi
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2"); //  cihazin otomasyonu
        cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\User\\IdeaProjects\\Appium_T_141\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");

        // C:\Users\User\IdeaProjects\Appium_T_141\Apps\Calculator_8.4 (503542421)_Apkpure (3).apk
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


        //uygulamanin yüklendigini dogrular(installed)
       // driver.isAppInstalled("com.google.android.calculator");
        // bandleld ID :app in ID si,
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        //uygulamanin acildigini dogrular

        Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/clr").isDisplayed());
        //400 ün 3 katinin 1200 old dogrular

        driver.findElementByAccessibilityId("4").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("3").click();
        String islemSonucu= driver.findElementById("com.google.android.calculator:id/result_preview").getText();
       int expectedIslemSonucu=1200;
       Assert.assertEquals(Integer.parseInt(islemSonucu),expectedIslemSonucu);
    }
}