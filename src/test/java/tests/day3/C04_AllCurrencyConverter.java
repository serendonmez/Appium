package tests.day3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class C04_AllCurrencyConverter {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurrencyPage allCurrencyPage=new AllCurrencyPage();


    @Test
    public void currencyTest() throws IOException {






        // cevirmek istedigimiz para birimi zloty olarak secilir

        allCurrencyPage.cevirilenBirim.click();
        ReusableMethods.scrollWithUiScrollableAndClick("Polish Zloty");
        // cevirelecek olan para birimi Tl olarak secilir
        allCurrencyPage.cevirilecekBirim.click();
        ReusableMethods.scrollWithUiScrollableAndClick("Turkish Lira");


        allCurrencyPage.bir.click();
        allCurrencyPage.ucSifir.click();

        // cevrilen tutar screenShot olarak kaydedilir

       File ekranFoto= driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ekranFoto,new File("Ekran Fotosu.png"));


        ReusableMethods.getScreenshot("Method kullanarak");


        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        String tlDeger=allCurrencyPage.tlDeger.getText();

        // kullaniciya sms olarak bildirilir
        driver.sendSMS("025863",tlDeger);










    }
}
