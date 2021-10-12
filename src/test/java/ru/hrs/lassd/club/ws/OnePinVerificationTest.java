package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.OnePinVerificationAction;
import ru.hrs.lassd.club.ws.helper.Utils;
import ru.hrs.lassd.club.ws.schema.OneTimePinVerificationResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;


@RunWith(SpringJUnit4ClassRunner.class)
public class OnePinVerificationTest extends BaseTest {


    @Test
    public void getVerificationPin() {
        OneTimePinVerificationResponse response = onePinVerificationAction.getVerificationPin(
                "CID:" + data.profileCard,
                null,
                10.0,
                null,
                "verification pin for ws autotest"
        );
        onePinVerificationAction.checkResultStatus(response, ResultStatusFlag.FAIL); //TODO add SMS sending in TNG
        onePinVerificationAction.checkResultPaymentInfo(response, "Error #6, ID: 56");
    }


    @Test
    public void getVerificationPinForBlockedCard() {
        OneTimePinVerificationResponse response = onePinVerificationAction.getVerificationPin(
                "MSW:" + data.profileLockedMagstripe,
                null,
                10.0,
                null,
                "verification pin for ws autotest"
        );
        onePinVerificationAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        onePinVerificationAction.checkResultPaymentInfo(response, "Card is blocked");
    }







    @Autowired private OnePinVerificationAction onePinVerificationAction;
    @Autowired private Utils utils;
}
