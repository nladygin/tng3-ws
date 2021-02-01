package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.AddKeyAction;
import ru.hrs.lassd.club.ws.action.VoucherAction;
import ru.hrs.lassd.club.ws.entity.Fault;
import ru.hrs.lassd.club.ws.schema.AddKeyResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;
import ru.hrs.lassd.club.ws.schema.VoucherResponse;

import java.math.BigInteger;


@RunWith(SpringJUnit4ClassRunner.class)
public class VoucherTest extends BaseTest {


    @Test
    public void getVoucher() {
        VoucherResponse response = voucherAction.getVoucher(
            data.profileVoucherAmount
        );
        voucherAction.checkResultId(response, new BigInteger("2636"));
        voucherAction.checkResultCampaign(response, "A-auto");
        voucherAction.checkResultStatus(response, "create");
        voucherAction.checkResultInactiveReason(response, null);
        voucherAction.checkResultDescription(response, "auto voucher");
        voucherAction.checkResultExpiryDate(response, "2030-01-01");
        voucherAction.checkResultCardId(response, data.profileCard);
    }


    @Test
    public void getLockedVoucher() {
        VoucherResponse response = voucherAction.getVoucher(
                data.profileVoucherLocked
        );
        voucherAction.checkResultId(response, new BigInteger("2634"));
        voucherAction.checkResultCampaign(response, "A-auto");
        voucherAction.checkResultStatus(response, "lock");
        voucherAction.checkResultInactiveReason(response, "Voucher is locked");
        voucherAction.checkResultDescription(response, "auto voucher");
        voucherAction.checkResultExpiryDate(response, "2030-01-01");
        voucherAction.checkResultCardId(response, data.profileCard);
    }


    @Test
    public void getExpiredVoucher() {
        VoucherResponse response = voucherAction.getVoucher(
                data.profileVoucherExpired
        );
        voucherAction.checkResultId(response, new BigInteger("2841"));
        voucherAction.checkResultCampaign(response, "A-auto");
        voucherAction.checkResultStatus(response, "expire");
        voucherAction.checkResultInactiveReason(response, "Voucher expired");
        voucherAction.checkResultDescription(response, "auto voucher");
        voucherAction.checkResultExpiryDate(response, "2020-01-02");
        voucherAction.checkResultCardId(response, data.profileCard);
    }


    @Test
    public void getConsumedVoucher() {
        VoucherResponse response = voucherAction.getVoucher(
                data.profileVoucherConsumed
        );
        voucherAction.checkResultId(response, new BigInteger("2694"));
        voucherAction.checkResultCampaign(response, "A-auto");
        voucherAction.checkResultStatus(response, "consume");
        voucherAction.checkResultInactiveReason(response, "Voucher is already consumed");
        voucherAction.checkResultDescription(response, "auto voucher");
        voucherAction.checkResultExpiryDate(response, "2021-03-31");
        voucherAction.checkResultCardId(response, data.profileCard);
    }


    @Test
    public void getWrongVoucher() {
        Fault response = voucherAction.getWrongVoucher(
                "666",
                null
        );
        voucherAction.checkFaultMessageIsEqualTo(response, "Unknown voucher code");
    }



    @Autowired private VoucherAction voucherAction;
}
