package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KiwiPage {

    public KiwiPage() {

        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }


    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement continueAsAGuest;

  @FindBy(xpath = "//*[@text='Return']")
    public WebElement tripType;

  @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWay;


  @FindBy(xpath = "//*[@text='From:']")
    public WebElement from;

  @FindBy(xpath = "//*[@content-desc='Clear All']")
    public WebElement clear;

@FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement departerPoint;

@FindBy(xpath = "(//*[@content-desc='Add destination'])[1]")
    public WebElement addDestionation;
@FindBy(xpath = "//*[@text='Choose']")
    public WebElement choose;

@FindBy(xpath = "//*[@text='To:']")
    public WebElement landing;

@FindBy(xpath = "//*[@text='Departure:']")
    public WebElement time;


@FindBy(id="com.skypicker.main:id/saveButton")
public WebElement setDate;

@FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement search;

@FindBy(xpath = "//*[@text='Popular']")
    public WebElement popular;

@FindBy(xpath = "//*[@text='Cheapest']")
public WebElement cheapest;

@FindBy(xpath = "//*[@text='Stops']")
    public WebElement stops;

@FindBy(xpath = "//*[@text='Nonstop']")
    public WebElement nonstop;

@FindBy(xpath = "(//*[@text='Berlin'])[1]")
    public WebElement berlin;

@FindBy(xpath = "(//android.widget.TextView[@text=\"$175.00\"])[1]")
    public WebElement biletFiyati;



























}
