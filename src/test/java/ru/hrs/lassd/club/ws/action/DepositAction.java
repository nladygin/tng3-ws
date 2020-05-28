package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.entity.Fault;
import ru.hrs.lassd.club.ws.schema.*;

import javax.xml.datatype.XMLGregorianCalendar;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class DepositAction extends BaseAction{



    /* required */
    public DepositResponse deposit(
            String number,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            Double paymentAmount,
            int cashierEmpId,
            String cashierEmpName,
            String account,
            long checkNumber,
            Boolean confirm
    ) {
        return deposit(
                number,
                null,
                null,
                false,
                postPropertyId,
                registerId,
                revenueCenterId,
                paymentAmount,
                cashierEmpId,
                cashierEmpName,
                "",
                account,
                checkNumber,
                false,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                confirm
        );
    }



    /* with posting GUID */
    public DepositResponse deposit(
            String number,
            String postingGUID,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            Double paymentAmount,
            int cashierEmpId,
            String cashierEmpName,
            String account,
            long checkNumber,
            Boolean confirm
    ) {
        return deposit(
                number,
                null,
                postingGUID,
                false,
                postPropertyId,
                registerId,
                revenueCenterId,
                paymentAmount,
                cashierEmpId,
                cashierEmpName,
                "",
                account,
                checkNumber,
                false,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                confirm
        );
    }



    /* void */
    public DepositResponse deposit(
            String number,
            String postingGUID,
            Boolean voidFlag,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            int cashierEmpId,
            String cashierEmpName,
            String account,
            long checkNumber,
            Boolean confirm
    ) {
        return deposit(
                number,
                null,
                postingGUID,
                voidFlag,
                postPropertyId,
                registerId,
                revenueCenterId,
                0.0,
                cashierEmpId,
                cashierEmpName,
                "",
                account,
                checkNumber,
                false,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                confirm
        );
    }



    /* loan with expire date */
    public DepositResponse deposit(
            String number,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            Double paymentAmount,
            int cashierEmpId,
            String cashierEmpName,
            String account,
            long checkNumber,
            XMLGregorianCalendar expiryDate,
            Boolean confirm
    ) {
        return deposit(
                number,
                null,
                null,
                false,
                postPropertyId,
                registerId,
                revenueCenterId,
                paymentAmount,
                cashierEmpId,
                cashierEmpName,
                "",
                account,
                checkNumber,
                true,
                expiryDate,
                null,
                null,
                null,
                null,
                null,
                null,
                confirm
        );
    }


    /* voucher */
    public DepositResponse deposit(
            String number,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            Double paymentAmount,
            int cashierEmpId,
            String cashierEmpName,
            String account,
            long checkNumber,
            String voucherType,
            String voucher,
            Integer voucherRecipient,
            Long voucherItems,
            Boolean confirm
    ) {
        return deposit(
                number,
                null,
                null,
                false,
                postPropertyId,
                registerId,
                revenueCenterId,
                paymentAmount,
                cashierEmpId,
                cashierEmpName,
                "",
                account,
                checkNumber,
                false,
                null,
                voucherType,
                voucher,
                voucherRecipient,
                voucherItems,
                null,
                null,
                confirm
        );
    }


    /* subscription */
    public DepositResponse deposit(
            String number,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            Double paymentAmount,
            int cashierEmpId,
            String cashierEmpName,
            String account,
            long checkNumber,
            long subscriptionId,
            Boolean confirm
    ) {
        return deposit(
                number,
                null,
                null,
                false,
                postPropertyId,
                registerId,
                revenueCenterId,
                paymentAmount,
                cashierEmpId,
                cashierEmpName,
                "",
                account,
                checkNumber,
                false,
                null,
                null,
                null,
                null,
                null,
                subscriptionId,
                null,
                confirm
        );
    }




    public DepositResponse deposit(
            String number,
            UniqueID clientId,
            String postingGUID,
            Boolean voidFlag,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            Double paymentAmount,
            int cashierEmpId,
            String cashierEmpName,
            String cashierOptMask,
            String account,
            long checkNumber,
            Boolean loanFlag,
            XMLGregorianCalendar expiryDate,
            String voucherType,
            String voucher,
            Integer voucherRecipient,
            Long voucherItems,
            Long subscriptionId,
            String description,
            Boolean confirm
    ){
        DepositRequest request = new DepositRequest();

            request.setNumber(number);
            request.setClientId(clientId);
            request.setPostingGUID(postingGUID);
            request.setVoidFlag(voidFlag ? "T" : "F");
            request.setPostPropertyId(String.valueOf(postPropertyId));
            request.setRegisterId(registerId);
            request.setRevenueCenterId(String.valueOf(revenueCenterId));
            request.setPaymentAmount(String.valueOf(paymentAmount));
            request.setCashierEmpId(String.valueOf(cashierEmpId));
            request.setCashierEmpName(cashierEmpName);
            request.setCashierOptMask(cashierOptMask);
            request.setAccount(account);
            request.setCheckNumber(String.valueOf(checkNumber));
            request.setLoanFlag(loanFlag ? "T" : "F");
            request.setExpiryDate(expiryDate);
            request.setVoucherType(voucherType);
            request.setVoucher(voucher);
            request.setVoucherRecipient(String.valueOf(voucherRecipient));
            request.setVoucherItems(String.valueOf(voucherItems));
            request.setSubscriptionId(subscriptionId);
            request.setDescription(description);
            request.setConfirm(confirm);

        return (DepositResponse) soapHelper.go(request);
    }


    /* required with fault result */
    public Fault depositFault(
            String number,
            int postPropertyId,
            UniqueID registerId,
            BigInteger revenueCenterId,
            Double paymentAmount,
            int cashierEmpId,
            String cashierEmpName,
            String account,
            long checkNumber,
            Boolean confirm
    ) {
        DepositRequest request = new DepositRequest();

        request.setNumber(number);
        request.setPostPropertyId(String.valueOf(postPropertyId));
        request.setRegisterId(registerId);
        request.setRevenueCenterId(String.valueOf(revenueCenterId));
        request.setPaymentAmount(String.valueOf(paymentAmount));
        request.setCashierEmpId(String.valueOf(cashierEmpId));
        request.setCashierEmpName(cashierEmpName);
        request.setAccount(account);
        request.setCheckNumber(String.valueOf(checkNumber));
        request.setConfirm(confirm);

        return (Fault) soapHelper.go(request);
    }







    public void checkResultStatus(DepositResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }


    public void checkResultPostingGUID(DepositResponse response, String postingGUID) {
        assertThat(
                response.getPostingGUID(),
                CoreMatchers.equalTo(postingGUID)
        );
    }


    public void checkResultCheckNumber(DepositResponse response, long checkNumber) {
        assertThat(
                Long.parseLong(response.getCheckNumber()),
                CoreMatchers.equalTo(checkNumber)
        );
    }


    public void checkResultPaymentAmount(DepositResponse response, Double paymentAmount) {
        assertThat(
                Double.valueOf(response.getPaymentAmount()),
                CoreMatchers.equalTo(paymentAmount)
        );
    }


    public void checkResultAccount(DepositResponse response, String account) {
        assertThat(
                response.getAccount(),
                CoreMatchers.equalTo(account)
        );
    }


    public void checkResultPaymentInfo(DepositResponse response, String paymentInfo) {
        assertThat(
                response.getPaymentInfo(),
                CoreMatchers.equalTo(paymentInfo)
        );
    }


    public void checkResultPaymentInfoContents(DepositResponse response, String paymentInfoPart) {
        assertThat(
                response.getPaymentInfo().contains(paymentInfoPart),
                CoreMatchers.equalTo(true)
        );
    }


    public void checkResultCardId(DepositResponse response, int cardId) {
        assertThat(
                Integer.valueOf(response.getCardId()),
                CoreMatchers.equalTo(cardId)
        );
    }


    public void checkResultVoucher(DepositResponse response, String voucher) {
        assertThat(
                response.getVoucher(),
                CoreMatchers.equalTo(voucher)
        );
    }


    public void checkResultFaultStringIsEqualTo(Fault response, String expectedFaultString) {
        assertThat(
                response.getFaultString(),
                CoreMatchers.equalTo(expectedFaultString)
        );
    }


}
