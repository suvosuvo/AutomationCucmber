package stepDefinitions;

import BinaryTree.*;
import Browser.LaunchBrowser;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.apache.commons.lang.RandomStringUtils;

import java.io.IOException;
import java.util.*;

public class WebPracticesteps extends LaunchBrowser {

    private Scenario scenario;

    @Before
    public void init(Scenario scenario){
        this.scenario = scenario;
        System.out.println(scenario.getName());
        scenario.log(scenario.getName());
    }

    @Given("open the Browser")
    public void open_the_browser(DataTable table){

        List<Map<String,String>> row = table.asMaps(String.class,String.class);
        Map<String,String> requestMap = new HashMap<>();
        requestMap.putAll(row.get(0));
        initiateBrowser(requestMap.get("SiteName"));
        scenario.log(scenario.getName()+"\nWeb Browser Title\n"+webDriver.getTitle());
    }
    @Then("store all Links")
    public void store_all_links() {
        scenario.log(scenario.getName()+"\nAll Links From WebSite\n"+getAllLinkFromBrowser());
        closeBrowser();
    }

    @Then("store all staticText")
    public void store_all_static_text() {
    }


    @After
    public void teardown(){

    }


}
