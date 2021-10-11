package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.DepositPackageAction;
import ru.hrs.lassd.club.ws.action.UniqueIDAction;
import ru.hrs.lassd.club.ws.helper.Utils;
import ru.hrs.lassd.club.ws.schema.DepositItemList;
import ru.hrs.lassd.club.ws.schema.DepositPackageResponse;
import ru.hrs.lassd.club.ws.schema.ResultStatusFlag;

import javax.xml.datatype.DatatypeConfigurationException;


@RunWith(SpringJUnit4ClassRunner.class)
public class DepositPackageTest extends BaseTest {


    @Test
    public void depositPackage() throws DatatypeConfigurationException {
        DepositItemList depositItemList = new DepositItemList();
        depositItemList.getDepositItem().add(
                depositPackageAction.createDepositItem(
                "",
                utils.generateDateXML(0),
                data.siteId,
                null,
                data.outletID,
                10.0,
                data.employeeId,
                data.employeeName,
                "",
                false,
                null,
                "ws autotest"
        ));
        DepositPackageResponse response = depositPackageAction.depositPackage(
                "CID:" + data.profileCard,
                null,
                "DEPO",
                depositItemList,
                true
        );
        depositPackageAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void depositPackageWithLoan() throws DatatypeConfigurationException {
        DepositItemList depositItemList = new DepositItemList();
        depositItemList.getDepositItem().add(
                depositPackageAction.createDepositItem(
                "",
                utils.generateDateXML(0),
                data.siteId,
                null,
                data.outletID,
                20.0,
                data.employeeId,
                data.employeeName,
                "",
                true,
                utils.generateDateXML(10),
                "ws autotest"
        ));
        DepositPackageResponse response = depositPackageAction.depositPackage(
                "CID:" + data.profileCard,
                null,
                "DEPO",
                depositItemList,
                true
        );
        depositPackageAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void depositPackageMultiple() throws DatatypeConfigurationException {
        DepositItemList depositItemList = new DepositItemList();
        depositItemList.getDepositItem().add(
                depositPackageAction.createDepositItem(
                "",
                utils.generateDateXML(0),
                data.siteId,
                null,
                data.outletID,
                10.0,
                data.employeeId,
                data.employeeName,
                "",
                true,
                utils.generateDateXML(10),
                "ws autotest"
        ));
        depositItemList.getDepositItem().add(
                depositPackageAction.createDepositItem(
                        "",
                        utils.generateDateXML(0),
                        data.siteId,
                        null,
                        data.outletID,
                        20.0,
                        data.employeeId,
                        data.employeeName,
                        "",
                        true,
                        utils.generateDateXML(10),
                        "ws autotest"
                ));
        DepositPackageResponse response = depositPackageAction.depositPackage(
                "CID:" + data.profileCard,
                null,
                "DEPO",
                depositItemList,
                true
        );
        depositPackageAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }




    @Autowired private DepositPackageAction depositPackageAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private Utils utils;
}
