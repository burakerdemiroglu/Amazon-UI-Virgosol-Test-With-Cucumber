package VCase.Pages;

import VCase.utils.Driver;
import VCase.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Helper {
    public SearchPage (){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//span[@class=\"a-color-state a-text-bold\"]")
    public WebElement searchProduct ;
    @FindBy(css = ".s-pagination-selected")
    public WebElement selectedPage;


    public void isSearchKeywordListed (String searchKeyword){
        Assert.assertEquals("\"" + searchKeyword + "\"", getText(searchProduct));
    }
    public void selectPageFromPagination(String pageNumber) {
        By pageLocator = By.xpath("//a[@aria-label='" + pageNumber + " sayfasına git']");
        clickElement(pageLocator);
    }
    public void IsPageSelected(String pageNumber) {
        Assert.assertEquals(pageNumber, getText(selectedPage));
    }
    public void selectProductFromSearchList(String productNumber) {
        By productLocator = By.xpath("//div[@data-index='" + productNumber + "']//img");
        clickElement(productLocator);
    }
}
