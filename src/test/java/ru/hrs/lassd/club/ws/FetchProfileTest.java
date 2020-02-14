package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.FetchProfileAction;
import ru.hrs.lassd.club.ws.entity.Fault;
import ru.hrs.lassd.club.ws.schema.FetchProfileResponse;



@RunWith(SpringJUnit4ClassRunner.class)
public class FetchProfileTest extends BaseTest {


    @Test
    public void fetchProfileByMagstripe() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                data.profileMagstripe,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByWrongMagstripe() {
        Fault response = fetchProfileAction.fetchProfileFault(
                "666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "Card not found");
    }


    @Test
    public void fetchProfileByExtraMagstripe() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                data.profileExtraMagstripe,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByCardId() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "CID:" + data.profileCard,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByWrongCardId() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "CID:666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByTicket() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                ":" + data.profileTicket,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }






    @Autowired private FetchProfileAction fetchProfileAction;
}
