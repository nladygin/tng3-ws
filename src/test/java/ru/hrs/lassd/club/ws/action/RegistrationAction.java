package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class RegistrationAction extends BaseAction{

    public RegistrationResponse register(
            String number,
            int rvcId,
            int cardId,
            Integer bookingId,
            String clockIn,
            String clockOut
    ){
        RegistrationRequest request = new RegistrationRequest();
            request.setNumber(number);
            request.setRVCId(String.valueOf(rvcId));
            request.setCardId(String.valueOf(cardId));
            request.setBookingId(String.valueOf(bookingId));
            request.setClockIn(clockIn);
            request.setClockOut(clockOut);
        return (RegistrationResponse) soapHelper.go(request);
    }






    public void checkResultInfo(RegistrationResponse response, String info) {
        assertThat(
                response.getTextInfo(),
                CoreMatchers.equalTo(info)
        );
    }



}
