package ru.hrs.lassd.club.ws;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.AddKeyAction;
import ru.hrs.lassd.club.ws.action.QuickCheckInAction;
import ru.hrs.lassd.club.ws.schema.AddKeyResponse;
import ru.hrs.lassd.club.ws.schema.QuickCheckInResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;


@RunWith(SpringJUnit4ClassRunner.class)
public class AddKeyTest extends BaseTest {


    @Test
    public void addKey() {
        AddKeyResponse response = addKeyAction.addKey(
                data.siteId,
                data.profileBookingId,
                utils.generateDate("YYYYMMddHHmm",0) + utils.generateDigits(3)
        );
        addKeyAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test @Ignore ("TODO")
    public void addDoubleKeys() {
        String key = utils.generateDate("YYYYMMddHHmm",0) + utils.generateDigits(3);
            AddKeyResponse response = addKeyAction.addKey(
                    data.siteId,
                    data.profileBookingId,
                    key
            );
        addKeyAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);

            response = addKeyAction.addKey(
                    data.siteId,
                    data.profileBookingId,
                    key
            );
        addKeyAction.checkResultStatus(response, ResultStatusFlag.FAIL);
    }


    @Test @Ignore ("TODO")
    public void addKeyWithWrongBooking() {
        AddKeyResponse response = addKeyAction.addKey(
                data.siteId,
                "666",
                utils.generateDate("YYYYMMddHHmm",0) + utils.generateDigits(3)
        );
        addKeyAction.checkResultStatus(response, ResultStatusFlag.FAIL);
    }


    @Test @Ignore ("TODO")
    public void addKeyWithWrongSite() {
        AddKeyResponse response = addKeyAction.addKey(
                666,
                data.profileBookingId,
                utils.generateDate("YYYYMMddHHmm",0) + utils.generateDigits(3)
        );
        addKeyAction.checkResultStatus(response, ResultStatusFlag.FAIL);
    }



    @Autowired private AddKeyAction addKeyAction;
}
