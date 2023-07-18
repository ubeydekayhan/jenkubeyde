package hooks;

import io.cucumber.java.Before;

import static base_urls.Managementonschool_base.setUpApi;


public class Hooks {

    @Before("@Api")//Import cucumber
    public void before(){

        setUpApi();

    }
}
