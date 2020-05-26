package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.AddKeyAction;
import ru.hrs.lassd.club.ws.action.RedeemItemVoucherAction;
import ru.hrs.lassd.club.ws.schema.AddKeyResponse;
import ru.hrs.lassd.club.ws.schema.RedeemItemVoucherResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;

import java.math.BigInteger;


@RunWith(SpringJUnit4ClassRunner.class)
public class RedeemItemVoucherTest extends BaseTest {


    @Test
    public void redeemVoucher() {
        RedeemItemVoucherResponse response = redeemItemVoucherAction.redeemVoucher(
                data.siteId,
                data.rvcNumber,
                utils.generateDigits(4),
                10.0,
                data.employeeName,
                data.profileVoucherExtraItems

        );
        redeemItemVoucherAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        redeemItemVoucherAction.isItemNumberEqual(response, 1);
        redeemItemVoucherAction.checkCardId(response, data.profileCard);
    }


    @Test
    public void redeemVoucherWithWrongSite() {
        RedeemItemVoucherResponse response = redeemItemVoucherAction.redeemVoucher(
                666,
                data.rvcNumber,
                utils.generateDigits(4),
                10.0,
                data.employeeName,
                data.profileVoucherExtraItems

        );
        redeemItemVoucherAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        redeemItemVoucherAction.checkRedeemInfo(response, "Can't find site by key 666");
    }


    @Test
    public void redeemVoucherWithWrongOutlet() {
        RedeemItemVoucherResponse response = redeemItemVoucherAction.redeemVoucher(
                data.siteId,
                BigInteger.valueOf(666),
                utils.generateDigits(4),
                10.0,
                data.employeeName,
                data.profileVoucherExtraItems

        );
        redeemItemVoucherAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        redeemItemVoucherAction.checkRedeemInfo(response, "Can't find rvc");
    }


    @Test
    public void redeemWrongVoucher() {
        RedeemItemVoucherResponse response = redeemItemVoucherAction.redeemVoucher(
                data.siteId,
                data.rvcNumber,
                utils.generateDigits(4),
                10.0,
                data.employeeName,
                "WrongVoucher"

        );
        redeemItemVoucherAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        redeemItemVoucherAction.checkRedeemInfo(response, "Voucher not found or inactive");
    }


    @Test
    public void redeemInactiveVoucher() {
        RedeemItemVoucherResponse response = redeemItemVoucherAction.redeemVoucher(
                data.siteId,
                data.rvcNumber,
                utils.generateDigits(4),
                10.0,
                data.employeeName,
                data.profileVoucherInactiveExtraItems
        );
        redeemItemVoucherAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        redeemItemVoucherAction.checkRedeemInfo(response, "Voucher not found or inactive");
    }








    @Autowired private RedeemItemVoucherAction redeemItemVoucherAction;
}
