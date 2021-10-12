package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class QuickCheckOutAction extends BaseAction{



    /* simple */
    public QuickCheckOutResponse checkOut(
            String number,
            int postPropertyId,
            int revenueCenterId,
            int cashierEmpId,
            String cashierEmpName,
            String info
    ) {
        QuickCheckOutRequest request = new QuickCheckOutRequest();
        request.setNumber(number);
        request.setClientId(null);
        request.setVoidFlag("F");
        request.setPostPropertyId(String.valueOf(postPropertyId));
        request.setRegisterId(null);
        request.setRevenueCenterId(String.valueOf(revenueCenterId));
        request.setBookingNumber(null);
        request.setKeyNumber(null);
        request.setMealPeriod(null);
        request.setCashierEmpId(String.valueOf(cashierEmpId));
        request.setCashierEmpName(cashierEmpName);
        request.setCashierOptMask(null);
        request.setInfo(info);
        request.setProcessOvertime(null);
        request.setLockerNum(null);
        return (QuickCheckOutResponse) soapHelper.go(request);
    }





    public QuickCheckOutResponse checkOut(
            String number,
            UniqueID clientId,
            String voidFlag,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            String bookingNumber,
            String keyNumber,
            String mealPeriod,
            int cashierEmpId,
            String cashierEmpName,
            String cashierOptMask,
            String info,
            String processOvertime,
            String lockerNum
    ) {
        QuickCheckOutRequest request = new QuickCheckOutRequest();
            request.setNumber(number);
            request.setClientId(clientId);
            request.setVoidFlag(voidFlag);
            request.setPostPropertyId(String.valueOf(postPropertyId));
            request.setRegisterId(registerId);
            request.setRevenueCenterId(String.valueOf(revenueCenterId));
            request.setBookingNumber(bookingNumber);
            request.setKeyNumber(keyNumber);
            request.setMealPeriod(mealPeriod);
            request.setCashierEmpId(String.valueOf(cashierEmpId));
            request.setCashierEmpName(cashierEmpName);
            request.setCashierOptMask(cashierOptMask);
            request.setInfo(info);
            request.setProcessOvertime(processOvertime);
            request.setLockerNum(lockerNum);

        return (QuickCheckOutResponse) soapHelper.go(request);
    }









    public void checkResultStatus(QuickCheckOutResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }


    public void checkResultTextInfo(QuickCheckOutResponse response, String textInfo) {
        assertThat(
                response.getTextInfo(),
                CoreMatchers.equalTo(textInfo)
        );
    }

}
