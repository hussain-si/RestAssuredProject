package org.project.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.project.config.BaseUrlConfig;

import static io.restassured.RestAssured.given;

public class TodoEndpoint {

    public Response getTodos() {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/todos")
                .then()
                .extract().response();
    }

    public Response getTodoById(int todoId) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/todos/{todoId}", todoId)
                .then()
                .extract().response();
    }

}
