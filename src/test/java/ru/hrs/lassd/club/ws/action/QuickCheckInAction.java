package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class QuickCheckInAction extends BaseAction{



    /* required  */
    public QuickCheckInResponse checkIn(
            String number,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            int cashierEmpId,
            String cashierEmpName
    ) {
        return checkIn(
                number,
                null,
                null,
                postPropertyId,
                registerId,
                revenueCenterId,
                null,
                null,
                null,
                null,
                cashierEmpId,
                cashierEmpName,
                "",
                null,
                null,
                null
        );
    }





    public QuickCheckInResponse checkIn(
            String number,
            UniqueID clientId,
            String voidFlag,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            String bookingNumber,
            String rateCode,
            XMLGregorianCalendar expDeparture,
            String mealPeriod,
            int cashierEmpId,
            String cashierEmpName,
            String cashierOptMask,
            RegisterKeyList registerKeys,
            String info,
            String lockerNum
    ) {
        QuickCheckInRequest request = new QuickCheckInRequest();
            request.setNumber(number);
            request.setClientId(clientId);
            request.setVoidFlag(voidFlag);
            request.setPostPropertyId(String.valueOf(postPropertyId));
            request.setRegisterId(registerId);
            request.setRevenueCenterId(String.valueOf(revenueCenterId));
            request.setBookingNumber(bookingNumber);
            request.setRateCode(rateCode);
            request.setExpDeparture(expDeparture);
            request.setMealPeriod(mealPeriod);
            request.setCashierEmpId(String.valueOf(cashierEmpId));
            request.setCashierEmpName(cashierEmpName);
            request.setCashierOptMask(cashierOptMask);
            request.setRegisterKeys(registerKeys);
            request.setInfo(info);
            request.setLockerNum(lockerNum);

        return (QuickCheckInResponse) soapHelper.go(request);
    }









    public void checkResultStatus(QuickCheckInResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }


    public void checkResultTextInfo(QuickCheckInResponse response, String textInfo) {
        assertThat(
                response.getTextInfo(),
                CoreMatchers.equalTo(textInfo)
        );
    }

}
