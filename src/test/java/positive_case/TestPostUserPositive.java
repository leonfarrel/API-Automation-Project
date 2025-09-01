package positive_case;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TestPostUserPositive {

    @Test
    public void testPostUserPositive(){

        String valueNama = "Leon Farrel";
        String valueEmail = "leon1990@gmail.com";
        String valueGender ="male";
        String valueStatus ="active";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", valueNama);
        bodyObj.put("email", valueEmail);
        bodyObj.put("gender", valueGender);
        bodyObj.put("status", valueStatus);

        RestAssured.given()
                .header("Authorization", "Bearer 3df5a19b9214fbbfa6746286a8f7ea655592fa87c5b55d1b09b2ff7c7732bd7a")
                .contentType("application/json")
                .accept("application/json")
                .body(bodyObj.toString())
                .when()
                .post(" https://gorest.co.in/public/v2/users")
                .then().log().all()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(valueNama));

    }

    @Test
    public void testGetPostedUserPositive(){

        RestAssured.given()
                .header("Authorization", "Bearer 3df5a19b9214fbbfa6746286a8f7ea655592fa87c5b55d1b09b2ff7c7732bd7a")
                .when().get("https://gorest.co.in/public/v2/users/8097968")
                .then().log().all()
                .assertThat().statusCode(200);
    }


}
