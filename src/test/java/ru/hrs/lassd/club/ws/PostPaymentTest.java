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
                5.0,
                5.0,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 5.0);
    }


    @Test
    public void createCheckWithItemDiscount(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                1.0,
                1.0,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice, 4.0),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 1.0);
    }


    @Test
    public void createCheckWithPartialPayment(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                1.0,
                5.0,
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
                5.0,
                5.0,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 2.5);
    }


    @Test
    public void createCheckWithPaymentLimitWithDiscount(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "MSW:" + data.profileExtraMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                1.0,
                1.0,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice, 4.0),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 0.5);
    }


    @Test
    public void attachCheckByCard(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                5.0,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                "ATTACH:" + data.siteId + ":" + data.rvcNumber,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 5.0);
    }


    @Test
    public void attachCheckByMagstripe(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "MSW:" + data.profileMagstripe,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                5.0,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                "ATTACH:" + data.siteId + ":" + data.rvcNumber,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 5.0);
    }


    @Test
    public void attachCheckByTicket(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "MSW:" + data.profileTicket,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                5.0,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                "ATTACH:" + data.siteId + ":" + data.rvcNumber,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions()
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 5.0);
    }


    @Test
    public void createCheckWithRouting(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCardSlave,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                5.0,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                postPaymentAction.generatePaymentRestrictions(false, true, false)
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 5.0);
    }


    @Test
    public void createCheckWithDeniedRouting(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCardSlave,
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                5.0,
                5.0,
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
                5.0,
                5.0,
                utils.generateDigits(4),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                data.profileVoucher,
                postPaymentAction.generatePaymentRestrictions(false, false, true)
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        postPaymentAction.checkResultPaymentAmount(response, 5.0);
    }










    @Autowired private PostPaymentAction postPaymentAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private MenuItemListAction menuItemListAction;
}