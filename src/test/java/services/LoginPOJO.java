package services;

import Pojo.Data;
import Pojo.PojoLogin;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigurationReader;


public class LoginPOJO {

    Response response;

    public  void pojoLogin(){

        String email= ConfigurationReader.get("email");
        String password=ConfigurationReader.get("commonPassword");

        PojoLogin pojoLogin= new PojoLogin(email,password);

        response= RestAssured.given().contentType(ContentType.JSON)
                .body(pojoLogin).log().all()
                .when().post("auth/login").prettyPeek();
    }

    public void verifyPOJO(){
        Data data= response.as(Data.class);

        Assert.assertEquals(200,response.statusCode());

       Assert.assertEquals("Lion", data.getData().getFirstName());

       Assert.assertEquals("Writtenstone", data.getData().getLastName());

    }














}
