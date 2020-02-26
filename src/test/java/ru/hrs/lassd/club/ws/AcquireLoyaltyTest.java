package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.*;
import ru.hrs.lassd.club.ws.schema.AcquireLoyaltyResponse;
import ru.hrs.lassd.club.ws.schema.UniqueID;


@RunWith(SpringJUnit4ClassRunner.class)
public class AcquireLoyaltyTest extends BaseTest {

    @Test
    public void createCheck() {

        AcquireLoyaltyResponse response = acquireLoyaltyAction.acquireLoyalty(
                String.valueOf(utils.generateDigits(10)),
                data.siteId,
                uniqueIDAction.generate(),
                data.outletID,
                10.0,
                "2345",
                data.employeeId,
                data.employeeName,
                "",
                1,
                0.0,
                menuItemListAction.generate(),
                paymentOptionsTypeAction.generate()
        );
    }




    @Autowired private AcquireLoyaltyAction acquireLoyaltyAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private MenuItemListAction menuItemListAction;
    @Autowired private PaymentOptionsTypeAction paymentOptionsTypeAction;
}
