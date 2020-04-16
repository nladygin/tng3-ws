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


@RunWith(SpringJUnit4ClassRunner.class)
public class DepositTest extends BaseTest {


    @Test
    public void depositTopUp() {
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
                false,
                true
        );
        depositAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        depositAction.checkResultPaymentAmount(response, 5.0);
    }






    @Autowired private DepositAction depositAction;
    @Autowired private UniqueIDAction uniqueIDAction;
}
