package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import javax.xml.datatype.XMLGregorianCalendar;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;


@Component
public class AcquireLoyaltyAction extends BaseAction {


    /* Simple */
    public AcquireLoyaltyResponse acquireLoyalty(
            String number,
            String postingGUID,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            double paymentAmount,
            String checkNumber,
            int cashierEmpId,
            String cashierEmpName,
            MenuItemList menuItemList,
            PaymentOptionsType loyaltyOptions
    ) {

        return acquireLoyalty(
                number,
                null,
                postingGUID,
                null,
                postPropertyId,
                registerId,
                revenueCenterId,
                null,
                paymentAmount,
                checkNumber,
                cashierEmpId,
                cashierEmpName,
                "",
                1,
                0.0,
                null,
                menuItemList,
                loyaltyOptions,
                null,
                null,
                null,
                null,
                null
        );
    }

    /* + Service charge */
    public AcquireLoyaltyResponse acquireLoyalty(
            String number,
            String postingGUID,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            double paymentAmount,
            String checkNumber,
            int cashierEmpId,
            String cashierEmpName,
            double serviceChargeAmount,
            MenuItemList menuItemList,
            PaymentOptionsType loyaltyOptions
    ) {

        return acquireLoyalty(
                number,
                null,
                postingGUID,
                null,
                postPropertyId,
                registerId,
                revenueCenterId,
                null,
                paymentAmount,
                checkNumber,
                cashierEmpId,
                cashierEmpName,
                "",
                1,
                serviceChargeAmount,
                null,
                menuItemList,
                loyaltyOptions,
                null,
                null,
                null,
                null,
                null
        );
    }



    /* + Serving period */
    public AcquireLoyaltyResponse acquireLoyalty(
            String number,
            String postingGUID,
            int postPropertyId,
            UniqueID registerId,
            Long mealPeriod,
            BigInteger revenueCenterId,
            double paymentAmount,
            String checkNumber,
            int cashierEmpId,
            String cashierEmpName,
            MenuItemList menuItemList,
            PaymentOptionsType loyaltyOptions
    ) {

        return acquireLoyalty(
                number,
                null,
                postingGUID,
                null,
                postPropertyId,
                registerId,
                revenueCenterId,
                mealPeriod,
                paymentAmount,
                checkNumber,
                cashierEmpId,
                cashierEmpName,
                "",
                1,
                0.0,
                null,
                menuItemList,
                loyaltyOptions,
                null,
                null,
                null,
                null,
                null
        );
    }



    /* Full */
    public AcquireLoyaltyResponse acquireLoyalty(
            String number,
            UniqueID clientId,
            String postingGUID,
            Boolean voidFlag,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            Long mealPeriod,
            double paymentAmount,
            String checkNumber,
            int cashierEmpId,
            String cashierEmpName,
            String cashierOptMask,
            int checkGuestCount,
            double serviceChargeAmount,
            String voucher,
            MenuItemList menuItemList,
            PaymentOptionsType loyaltyOptions,
            Boolean confirm,
            Boolean calcOnly,
            XMLGregorianCalendar calcForDate,
            Integer calcRuleset,
            Double discountRedeemLimit
            ) {

            AcquireLoyaltyRequest request = new AcquireLoyaltyRequest();

                request.setNumber(number);
                request.setClientId(clientId);
                request.setPostingGUID(postingGUID);
                request.setVoidFlag(voidFlag);
                request.setPostPropertyId(String.valueOf(postPropertyId));
                request.setRegisterId(registerId);
                request.setRevenueCenterId(String.valueOf(revenueCenterId));
                request.setMealPeriod(mealPeriod);
                request.setPaymentAmount(String.valueOf(paymentAmount));
                request.setCheckNumber(checkNumber);
                request.setCashierEmpId(String.valueOf(cashierEmpId));
                request.setCashierEmpName(cashierEmpName);
                request.setCashierOptMask(cashierOptMask);
                request.setCheckGuestCount(String.valueOf(checkGuestCount));
                request.setServiceChargeAmount(String.valueOf(serviceChargeAmount));
                request.setVoucher(voucher);
                request.setMenuItemList(menuItemList);
                request.setLoyaltyOptions(loyaltyOptions);
                request.setConfirm(confirm);
                request.setCalcOnly(calcOnly);
                request.setCalcForDate(calcForDate);
                request.setCalcRuleset(calcRuleset);
                request.setDiscountRedeemLimit(discountRedeemLimit);

        return (AcquireLoyaltyResponse) soapHelper.go(request);
    }




    public void checkResultStatus(AcquireLoyaltyResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }




    public void checkItemDiscount(AcquireLoyaltyResponse response, int itemNum, Double expectedResultItemDiscount) {
        assertThat(
                response.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(itemNum).getDiscount(),
                CoreMatchers.equalTo(expectedResultItemDiscount)
        );
    }



    public void checkResultInfo(AcquireLoyaltyResponse response, String expectedPaymentInfo) {
        assertThat(
                response.getPaymentInfo(),
                CoreMatchers.equalTo(expectedPaymentInfo)
        );
    }




}
