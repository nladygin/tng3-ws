package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;


@Component
public class PostPaymentAction extends BaseAction {



    public PostPaymentResponse postPayment(
        String number,
        String postPropertyId,
        UniqueID registerId,
        BigInteger revenueCenterId,
        String paymentAmount,
        String chkTtl,
        String checkNumber,
        String cashierEmpId,
        String cashierEmpName,
        String cashierOptMask,
        String checkGuestCount,
        String serviceChargeAmount,
        MenuItemList menuItemList,
        PostPaymentRequest.PaymentRestrictions paymentRestrictions,
        Boolean confirm
    ){
        return postPayment(
                number,
                null,
                null,
                null,
                postPropertyId,
                registerId,
                revenueCenterId,
                null,
                paymentAmount,
                null,
                chkTtl,
                null,
                checkNumber,
                cashierEmpId,
                cashierEmpName,
                cashierOptMask,
                checkGuestCount,
                serviceChargeAmount,
                menuItemList,
                null,
                paymentRestrictions,
                confirm
        );
    }





    public PostPaymentResponse postPayment(
        String number,
        UniqueID clientId,
        String postingGUID,
        Boolean voidFlag,
        String postPropertyId,
        UniqueID registerId,
        BigInteger revenueCenterId,
        Long mealPeriod,
        String paymentAmount,
        String servPeriod,
        String chkTtl,
        String checkId,
        String checkNumber,
        String cashierEmpId,
        String cashierEmpName,
        String cashierOptMask,
        String checkGuestCount,
        String serviceChargeAmount,
        MenuItemList menuItemList,
        String voucher,
        PostPaymentRequest.PaymentRestrictions paymentRestrictions,
        Boolean confirm
    ){
        PostPaymentRequest request = new PostPaymentRequest();

            request.setNumber(number);
            request.setClientId(clientId);
            request.setPostingGUID(postingGUID);
            request.setVoidFlag(voidFlag);
            request.setPostPropertyId(postPropertyId);
            request.setRegisterId(registerId);
            request.setRevenueCenterId(revenueCenterId);
            request.setMealPeriod(mealPeriod);
            request.setPaymentAmount(paymentAmount);
            request.setServPeriod(servPeriod);
            request.setChkTtl(chkTtl);
            request.setCheckId(checkId);
            request.setCheckNumber(checkNumber);
            request.setCashierEmpId(cashierEmpId);
            request.setCashierEmpName(cashierEmpName);
            request.setCashierOptMask(cashierOptMask);
            request.setCheckGuestCount(checkGuestCount);
            request.setServiceChargeAmount(serviceChargeAmount);
            request.setMenuItemList(menuItemList);
            request.setVoucher(voucher);
            request.setPaymentRestrictions(paymentRestrictions);
            request.setConfirm(confirm);

        return (PostPaymentResponse) soapHelper.go(request);
    }






    public PostPaymentRequest.PaymentRestrictions generatePaymentRestrictions() {
        return generatePaymentRestrictions(false, false, false);
    }


    public PostPaymentRequest.PaymentRestrictions generatePaymentRestrictions(Boolean local, Boolean master, Boolean voucher) {
        PostPaymentRequest.PaymentRestrictions restrictions = new PostPaymentRequest.PaymentRestrictions();
            restrictions.setLocal(local ? "T":"F");
            restrictions.setMaster(master ? "T":"F");
            restrictions.setVoucher(voucher ? "T":"F");
        return restrictions;
    }




    public void checkResultStatus(PostPaymentResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }


    public void checkResultInfo(PostPaymentResponse response, String expectedPaymentInfo) {
        assertThat(
                response.getPaymentInfo(),
                CoreMatchers.equalTo(expectedPaymentInfo)
        );
    }




}
