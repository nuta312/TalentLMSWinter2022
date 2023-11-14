package com.digital.asserts;

import com.digital.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
@Slf4j
public class UserAssert {
    User actualUser;

    public UserAssert(User actualUser) {
        this.actualUser = actualUser;
    }

    public UserAssert isCorrectName(String expectedName) {
        Assert.assertEquals(actualUser.getFirstName(), expectedName);
        log.info("Name is correct, Expected {}, Actual {}", expectedName, actualUser.getFirstName());
        return this;
    }

    public UserAssert isCorrectLastName(String expectedLastName){
        Assert.assertEquals(actualUser.getLastName(), expectedLastName);
        log.info("LastName is correct, expected {}, Actual {}", expectedLastName, actualUser.getLastName());
        return this;
    }


}
