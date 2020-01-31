package ru.hrs.lassd.club.ws.action;

import org.springframework.beans.factory.annotation.Autowired;
import ru.hrs.lassd.club.ws.helper.SOAPHelper;

public class BaseAction {


    @Autowired protected SOAPHelper soapHelper;
}
