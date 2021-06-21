package pages;

import io.cucumber.messages.Messages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepdefinitions.Hooks;
import utils.Helper;

public class LoginPage {


    @FindBy(xpath = "//a[@href='/login']")
    WebElement lnkLogin;

    @FindBy(id = "Email")
    WebElement txtUsername;

    @FindBy(id = "Password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@type='submit' and @value='Log in']")
    WebElement btnLogIn;

    @FindBy(xpath = "//ul[@class='top-menu']")
    WebElement lblTopMenu;

//    private WebDriver driver;
//    @Autowired
    public LoginPage(){
        PageFactory.initElements(Hooks.driver,this);
    }

    public void clickOnTheLoginLink() {
        lnkLogin.click();
    }

    public void enterUsername(){
        Helper.enterTextInTheTextBox(txtUsername, Hooks.properties.getProperty("username"));
    }

    public void enterPassword(){
        Helper.enterTextInTheTextBox(txtPassword, Hooks.properties.getProperty("password"));
    }

    public void clickLoginButton(){
        btnLogIn.click();
    }

   public boolean isTopMenuDisplayed(){
        return lblTopMenu.isDisplayed();
   }
}
