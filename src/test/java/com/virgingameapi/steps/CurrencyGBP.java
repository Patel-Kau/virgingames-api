package com.virgingameapi.steps;

import com.virgingameapi.constants.EndPoints;
import com.virgingameapi.constants.Path;
import com.virgingameapi.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Kaushik Patel
 */
@RunWith(SerenityRunner.class)
public class CurrencyGBP extends TestBase {
    @Title("This is method to verify the Currency = GBP")
    @Test
    public void poundCurrencyVarification() {
        ValidatableResponse response = SerenityRest.given().log().all()
                .queryParam("currency", "GBP")
                .when()
                .get(Path.RESOURCE + EndPoints.BINGO)
                .then().log().all().statusCode(200);
        String actualResult = response.extract().path("data.pots[2].currency");
        Assert.assertEquals("GBP",actualResult);




    }

}
