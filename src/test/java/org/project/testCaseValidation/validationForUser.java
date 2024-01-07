package org.project.testCaseValidation;

import io.restassured.response.Response;
import org.project.config.testDataProvider;
import org.project.endpoint.UserEndpoint;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class validationForUser {


    private UserEndpoint users = new UserEndpoint();

    @Test
    public void getUsersTest() {
        Response response = users.getUsers();

        // ... assertions
        Assert.assertEquals(response.statusCode(), 200); // Verify successful response
        Assert.assertTrue(response.jsonPath().getList("id").size() > 0); // Ensure a list of users is returned


    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void getUserByIdTest(int userId) {
        Response response = users.getUserById(userId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), userId);
    }

    @Test(dataProvider = "createUserData", dataProviderClass = testDataProvider.class)
    public void createUserTest(String name, String username, String email) {
        String newUser = "{\"name\": \"" + name + "\", \"username\": \"" + username + "\", \"email\": \"" + email + "\"}";
        Response response = users.createUser(newUser);
        Assert.assertEquals(response.statusCode(), 201); // Verify successful creation
        Assert.assertNotNull(response.jsonPath().getString("id")); // Ensure a new user ID is assigned


    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void updateUserTest(int userId) {
        String updatedEmail = "Test4567@gmail.com";
        Response response = users.updateUser(userId, "{\"email\": \"" + updatedEmail + "\"}");
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("email"), updatedEmail); // Check if email was updated successfully


    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void deleteUserTest(int userId) {
        Response response = users.deleteUser(userId);
        Assert.assertEquals(response.statusCode(), 200);


    }
}
