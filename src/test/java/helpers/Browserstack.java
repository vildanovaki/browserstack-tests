package helpers;

import config.AppConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static AppConfig credentials =
            ConfigFactory.create(AppConfig.class);

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(credentials.userName(), credentials.password())
                .when()
                .get(credentials.browserstackSessions() + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}
