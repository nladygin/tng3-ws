package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.ProfileLookupAction;
import ru.hrs.lassd.club.ws.schema.ProfileLookupResponse;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileLookupTest extends BaseTest {

    @Test
    public void lookupByLastFirstName() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile(data.profileLookupLastName, data.profileLookupFirstName);
        profileLookupAction.checkProfilesCountIsEqualTo(response, 4);
    }


    @Test
    public void lookupByBadLastFirstName() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("bad", "mother fucker");
        profileLookupAction.checkProfilesCountIsEqualTo(response, 0);
    }


    @Test
    public void lookupByBadLastName() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("bad mother fucker");
        profileLookupAction.checkProfilesCountIsEqualTo(response, 0);
    }


    @Test
    public void lookupByRoomNumber() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("r" + data.profileLookupRoom);
        profileLookupAction.checkProfilesCountIsEqualTo(response, 1);
    }


    @Test
    public void lookupByBadRoomNumber() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("r666");
        profileLookupAction.checkProfilesCountIsEqualTo(response, 0);
    }


    @Test
    public void lookupByCardId() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile(String.valueOf(data.profileLookupCard));
        profileLookupAction.checkProfilesCountIsEqualTo(response, 1);
    }


    @Test
    public void lookupByBadCardId() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile("66666");
        profileLookupAction.checkProfilesCountIsEqualTo(response, 0);
    }


    @Test
    public void lookupByLastFirstNameWithRange() {
        ProfileLookupResponse response = profileLookupAction.lookupProfile(data.profileLookupLastName, data.profileLookupFirstName, 0, 1);
        profileLookupAction.checkProfilesCountIsEqualTo(response, 1);
    }






    @Autowired private ProfileLookupAction profileLookupAction;
}
