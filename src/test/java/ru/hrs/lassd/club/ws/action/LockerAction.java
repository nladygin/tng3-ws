package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class LockerAction extends BaseAction{



    public LockerResponse action(
            int postPropertyId,
            BigInteger revenueCenterId,
            String lockerNumber,
            String cardUID,
            String action
    ) {
        LockerRequest request = new LockerRequest();
            request.setPostPropertyId(String.valueOf(postPropertyId));
            request.setRevenueCenterId(String.valueOf(revenueCenterId));
            request.setLockerNumber(lockerNumber);
            request.setCardUID(cardUID);
            request.setAction(action);

        return (LockerResponse) soapHelper.go(request);
    }





    public void checkResultStatus(LockerResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }


    public void checkResultInformation(LockerResponse response, String expectedInformation) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedInformation)
        );
    }


}
