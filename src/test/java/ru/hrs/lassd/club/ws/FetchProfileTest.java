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
    public void fetchProfileWithoutPrefix() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                data.profileMagstripe,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void createProfileByMagstripeSwipe() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "MSW:" + utils.generateDate("YYYYMMddHHmm",0),
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void createProfileByMagstripeManual() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "MSM:" + utils.generateDate("YYYYMMddHHmm",0),
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void createProfileByForeignId() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "FID:" + utils.generateDate("YYYYMMddHHmm",0),
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByMagstripe() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "MSW:" + data.profileMagstripe,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByWrongMagstripe() {
        Fault response = fetchProfileAction.fetchProfileFault(
                "MSW:" + "666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "Card not found");
    }


    @Test
    public void fetchProfileByExtraMagstripe() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "MSW:" + data.profileExtraMagstripe,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByMobile() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "MSM:" + data.profileMobile,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByWrongMobile() {
        Fault response = fetchProfileAction.fetchProfileFault(
                "MSM:" + "666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "Card not found");
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
        Fault response = fetchProfileAction.fetchProfileFault(
                "CID:666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "Card not found");
    }


    @Test
    public void fetchProfileByTicket() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "MSW:" + data.profileTicket,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByKeyCodeTerminal() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "KDT:" + data.profileKeyCode,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByWrongKeyCodeTerminal() {
        Fault response = fetchProfileAction.fetchProfileFault(
                "KDT:" + "666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "Card not found");
    }


    @Test
    public void fetchProfileByKeyCodeManual() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "KDM:" + data.profileKeyCode,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByWrongKeyCodeManual() {
        Fault response = fetchProfileAction.fetchProfileFault(
                "KDM:" + "666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "Card not found");
    }


    @Test
    public void fetchProfileByKeyNumber() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "KID:" + data.profileKeyNumber,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByWrongKeyNumber() {
        Fault response = fetchProfileAction.fetchProfileFault(
                "KID:" + "666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "Card not found");
    }


    @Test
    public void fetchProfileByBookingId() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "RES:" + data.siteId + "|" + data.profileBookingId,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByWrongKeyBookingId() {
        Fault response = fetchProfileAction.fetchProfileFault(
                "RES:" + "1002|666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "Card not found");
    }


    @Test
    public void fetchProfileByForeignId() {
        FetchProfileResponse response = fetchProfileAction.fetchProfile(
                "FID:" + data.profileForeignId,
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkForProfileExist(response);
    }


    @Test
    public void fetchProfileByWrongForeignId() {
        Fault response = fetchProfileAction.fetchProfileFault(
                "FID:" + "1002|V8|666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "Card not found");
    }


    @Test
    public void fetchProfileByBadTag() {
        Fault response = fetchProfileAction.fetchProfileFault(
                "OMG:" + "666",
                data.siteId,
                data.outletID
        );
        fetchProfileAction.checkFaultMessageIsEqualTo(response, "No support for lookup tag (OMG:666)");
    }






    @Autowired private FetchProfileAction fetchProfileAction;
}
