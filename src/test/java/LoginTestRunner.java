import org.testng.annotations.Test;

public class LoginTestRunner extends Setup {

    @Test
    public void doLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }
}
