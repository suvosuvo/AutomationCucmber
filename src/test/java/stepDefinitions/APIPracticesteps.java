package stepDefinitions;

import API.APITest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIPracticesteps extends APITest {

    private Scenario scenario;

    @Before
    public void init(Scenario scenario){
        this.scenario = scenario;
        System.out.println(scenario.getName());
        scenario.log(scenario.getName());
    }

    @Given("Get Call from API")
    public void get_call_from_api(DataTable table) {

        List<Map<String,String>> row = table.asMaps(String.class,String.class);
        Map<String,String> requestMap = new HashMap<>();
        requestMap.putAll(row.get(0));
        scenario.log(scenario.getName()+"\nEndPoint\n"+testAPI(requestMap.get("EndPoint")));
    }

    @After
    public void teardown(Scenario scenario){
    }


}
