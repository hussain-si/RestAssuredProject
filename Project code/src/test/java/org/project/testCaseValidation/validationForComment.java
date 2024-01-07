package org.project.testCaseValidation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.project.config.testDataProvider;
import org.project.endpoint.CommentEndpoint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class validationForComment {
    private CommentEndpoint comments = new CommentEndpoint();

    @Test
    public void testGetComments() {
        Response response = comments.getComments();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("id").size() > 0); // Ensure a list of comments is returned

    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void testGetCommentById(int commentId) {

        Response response = comments.getCommentById(commentId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), commentId);

    }

}
