package org.project.testCaseValidation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.project.config.testDataProvider;
import org.project.endpoint.PhotosEndpoint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class validationForPhotos {

    private PhotosEndpoint photos = new PhotosEndpoint();

    @Test
    public void testGetPhotos() {
        Response response = photos.getPhotos();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("id").size() > 0); // Ensure a list of photos is returned

    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void testGetPhotoById(int photoId) {

        Response response = photos.getPhotoById(photoId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), photoId);

    }
}
