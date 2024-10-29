package tests.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_Kiwi {



    @Test

    public void kiwiAppTest() throws InterruptedException {

        AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();
        KiwiPage kiwiPage=new KiwiPage();


        // uygulamanin yuklendigi dogrulanir
       Assert.assertTrue( driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir
       Assert.assertTrue( kiwiPage.continueAsAGuest.isDisplayed());

        // misafir olarak devam et e tiklanir
        kiwiPage.continueAsAGuest.click();
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir

        // 512 2061


        for (int i = 0; i < 3; i++) {
            ReusableMethods.koordinatTiklamaMethodu(512,2061,1500);

            Thread.sleep(2000);
        }
        Thread.sleep(1000);



        // Trip type,one way olarak secilir

        kiwiPage.tripType.click();
        kiwiPage.oneWay.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir

        kiwiPage.from.click();
        kiwiPage.clear.click();
        Thread.sleep(1000);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir

        if (driver.isKeyboardShown()){
        driver.getKeyboard().pressKey("Istanbul");

        }else {
            kiwiPage.departerPoint.sendKeys("Dusseldorf");


        }

        kiwiPage.addDestionation.click();
        kiwiPage.choose.click();


        Thread.sleep(1000);
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        Thread.sleep(500);
        kiwiPage.landing.click();

        driver.getKeyboard().pressKey("Berlin");
        kiwiPage.addDestionation.click();
        kiwiPage.choose.click();
        // gidis tarihi agustos ayinin 21 i olarak secilir ve set date e tiklanir
        kiwiPage.time.click();
        Thread.sleep(1000);


        // 465 1661





        TouchAction action=new TouchAction<>(driver);
        for (int i = 0; i <7; i++) {


            action.press(PointOption.point(465, 1661))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(465, 297))
                    .release()
                    .perform();
            Thread.sleep(1000);
        }



        action.press(PointOption.point(685,933)).release().perform();



        Thread.sleep(500);
        kiwiPage.setDate.click();
        // search butonuna tiklanir
        kiwiPage.search.click();

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        Thread.sleep(2000);

        kiwiPage.popular.click();
        kiwiPage.cheapest.click();
        kiwiPage.stops.click();
        kiwiPage.nonstop.click();
        kiwiPage.berlin.click();
        Thread.sleep(7000);





        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir


       String biletFiyati= kiwiPage.biletFiyati.getText();
       driver.sendSMS("1111125631111","bu ucusun fiyati : "+biletFiyati);



    }
}