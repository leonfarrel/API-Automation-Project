package negative_case;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;

public class TestGetUserNegative {

    @Test
    public void testGetSpecificUserNegative() {

        RestAssured
                .given().when().get("https://gorest.co.in/public/v2/users/312313123").then().log().all()
                .assertThat().statusCode(404)
                .assertThat().body("message", Matchers.equalTo("Resource not found"));
    }

    @Test
    public void testGetDeletedUser(){

        RestAssured
                .given().when().get("https://gorest.co.in/public/v2/users/8064466").then().log().all()
                .assertThat().statusCode(404)
                .assertThat().body("message", Matchers.equalTo("Resource not found"));

    }

}
