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
                .header("Authorization", "Bearer ")
                .contentType("application/json")
                .accept("application/json")
                .body(bodyObj.toString())
                .when()
                .patch("https://gorest.co.in/public/v2/users/8064437")
                .then().log().all()
                .assertThat().statusCode(422)
                .assertThat().body("field", Matchers.contains("name"))
                .assertThat().body("message", Matchers.contains("can't be blank"));
    }
}
