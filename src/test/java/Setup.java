
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Setup {
    WebDriver driver;
@BeforeMethod
    public void setup() {

     driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @AfterMethod
    public void closeBrowser() {
    driver.quit();
        }
}
