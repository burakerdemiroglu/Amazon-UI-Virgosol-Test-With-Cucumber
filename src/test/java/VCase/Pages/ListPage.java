package VCase.Pages;

import VCase.utils.Driver;
import VCase.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListPage extends Helper {
    public ListPage (){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id="list-name")
    public WebElement clearListArea;
    @FindBy(id="wl-redesigned-create-list")
    public WebElement submitBtn;
    @FindBy(id="profile-list-name")
    public WebElement profilListName;
    @FindBy(name="submit.deleteItem")
    public WebElement deleteBtn;
    @FindBy(xpath = "//div[contains(text(),'Silindi')]")
    public WebElement removeCheck ;
    public void clickClearListArena(){
        clearElement(clearListArea);
    }
    public void typeListName(String listname){
        sendKeysElement(clearListArea,listname);
    }
    public void clickSubmitBtn(){
        clickElement(submitBtn);
    }
    public void checkProfilListName (String listname){
        Assert.assertEquals(listname,getText(profilListName));
    }
    public void clickDeleteBtn(){
        clickElement(deleteBtn);
    }
    public void isRemovCheck (){
        Assert.assertTrue(removeCheck.isDisplayed());
    }
}
