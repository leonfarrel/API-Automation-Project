package positive_case;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestPutUserPositive {

    @Test
    public void testPutUserPositive(){

        String updateName = "Rei Shengg";
        String updateEmail = "reishengg@gmail.com";
        String updateGender = "female";
        String updateStatus = "inactive";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", updateName);
        bodyObj.put("email", updateEmail);
        bodyObj.put("gender", updateGender);
        bodyObj.put("status", updateStatus);

        RestAssured.given()
                .header("Authorization", "Bearer 3df5a19b9214fbbfa6746286a8f7ea655592fa87c5b55d1b09b2ff7c7732bd7a")
                .contentType("application/json")
                .accept("application/json")
                .body(bodyObj.toString())
                .when()
                .put("https://gorest.co.in/public/v2/users/8098386")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
