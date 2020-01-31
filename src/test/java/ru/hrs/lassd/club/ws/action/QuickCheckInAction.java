package ru.hrs.lassd.club.ws.action;

import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.QuickCheckInRequest;
import ru.hrs.lassd.club.ws.schema.QuickCheckInResponse;

@Component
public class QuickCheckInAction extends BaseAction{

    public QuickCheckInResponse checkIn(String number) {

        QuickCheckInRequest request = new QuickCheckInRequest();
            request.setNumber(number);

        return (QuickCheckInResponse) soapHelper.go(request);
    }



}
