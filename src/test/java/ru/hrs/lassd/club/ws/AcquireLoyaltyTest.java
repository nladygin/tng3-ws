package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.*;
import ru.hrs.lassd.club.ws.schema.AcquireLoyaltyResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;

import java.math.BigInteger;


@RunWith(SpringJUnit4ClassRunner.class)
public class AcquireLoyaltyTest extends BaseTest {



    @Test
    public void createCheck() {
        AcquireLoyaltyResponse response = acquireLoyaltyAction.acquireLoyalty(
                "CID:"+data.profileCard,
                String.valueOf(utils.generateDigits(10)),
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                String.valueOf(utils.generateDigits(4)),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                paymentOptionsTypeAction.generate()
        );
        acquireLoyaltyAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        acquireLoyaltyAction.checkItemDiscount(response, 0, data.miPrice/-10);
    }


    @Test
    public void createCheckWithServiceCharge() {
        AcquireLoyaltyResponse response = acquireLoyaltyAction.acquireLoyalty(
                "CID:"+data.profileCard,
                String.valueOf(utils.generateDigits(10)),
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                String.valueOf(utils.generateDigits(4)),
                data.employeeId,
                data.employeeName,
                3.0,
                menuItemListAction.generate(data.miPrice),
                paymentOptionsTypeAction.generate()
        );
        acquireLoyaltyAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        acquireLoyaltyAction.checkItemDiscount(response, 0, data.miPrice/-10);
    }


    @Test
    public void createCheckWithDiscount() {
        AcquireLoyaltyResponse response = acquireLoyaltyAction.acquireLoyalty(
                "CID:"+data.profileCard,
                String.valueOf(utils.generateDigits(10)),
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice-data.miDiscount,
                String.valueOf(utils.generateDigits(4)),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice, data.miDiscount),
                paymentOptionsTypeAction.generate()
        );
        acquireLoyaltyAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        acquireLoyaltyAction.checkItemDiscount(response, 0, 0.0);
    }


    @Test
    public void createCheckWithMealPeriod() {
        AcquireLoyaltyResponse response = acquireLoyaltyAction.acquireLoyalty(
                "CID:"+data.profileCard,
                String.valueOf(utils.generateDigits(10)),
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                1L,
                data.rvcNumber,
                data.miPrice,
                String.valueOf(utils.generateDigits(4)),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                paymentOptionsTypeAction.generate()
        );
        acquireLoyaltyAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        acquireLoyaltyAction.checkItemDiscount(response, 0, data.miPrice/-2);
    }


    @Test
    public void createCheckWithWrongCard() {
        AcquireLoyaltyResponse response = acquireLoyaltyAction.acquireLoyalty(
                "CID:666",
                String.valueOf(utils.generateDigits(10)),
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                String.valueOf(utils.generateDigits(4)),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                paymentOptionsTypeAction.generate()
        );
        acquireLoyaltyAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        acquireLoyaltyAction.checkResultInfo(response, "Can't find profile");
    }


    @Test
    public void createCheckWithWrongSiteId() {
        AcquireLoyaltyResponse response = acquireLoyaltyAction.acquireLoyalty(
                "CID:"+data.profileCard,
                String.valueOf(utils.generateDigits(10)),
                666,
                uniqueIDAction.generate(data.wsId),
                data.rvcNumber,
                data.miPrice,
                String.valueOf(utils.generateDigits(4)),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                paymentOptionsTypeAction.generate()
        );
        acquireLoyaltyAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        acquireLoyaltyAction.checkResultInfo(response, "Can't find site by key 666");
    }


    @Test
    public void createCheckWithWrongRvcNumber() {
        AcquireLoyaltyResponse response = acquireLoyaltyAction.acquireLoyalty(
                "CID:"+data.profileCard,
                String.valueOf(utils.generateDigits(10)),
                data.siteId,
                uniqueIDAction.generate(data.wsId),
                BigInteger.valueOf(666),
                data.miPrice,
                String.valueOf(utils.generateDigits(4)),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                paymentOptionsTypeAction.generate()
        );
        acquireLoyaltyAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        acquireLoyaltyAction.checkResultInfo(response, "Can't find rvc");
    }


    @Test
    public void createCheckWithWrongWS() {
        AcquireLoyaltyResponse response = acquireLoyaltyAction.acquireLoyalty(
                "CID:"+data.profileCard,
                String.valueOf(utils.generateDigits(10)),
                data.siteId,
                uniqueIDAction.generate("666", ""),
                data.rvcNumber,
                10.0,
                String.valueOf(utils.generateDigits(4)),
                data.employeeId,
                data.employeeName,
                menuItemListAction.generate(data.miPrice),
                paymentOptionsTypeAction.generate()
        );
        acquireLoyaltyAction.checkResultStatus(response, ResultStatusFlag.FAIL);
        acquireLoyaltyAction.checkResultInfo(response, "This connection is not listed under license [wsNum: '666', ip: '127.0.0.1']");
    }









    @Autowired private AcquireLoyaltyAction acquireLoyaltyAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private MenuItemListAction menuItemListAction;
    @Autowired private PaymentOptionsTypeAction paymentOptionsTypeAction;
}
