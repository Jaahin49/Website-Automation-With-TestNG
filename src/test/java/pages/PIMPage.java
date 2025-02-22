package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.EmployeeModel;

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

    public void addNewEmployee(EmployeeModel model){

        infoField.get(1).sendKeys(model.getFirstName());
        infoField.get(3).sendKeys(model.getLastName());
        infoField.get(5).sendKeys(model.getUserName());
        infoField.get(6).sendKeys(model.getPassWord());
        infoField.get(7).sendKeys(model.getPassWord());

    }
}
