package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Conditions;

public class Vusal extends BaseTest{
    @Test(groups = {"smokeTest"})
    public void kanbanListTest() {
        //Display results in Canban or list view

        purchases.resultsAsCanban();
        Assert.assertTrue($$(purchases.resultsInList).size()==0);
        purchases.resultsAsList();
        Assert.assertTrue($$(purchases.resultsInCanban).size()==0);
    }
    @Test
    public void searchingVendorCompany() throws InterruptedException {
        purchases.switchTab("Vendors");
        WebElement createButton = $x("//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']");
        //Thread.sleep(3000);
        createButton.click();

        //$x(byXpath("//input[@class='o_input ui-autocomplete-input']")).click();
        $(purchases.saveButton).click();
        // assertThat(ExpectedConditions.visibilityOfElementLocated(byCss(".o_notification.undefined.o_error")));
        assertThat(Conditions.textToBePresentInElementLocatedIgnoreCase(byCss(".o_notification_title"),
                "The following fields are invalid:"));
        assertThat(ExpectedConditions.invisibilityOfElementLocated(byCss(".o_notification_title")));
    }

}
