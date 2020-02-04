package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hrs.lassd.club.ws.entity.Fault;
import ru.hrs.lassd.club.ws.helper.SOAPHelper;

import static org.hamcrest.MatcherAssert.assertThat;

public class BaseAction {


    public void checkFaultMessageIsEqualTo(Fault response, String msg) {
        assertThat(
                response.getFaultString(),
                CoreMatchers.equalTo(msg)
        );
    }




    @Autowired protected SOAPHelper soapHelper;

}
