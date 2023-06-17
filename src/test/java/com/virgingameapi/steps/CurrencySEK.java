package com.virgingameapi.steps;

import com.virgingameapi.constants.EndPoints;
import com.virgingameapi.constants.Path;
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
public class CurrencySEK {

    @Title("This is method to verify the Currency = SEK")
    @Test
    public void sekCurrencyVarification() {
        ValidatableResponse response = SerenityRest.given().log().all()
                .queryParam("currency", "SEK")
                .when()
                .get(Path.RESOURCE + EndPoints.BINGO)
                .then().log().all().statusCode(200);
        String actualResult = response.extract().path("data.pots[1].currency");
        Assert.assertEquals("SEK",actualResult);

    }

}
