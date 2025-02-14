package testrunner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import setup.Setup;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;

    @Test(priority = 1, description = "Admin can't Login with invalid creds")
    public void doLoginWithWrongCreds(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Wrong", "wrong123");
        WebElement alertText = driver.findElement(By.className("oxd-alert-content-text"));
        Assert.assertEquals(alertText.getText(), "Invalid credentials");
    }

    @Test(priority =2, description = "Admin will Login with invalid creds" )
    public void doLogin(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
        WebElement profilePhoto = driver.findElement(By.className("oxd-userdropdown-img"));
        Assert.assertTrue(profilePhoto.isDisplayed());
    }

    @Test(priority =3, description = "Admin will Logout by clicking Logout button")
    public void doLogout(){
        loginPage = new LoginPage(driver);
        loginPage.doLogout();
        WebElement forgetPasswordElmn=driver.findElement(By.className("orangehrm-login-forgot-header"));
        Assert.assertTrue(forgetPasswordElmn.isDisplayed());
    }

}
