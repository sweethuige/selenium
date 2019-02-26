package testsuite;

import framework.Email;
import org.testng.annotations.Test;

public class EmailTest {

    @Test()
    public void sendEmail(){
        Email.sendEmail();
    }

}
