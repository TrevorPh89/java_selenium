import Pages.MainPage;
import org.junit.Assert;
import org.junit.Test;

public class MainPage_Test extends BaseTest{
    private static final String SITE = "http://www.cnn.com/";
    private static String searchRequestText = new String();


    @Test
    public void searchResultsDisplayed(){
        searchRequestText = "NFL";
        MainPage mainpage = new MainPage(driver);
        mainpage.goToSite(SITE);
        mainpage.clickSearchFinder();
        mainpage.inputTextInSearchField(searchRequestText);
        mainpage.clickSearchButton();
        Assert.assertTrue("Results were not found!",(mainpage.getSearchResults().size() > 1));
    }

    @Test
    public void noSearchResultsDisplayed(){
        searchRequestText = "NFLFake";
        MainPage mainpage = new MainPage(driver);
        mainpage.goToSite(SITE);
        mainpage.clickSearchFinder();
        mainpage.inputTextInSearchField(searchRequestText);
        mainpage.clickSearchButton();
        Assert.assertEquals(String.format("Your search for %s did not match any documents.",searchRequestText),mainpage.getTextOfNoResultsLabel());

    }
}
