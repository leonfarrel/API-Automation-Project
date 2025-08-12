package negative_case;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TestDeleteUserNegative {

    @Test
    public void testUserThatIsAlreadyDeleted(){
        RestAssured.given()
                .header("Authorization", "Bearer ")
                .when().delete("https://gorest.co.in/public/v2/users/8063049")
                .then().log().all()
                .assertThat().statusCode(404)
                .assertThat().body("message", Matchers.equalTo("Resource not found"));
    }
}
