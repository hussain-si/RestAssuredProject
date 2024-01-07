package org.project.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.project.config.BaseUrlConfig;

import static io.restassured.RestAssured.given;

public class CommentEndpoint {

    public Response getComments() {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/comments")
                .then()
                .extract().response();
    }

    public Response getCommentById(int commentId) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/comments/{commentId}", commentId)
                .then()
                .extract().response();
    }
}
