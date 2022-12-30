package VCase.Pages;

import VCase.utils.Driver;
import VCase.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Helper {
    public LoginPage (){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="ap_email")
    public WebElement eMailField ;
    @FindBy(id="continue")
    public WebElement continueBtn ;
    @FindBy(id="ap_password")
    public WebElement passwordField ;
    @FindBy(id="signInSubmit")
    public WebElement finishBtn ;

    @FindBy(id = "createAccountSubmit")
    public WebElement singOutSuccesfull;


    public void typeEmail(String email){
        sendKeysElement(eMailField,email);
    }
    public void clickContiuneBtn(){
        clickElement(continueBtn);
    }
    public void typepassword(String password){
        sendKeysElement(passwordField,password);
    }
    public void clickFinshBtn(){
        clickElement(finishBtn);
    }
    public void controlSingOutSuccesfull (){
        Assert.assertTrue(isDisplayed(singOutSuccesfull));
    }

}
