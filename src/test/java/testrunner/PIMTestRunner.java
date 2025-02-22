package testrunner;

import com.github.javafaker.Faker;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.emitter.Emitable;
import pages.LoginPage;
import pages.PIMPage;
import setup.EmployeeModel;
import setup.Setup;
import utils.Utils;

import java.io.IOException;
import java.time.Duration;

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
    public void addNewEmployee() throws IOException, ParseException {
        pimPage = new PIMPage(driver);
        pimPage.button.get(2).click();
        driver.findElement(By.className("oxd-switch-input")).click();
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String userName = faker.name().username();
        String passWord = "p@ssword123";

        EmployeeModel model = new EmployeeModel();

        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setUserName(userName);
        model.setPassWord(passWord);


        pimPage.addNewEmployee(model);

        pimPage.button.get(1).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        WebElement headerElment =driver.findElement(By.xpath("//h6[text()=\"Personal Details\"]"));

        String textTitle=headerElment.getText();
        Assert.assertTrue(textTitle.contains("Personal Details"));

        Utils.saveUser(model);

    }
}

