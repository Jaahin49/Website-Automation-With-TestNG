package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {

    @FindBy(className = "oxd-main-menu-item")
    public List<WebElement> leftMenubar;

    @FindBy(className = "oxd-button")
    public List<WebElement> button;

    @FindBy(className = "oxd-input")
    public List<WebElement> infoField;

    public PIMPage(WebDriver driver){

        PageFactory.initElements(driver, this);
    }

    public void addNewEmployee(String firstName, String lastName, String userName, String passWord){

        infoField.get(1).sendKeys(firstName);
        infoField.get(3).sendKeys(lastName);
        infoField.get(5).sendKeys(userName);
        infoField.get(6).sendKeys(passWord);
        infoField.get(7).sendKeys(passWord);

    }
}
