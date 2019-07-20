package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Vusal extends BaseTest{
    @Test(groups = {"smokeTest"})
    public void kanbanListTest() {
        //Display results in Canban or list view

        purchases.resultsAsCanban();
        Assert.assertTrue($$(purchases.resultsInList).size()==0);
        purchases.resultsAsList();
        Assert.assertTrue($$(purchases.resultsInCanban).size()==0);
    }

}
