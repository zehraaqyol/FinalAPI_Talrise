package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;

import java.util.Map;
import java.util.Objects;

public class Login {

    Response response;
    static String firstName;
    static String email;
    static String token;

    public void loginRequest(){


        String loginBody = "{\n" +
                "  \"email\": \"Lionel@yopmail.com\",\n" +
                "  \"password\": \"Test123456!\"\n" +
                "}";


        response = RestAssured.given().contentType(ContentType.JSON).
                body(loginBody).log().all().
                when().post("auth/login").prettyPeek();



        //Method 2: Jsonpath() metodu

        JsonPath js = response.jsonPath();

        firstName=js.getString("data.firstName");
        email=js.getString("data.email");

        //firstName=response.jsonPath().getString("data.firstName");  // JsonPath metodu ile yukarıda sadeleştirik
        //email=response.jsonPath().getString("data.email");
    }

    public void verifyBody(int statusCode){

        Assert.assertEquals(statusCode, response.statusCode());
        //Assert.assertEquals("Lionel",firstName);
        //Assert.assertEquals("Lionel@yopmail.com",email);


        //Method 1: asString.contains() //Tavsiye edilmiyor. "Lion" asıl doğrulamak istediğimiz yer dışında bir yerde olabilir.
                                        //Sonuç bizi bu nedenle yanıltabilir.

        //Assert.assertTrue(response.asString().contains("Lion"));

        //Method 3: path() metodu
        //String actualFirstName = response.path("data.firstName");
        //Assert.assertEquals("Lionel", actualFirstName);

        //Method 4: de serialization to collection
        Map<String, Object>login = response.as(Map.class);
        System.out.println("login" + login);

        System.out.println(((Map<String,Object>)login.get("data")).get("firstName"));
        Assert.assertEquals("Lionel", ((Map<String,Objects>)login.get("data")).get("firstName"));

    }

    //method 5 hemcrest matchers
    public void hamcrestLogin(){

        String loginBody="{\n" +
                "  \"email\": \"Lionel@yopmail.com\",\n" +
                "  \"password\": \"Test123456!\"\n" +
                "}";

        RestAssured.given().contentType(ContentType.JSON)
                .body(loginBody)
                .when().log().all()
                .post("auth/login")
                .then().statusCode(200)
                .and().contentType(equalTo("application/json"))
                .body("data.firstName", equalTo("Lionel"),
                        "data.lastName",equalTo("Effertz"),
                        "data.roles[0]",equalTo("USER"));



    }
}



