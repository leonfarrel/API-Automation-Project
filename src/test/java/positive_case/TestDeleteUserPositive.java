package positive_case;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestDeleteUserPositive {

    @Test
    public void testDeleteUserPositive() {

        RestAssured.given()
                .header("Authorization", "Bearer ")
                .when().delete("https://gorest.co.in/public/v2/users/8064466")
                .then().log().all()
                .assertThat().statusCode(204);
    }

}
