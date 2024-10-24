package tests.day3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_Kiwi {



    @Test

    public void kiwiAppTest(){

        AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();



        // uygulamanin yuklendigi dogrulanir
       Assert.assertTrue( driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir

        // misafir olarak devam et e tiklanir
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        // Trip type,one way olarak secilir
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        // gidis tarihi agustos ayinin 21 i olarak secilir ve set date e tiklanir
        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir



    }
}
