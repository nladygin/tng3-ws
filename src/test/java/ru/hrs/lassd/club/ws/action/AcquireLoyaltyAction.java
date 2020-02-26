package ru.hrs.lassd.club.ws.action;

import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import javax.xml.datatype.XMLGregorianCalendar;


@Component
public class AcquireLoyaltyAction extends BaseAction {


    public AcquireLoyaltyResponse acquireLoyalty(
            String postingGUID,
            int postPropertyId,
            UniqueID registerId,
            int revenueCenterId,
            double paymentAmount,
            String checkNumber,
            int cashierEmpId,
            String cashierEmpName,
            String cashierOptMask,
            int checkGuestCount,
            double serviceChargeAmount,
            MenuItemList menuItemList,
            PaymentOptionsType loyaltyOptions
    ) {

        return acquireLoyalty(
                null,
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
                cashierOptMask,
                checkGuestCount,
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




    public AcquireLoyaltyResponse acquireLoyalty(
            String number,
            UniqueID clientId,
            String postingGUID,
            Boolean voidFlag,
            int postPropertyId,
            UniqueID registerId,
            int revenueCenterId,
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


}
