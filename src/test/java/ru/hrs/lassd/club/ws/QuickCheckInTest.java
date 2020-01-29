package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import ru.hrs.lassd.club.ws.schema.PersonName;
import ru.hrs.lassd.club.ws.schema.ProfileLookupRequest;
import ru.hrs.lassd.club.ws.schema.ProfileLookupResponse;


@RunWith(SpringJUnit4ClassRunner.class)
public class QuickCheckInTest extends BaseTest {

    @Test
    public void checkInByMagstripe() {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("ru.hrs.lassd.club.ws.schema");

        WebServiceTemplate template = new WebServiceTemplate(marshaller, marshaller);
        template.setDefaultUri("http://127.0.0.1:8080/ws");

        PersonName name = new PersonName();
        name.setLastName("test");

        ProfileLookupRequest lookup = new ProfileLookupRequest();
        lookup.setPersonName(name);
        ProfileLookupResponse res = (ProfileLookupResponse)template.marshalSendAndReceive(lookup);
        System.out.println(res.getBriefProfileList().getBriefProfile().size());


    }



}
