package negative_case;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestPostUserNegative {

    @Test
    public void testPostUserNegative(){

        String valueName = "Leon Farrel";
        String valueEmail = "wrong@gmail.com";
        String valueGender = "cowok";
        String valueStatus = "aktif";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name",valueName);
        bodyObj.put("email", valueEmail);
        bodyObj.put("gender", valueGender);
        bodyObj.put("status", valueStatus);

        RestAssured
                .given()
                .header("Authorization", "Bearer ")
                .contentType("application/json")
                .accept("application/json")
                .body(bodyObj.toString())
                .when()
                .post(" https://gorest.co.in/public/v2/users")
                .then().log().all()
                .assertThat().statusCode(422)
                .assertThat().body("field", Matchers.containsInAnyOrder("gender","status"))
                .assertThat().body("message",Matchers.containsInAnyOrder("can't be blank",
                        "can't be blank, can be male of female"));
    }

    @Test
    public void testPostUserEmptyField(){

        String valueName = " ";
        String valueEmail = " ";
        String valueGender = " ";
        String valueStatus = " ";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", valueName);
        bodyObj.put("email", valueEmail);
        bodyObj.put("gender", valueGender);
        bodyObj.put("status", valueStatus);

        RestAssured.given()
                .header("Authorization", "Bearer ")
                .contentType("application/json")
                .accept("application/json")
                .body(bodyObj.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then().log().all()
                .assertThat().statusCode(422)
                .assertThat().body("field", Matchers.containsInAnyOrder("email", "name","gender","status"))
                .assertThat().body("message", Matchers.containsInAnyOrder("can't be blank","can't be blank",
                        "can't be blank, can be male of female", "can't be blank"));
    }
}
