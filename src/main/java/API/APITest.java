package API;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class APITest {

    public String testAPI(String endPoint) {
        defaultParser = Parser.JSON;
        Response response = given().relaxedHTTPSValidation().
                when().
                get(endPoint).
                then().log().all().contentType(ContentType.JSON).extract().response();
                return response.prettyPrint();

    }
}
