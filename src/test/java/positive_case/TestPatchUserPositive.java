package positive_case;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestPatchUserPositive {

    @Test
    public void testPatchUserPositive(){
        String updateName = "Leon QA Engineer";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", updateName);

        RestAssured.given()
                .header("Authorization", "Bearer ")
                .contentType("application/json")
                .accept("application/json")
                .body(bodyObj.toString())
                .when()
                .patch("https://gorest.co.in/public/v2/users/8064466")
                .then().log().all()
                .assertThat().statusCode(200);
    }
}
