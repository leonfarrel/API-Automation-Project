package positive_case;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

public class TestGetUserPositive {

    @Test
    public void testGetUserPositive(){

        RestAssured
                .given().when().get("https://gorest.co.in/public/v2/users").then().log().all()
                .assertThat().statusCode(200);
    }


    @Test
    public void testGetSpecificUserPositive(){

        RestAssured
                .given()
                .header("Authorization", "Bearer 3df5a19b9214fbbfa6746286a8f7ea655592fa87c5b55d1b09b2ff7c7732bd7a")
                .when().get("https://gorest.co.in/public/v2/users/8097968").then().log().all()
                .assertThat().statusCode(200);
    }
}
