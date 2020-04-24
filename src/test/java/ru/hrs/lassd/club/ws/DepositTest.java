package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.AddKeyAction;
import ru.hrs.lassd.club.ws.action.DepositAction;
import ru.hrs.lassd.club.ws.action.UniqueIDAction;
import ru.hrs.lassd.club.ws.schema.AddKeyResponse;
import ru.hrs.lassd.club.ws.schema.DepositResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;

import javax.xml.datatype.DatatypeConfigurationException;
import java.math.BigInteger;


@RunWith(SpringJUnit4ClassRunner.class)
public class DepositTest extends BaseTest {


    @Test
    public void depositTopUpByCardId() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultPaymentAmount(response, 5.0);
        depositAction.checkResultCardId(response, data.profileCard);
    }


    @Test
    public void depositTopUpByWrongCardId() {
        DepositResponse response = depositAction.deposit(
                "CID:" + "666",
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultCardId(response, 666);
        depositAction.checkResultAccount(response, "DEPO");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfo(response, "Card with # 666 not found !");
        depositAction.checkResultPostingGUID(response, "0");
    }


    @Test
    public void depositTopUpByExpiredCard() {
        DepositResponse response = depositAction.deposit(
                "MSW:" + data.profileExpiredMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultAccount(response, "DEPO");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfo(response, "Card expired !");
        depositAction.checkResultPostingGUID(response, "0");
    }


    @Test
    public void depositTopUpByLockedCard() {
        DepositResponse response = depositAction.deposit(
                "MSW:" + data.profileLockedMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultAccount(response, "DEPO");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfo(response, "Card is locked !");
        depositAction.checkResultPostingGUID(response, "0");
    }


    @Test
    public void depositTopUpByMagstripe() {
        DepositResponse response = depositAction.deposit(
                "MSW:" + data.profileMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultPaymentAmount(response, 5.0);
        depositAction.checkResultCardId(response, data.profileCard);
    }


    @Test
    public void depositLoan() throws DatatypeConfigurationException {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                utils.generateDateXML(1),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultPaymentAmount(response, 5.0);
    }


    @Test
    public void depositLoanWithoutExpiry() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                null,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
    }


    @Test
    public void depositTopUpAndVoid() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultPaymentAmount(response, 5.0);

            String postingGUID = response.getPostingGUID();
            long checkNumber = utils.generateDigits(4);

            response = depositAction.deposit(
                    "CID:" + data.profileCard,
                    postingGUID,
                    true,
                    data.siteId,
                    uniqueIDAction.generate(data.wsId),
                    data.rvcNumber,
                    data.employeeId,
                    data.employeeName,
                    "DEPO",
                    checkNumber,
                    true
            );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultCheckNumber(response, String.valueOf(checkNumber));
        depositAction.checkResultPostingGUID(response, postingGUID);
        depositAction.checkResultAccount(response, "DEPO");
    }


    @Test
    public void depositVoidWithWrongPostingGUID() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                "666",
                true,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultAccount(response, "DEPO");
        depositAction.checkResultPaymentInfo(response, "Document not found - nothing to void");
        depositAction.checkResultPostingGUID(response, "666");
        depositAction.checkResultPaymentAmount(response, 0.0);
    }


    @Test
    public void depositVoidWithEmptyPostingGUID() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                "",
                true,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultAccount(response, "DEPO");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfo(response, "Void Failed: Invalid PostingGUID");
        depositAction.checkResultPostingGUID(response, "0");
    }


    @Test
    public void depositVoidWithWrongVoucherCode() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                "",
                "666",
                null,
                null,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultPaymentInfo(response, "Can't find voucher 666");
        depositAction.checkResultCardId(response, data.profileCard);
    }


    @Test
    public void depositVoidWithWrongVoucherCampaign() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                "666",
                "666",
                null,
                null,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultPaymentInfo(response, "Can't find voucher 666");
        depositAction.checkResultCardId(response, data.profileCard);
    }


    @Test
    public void depositVoidWithVoucherAndWrongAccount() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "WRONGACCOUNT",
                utils.generateDigits(4),
                null,
                data.profileVoucher,
                null,
                null,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultPostingGUID(response, "0");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultAccount(response, "WRONGACCOUNT");
        depositAction.checkResultPaymentInfo(response, "Account Not Found !");
    }


    @Test
    public void depositTopUpByDeniedAccount() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "NYDEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultAccount(response, "NYDEPO");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPostingGUID(response, "0");
        depositAction.checkResultPaymentInfo(response, "Posting to NY Deposit is not allowed for card type autotest ws !");
    }










    @Test
    public void depositTopUpWithWrongSite() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                666,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultPostingGUID(response, "0");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfo(response, "Site not found !");
    }


    @Test
    public void depositTopUpWithWrongRVC() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                BigInteger.valueOf(666),
                5.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfo(response, "Operation error: RVC666 is not configured");
    }









    @Autowired private DepositAction depositAction;
    @Autowired private UniqueIDAction uniqueIDAction;
}
