package tests.day1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class APKYukleme {

    AndroidDriver<AndroidElement> driver;
    // Android driver android cihazlari icin üretilmis ona göre özl leri eklenmis driver
    AppiumDriver<MobileElement> appiumDriver;

    //önceden tek bir driver , appium driver , vardi ; appium um zamanla gelistirilmesinden sonra
    //ios icin ayri android icin ayri driverlar üretti
    // önceki appium ddriver hem IOS hem Android icin calisiyordu


    IOSDriver<IOSElement> iosDriver;
    //Android driver android cihazlari icin üretilmis ona göre özl leri eklenmis driver

    @Test
    public void deneme() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4"); // cihaz ismi

        // cap.setCapability("deviceName","PIXEL 4"); ikisini de string olarak belirtebiliriz
        // eger tek emülatör cihazimiz varsa ve aktif ise cihaz ismi farkli girsek bile test passed olur
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android"); // ios / android
        // cap.setCapability("platformName","Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0"); // cihazin isletim sistemi
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); //cihazin otomasyonu IOS icin XCUITest

        /*
        UIAutomator isletim sistemi 6.0 ya da 6.0 dan kücük olan isletim sistemleri icin
        UIAutomator 2 isletim sistemi 6.0 dan büyük olan isletim sistemleri icin
         */

        cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\User\\IdeaProjects\\Appium_T_141\\Apps\\all-currency-converter-3-9-0 (1).apk");


        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // cihazdaki bir uygulamayi test etmek icin uygulamanin cihaza Download edilmis olmasi gerekir
        // download islemi android cihazda play store dan ya da APK dan  download etmek gerekir.
        // APK ile PlayStore dan indirmek arasindaki fark ;
        // APK da ki uygulama henüz Release e hazir omayan uygulama
        // Play store da ise test edilmis ve bitmis bir uygulamayi download ederiz
        // test ekibi bir uygulamayi APK üzerinden Download ederek test eder
        // uygulama yeni ise piyasaya cikmamis ise ilk bitmis halinin APK si gerekir
        // ilk halinin APK si üzerinden test edilir


    }


}
