package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.MenuItemListAction;
import ru.hrs.lassd.club.ws.action.PostPaymentAction;
import ru.hrs.lassd.club.ws.action.UniqueIDAction;
import ru.hrs.lassd.club.ws.schema.PostPaymentResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;


@RunWith(SpringJUnit4ClassRunner.class)
public class PostPaymentTest extends BaseTest {



    @Test
    public void createCheck(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice);
    }


    @Test
    public void createCheckWithItemDiscount(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice - data.miDiscount,
                data.miPrice - data.miDiscount,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice, data.miDiscount),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice - data.miDiscount);
    }


    @Test
    public void createCheckWithItemDiscountAndVATTax(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice - data.miDiscount,
                data.miPrice - data.miDiscount,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice, data.miDiscount, utils.calcVAT(data.miPrice-data.miDiscount, data.taxVATRate)),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice - data.miDiscount);
    }


    @Test
    public void createCheckWithItemDiscountAndAddonTax(){
        double tax = utils.calcAddon(data.miPrice - data.miDiscount, data.taxAddonRate);
            PostPaymentResponse response = postPaymentAction.postPayment(
                    "CID:" + data.profileCard,
                    data.siteId,
                    uniqueIDAction.generate(data.wsId),
                    data.rvcNumber,
                    data.miPrice - data.miDiscount + tax,
                    data.miPrice - data.miDiscount + tax,
                    utils.generateDigits(4),
                    data.employeeId,
                    data.employeeName,
                    menuItemListAction.generate(data.miPrice, -1*data.miDiscount, utils.calcAddon(data.miPrice-data.miDiscount, data.taxAddonRate)),
                    postPaymentAction.generatePaymentRestrictions()
            );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice - data.miDiscount + tax);
    }


    @Test
    public void createCheckWithPartialPayment(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                1.0,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 1.0);
    }


    @Test
    public void createCheckWithPaymentLimit(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "MSW:" + data.profileExtraMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice/2);
    }


    @Test
    public void createCheckWithPaymentLimitWithDiscount(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "MSW:" + data.profileExtraMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice - data.miDiscount,
                data.miPrice - data.miDiscount,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice, data.miDiscount),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, (data.miPrice - data.miDiscount)/2);
    }


    @Test
    public void attachCheckByCard(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                "ATTACH:" + data.siteId + ":" + data.rvcNumber,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice);
    }


    @Test
    public void attachCheckByMagstripe(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "MSW:" + data.profileMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                "ATTACH:" + data.siteId + ":" + data.rvcNumber,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice);
    }


    @Test
    public void attachCheckByTicket(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "MSW:" + data.profileTicket,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                "ATTACH:" + data.siteId + ":" + data.rvcNumber,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice);
    }


    @Test
    public void createCheckWithRouting(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCardSlave,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions(false, true, false)
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice);
    }


    @Test
    public void createCheckWithDeniedRouting(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCardSlave,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions(false, false, false)
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 0.0);
    }


    @Test
    public void createCheckWithVoucherPayment(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                data.profileVoucher,
                postPaymentAction.generatePaymentRestrictions(false, false, true)
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, data.miPrice);
    }


    @Test
    public void createCheckWithWrongVoucherPayment(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                "WRONGVOUCHERCODE",
                postPaymentAction.generatePaymentRestrictions(false, false, true)
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        postPaymentAction.checkResultPaymentAmount(response, 0.0);
        postPaymentAction.checkResultInfo(response, "Unknown voucher code");
    }


    @Test
    public void createCheckWithConsumedVoucherPayment(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                data.profileVoucherConsumed,
                postPaymentAction.generatePaymentRestrictions(false, false, true)
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        postPaymentAction.checkResultPaymentAmount(response, 0.0);
        postPaymentAction.checkResultInfo(response, "Voucher is already consumed");
    }


    @Test
    public void createCheckWithExpiredVoucherPayment(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                data.profileVoucherExpired,
                postPaymentAction.generatePaymentRestrictions(false, false, true)
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        postPaymentAction.checkResultPaymentAmount(response, 0.0);
        postPaymentAction.checkResultInfo(response, "VOUCHER_EXPIRED");
    }


    @Test
    public void createCheckWithLockedVoucherPayment(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                data.miPrice,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                data.profileVoucherLocked,
                postPaymentAction.generatePaymentRestrictions(false, false, true)
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        postPaymentAction.checkResultPaymentAmount(response, 0.0);
        postPaymentAction.checkResultInfo(response, "VOUCHER_LOCKED");
    }








    @Autowired private PostPaymentAction postPaymentAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private MenuItemListAction menuItemListAction;
}