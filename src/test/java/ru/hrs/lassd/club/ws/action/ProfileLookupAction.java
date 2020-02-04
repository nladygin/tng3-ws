package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import java.math.BigInteger;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class ProfileLookupAction extends BaseAction {

    public ProfileLookupResponse lookupProfile(String lastName, String firstName) {
        return lookupProfile(
                null,
                firstName,
                null,
                lastName,
                null,
                null,
                null,
                null,
                null
        );
    }


    public ProfileLookupResponse lookupProfile(String lastName, String firstName, int firstResult, int maxResult) {

        return lookupProfile(
                null,
                firstName,
                null,
                lastName,
                null,
                null,
                null,
                firstResult,
                maxResult
        );
    }


    public ProfileLookupResponse lookupProfile(String searchString) {
        return lookupProfile(
                null,
                null,
                null,
                searchString,
                null,
                null,
                null,
                null,
                null
        );
    }


    public ProfileLookupResponse lookupProfile(
            List<String> titleName,
            String firstName,
            List<String> middleName,
            String lastName,
            List<String> nameSuffix,
            String familiarName,
            String nameOrdered,
            Integer firstResult,
            Integer maxResult
            ) {

            ProfileLookupRequest request = new ProfileLookupRequest();

                PersonName name = new PersonName();
                    name.setLastName(lastName);
                    name.setFirstName(firstName);

                        request.setPersonName(name);

                            if (firstResult != null && maxResult != null) {
                                Range range = new Range();
                                range.setBegin(BigInteger.valueOf(firstResult));
                                range.setEnd(BigInteger.valueOf(maxResult));
                                request.setResultRange(range);
                            }
        return (ProfileLookupResponse) soapHelper.go(request);
    }


    public void checkProfilesCountIsEqualTo(ProfileLookupResponse response, int count) {
        assertThat(
                response.getBriefProfileList().getBriefProfile().size(),
                CoreMatchers.equalTo(count)
        );
    }

}
