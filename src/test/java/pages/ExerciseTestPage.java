package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.BrowserUtils;

public class ExerciseTestPage {
    public ExerciseTestPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="UID")
    public WebElement inputUserField;
    @FindBy(id="PWD")
    public WebElement inputPasswordField;
    @FindBy(name="login")
    public WebElement login;
    @FindBy(xpath = "//a[@class='username']")
    public  WebElement user1Test;
    @FindBy(xpath = "//table//tbody//td[2]/select[@id='IU']")
    public WebElement firstScreenDropDown;
    @FindBy(name="DETAIL")
    public WebElement submit;
    @FindBy(xpath = "//a[@class='logout']")
    public WebElement logout;
    @FindBy(id="pageTitle")
    public WebElement learLitle;
    @FindBy(css = "#login-box > h2")
    public WebElement loginBox;
    @FindBy(css = "#column_0 > div > div.widget-header.row_0 > span")
    public WebElement recentActivities;



    public void login(String usernameStr, String passwordStr){
        inputUserField.sendKeys(usernameStr);
        inputPasswordField.sendKeys(passwordStr);
        login.click();

        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.titleIs(BrowserUtils.getCurrentTitle()));

    }






}