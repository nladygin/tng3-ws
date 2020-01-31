package ru.hrs.lassd.club.ws.action;

import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.QuickCheckInRequest;
import ru.hrs.lassd.club.ws.schema.QuickCheckInResponse;

@Component
public class QuickCheckInAction extends BaseAction{

    public QuickCheckInResponse checkInByMagstripe() {

        QuickCheckInRequest request = new QuickCheckInRequest();


//        soapHelper.go(lookup, response);
        return null;
    }



}
