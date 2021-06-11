package ru.hrs.lassd.club.ws;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.DepositAction;
import ru.hrs.lassd.club.ws.action.UniqueIDAction;
import ru.hrs.lassd.club.ws.entity.Fault;
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


    @Test @Ignore("TODO")
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
//        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultAccount(response, "DEPO");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfo(response, "Card is expired");
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
//        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultAccount(response, "DEPO");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfo(response, "Card is blocked");
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


    @Test @Ignore("TODO")
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
            depositAction.checkResultAccount(response, "DEPO");
            depositAction.checkResultCardId(response, data.profileCard);

                String postingGUID = response.getPostingGUID();
                long checkNumber = Long.parseLong(response.getCheckNumber());

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
                depositAction.checkResultCheckNumber(response, checkNumber);
                depositAction.checkResultPostingGUID(response, postingGUID);
                depositAction.checkResultAccount(response, "DEPO");
                //depositAction.checkResultCardId(response, data.profileCard);
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
    public void depositTopUpWithWrongVoucherCode() {
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
    public void depositTopUpWithWrongVoucherCampaign() {
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
    public void depositTopUpWithVoucherAndWrongAccount() {
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
                data.profileVoucherAmount,
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
    public void depositTopUpWithNegativeAmountAndVoucher() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                -9000000.0,
                data.employeeId,
                data.employeeName,
                null,
                utils.generateDigits(4),
                "",
                data.profileVoucherAmount,
                null,
                null,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultPostingGUID(response, "0");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfoContents(response, "Amount too large. Max amount: ");
    }


    @Test
    public void depositTopUpWithNegativeAmountAndAccount() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                -9000000.0,
                data.employeeId,
                data.employeeName,
                "DEPO",
                utils.generateDigits(4),
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultPostingGUID(response, "0");
        depositAction.checkResultPaymentAmount(response, 0.0);
        depositAction.checkResultPaymentInfoContents(response, "Amount too large. Max amount: ");
    }


    @Test
    public void depositTopUpWithClosedDoc() {
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
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultPaymentAmount(response, 5.0);
        depositAction.checkResultAccount(response, "DEPO");

            String postingGUID = response.getPostingGUID();

                response = depositAction.deposit(
                        "CID:" + data.profileCard,
                        postingGUID,
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
                depositAction.checkResultPostingGUID(response, postingGUID);
                depositAction.checkResultPaymentAmount(response, 0.0);
                depositAction.checkResultAccount(response, "DEPO");
                depositAction.checkResultPaymentInfo(response, "Operation error: DOC " + postingGUID + " already exist and confirmed");
    }


    @Test
    public void voucherTopUp() {
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
                data.profileVoucherAmount,
                null,
                null,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultPaymentAmount(response, 5.0);
        depositAction.checkResultVoucher(response, data.profileVoucherAmount);
    }


    @Test
    public void voucherSellToProfile() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                null,
                utils.generateDigits(4),
                data.profileVoucherAmountCampaign,
                null,
                data.profileCardSlave,
                null,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultPaymentAmount(response, 5.0);
    }


    @Test
    public void voucherSellWithItem() {
        DepositResponse response = depositAction.deposit(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                data.employeeId,
                data.employeeName,
                null,
                utils.generateDigits(4),
                data.profileVoucherItemsCampaign,
                null,
                data.profileCardSlave,
                data.miId,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultPaymentAmount(response, 5.0);
    }


    @Test
    public void subscriptionTopUp() {
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
                data.profileMembership,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultCardId(response, data.profileCard);
        depositAction.checkResultPaymentAmount(response, 5.0);
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
