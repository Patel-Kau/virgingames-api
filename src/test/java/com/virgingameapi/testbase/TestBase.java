package com.virgingameapi.testbase;


import com.virgingameapi.utils.PropertyReader;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

/**
 * Created by Kaushik Patel
 */
public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");

    }

}
