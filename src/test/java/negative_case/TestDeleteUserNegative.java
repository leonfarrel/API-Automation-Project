package negative_case;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TestDeleteUserNegative {

    @Test
    public void testUserThatIsAlreadyDeleted(){
        RestAssured.given()
                .header("Authorization", "Bearer 3df5a19b9214fbbfa6746286a8f7ea655592fa87c5b55d1b09b2ff7c7732bd7a")
                .when().delete("https://gorest.co.in/public/v2/users/8063049")
                .then().log().all()
                .assertThat().statusCode(404)
                .assertThat().body("message", Matchers.equalTo("Resource not found"));
    }
}
