package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.AddKeyAction;
import ru.hrs.lassd.club.ws.action.LockerAction;
import ru.hrs.lassd.club.ws.schema.AddKeyResponse;
import ru.hrs.lassd.club.ws.schema.LockerResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;


@RunWith(SpringJUnit4ClassRunner.class)
public class LockerTest extends BaseTest {


    @Test
    public void openLocker() {
        LockerResponse response = lockerAction.action(
                data.siteId,
                data.rvcNumber,
                data.profileLockerNumber,
                "CID:"+data.profileCard,
                "OPEN"
        );
        lockerAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }
/* TODO */



    @Test
    public void actionWithWrongSite() {
        LockerResponse response = lockerAction.action(
                666,
                data.rvcNumber,
                data.profileLockerNumber,
                "CID:"+data.profileCard,
                "OPEN"
        );
        lockerAction.checkResultStatus(response, ResultStatusFlag.FAIL);
    }



    @Autowired private LockerAction lockerAction;
}
