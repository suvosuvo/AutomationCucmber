package stepDefinitions;

import BinaryTree.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Practicesteps {

    Utility utility = new Utility();
    BinaryTreeNew binaryTreeNew = new BinaryTreeNew();
    String Str = "This is a Beautiful String";
    String Rev = "";
    ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList("suvo","mouli","adrija","om",6908890,768346647,99087));
    ArrayList<Object> revArrayList = new ArrayList<Object>();
    HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
    private Scenario scenario;

    @Before
    public void init(Scenario scenario){
        this.scenario = scenario;
        System.out.println(scenario.getName());
        scenario.log(scenario.getName());
    }


    @Given("I created Java String")
    public void i_created_java_string() {
        System.out.println(Str);
        scenario.log(scenario.getName()+Str);
    }

    @When("Make them reverse")
    public void make_them_reverse() {
        scenario.log(scenario.getName()+"\nString\n"+Str);
        Rev = utility.getRevString(Str);
        scenario.log(scenario.getName()+"\nArrayList\n"+arrayList);
        for(Object i : arrayList) {
            revArrayList.add(utility.getRevString(i.toString()));
        }
//        hashMap.put("Shsah",122);
//        hashMap.put("wewe",87987);

    }
    @Then("Print the String")
    public void print_the_string() {
        scenario.log(scenario.getName()+"\nMake the String Reverse\n"+Rev);
        scenario.log(scenario.getName()+"\nMake the ArrayList Reverse\n"+revArrayList);
//        scenario.log(scenario.getName()+"\n"+hashMap);
    }
    @After
    public void teardown(){
        this.scenario = scenario;
        System.out.println(scenario.getName());
        scenario.log(scenario.getName());
        scenario.log(binaryTreeNew.toString());
    }


}
