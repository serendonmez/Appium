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

public class C02_ToDoList {
    AndroidDriver<AndroidElement> driver;


    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL 4"); // cihaz ismi
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android"); // ios / android
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0"); // cihazin isletim sistemi
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); //  cihazin otomasyonu
        cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\User\\IdeaProjects\\Appium_T_141\\Apps\\To-Do List - Schedule Planner_1.02.61.0928_APKPure.apk");
            /*
          set cap ile app i telefona yükleme ve appi acma isemi yapar
             */
        // cap.setCapability("appPackage","todolist.scheduleplanner.dailyplanner.todo.reminders");
       // cap.setCapability("appActivity","app.todolist.activity.SplashActivity");
        /*
        appPackage+appActivity -> app ID+ uygulamanin activities sayfasi-> yüklenmis app i istenilen sayfadan acar

         */
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);







    }

    @Test
    public void test() throws InterruptedException {

        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("todolist.scheduleplanner.dailyplanner.todo.reminders"));
        // uygulaminin basarili bir sekilde acildigi dogrulanir

        Thread.sleep(2500);
       Assert.assertTrue( driver.findElementByXPath("//*[@text='Welcome to To-do List']").isDisplayed());

        // Ileri butonlarina tiklanir ve pop-up lar kapatilir
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/honor_continue").click();
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/vip_continue_icon").click();
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/vip_top_pic1").click();

        TouchAction action =new TouchAction<>(driver);

        action.press(PointOption.point(1002,226)).release().perform();
        Thread.sleep(1000);
        action.press(PointOption.point(1002,885)).release().perform();
        Thread.sleep(1000);



        // görev ekleme adimina gecilir
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/iv_task_add").click();


        // görev adi girilir
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_create_input").sendKeys("check the tasks");

        // görev kaydedilir
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_create_btn").click();

        // görev silinir
        //1210 889

        Thread.sleep(2000);


        for (int i = 0; i < 3; i++) {

            action.press(PointOption.point(902,1219)).release().perform();
            Thread.sleep(1000);

        }

        action.press(PointOption.point(781,534)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(780)))
                .moveTo(PointOption.point(525,534)).release().perform();
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/task_delete").click();
        driver.findElementById("todolist.scheduleplanner.dailyplanner.todo.reminders:id/dialog_confirm").click();


        // Görev olusturma sayfasina geri dönüldügü dogrulanir


       Assert.assertTrue( driver.findElementByXPath("//*[@text='Click here to create your first task.']").isDisplayed());








    }



}
