package negative_case;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestPutUserNegative {

    @Test
    public void testPutUserNegative(){

        String updateName = "Rei Shengg";
        String updateEmail = "reiz@gmail.com";
        String updateGender = "cewek";
        String updateStatus = "tidak aktif";

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
                .put("https://gorest.co.in/public/v2/users/8098381")
                .then().log().all()
                .assertThat().statusCode(422)
                .assertThat().body("field", Matchers.containsInAnyOrder("gender", "status"))
                .assertThat().body("message", Matchers.containsInAnyOrder("can't be blank",
                        "can't be blank, can be male of female"));
    }

    @Test
    public void testPutUserEmptyField(){
        String updateName = " ";
        String updateEmail = " ";
        String updateGender = " ";
        String updateStatus = " ";

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
                .put("https://gorest.co.in/public/v2/users/8098381")
                .then().log().all()
                .assertThat().statusCode(422)
                .assertThat().body("field", Matchers.containsInAnyOrder("email", "name", "gender", "status"))
                .assertThat().body("message", Matchers.containsInAnyOrder("can't be blank", "can't be blank",
                        "can't be blank","can't be blank, can be male of female"));

    }
}
