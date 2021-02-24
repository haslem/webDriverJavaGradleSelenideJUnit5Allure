package login;

import base.BaseTest;
import org.junit.jupiter.api.Test;


public class LoginTest extends BaseTest {

    @Test
    public void testLogin(){
        homePage.clickLogin();
        myMapsPage.isLoggedIn();
    }

}
