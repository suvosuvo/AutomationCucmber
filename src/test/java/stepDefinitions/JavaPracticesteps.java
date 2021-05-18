package stepDefinitions;

import BinaryTree.BinaryTreeNew;
import BinaryTree.Utility;
import Browser.LaunchBrowser;
import com.google.gson.internal.bind.util.ISO8601Utils;
import io.cucumber.datatable.DataTable;
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
    String Str = "This is a Beautiful is Alphanumeric String as a "+ RandomStringUtils.random(12, true, true);;
    String Rev = "";
    char c = (char)(new Random().nextInt(26) + 'a');


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
    @Then("Print Count the Number of Occurrences of a generic Character in a generic String")
    public void print_count_the_number_of_occurrences_of_a_generic_character_in_a_generic_string() {
        scenario.log(scenario.getName()+"\nPrint the Char Occurrence '"+c+"' in a generic String '"+Str+"'\n"
                +utility.getCountChrOccurrence(Str,c));
    }
    @Then("Print Count the Number of Vowel of a generic Character in a generic String")
    public void print_count_the_number_of_vowel_of_a_generic_character_in_a_generic_string() {
        scenario.log(scenario.getName()+"\nPrint the Vowel occurrence in a generic String '"+Str+"'\n"
                +utility.getCountVowelOccurrence(Str.toLowerCase()));
    }
    @Then("Print delete duplicate string in a generic Character in a generic String")
    public void print_delete_duplicate_string_in_a_generic_character_in_a_generic_string() {
        scenario.log(scenario.getName()+"\nPrint the duplicate in a generic String '"+Str+"'\n"
                +utility.getDuplicateDelete(Str.toLowerCase()));
    }
    @Then("Print Date format for input date DDMMYYYY")
    public void print_date_format_for_input_date(DataTable dataTable) {
        List<Map<String,String>> row = dataTable.asMaps(String.class,String.class);
        Map<String,String> requestMap = new HashMap<>();
        requestMap.putAll(row.get(0));
        scenario.log(scenario.getName()+"\nPrint the Data Format String '"+requestMap.get("Date")+"'\n"
                +utility.getDataFormat(requestMap.get("Date").toLowerCase()));
    }

    @Then("count the array elements that divide the sum of other elements")
    public void count_the_array_elements_that_divide_the_sum_of_other_elements() {
        ArrayList<Object> arrayElementList = new ArrayList<Object>(Arrays.asList(
                new Random().nextInt(59-9)+1
                ,new Random().nextInt(79-9)+1
                ,new Random().nextInt(89-9)+1
                ,new Random().nextInt(99-9)+1
                ,new Random().nextInt(999-9)+1));

//        scenario.log(scenario.getName()+"\ncount the array elements "+arrayElementList.size()+" that divide the sum of other elements\n"
//                +utility.getCountElement(arrayElementList));
    }


    @After
    public void teardown(){
        this.scenario = scenario;
        scenario.log(scenario.getName());
        scenario.log(scenario.getName());
        scenario.log(binaryTreeNew.toString());

    }


}
