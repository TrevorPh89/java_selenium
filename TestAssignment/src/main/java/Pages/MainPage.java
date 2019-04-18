package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MainPage extends BasePage {

    @FindBy(id = "search-button")
    private WebElement searchFinder;

    @FindBy(id = "search-input-field")
    private WebElement searchField;

    @FindBy(id = "submit-button")
    private WebElement searchButton;

    private String noResultsLabel = "//div[@class='cnn-search__no-results no-results--returned']/h3";
    private String searchResult = "//div[@class='cnn-search__result cnn-search__result--article']";

    public MainPage(WebDriver driver){
        super(driver);
    }


    public MainPage goToSite(String site) {
        driver.get(site);
        return this;
    }

    public MainPage clickSearchFinder() {
        searchFinder.click();
        return this;
    }

    public MainPage inputTextInSearchField(String searchString) {
        searchField.sendKeys(searchString);
        return this;
    }

    public MainPage clickSearchButton() {
        searchButton.click();
        return this;
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.xpath(searchResult));
    }

    public String getTextOfNoResultsLabel() {
        return driver.findElement(By.xpath(noResultsLabel)).getText();
    }

}
