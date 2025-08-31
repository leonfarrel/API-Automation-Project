package negative_case;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestPatchUserNegative {

    @Test
    public void testPatchUserNegative(){

        String updateName = " ";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", updateName);

        RestAssured.given()
                .header("Authorization", "Bearer 3df5a19b9214fbbfa6746286a8f7ea655592fa87c5b55d1b09b2ff7c7732bd7a")
                .contentType("application/json")
                .accept("application/json")
                .body(bodyObj.toString())
                .when()
                .patch("https://gorest.co.in/public/v2/users/8098381")
                .then().log().all()
                .assertThat().statusCode(422)
                .assertThat().body("field", Matchers.contains("name"))
                .assertThat().body("message", Matchers.contains("can't be blank"));
    }
}
