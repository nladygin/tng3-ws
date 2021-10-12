package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.QuickCheckInAction;
import ru.hrs.lassd.club.ws.action.QuickCheckOutAction;
import ru.hrs.lassd.club.ws.action.UniqueIDAction;
import ru.hrs.lassd.club.ws.schema.QuickCheckInResponse;
import ru.hrs.lassd.club.ws.schema.QuickCheckOutResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;



@RunWith(SpringJUnit4ClassRunner.class)
public class QuickCheckInTest extends BaseTest {


    @Test
    public void checkinByMagstripe() {
        QuickCheckInResponse response = quickCheckInAction.checkIn(
                "MSW:" + data.profileMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.employeeId,
                data.employeeName
        );
// TODO registered by ticket, not CID

    }


    @Test
    public void checkinWithWrongSite() {
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


    @Test
    public void checkinAndCheckout() {
        QuickCheckInResponse checkInResponse = quickCheckInAction.checkIn(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.employeeId,
                data.employeeName
        );
        quickCheckInAction.checkResultStatus(checkInResponse, ResultStatusFlag.SUCCESS); // TODO registered by ticket, not CID

        QuickCheckOutResponse checkOutResponse = quickCheckOutAction.checkOut(
                "CID:" + data.profileCard,
                data.siteId,
                data.outletID,
                data.employeeId,
                data.employeeName,
                "checkout ws autotest"
        );
        quickCheckOutAction.checkResultStatus(checkOutResponse, ResultStatusFlag.SUCCESS); // TODO registered by ticket, not CID
    }







    @Autowired private QuickCheckInAction quickCheckInAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private QuickCheckOutAction quickCheckOutAction;
}
