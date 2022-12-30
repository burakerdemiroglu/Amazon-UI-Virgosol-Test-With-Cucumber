package VCase.step_def;

import VCase.Pages.*;
import VCase.utils.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonSteps {
    Helper _helper;
    HomePage _homepage;
    LoginPage _loginpage;
    ListPage _listpage ;
    SearchPage _searchpage;
    ProductPage _productpage;



    public AmazonSteps() {
        _helper = new Helper();
        _homepage = new HomePage();
        _loginpage = new LoginPage();
        _listpage =new ListPage();
        _searchpage=new SearchPage();
        _productpage=new ProductPage();
    }

    @Given("I visit {string}")
    public void iVisit(String url) {
        _helper.navigateToUrl("https://www.amazon.com.tr/");
    }

    @And("I check that the home page is opened")
    public void iCheckThatTheHomePageIsOpened() {
        _homepage.isHomePageOpened();
    }

    @And("I choose Accept Cookies from the cookie preferences")
    public void iChooseAcceptCookiesFromTheCookiePreferences() {
        _homepage.clickAcceptCookiBtn();
    }

    @And("I login with {string} and {string}")
    public void iLoginWithAnd(String email, String password) {
        _homepage.hoverAccount();
        _homepage.clickSingInButtn();
        _loginpage.typeEmail(email);
        _loginpage.clickContiuneBtn();
        _loginpage.typepassword(password);
        _loginpage.clickFinshBtn();
    }

    @And("I check that successfully login")
    public void iCheckThatSuccessfullyLogin() {
        _homepage.hoverAccount();
        _homepage.clickOutBttn();
    }

    @And("I am creating a new list called {string} from the My Account section")
    public void iAmCreatingANewListCalledFromTheMyAccountSection(String listname) {
        _homepage.hoverAccount();
        _homepage.clickCreateListBtn();
        _listpage.clickClearListArena();
        _listpage.typeListName(listname);
        _listpage.clickSubmitBtn();
    }

    @And("I choose {string} from the categories field next to the search button")
    public void iChooseFromTheCategoriesFieldNextToTheSearchButton(String category) {
        _homepage.ClickSearchDropDownBtn();
        _homepage.choosekSearchDropDown(category);
    }

    @And("I checking that the {string} category is selected")
    public void iCheckingThatTheCategoryIsSelected(String category) {
        _homepage.searchCategoryControl(category);
    }

    @And("I type {string} in the search field and click the search button")
    public void iTypeInTheSearchFieldAndClickTheSearchButton(String searchKeyword) {
        _homepage.clickSearchTextBox(searchKeyword);
        _homepage.clickSearchSubmitBtn();
    }

    @And("I checking that {string} successfully listed")
    public void iCheckingThatSuccessfullyListed(String searchKeyword) {
        _searchpage.isSearchKeywordListed(searchKeyword);
    }

    @And("I open the {string} page from the search results page")
    public void iOpenThePageFromTheSearchResultsPage(String pageNumber) {
        _searchpage.selectPageFromPagination(pageNumber);
    }

    @And("I check that page {string} is opened from the search results page")
    public void iCheckThatPageIsOpenedFromTheSearchResultsPage(String pageNumber) {
        _searchpage.IsPageSelected(pageNumber);
    }

    @And("I add the {string} product on the page to the created {string} list")
    public void iAddTheProductOnThePageToTheCreatedList(String productNumber, String listname) {
        _searchpage.selectProductFromSearchList(productNumber);
        _productpage.addProductToList(listname);
    }

    @And("I checking if the product has been added to the list")
    public void iCheckingIfTheProductHasBeenAddedToTheList() {
        _productpage.isProductAddedToList();
        _productpage.clickContinueShopping();
    }

    @And("I go to the {string} page")
    public void iGoToThePage(String listname) throws InterruptedException {
        _homepage.hoverAccount();
        Thread.sleep(2000);
        _homepage.clickAccountTabListName(listname);
    }

    @And("I check that the {string} page opens")
    public void iCheckThatThePageOpens(String listname) {
        _listpage.checkProfilListName(listname);
    }

    @And("I remove the added product from the {string}")
    public void iRemoveTheAddedProductFromThe(String listname) {
        _listpage.checkProfilListName(listname);
        _listpage.clickDeleteBtn();
    }

    @And("I check if the product has been deleted from the list")
    public void iCheckIfTheProductHasBeenDeletedFromTheList() {
        _listpage.isRemovCheck();
    }

    @When("I logout of account")
    public void iLogoutOfAccount() throws InterruptedException {
        _homepage.hoverAccount();
        _homepage.singOutControlBtn();
    }

    @Then("I check that the logout was successful")
    public void iCheckThatTheLogoutWasSuccessful() {
        _loginpage.controlSingOutSuccesfull();
    }
}
