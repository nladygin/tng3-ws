package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.config.Data;
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
            Boolean loanFlag,
            Boolean confirm
    ) {
        return deposit(
                number,
                null,
                null,
                null,
                postPropertyId,
                registerId,
                revenueCenterId,
                paymentAmount,
                cashierEmpId,
                cashierEmpName,
                "",
                account,
                checkNumber,
                loanFlag,
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




    public DepositResponse deposit(
            String number,
            UniqueID clientId,
            String postingGUID,
            String voidFlag,
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
            String voucherRecipient,
            String voucherItems,
            Long subscriptionId,
            String description,
            Boolean confirm
    ){
        DepositRequest request = new DepositRequest();

            request.setNumber(number);
            request.setClientId(clientId);
            request.setPostingGUID(postingGUID);
            request.setVoidFlag(voidFlag);
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
            request.setVoucherRecipient(voucherRecipient);
            request.setVoucherItems(voucherItems);
            request.setSubscriptionId(subscriptionId);
            request.setDescription(description);
            request.setConfirm(confirm);

        return (DepositResponse) soapHelper.go(request);
    }






    public void checkResultStatus(DepositResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }


    public void checkResultPaymentAmount(DepositResponse response, Double paymentAmount) {
        assertThat(
                Double.valueOf(response.getPaymentAmount()),
                CoreMatchers.equalTo(paymentAmount)
        );
    }

}
