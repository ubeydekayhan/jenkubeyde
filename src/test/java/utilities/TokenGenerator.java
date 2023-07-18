package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TokenGenerator {
    public static void main(String[] args) {
        System.out.println(generateTokenAdmin());
    }
    public static String generateTokenAdmin(){
        String postBody = "{ \"password\": \""+ConfigReader.getProperty("AdminPassword")+"\"," +
                "  \"username\": \""+ConfigReader.getProperty("AdminUserName")+"\"\n" +"}";

        Response response = given().contentType(ContentType.JSON).body(postBody).post("https://managementonschools.com/app/auth/login");

        return response.jsonPath().getString("token");
    }
    public static String generateTokenViceDean(){
        String postBody = "{ \"password\": \""+ConfigReader.getProperty("ViceDeanUserPassword")+"\"," +
                "  \"username\": \""+ConfigReader.getProperty("ViceDeanUserName")+"\"\n" +"}";

        Response response = given().contentType(ContentType.JSON).body(postBody).post("https://managementonschools.com/app/auth/login");

        return response.jsonPath().getString("token");
    }

    public static String generateTokenTeacher(){
        String postBody = "{ \"password\": \""+ConfigReader.getProperty("TeacherPassword")+"\"," +
                "  \"username\": \""+ConfigReader.getProperty("TeacherUserName")+"\"\n" +"}";

        Response response = given().contentType(ContentType.JSON).body(postBody).post("https://managementonschools.com/app/auth/login");

        return response.jsonPath().getString("token");
    }
    public static String generateTokenDean(){
        String postBody = "{ \"password\": \""+ConfigReader.getProperty("DeanUserPassword")+"\"," +
                "  \"username\": \""+ConfigReader.getProperty("DeanUserName")+"\"\n" +"}";

        Response response = given().contentType(ContentType.JSON).body(postBody).post("https://managementonschools.com/app/auth/login");

        return response.jsonPath().getString("token");
    }


    public static String generateTokenStudent(){
        String postBody = "{ \"password\": \""+ConfigReader.getProperty("studentPassword")+"\"," +
                "  \"username\": \""+ConfigReader.getProperty("studentUsername")+"\"\n" +"}";

        Response response = given().contentType(ContentType.JSON).body(postBody).post("https://managementonschools.com/app/auth/login");

        return response.jsonPath().getString("token");
    }

}
