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

import java.math.BigInteger;


@RunWith(SpringJUnit4ClassRunner.class)
public class PostPaymentTest extends BaseTest {



    @Test
    public void createCheck(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                String.valueOf(data.siteId),
                uniqueIDAction.generate(String.valueOf(data.wsId), ""),
                BigInteger.valueOf(data.rvcNumber),
                "10.0",
                "0.0",
                String.valueOf(utils.generateDigits(4)),
                String.valueOf(data.employeeId),
                data.employeeName,
                "",
                "1",
                "0.0",
                menuItemListAction.generate(),
                postPaymentAction.generatePaymentRestrictions(),
                false
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void createCheckWithConfirmation(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                String.valueOf(data.siteId),
                uniqueIDAction.generate(String.valueOf(data.wsId), ""),
                BigInteger.valueOf(data.rvcNumber),
                "10.0",
                "0.0",
                String.valueOf(utils.generateDigits(4)),
                String.valueOf(data.employeeId),
                data.employeeName,
                "",
                "1",
                "0.0",
                menuItemListAction.generate(),
                postPaymentAction.generatePaymentRestrictions(),
                true
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void createCheckWithItemDiscount(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                String.valueOf(data.siteId),
                uniqueIDAction.generate(String.valueOf(data.wsId), ""),
                BigInteger.valueOf(data.rvcNumber),
                "10.0",
                "0.0",
                String.valueOf(utils.generateDigits(4)),
                String.valueOf(data.employeeId),
                data.employeeName,
                "",
                "1",
                "0.0",
                menuItemListAction.generate(1, 4.0),
                postPaymentAction.generatePaymentRestrictions(),
                false
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void createCheckWithItemDiscountWithConfirmation(){
        PostPaymentResponse response = postPaymentAction.postPayment(
                "CID:" + data.profileCard,
                String.valueOf(data.siteId),
                uniqueIDAction.generate(String.valueOf(data.wsId), ""),
                BigInteger.valueOf(data.rvcNumber),
                "10.0",
                "0.0",
                String.valueOf(utils.generateDigits(4)),
                String.valueOf(data.employeeId),
                data.employeeName,
                "",
                "1",
                "0.0",
                menuItemListAction.generate(1, 4.0),
                postPaymentAction.generatePaymentRestrictions(),
                true
        );
        postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }






    @Autowired private PostPaymentAction postPaymentAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private MenuItemListAction menuItemListAction;
}