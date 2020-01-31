package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.QuickCheckInAction;
import ru.hrs.lassd.club.ws.schema.QuickCheckInResponse;


@RunWith(SpringJUnit4ClassRunner.class)
public class QuickCheckInTest extends BaseTest {

    @Test
    public void checkInByMagstripe() {

        QuickCheckInResponse response = quickCheckInAction.checkIn("CID:");

    }



    @Autowired private QuickCheckInAction quickCheckInAction;
}
