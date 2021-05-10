package stepDefinitions;

import BinaryTree.BinaryTreeNew;
import BinaryTree.Utility;
import Browser.LaunchBrowser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.RandomStringUtils;

import java.util.*;

public class JavaPracticesteps extends LaunchBrowser {

    Utility utility = new Utility();
    BinaryTreeNew binaryTreeNew = new BinaryTreeNew();
    String Str = "This is a Beautiful Alphanumeric String as "+ RandomStringUtils.random(12, true, true);;
    String Rev = "";
    ArrayList<Object> arrayList = new ArrayList<Object>(Arrays.asList(
             RandomStringUtils.random(12, true, true)
            ,RandomStringUtils.random(15, true, true)
            ,RandomStringUtils.random(17, true, true)
            ,RandomStringUtils.random(8, true, true)
            ,RandomStringUtils.random(23, true, true)));

    ArrayList<Object> revArrayList = new ArrayList<Object>();
    HashMap<Object,Object> hashMap = new HashMap<Object,Object>();
    private Scenario scenario;

    @Before
    public void init(Scenario scenario){
        this.scenario = scenario;
        System.out.println(scenario.getName());
        scenario.log(scenario.getName());
        hashMap.put( RandomStringUtils.random(10, false, true)
                     ,RandomStringUtils.random(20, true, false));
        hashMap.put( RandomStringUtils.random(10, false, true)
                    ,RandomStringUtils.random(20, true, false));
        hashMap.put( RandomStringUtils.random(10, false, true)
                    ,RandomStringUtils.random(20, true, false));

    }


    @Given("I created Java String and Java Array List and HashMap")
    public void i_created_java_string() {
        scenario.log(scenario.getName()+Str+"\n");
        scenario.log(scenario.getName()+arrayList+"\n");
        scenario.log(scenario.getName()+hashMap+"\n");

    }
    @When("Make them reverse")
    public void make_them_reverse() {
        scenario.log(scenario.getName()+"\nString\n"+Str);
        Rev = utility.getRevString(Str);
        scenario.log(scenario.getName()+"\nArrayList\n"+arrayList);
        for(Object i : arrayList) {
            revArrayList.add(utility.getRevString(i.toString()));
        }

        scenario.log(scenario.getName()+"\nhashmap\n"+hashMap);
        Iterator it = hashMap.entrySet().iterator();
        // convert to ArrayList of key set
        List<Object> alKeys = new ArrayList<Object>(hashMap.keySet());
        Collections.reverse(alKeys);
        scenario.log(scenario.getName()+"\niterate Hashmap using reverse order of keys\n");
        for (Object strKey : alKeys) {
            scenario.log("Key : " + strKey + "\t\t"
                    + "Value : "
                    + hashMap.get(strKey));
        }
    }
    @Then("Print the all the reverse Java String and Java Array List and HashMap")
    public void print_the_string() {
        scenario.log(scenario.getName()+"\nMake the String Reverse\n"+Rev);
        scenario.log(scenario.getName()+"\nMake the ArrayList Reverse\n"+revArrayList);

    }
    @After
    public void teardown(){
        this.scenario = scenario;
        scenario.log(scenario.getName());
        scenario.log(scenario.getName());
        scenario.log(binaryTreeNew.toString());

    }


}
