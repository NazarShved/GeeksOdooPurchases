package testCases;


import org.testng.annotations.Test;
import utilities.Conditions;


public class Aigerim extends BaseTest {


    @Test(groups = {"smokeTest"})
    public void VendorBills() throws InterruptedException {


        purchases.switchTab("Vendors");
        // locating create link
        $(".btn.btn-primary.btn-sm.o-kanban-button-new.btn-default").click();
        // typing the name in the nameBox
        inputToAfield(byCss(".o_field_char.o_field_widget.o_input.o_required_modifier"), "Tester1");
        // locating create button on the buttom of the page
        $(".btn.btn-primary.btn-sm.o-kanban-button-new").click();
        // creating contactName
        String inp = config.getProperty("contactName");
        inputToAfield(byXpath("(//input[@class='o_field_char o_field_widget o_input o_required_modifier'])[2]"), inp);
        // locating titleLink
        $get(byCss(".o_input.ui-autocomplete-input"), 14).click();
        // selecting IT title
        $get(byCss(".ui-menu-item"), 6).click();
        // typing phoneNumber
        inputToAfield(byXpath("(//input[@class='o_field_phone o_field_widget o_input'])[3]"), config.getProperty("phoneNumber"));
        // making note for a new contact
        inputToAfield(byXpath("(//textarea[@class='o_field_text o_field_widget o_input'])[2]"), config.getProperty("note"));
        // selecting save & close button
        $x("(//button[@class='btn btn-sm btn-primary'])[1]").click();

        assertThat(Conditions.textToBePresentInElementLocatedIgnoreCase(byCss(".oe_kanban_details"),inp));

    }
}
