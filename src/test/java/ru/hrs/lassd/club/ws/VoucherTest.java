package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.AddKeyAction;
import ru.hrs.lassd.club.ws.action.VoucherAction;
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
        voucherAction.checkResultInactiveReason(response, "");
        voucherAction.checkResultDescription(response, "auto voucher");
        voucherAction.checkResultExpiryDate(response, "2021-03-27");
        voucherAction.checkResultCardId(response, data.profileCard);
    }

/* TODO */
    @Test
    public void getLockedVoucher() {
        VoucherResponse response = voucherAction.getVoucher(
                data.profileVoucherLocked
        );
        voucherAction.checkResultId(response, new BigInteger("2634"));
        voucherAction.checkResultCampaign(response, "A-auto");
        voucherAction.checkResultStatus(response, "lock");
        voucherAction.checkResultInactiveReason(response, "");
        voucherAction.checkResultDescription(response, "auto voucher");
        voucherAction.checkResultExpiryDate(response, "2030-01-01");
        voucherAction.checkResultCardId(response, data.profileCard);
    }


    @Test
    public void getWrongVoucher() {
        VoucherResponse response = voucherAction.getVoucher(
                "666"
        );
        voucherAction.checkResultId(response, new BigInteger("2636"));
        voucherAction.checkResultCampaign(response, "A-auto");
        voucherAction.checkResultStatus(response, "create");
        voucherAction.checkResultInactiveReason(response, "");
        voucherAction.checkResultDescription(response, "auto voucher");
        voucherAction.checkResultExpiryDate(response, "2021-03-27");
        voucherAction.checkResultCardId(response, data.profileCard);
    }




    @Autowired private VoucherAction voucherAction;
}
