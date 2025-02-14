package testrunner;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;
import setup.Setup;

public class PIMTestRunner extends Setup {

    LoginPage loginPage;
    PIMPage pimPage;

    @BeforeTest
    public void doLogin(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }
    @Test(priority = 1)
    public void checkEmployeeList() throws InterruptedException {
        pimPage = new PIMPage(driver);
        pimPage.leftMenubar.get(1).click();
        Thread.sleep(5000);
        String actualMessage = driver.findElements(By.className("oxd-text--span")).get(12).getText();
        String expectedMesage = "Records Found";
        Assert.assertTrue(actualMessage.contains(expectedMesage));

    }

    @Test(priority = 2)
    public void addNewEmployee(){
        pimPage = new PIMPage(driver);
        pimPage.button.get(2).click();
        driver.findElement(By.className("oxd-switch-input")).click();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.name().username();
        String passWord = "p@ssword123";
        pimPage.addNewEmployee(firstName,lastName,userName,passWord);
        pimPage.button.get(1).click();

    }
}

