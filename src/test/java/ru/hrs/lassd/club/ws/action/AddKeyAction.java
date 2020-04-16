package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class AddKeyAction extends BaseAction{



    public AddKeyResponse addKey(int resortId, String bookingNumber, String keyCode) {
        AddKeyRequest request = new AddKeyRequest();
            request.setResortId(String.valueOf(resortId));
            request.setBookingNumber(bookingNumber);
            request.setKeyCode(keyCode);
        return (AddKeyResponse) soapHelper.go(request);
    }





    public void checkResultStatus(AddKeyResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                ResultStatusFlag.fromValue(response.getStatus()),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }


}
