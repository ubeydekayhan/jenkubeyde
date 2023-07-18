package base_urls;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static utilities.TokenGenerator.*;

public class Managementonschool_base {
    public static RequestSpecification specAdmin,specTeacher,specDean,specViceDean,specGuest, specStudent;

    public static void setUpApi(){
        specAdmin = new RequestSpecBuilder().
                addHeader("Authorization",generateTokenAdmin()).setContentType(ContentType.JSON).
                setAccept(ContentType.JSON).
                setBaseUri("https://managementonschools.com/app").
                build();

        specTeacher = new RequestSpecBuilder().
                addHeader("Authorization",generateTokenTeacher()).setContentType(ContentType.JSON).
                setAccept(ContentType.JSON).
                setBaseUri("https://managementonschools.com/app").
                build();

        specDean = new RequestSpecBuilder().
                addHeader("Authorization",generateTokenDean()).setContentType(ContentType.JSON).
                setAccept(ContentType.JSON).
                setBaseUri("https://managementonschools.com/app").
                build();

        specViceDean = new RequestSpecBuilder().
                addHeader("Authorization",generateTokenViceDean()).
                setContentType(ContentType.JSON).setAccept(ContentType.JSON).setBaseUri("https://managementonschools.com/app").
                build();
        specGuest = new RequestSpecBuilder().
                addHeader("Authorization",generateTokenAdmin()).
                setBaseUri("https://managementonschools.com/app").setContentType(ContentType.JSON).
                build();


        specStudent = new RequestSpecBuilder().
                addHeader("Authorization",generateTokenStudent()).
                setBaseUri("https://managementonschools.com/app").setContentType(ContentType.JSON).

                build();
}

}
