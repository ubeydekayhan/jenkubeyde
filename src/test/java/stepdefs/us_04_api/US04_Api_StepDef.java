package stepdefs.us_04_api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.DeanPojo;
import pojos.DeanResponsePojo;
import utilities.FakeProfile;

import static base_urls.Managementonschool_base.specAdmin;
import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;


public class US04_Api_StepDef {
    FakeProfile fakeProfile;
    DeanPojo deanPojo;
    Response response;
    DeanResponsePojo actualData;
    public static int deanUserIdMustafa;

    @Given("Post request for add dean with username={string}, name={string}, surname={string}, birthDay={string}, ssn={string}, birthPlace={string}, phoneNumber={string}, gender={string}, password={string}")
    public void post_request_for_add_dean_with_username_name_surname_birth_day_ssn_birth_place_phone_number_gender_password(String username, String name, String surname, String birthDay, String ssn, String birthPlace, String phoneNumber, String gender, String password) {
        specAdmin.pathParams("first", "dean", "second", "save");

        fakeProfile = new FakeProfile();
        username = fakeProfile.getUserName();
        name = fakeProfile.getName();
        surname = fakeProfile.getSurname();
        birthDay = "1953-12-11";
        ssn = fakeProfile.getSocialSecurityNumber();
        birthPlace = fakeProfile.getBirthPlace();
        phoneNumber = fakeProfile.getPhoneNumber();
        gender = fakeProfile.getGender();
        password = fakeProfile.getPassword();


        deanPojo = new DeanPojo(username, name, surname, birthDay, ssn, birthPlace, phoneNumber, gender, password);

        response = given(specAdmin).body(deanPojo).post("{first}/{second}");

        response.prettyPrint();

        actualData = response.as(DeanResponsePojo.class);

     //   assertEquals(200, response.statusCode());

        deanUserIdMustafa = actualData.getObject().getUserId();

    }

    @Then("verify addition")
    public void verify_addition() {
        String message = "Dean Saved";
        assertEquals(message, actualData.getMessage());
        assertEquals(200, response.statusCode());
        assertEquals("CREATED", actualData.getHttpStatus());


        assertEquals(deanPojo.getName(), actualData.getObject().getName());
        assertEquals(deanPojo.getSurname(), actualData.getObject().getSurname());
        assertEquals(deanPojo.getUsername(), actualData.getObject().getUsername());
        assertEquals(deanPojo.getBirthDay(), actualData.getObject().getBirthDay());
        assertEquals(deanPojo.getSsn(), actualData.getObject().getSsn());
        assertEquals(deanPojo.getBirthPlace(), actualData.getObject().getBirthPlace());
        assertEquals(deanPojo.getPhoneNumber(), actualData.getObject().getPhoneNumber());
        assertEquals(deanPojo.getGender(), actualData.getObject().getGender());
    }

    @Given("Post request {string} for add dean with empty field username={string}, name={string}, surname={string}, birthDay={string}, ssn={string}, birthPlace={string}, phoneNumber={string}, gender={string}, password={string}")
    public void post_request_for_add_dean_with_empty_field_username_name_surname_birth_day_ssn_birth_place_phone_number_gender_password(String username, String name, String surname, String birthDay, String ssn, String birthPlace, String phoneNumber, String gender, String password, String stepNo) {

        specAdmin.pathParams("f", "dean", "s", "save");

        fakeProfile = new FakeProfile();
        if (username.equals("")) {
            username = "";
        } else {
            username = fakeProfile.getUserName();
        }
        if (name.equals("")) {
            name = "";
        } else {
            name = fakeProfile.getName();
        }
        if (surname.equals("")) {
            surname = "";
        } else {
            surname = fakeProfile.getSurname();
        }
        if (birthDay.equals("")) {
            birthDay = "";
        } else {
            birthDay = "1953-12-11";
        }
        if (ssn.equals("")) {
            ssn = "";
        } else {
            ssn = fakeProfile.getSocialSecurityNumber();
        }
        if (birthPlace.equals("")) {
            birthPlace = "";
        } else {
            birthPlace = fakeProfile.getBirthPlace();
        }
        if (phoneNumber.equals("")) {
            phoneNumber = "";
        } else {
            phoneNumber = fakeProfile.getPhoneNumber();
        }
        if (gender.equals("")) {
            gender = "";
        } else {
            gender = fakeProfile.getGender();
        }
        if (password.equals("")) {
            password = "";
        } else {
            password = fakeProfile.getPassword();
        }

        deanPojo = new DeanPojo(username, name, surname, birthDay, ssn, birthPlace, phoneNumber, gender, password);

        response = given(specAdmin).body(deanPojo).post("{f}/{s}");
        response.prettyPrint();


        JsonPath jsonPath = response.jsonPath();

        String birthDayWarn = "Please enter your birthday";
        String nameWarn = "Your name must consist of the characters .";
        String nameWarn2 = "Your name should be at least 2 characters";
        String surnameWarn = "Your surname must consist of the characters .";
        String surnameWarn2 = "Your surname should be at least 2 characters";
        String birtPlaceWarn = "Your birth place must consist of the characters .";
        String birtPlaceWarn2 = "Your birth place should be at least 2 characters";
        String ssnWarn = "Please enter valid SSN number";
        String passwordWarn = "Please enter your password as at least 8 characters";
        String phoneNumberWarn = "Phone number should be exact 12 characters";
        String phoneNumberWarn2 = "Please enter valid phone number";
        String genderWarn = "You have entered an invalid value. Valid values are: MALE, FEMALE";
        String usernameWarn = "Your username must consist of the characters .";
        String usernameWarn2 = "Your username should be at least 4 characters";

        switch (stepNo) {

            case "1":
                String actUsernameWarn = jsonPath.get("validations.username").toString();
                if (actUsernameWarn.contains(usernameWarn)) {
                    assertEquals(usernameWarn, actUsernameWarn);
                } else assertEquals(usernameWarn2, actUsernameWarn);

            case "2":
                String actNameWarn = jsonPath.get("validations.name").toString();
                if (actNameWarn.contains(nameWarn)) {
                    assertEquals(nameWarn, actNameWarn);
                } else assertEquals(nameWarn2, actNameWarn);

            case "3":
                String actSurnameWarn = jsonPath.get("validations.surname").toString();
                if (actSurnameWarn.contains(surnameWarn)) {
                    assertEquals(surnameWarn, actSurnameWarn);
                } else assertEquals(surnameWarn2, actSurnameWarn);

            case "4":
                String actBirtDayWarn = jsonPath.get("validations.birthDay").toString();

                assertEquals(birthDayWarn, actBirtDayWarn);

            case "5":
                String actSsnWarn = jsonPath.get("validations.ssn").toString();

                assertEquals(ssnWarn, actSsnWarn);

            case "6":
                String actBirthPlaceWarn = jsonPath.get(".validations.birthPlace").toString();
                if (actBirthPlaceWarn.contains(birtPlaceWarn)) {
                    assertEquals(birtPlaceWarn, actBirthPlaceWarn);
                } else assertEquals(birtPlaceWarn2, actBirthPlaceWarn);

            case "7":
                String actPhoneNumberWarn = jsonPath.get("validations.phoneNumber").toString();
                if (actPhoneNumberWarn.contains(phoneNumberWarn)) {
                    assertEquals(phoneNumberWarn, actPhoneNumberWarn);
                } else assertEquals(phoneNumberWarn2, actPhoneNumberWarn);
            case "8":
                String actGenderWarn = jsonPath.get("validations.gender").toString();
                assertEquals(genderWarn, actGenderWarn);
            case "9":
                String actPasswordWarn = jsonPath.get("validations.password").toString();
                assertEquals(passwordWarn, actPasswordWarn);
        }
    }

}