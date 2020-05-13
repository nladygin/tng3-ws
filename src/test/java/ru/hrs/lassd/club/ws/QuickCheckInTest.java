package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.QuickCheckInAction;
import ru.hrs.lassd.club.ws.action.QuickCheckOutAction;
import ru.hrs.lassd.club.ws.action.UniqueIDAction;
import ru.hrs.lassd.club.ws.schema.QuickCheckInResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;



@RunWith(SpringJUnit4ClassRunner.class)
public class QuickCheckInTest extends BaseTest {


    @Test
    public void checkInByMagstripe() {
        QuickCheckInResponse response = quickCheckInAction.checkIn(
                "MSW:" + data.profileMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.employeeId,
                data.employeeName
        );


    }


    @Test
    public void checkInWithWrongSite() {
        QuickCheckInResponse response = quickCheckInAction.checkIn(
                "CID:" + data.profileCard,
                666,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.employeeId,
                data.employeeName
        );
        quickCheckInAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        quickCheckInAction.checkResultTextInfo(response, "Site not found: 666");
    }







    @Autowired private QuickCheckInAction quickCheckInAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private QuickCheckOutAction quickCheckOutAction;
}
