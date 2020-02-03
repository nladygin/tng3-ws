package ru.hrs.lassd.club.ws;


import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import ru.hrs.lassd.club.ws.action.ProfileLookupAction;
import ru.hrs.lassd.club.ws.schema.PersonName;
import ru.hrs.lassd.club.ws.schema.ProfileLookupRequest;
import ru.hrs.lassd.club.ws.schema.ProfileLookupResponse;

import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileLookupTest extends BaseTest {

    @Test
    public void lookupByLastFirstName() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile(data.profileLookupLastName, data.profileLookupFirstName);
        assertThat(
                profileLookupAction.isProfilesCountEqualTo(response, 4),
                CoreMatchers.equalTo(true)
        );
    }


    @Test
    public void lookupByBadLastFirstName() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("bad", "mother fucker");
        assertThat(
                profileLookupAction.isProfilesCountEqualTo(response, 0),
                CoreMatchers.equalTo(true)
        );
    }


    @Test
    public void lookupByBadLastName() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("bad mother fucker");
        assertThat(
                profileLookupAction.isProfilesCountEqualTo(response, 0),
                CoreMatchers.equalTo(true)
        );
    }


    @Test
    public void lookupByRoomNumber() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("r" + data.profileLookupRoom);
        assertThat(
                profileLookupAction.isProfilesCountEqualTo(response, 1),
                CoreMatchers.equalTo(true)
        );
    }


    @Test
    public void lookupByBadRoomNumber() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("r666");
        assertThat(
                profileLookupAction.isProfilesCountEqualTo(response, 0),
                CoreMatchers.equalTo(true)
        );
    }


    @Test
    public void lookupByCardId() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile(String.valueOf(data.profileLookupCard));
        assertThat(
                profileLookupAction.isProfilesCountEqualTo(response, 1),
                CoreMatchers.equalTo(true)
        );
    }


    @Test
    public void lookupByBadCardId() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("66666");
        assertThat(
                profileLookupAction.isProfilesCountEqualTo(response, 0),
                CoreMatchers.equalTo(true)
        );
    }


    @Test
    public void lookupByLastFirstNameWithRange() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile(data.profileLookupLastName, data.profileLookupFirstName, 0, 1);
        assertThat(
                profileLookupAction.isProfilesCountEqualTo(response, 1),
                CoreMatchers.equalTo(true)
        );
    }






    @Autowired private ProfileLookupAction profileLookupAction;
}
