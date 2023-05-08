package com.digital.ui.pages.usersHP.course;

import com.digital.ui.driver.Driver;
import org.bouncycastle.crypto.modes.EAXBlockCipher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Asserts {

    public static void assertEqualsCourse(String expected, String actual){
            assertEquals(expected, actual);
    }
}

