package org.project.testCaseValidation;

import io.restassured.response.Response;
import org.project.config.testDataProvider;
import org.project.endpoint.TodoEndpoint;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validationForTodo {
    private TodoEndpoint todos = new TodoEndpoint();

    @Test
    public void testGetTodos() {
        Response response = todos.getTodos();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("id").size() > 0); // Ensure a list of todos is returned
    }

    @Test(dataProvider = "data", dataProviderClass = testDataProvider.class)
    public void testGetTodoById(int todoId) {
        Response response = todos.getTodoById(todoId);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), todoId);

    }
}
