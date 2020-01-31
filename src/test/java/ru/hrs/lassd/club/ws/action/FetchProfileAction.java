package ru.hrs.lassd.club.ws.action;

import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.FetchProfileRequest;
import ru.hrs.lassd.club.ws.schema.FetchProfileResponse;
import ru.hrs.lassd.club.ws.schema.UniqueID;

@Component
public class FetchProfileAction extends BaseAction{


    public FetchProfileResponse fetchProfile(String searchValue, int siteId, int outletId) {
        return fetchProfile(
                searchValue,
                null,
                String.valueOf(siteId),
                null,
                null,
                null,
                String.valueOf(outletId),
                null,
                null,
                null
        );
    }


    public FetchProfileResponse fetchProfile(
            String profileIdValue,
            String profileIdSource,
            String propertyIdValue,
            String propertyIdSource,
            String registerIdValue,
            String registerIdSource,
            String revenueCenterIdValue,
            String revenueCenterIdSource,
            String cashierEmpName,
            String cashierOptMask
    ) {

        UniqueID profileId = new UniqueID();
            profileId.setValue(profileIdValue);
            profileId.setSource(profileIdSource);
        UniqueID propertyId = new UniqueID();
            propertyId.setValue(propertyIdValue);
            propertyId.setSource(propertyIdSource);
        UniqueID registerId = new UniqueID();
            registerId.setValue(registerIdValue);
            registerId.setSource(registerIdSource);
        UniqueID revenueCenterId = new UniqueID();
            revenueCenterId.setValue(revenueCenterIdValue);
            revenueCenterId.setSource(revenueCenterIdSource);

                FetchProfileRequest request = new FetchProfileRequest();
                    request.setProfileID(profileId);
                    request.setPropertyId(propertyId);
                    request.setRegisterId(registerId);
                    request.setRevenueCenterId(revenueCenterId);
                    request.setCashierEmpName(cashierEmpName);
                    request.setCashierOptMask(cashierOptMask);

        return (FetchProfileResponse) soapHelper.go(request);
    }




    public boolean isProfileExist(FetchProfileResponse response) {
        return response.getProfileID() != null;
    }

}
