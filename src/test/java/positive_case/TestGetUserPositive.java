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
                .given().when().get("https://gorest.co.in/public/v2/users/8063901").then().log().all()
                .assertThat().statusCode(200);
    }
}
