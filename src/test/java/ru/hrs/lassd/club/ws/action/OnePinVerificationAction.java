package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.entity.Fault;
import ru.hrs.lassd.club.ws.schema.*;

import javax.xml.datatype.XMLGregorianCalendar;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class OnePinVerificationAction extends BaseAction{

    public OneTimePinVerificationResponse getVerificationPin(
            String number,
            String postingGUID,
            Double paymentAmount,
            String requestId,
            String note
    ){
        OneTimePinVerificationRequest request = new OneTimePinVerificationRequest();
            request.setNumber(number);
            request.setPostingGUID(postingGUID);
            request.setPaymentAmount(String.valueOf(paymentAmount));
            request.setRequestId(requestId);
            request.setNote(note);
        return (OneTimePinVerificationResponse) soapHelper.go(request);
    }






    public void checkResultStatus(OneTimePinVerificationResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }


    public void checkResultPaymentInfo(OneTimePinVerificationResponse response, String info) {
        assertThat(
                response.getInfo(),
                CoreMatchers.equalTo(info)
        );
    }



}
