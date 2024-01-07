package org.project.testCaseValidation;

import io.restassured.response.Response;
import org.project.config.testDataProvider;
import org.project.endpoint.AlbumEndpoint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validationForAlbum {
    private AlbumEndpoint albums = new AlbumEndpoint();


    @Test
    public void testGetAlbums() {
        Response response = albums.getAlbums();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("id").size() > 0); // Ensure a list of albums is returned

    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void testGetAlbumById(int albumId) {

        Response response = albums.getAlbumById(albumId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), albumId);

    }
}
