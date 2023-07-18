package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FakeMailIcinMethod {
    public List<String> fakeMail() {
        Driver.getDriver().get("https://www.fakemail.net/");
        String email = Driver.getDriver().findElement(By.id("email")).getText();
        String password = Driver.getDriver().findElement(By.id("hesloGen")).getText();

        List<String> emailVePassword = new ArrayList<>();
        emailVePassword.add(email);
        emailVePassword.add(password);
        Driver.getDriver().navigate().back();
        return emailVePassword;
    }


    public String mailVerificationCode() {
        String code = "";
        Driver.getDriver().navigate().forward();//fake maile gidis
        ReusableMethods.visibleWait(By.xpath("//*[@id='schranka']/tr[1]/td[2]"), 10);

        WebElement text = Driver.getDriver().findElement(By.xpath("//*[@id='schranka']/tr[1]/td[2]"));//Verification code text satririnin locati

        code = text.getText().split("-")[1].trim();//verification code satirindan sadece verication kodu cekme
        Driver.getDriver().navigate().back();//allure'a donus
        return code;
    }

    public void deleteMail (){
        Driver.getDriver().get("https://www.fakemail.net/");
        WebElement deleteButton= Driver.getDriver().findElement(By.xpath("//*[text()='Delete']"));
        ReusableMethods.visibleWait(deleteButton,10);
        deleteButton.click();
        Driver.getDriver().navigate().back();
    }
}
