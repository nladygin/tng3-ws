package ru.hrs.lassd.club.ws;


import org.hamcrest.CoreMatchers;
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
                data.fetchProfileMagstripe,
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


    @Autowired private FetchProfileAction fetchProfileAction;
}
