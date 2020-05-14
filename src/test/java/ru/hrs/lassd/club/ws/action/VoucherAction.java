package ru.hrs.lassd.club.ws.action;

import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.entity.Fault;
import ru.hrs.lassd.club.ws.schema.*;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class VoucherAction extends BaseAction{




    public VoucherResponse getVoucher(
            String code
    ){
        return getVoucher(code, null);
    }


    public VoucherResponse getVoucher(
            String code,
            String lang
    ) {
        VoucherRequest request = new VoucherRequest();
            request.setCode(code);
            request.setLang(lang);
        return (VoucherResponse) soapHelper.go(request);
    }


    public Fault getWrongVoucher(
            String code,
            String lang
    ) {
        VoucherRequest request = new VoucherRequest();
            request.setCode(code);
            request.setLang(lang);
        return (Fault) soapHelper.go(request);
    }







    public void checkResultId(VoucherResponse response, BigInteger expectedResultId) {
        assertThat(
                response.getId(),
                CoreMatchers.equalTo(expectedResultId)
        );
    }


    public void checkResultCampaign(VoucherResponse response, String expectedResultCampaign) {
        assertThat(
                response.getCampaign(),
                CoreMatchers.equalTo(expectedResultCampaign)
        );
    }


    public void checkResultStatus(VoucherResponse response, String expectedResultStatus) {
        assertThat(
                response.getStatus(),
                CoreMatchers.equalTo(expectedResultStatus)
        );
    }


    public void checkResultBalance(VoucherResponse response, double expectedResultBalance) {
        assertThat(
                response.getBalance(),
                CoreMatchers.equalTo(expectedResultBalance)
        );
    }


    public void checkResultInactiveReason(VoucherResponse response, String expectedResultInactiveReason) {
        assertThat(
                response.getInactiveReason(),
                CoreMatchers.equalTo(expectedResultInactiveReason)
        );
    }


    public void checkResultDescription(VoucherResponse response, String expectedResultDescription) {
        assertThat(
                response.getDescription(),
                CoreMatchers.equalTo(expectedResultDescription)
        );
    }


    public void checkResultExpiryDate(VoucherResponse response, String expectedResultExpiryDate) {
        assertThat(
                response.getExpiryDate(),
                CoreMatchers.equalTo(expectedResultExpiryDate)
        );
    }


    public void checkResultCardId(VoucherResponse response, int expectedCardId) {
        assertThat(
                response.getCardId(),
                CoreMatchers.equalTo(String.valueOf(expectedCardId))
        );
    }


}
