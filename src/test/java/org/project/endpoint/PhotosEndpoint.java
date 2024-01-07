package org.project.endpoint;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.project.config.BaseUrlConfig;

import static io.restassured.RestAssured.given;

public class PhotosEndpoint {

    public Response getPhotos() {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/photos")
                .then()
                .extract().response();
    }

    public Response getPhotoById(int photoId) {
        return given()
                .baseUri(BaseUrlConfig.BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .get("/photos/{photoId}", photoId)
                .then()
                .extract().response();
    }

}
