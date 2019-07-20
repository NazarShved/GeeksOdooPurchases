package test;

import com.github.javafaker.Faker;
import com.pages.PurchasesPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Conditions;
import utilities.ConsAPI;
import utilities.DriverSetup;

import java.util.List;

public class Nazar extends BaseTest{


    @Test(groups = {"smokeTest"})
    public void searchFunctionalityTest(){
        //Input an acceptable word to the search field and press Enter #116

        purchases.switchTab("Products");
        String testInput = config.getProperty("testSearchInput");
        purchases.search(testInput);

        //check if all list elements(search results) contain the searchable word
        assertThat(Conditions.textToBePresentInElementsLocatedIgnoreCase(byCss(".o_kanban_record_title"), testInput));
        //verify that a closable block containing a search value is present
        assertThat(Conditions.textToBePresentInElementLocatedIgnoreCase(byXpath("(//*[@class = 'o_facet_values']/span)[2]"), testInput));
    }

    @Test(groups = {"smokeTest"})
    public void dropDownTest(){
        //#126 Display/Hide advanced search options

        WebElement advencedSearchOptions = getWebDriver().findElement(purchases.searchOptinsTab);
        if (!advencedSearchOptions.isDisplayed()) purchases.showHideSearchFilters();
        assertThat(ExpectedConditions.visibilityOf(advencedSearchOptions));
        purchases.showHideSearchFilters();
        assertThat(ExpectedConditions.invisibilityOf(advencedSearchOptions));

    }

}


