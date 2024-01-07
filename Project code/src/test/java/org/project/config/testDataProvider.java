package org.project.config;

import org.testng.annotations.DataProvider;

public class testDataProvider {
    @DataProvider
    public static Object[][] createUserData() {
        return new Object[][]{
                {"Hussain", "Hussain123", "Hussain@gmail.com"},
                {"Minkesh", "Minkesh456", "Minkesh@gmail.com"},
        };
    }

    @DataProvider(name = "data")
    public Object[][] commentIds() {
        return new Object[][] {
                {1},
                {2}
        };
    }
    @DataProvider(name = "createPostTest", parallel = true)
    public Object[][] provideTestData() {
        return new Object[][] {
                {"New Post", "This is a new post", 1},

        };
    }

}
