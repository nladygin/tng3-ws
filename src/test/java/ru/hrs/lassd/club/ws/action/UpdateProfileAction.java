package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class UpdateProfileAction extends BaseAction{








    public UpdateProfileResponse updateProfile(
            Profile profile,
            int resortId
    ) {
        UpdateProfileRequest request = new UpdateProfileRequest();
            request.setProfile(profile);
            request.setResortId(String.valueOf(resortId));
        return (UpdateProfileResponse) soapHelper.go(request);
    }









    public void checkResultStatus(UpdateProfileResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getResult(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }



}
