package ru.hrs.lassd.club.ws;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.hrs.lassd.club.ws.action.*;
import ru.hrs.lassd.club.ws.schema.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class DocConfirmTest extends BaseTest {



    @Test
    public void confirmCheckVAT(){
        AcquireLoyaltyResponse acquireLoyaltyResponse = createCheck();
        double netItemPrice = data.miPrice + acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getDiscount();

            DocConfirmResponse response = docConfirmAction.docConfirm(
                    uniqueIDAction.generate(data.wsId),
                    acquireLoyaltyResponse.getPostingGUID(),
                    "",
                    null,
                    menuItemListAction.generate(netItemPrice),
                    paymentItemListAction.generate(false, utils.calcNetAmountVAT(netItemPrice, data.taxVATRate)),
                    taxItemListAction.generate(true, data.taxVATRate, utils.calcVAT(netItemPrice, data.taxVATRate))
            );
        docConfirmAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void confirmCheckAddon(){
        AcquireLoyaltyResponse acquireLoyaltyResponse = createCheck();
        double netItemPrice = data.miPrice + acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getDiscount();

            DocConfirmResponse response = docConfirmAction.docConfirm(
                        uniqueIDAction.generate(data.wsId),
                        acquireLoyaltyResponse.getPostingGUID(),
                        "",
                        null,
                        menuItemListAction.generate(netItemPrice),
                        paymentItemListAction.generate(false, utils.calcNetAmountAddon(netItemPrice, data.taxAddonRate)),
                        taxItemListAction.generate(true, data.taxAddonRate, utils.calcAddon(netItemPrice, data.taxAddonRate))
            );
        docConfirmAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void confirmWrongCheck(){
        DocConfirmResponse response = docConfirmAction.docConfirm(
                uniqueIDAction.generate(data.wsId),
                "666",
                "",
                null,
                menuItemListAction.generate(data.miPrice),
                paymentItemListAction.generate(false, utils.calcNetAmountVAT(data.miPrice, data.taxVATRate)),
                taxItemListAction.generate(true, data.taxVATRate, utils.calcVAT(data.miPrice, data.taxVATRate))
        );

        docConfirmAction.checkResultStatus(response, ResultStatusFlag.FAIL);
    }








    private AcquireLoyaltyResponse createCheck() {
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
                paymentOptionsTypeAction.generateWithDiscountRules()
        );
        acquireLoyaltyAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
        acquireLoyaltyAction.checkItemDiscount(response, 0, data.miPrice/-10);
        acquireLoyaltyAction.checkItemRedeem(response, 0, 0.0);
        acquireLoyaltyAction.checkItemBonus(response, 0, 0.0);
        acquireLoyaltyAction.checkItemSubscription(response, 0, 0.0);
        acquireLoyaltyAction.checkItemPoints(response, 0, 0.0);
        return response;
    }





    @Autowired private DocConfirmAction docConfirmAction;
    @Autowired private AcquireLoyaltyAction acquireLoyaltyAction;
    @Autowired private PaymentOptionsTypeAction paymentOptionsTypeAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private MenuItemListAction menuItemListAction;
    @Autowired private PaymentItemListAction paymentItemListAction;
    @Autowired private TaxItemListAction taxItemListAction;
}