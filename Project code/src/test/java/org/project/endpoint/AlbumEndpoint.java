package org.project.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.project.config.BaseUrlConfig;
public class AlbumEndpoint {

    public Response getAlbums() {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/albums")
                .then()
                .extract().response();
    }

    public Response getAlbumById(int albumId) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/albums/{albumId}", albumId)
                .then()
                .extract().response();
    }

}
