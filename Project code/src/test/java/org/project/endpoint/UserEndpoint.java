package org.project.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.project.config.BaseUrlConfig;

import static io.restassured.RestAssured.given;

public class UserEndpoint {

    public Response getUsers() {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .extract().response();
    }

    public Response getUserById(int userId) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/users/{userId}", userId)
                .then()
                .extract().response();
    }

    public Response createUser(String newUser) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .body(newUser)
                .when()
                .post("/users")
                .then()
                .extract().response();
    }

    public Response updateUser(int userId, String updatedUser) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .body(updatedUser)
                .when()
                .put("/users/{userId}", userId)
                .then()
                .extract().response();
    }

    public Response deleteUser(int userId) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .when()
                .delete("/users/{userId}", userId)
                .then()
                .extract().response();
    }
}
