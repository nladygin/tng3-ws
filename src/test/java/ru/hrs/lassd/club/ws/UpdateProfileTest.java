package ru.hrs.lassd.club.ws;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.NewProfileAction;
import ru.hrs.lassd.club.ws.action.ProfileAction;
import ru.hrs.lassd.club.ws.action.UniqueIDAction;
import ru.hrs.lassd.club.ws.action.UpdateProfileAction;
import ru.hrs.lassd.club.ws.schema.*;

import javax.xml.datatype.DatatypeConfigurationException;


@RunWith(SpringJUnit4ClassRunner.class)
public class UpdateProfileTest extends BaseTest {


    @Test @Ignore("need to fix endpoint")
    public void updateProfile() throws DatatypeConfigurationException {
        Profile profile = new Profile();
            profile.setIDs(uniqueIDAction.generateList(
                    uniqueIDAction.generate("123456", "FI01"),
                    uniqueIDAction.generate("111", "ROOM")
            ));
            profile.setCustomer(
                    profileAction.createCustomer(
                            profileAction.createPersonName(
                                    "Mr",
                                    "Autotester",
                                    utils.generateString(),
                                    "Autotester"),
                    "QA",
                            profileAction.createGovernmentID(
                                    "passport",
                                    String.valueOf(utils.generateDigits()),
                                    utils.generateDateXML(0),
                                    utils.generateDateXML(10),
                                    "HRS",
                                    "ru_RU"
                            ),
                            utils.generateDateXML(0),
                            Gender.MALE
                    )
            );
            profile.setAddresses(
                    profileAction.createNameAddress(
                            uniqueIDAction.generateList(
                                    uniqueIDAction.generate("POST", "Russia, Lenin str, 1-1"),
                                    uniqueIDAction.generate("EMAIL", utils.generateString()+"@"+ utils.generateString()+".ru")
                            ),
                            true
                    )
            );
            profile.setBlacklist(
                    profileAction.createBlackList(
                            "Not blacklisted",
                            BlackListFlag.REMOVE
                    )
            );
            profile.setPhones(
                    profileAction.createNamePhone(
                            uniqueIDAction.generateList(
                                    uniqueIDAction.generate("MOBILE", String.valueOf(utils.generateDigits(10)))
                            ),
                            true
                    )
            );
            profile.setNegotiatedRates(
                    profileAction.createNegotiated(
                            "RACK",
                            data.siteId
                    )
            );
            profile.setLanguageCode("ru_RU");
            profile.setNationality("ru_RU");
            profile.setProtected(false);
            profile.setTaxExempt(false);
            profile.setInactiveDate(utils.generateDateXML(10));
            profile.setInsertDate(utils.generateDateXML(0));
            profile.setInsertUser("Inserter");
            profile.setUpdateDate(utils.generateDateXML(0));
            profile.setUpdateUser("Updater");
        UpdateProfileResponse response = updateProfileAction.updateProfile(
                profile,
                data.siteId
        );
        updateProfileAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }







    @Autowired private UpdateProfileAction updateProfileAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private ProfileAction profileAction;

}



