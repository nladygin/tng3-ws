package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.NewProfileRequest;
import ru.hrs.lassd.club.ws.schema.NewProfileResponse;
import ru.hrs.lassd.club.ws.schema.Profile;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class NewProfileAction extends BaseAction{








    public NewProfileResponse createProfile(
            Profile profile,
            int resortId
    ) {
        NewProfileRequest request = new NewProfileRequest();
            request.setProfile(profile);
            request.setResortId(String.valueOf(resortId));
        return (NewProfileResponse) soapHelper.go(request);
    }









    public void checkResultStatus(NewProfileResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getResult(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }



}
