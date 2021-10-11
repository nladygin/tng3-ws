package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.entity.Fault;
import ru.hrs.lassd.club.ws.helper.Utils;
import ru.hrs.lassd.club.ws.schema.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class DepositPackageAction extends BaseAction{

    public DepositPackageResponse depositPackage(
            String number,
            UniqueID clientId,
            String account,
            DepositItemList depositItemList,
            Boolean confirm
    ){
        DepositPackageRequest request = new DepositPackageRequest();
            request.setNumber(number);
            request.setClientId(clientId);
            request.setAccount(account);
            request.setDepositItemList(depositItemList);
            request.setConfirm(confirm);

        return (DepositPackageResponse) soapHelper.go(request);
    }





    public DepositItem createDepositItem(
            String postingGUID,
            XMLGregorianCalendar date,
            Integer propertyId,
            UniqueID registerId,
            Integer revenueCenterId,
            Double paymentAmount,
            Integer cashierEmpId,
            String cashierEmpName,
            String cashierOptMask,
            Boolean loanFlag,
            XMLGregorianCalendar expiryDate,
            String description) {
        DepositItem depositItem = new DepositItem();
        depositItem.setPostingGUID(postingGUID);
        depositItem.setPostingDate(date);
        depositItem.setPostPropertyId(String.valueOf(propertyId));
        depositItem.setRegisterId(registerId);
        depositItem.setRevenueCenterId(String.valueOf(revenueCenterId));
        depositItem.setPaymentAmount(String.valueOf(paymentAmount));
        depositItem.setCashierEmpId(String.valueOf(cashierEmpId));
        depositItem.setCashierEmpName(cashierEmpName);
        depositItem.setCashierOptMask(cashierOptMask);
        depositItem.setLoanFlag(loanFlag ? "T":"F");
        depositItem.setExpiryDate(expiryDate);
        depositItem.setDescription(description);
        return depositItem;
    }





    public void checkResultStatus(DepositPackageResponse response, ResultStatusFlag expectedResultStatusFlag) {
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


//    public void checkResultCardId(DepositPackageResponse response, int cardId) {
//        assertThat(
//                Integer.valueOf(response.getCardId()),
//                CoreMatchers.equalTo(cardId)
//        );
//    }


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
