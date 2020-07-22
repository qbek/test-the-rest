package com.github.qbek;

import static com.github.qbek.aux.FileSave.saveToFile;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.github.qbek.aux.FileSave;
import com.github.qbek.aux.UserData;
import com.github.qbek.aux.UserPrivateData;
import io.restassured.RestAssured;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class RestTest
{
    @Before
    public void setup () {
        RestAssured.baseURI = "http://localhost:1080";
    }


    @Test
    public void returnsUserDetails() throws IOException {
//        when().get("/user/jakub")
//        .then().log().all().and();
//                .body("firstname", equalTo("Jakub"))
//                .body("lastname", equalTo("Szewczyk"))
//                .body("$", not(hasKey("pesel")));

//        UserData user = get("/user/janusz").as(UserData.class);
//        assertThat("Firstname is correct", user.getFirstname(), equalTo("Jakub"));
//        assertThat("no hobby", user.getHobby(), nullValue());
        Response response = get("/user/janusz");
        saveToFile(response);
    }

    @Test
    public void returnsUserPrivateDetails() {
//        /user/jakub/priv: {
//            firstname: "Jakub",
//            lastname: "Szewczyk",
//            pesel: "1234567890",
//            city: "Lodz",
//            street: "Jaracza"
//        }
//        UserPrivateData privData = get("/user/jakub/priv").as(UserPrivateData.class);
        when()
                .get("/user/jakub/priv")
        .then().log().all()
                .body("firstname", equalTo("Jakub"))
                .body("lastname", equalTo("Szewczyk"))
                .body("pesel", equalTo("1234567890"))
                .body("city", equalTo("Lodz"));

    }
}
