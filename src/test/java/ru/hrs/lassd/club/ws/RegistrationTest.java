package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.RegistrationAction;
import ru.hrs.lassd.club.ws.schema.RegistrationResponse;


@RunWith(SpringJUnit4ClassRunner.class)
public class RegistrationTest extends BaseTest {


    @Test
    public void register() {
        RegistrationResponse response = registrationAction.register(
                "CID:"+data.profileCard,
                data.outletID,
                data.profileCard,
                null,
                utils.generateDate("dd.MM.yyyy", 0),
                utils.generateDate("dd.MM.yyyy", 2)
        );
        registrationAction.checkResultInfo(response, "SUCCESS");
    }






    @Autowired private RegistrationAction registrationAction;
}
