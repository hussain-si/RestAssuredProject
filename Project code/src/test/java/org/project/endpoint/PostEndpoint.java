package org.project.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.project.config.BaseUrlConfig;

import static io.restassured.RestAssured.given;

public class PostEndpoint {

    public Response getPosts() {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/posts")
                .then()
                .extract().response();
    }

    public Response getPostById(int postId) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/posts/{postId}", postId)
                .then()
                .extract().response();
    }

    public Response createPost(String newPost) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .extract().response();
    }

    public Response updatePost(int postId, String updatedPost) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .body(updatedPost)
                .when()
                .put("/posts/{postId}", postId)
                .then()
                .extract().response();
    }

    public Response deletePost(int postId) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .when()
                .delete("/posts/{postId}", postId)
                .then()
                .extract().response();
    }
}
