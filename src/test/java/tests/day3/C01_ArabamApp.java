package tests.day3;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class C01_ArabamApp {


    AndroidDriver<AndroidElement>driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL 4"); // cihaz ismi
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android"); // ios / android
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0"); // cihazin isletim sistemi
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); //  cihazin otomasyonu
        // cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\User\\IdeaProjects\\Appium_T_141\\Apps\\arabam.com_5.1.6_Apkpure.apk");
            /*
          set cap ile app i telefona yükleme ve appi acma isemi yapar
             */
        cap.setCapability("appPackage","com.dogan.arabam");
        cap.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        /*
        appPackage+appActivity -> app ID+ uygulamanin activities sayfasi-> yüklenmis app i istenilen sayfadan acar
         */
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @Test
    public void arabamTest() throws InterruptedException {
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // app ID = BundledID="com.dogan.arabam"

        // uygulaminin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());
        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();
        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        Thread.sleep(2000); // actionlardan önce sf nin yüklenmesi icin
        // arac olarak Volkswagen secilir
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(382,1935))
                //press islmei ekranda ilk dokundugumuz yerdir
                // buraya yazilacak pixel degerleri icin, Tap/Swipe By Coordinate e tikla
                // X  Y koordinatlarina göre istenilen Elementin koordinati bulunur

                // press islemi ekran parmagimizi kaydir islemini baslatmak icin ilk dokundugumuz yerdir
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(90)))
                // baslangic noktasiyla bitis noktasi arasindaki gecen sure
                // eger sure azalirsa; gidilen yol mesafesi ARTAR
                // eger sureyi arttirirsan; gidilen yol mesafesi AZALIR !!
                // yani tamamen bir ters oranti vardir. ekranda daha fazla asagi ya da yukari gitmek istiyorsak
                // birim zamanda sureyi azaltmaliyiz
                .moveTo(PointOption.point(382,69))
                // Move to pressten sonra kaydirilacak alan olan ekrandaki koordinat noktasi
                .release() // kaydirma islemi bittikten sonra ekrandan parmagimizi kaldirma islemi
                .perform();
        Thread.sleep(1500);

        driver.findElementByXPath("//*[@text='Volkswagen']").click();


        Thread.sleep(1000);

        // arac markasi olarak passat secilir
        driver.findElementByXPath("//*[@text='Passat']").click();
        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();
        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Comfortline']").click();
        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        driver.findElementByXPath("//*[@text='Sıralama']").click();
        /*
        xpathini alamaz isek koordinatlar ile click yaptirabilirz
          action.press(PointOption.point(408,400))
                .release()
                .perform();

         */

        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();

        Thread.sleep(1500);
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir

        String sonFiyat= driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]").getText();
            sonFiyat=sonFiyat.replaceAll("\\D","");
        Assert.assertTrue(Integer.parseInt(sonFiyat)>500000);

    }

}
