package com.digital.asserts;

import com.digital.entities.User;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

@Slf4j
public class ApiAssert {
    Response actualResponse;

    public ApiAssert(Response response) {
        this.actualResponse = response;
    }

    public static ApiAssert assertThat(Response actualResponse) {
        ApiAssert apiAssert = new ApiAssert(actualResponse);
        log.warn("Checking following response: {}", actualResponse.toString());
        return apiAssert;
    }

    public ApiAssert isCorrectStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, this.actualResponse.getStatusCode());
        log.info("Status code is correct, Expected: {}, Actual {}"
                , expectedStatusCode, this.actualResponse.getStatusCode());
        return this;
    }

    public UserAssert assertUser(User user) {
        return new UserAssert(user);
    }
}
