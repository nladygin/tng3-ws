package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.*;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class RedeemItemVoucherAction extends BaseAction{




    /* required */
    public RedeemItemVoucherResponse redeemVoucher(
            int postPropertyId,
            BigInteger revenueCenterId,
            long checkNumber,
            Double chkTtl,
            String cashierEmpName,
            String voucher
    ){
        return redeemVoucher(
                null,
                postPropertyId,
                revenueCenterId,
                false,
                checkNumber,
                chkTtl,
                cashierEmpName,
                voucher
        );
    }




    public RedeemItemVoucherResponse redeemVoucher(
            String postingGUID,
            int postPropertyId,
            BigInteger revenueCenterId,
            Boolean voidFlag,
            long checkNumber,
            Double chkTtl,
            String cashierEmpName,
            String voucher
    ) {
        RedeemItemVoucherRequest request = new RedeemItemVoucherRequest();
            request.setPostingGUID(postingGUID);
            request.setPostPropertyId(String.valueOf(postPropertyId));
            request.setRevenueCenterId(String.valueOf(revenueCenterId));
            request.setVoidFlag(voidFlag);
            request.setCheckNumber(String.valueOf(checkNumber));
            request.setChkTtl(String.valueOf(chkTtl));
            request.setCashierEmpName(cashierEmpName);
            request.setVoucher(voucher);

        return (RedeemItemVoucherResponse) soapHelper.go(request);
    }





    public void checkResultStatus(RedeemItemVoucherResponse response, ResultStatusFlag expectedResultStatusFlag) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatusFlag)
        );
    }


    public void isItemNumberEqual(RedeemItemVoucherResponse response, int expectedNumber) {
        assertThat(
                response.getLoyaltyMenuItemList().getLoyaltyMenuItem().size(),
                CoreMatchers.equalTo(expectedNumber)
        );
    }


    public void checkRedeemInfo(RedeemItemVoucherResponse response, String expectedRedeemInfo) {
        assertThat(
                response.getRedeemInfo(),
                CoreMatchers.equalTo(expectedRedeemInfo)
        );
    }


    public void checkCardId(RedeemItemVoucherResponse response, int expectedCardId) {
        assertThat(
                response.getCardId(),
                CoreMatchers.equalTo(String.valueOf(expectedCardId))
        );
    }


}
