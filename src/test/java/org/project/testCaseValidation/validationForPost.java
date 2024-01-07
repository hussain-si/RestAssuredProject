package org.project.testCaseValidation;

import io.restassured.response.Response;
import org.project.config.testDataProvider;
import org.project.endpoint.PostEndpoint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validationForPost {
    private PostEndpoint posts = new PostEndpoint();

    @Test
    public void getPostsTest() {
        Response response = posts.getPosts();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getList("id").size(), 100);
    }

    @Test(dataProvider = "createPostTest", dataProviderClass = testDataProvider.class)
    public void createPostTest(String title, String body, int userId) {
        String newPost = "{\"title\": \"" + title + "\", \"body\": \"" + body + "\", \"userId\": " + userId + "}";
        Response response = posts.createPost(newPost);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertNotNull(response.jsonPath().getString("id"));
    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void getPostByIdTest(int postId) {
        Response response = posts.getPostById(postId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), postId);
    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void updatePostTest(int postId) {
        String updatedTitle = "Updated Post Title";
        Response response = posts.updatePost(postId, "{\"title\": \"" + updatedTitle + "\"}");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), updatedTitle);
    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void deletePostTest(int postId) {

        Response response = posts.deletePost(postId);
        Assert.assertEquals(response.statusCode(), 200);

    }

}
