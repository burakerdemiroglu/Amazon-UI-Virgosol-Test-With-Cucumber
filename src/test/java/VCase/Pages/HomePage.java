package VCase.Pages;

import VCase.utils.Driver;
import VCase.utils.Helper;
import io.cucumber.java.bs.A;
import io.cucumber.java.zh_cn.假如;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Helper {
    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "nav-logo-sprites")
    public WebElement amazonLogo;
    @FindBy(id = "sp-cc-accept")
    public WebElement acceptCookieBtn;

    @FindBy(id = "nav-link-accountList")
    public WebElement accountList;
    @FindBy(xpath = "(//span[contains(text(),'Giriş yap')])[2]")
    public WebElement singInButton;
    @FindBy(id = "nav-item-signout")
    public WebElement singOutButton;
    @FindBy(xpath = "//span[contains(text(),'Liste Oluşturun')]")
    public WebElement createList;
    @FindBy(id="nav-search-dropdown-card")
    public WebElement searchDropDownBtn;
    @FindBy(id="searchDropdownBox")
    public  WebElement chooseCategory;
    @FindBy (id="nav-search-label-id")
    public WebElement searchCategory;
    @FindBy(id="twotabsearchtextbox")
    public WebElement searchTextBox;
    @FindBy(id="nav-search-submit-button")
    public WebElement searchSubmitBtn;



    public void isHomePageOpened() {
        Assert.assertTrue(amazonLogo.isDisplayed());
    }

    public void clickAcceptCookiBtn() {
        clickElement(acceptCookieBtn);
    }
    public void hoverAccount (){
        hoverElement(accountList);
    }
    public void clickSingInButtn(){
        clickElement(singInButton);
    }
    public void clickOutBttn (){
        Assert.assertTrue(singOutButton.isDisplayed());
    }
    public void clickCreateListBtn(){
        clickElement(createList);
    }
    public void ClickSearchDropDownBtn(){
        stalenessOfElementClick(searchDropDownBtn);
    }
    public void choosekSearchDropDown(String category){
        selectDropDown(chooseCategory,category);
    }
    public void searchCategoryControl(String category){
        Assert.assertEquals(category,getText(searchCategory));
    }

    public void clickSearchTextBox(String searchKeyword){
        sendKeysElement(searchTextBox,searchKeyword);
    }
    public void clickSearchSubmitBtn (){
        clickElement(searchSubmitBtn);
    }
    public void clickAccountTabListName(String listName) {
        By accountListName = By.xpath("//div[@id='nav-al-wishlist']//span[text()='" + listName + "']");
        clickElement(accountListName);
    }
    public void singOutControlBtn (){
        clickElement(singOutButton);
    }


}
