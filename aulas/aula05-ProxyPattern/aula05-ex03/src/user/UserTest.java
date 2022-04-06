package user;

import model.DownloadInterface;
import org.junit.jupiter.api.Test;
import service.DownloadProxy;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void userTest(){
        User u1 = new User();
        User u2 = new User();
        User u3 = new User();

        u1.setUserType("Premium");
        u3.setUserType("premium");
        DownloadInterface downloadInterface = new DownloadProxy();
        downloadInterface.verifyPremium(u1);
        downloadInterface.verifyPremium(u2);
        downloadInterface.verifyPremium(u3);
    }


}