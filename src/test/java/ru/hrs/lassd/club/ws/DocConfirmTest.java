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
    public void confirmCheckWithVATByDummy(){
        AcquireLoyaltyResponse acquireLoyaltyResponse = makeAcquireLoyalty();
            long miId = Long.parseLong(acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getId());
            double itemDiscount = acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getDiscount();
            double itemPrice = data.miPrice + itemDiscount;
            double tax = utils.calcVAT(itemPrice, data.taxVATRate);

                DocConfirmResponse response = docConfirmAction.docConfirm(
                        uniqueIDAction.generate(data.wsId),
                        acquireLoyaltyResponse.getPostingGUID(),
                        "",
                        null,
                        menuItemListAction.generate(miId, data.miPrice, itemDiscount, tax),
                        paymentItemListAction.generate(false, itemPrice),
                        taxItemListAction.generate(true, data.taxVATRate, utils.calcVAT(itemPrice, data.taxVATRate))
                );
        docConfirmAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void confirmCheckWithVATByDeposit(){
        AcquireLoyaltyResponse acquireLoyaltyResponse = makeAcquireLoyalty();
            String postingGUID = acquireLoyaltyResponse.getPostingGUID();
            long miId = Long.parseLong(acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getId());
            double itemDiscount = acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getDiscount();
            double itemPrice = data.miPrice + itemDiscount;
            double tax = utils.calcVAT(itemPrice, data.taxVATRate);

            makePostPayment(postingGUID, miId, itemPrice, itemDiscount, 0.0);

                DocConfirmResponse response = docConfirmAction.docConfirm(
                        uniqueIDAction.generate(data.wsId),
                        postingGUID,
                        "",
                        null,
                        menuItemListAction.generate(miId, data.miPrice, itemDiscount, tax),
                        paymentItemListAction.generate(true, itemPrice),
                        taxItemListAction.generate(true, data.taxVATRate, utils.calcVAT(itemPrice, data.taxVATRate))
                );
        docConfirmAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void confirmCheckWithAddonByDummy(){
        AcquireLoyaltyResponse acquireLoyaltyResponse = makeAcquireLoyalty();
            long miId = Long.parseLong(acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getId());
            double itemDiscount = acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getDiscount();
            double itemNetPrice = data.miPrice + itemDiscount;
            double tax = utils.calcAddon(itemNetPrice, data.taxAddonRate);
            double itemPrice = itemNetPrice + tax;

                DocConfirmResponse response = docConfirmAction.docConfirm(
                        uniqueIDAction.generate(data.wsId),
                        acquireLoyaltyResponse.getPostingGUID(),
                        "",
                        null,
                        menuItemListAction.generate(miId, data.miPrice, itemDiscount, tax),
                        paymentItemListAction.generate(false, itemPrice),
                        taxItemListAction.generate(false, data.taxAddonRate, utils.calcAddon(itemNetPrice, data.taxAddonRate))
                );
        docConfirmAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
    }


    @Test
    public void confirmCheckWithAddonByDeposit(){
        AcquireLoyaltyResponse acquireLoyaltyResponse = makeAcquireLoyalty();
            String postingGUID = acquireLoyaltyResponse.getPostingGUID();
            long miId = Long.parseLong(acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getId());
            double itemDiscount = acquireLoyaltyResponse.getLoyaltyMenuItemList().getLoyaltyMenuItem().get(0).getDiscount();
            double itemNetPrice = data.miPrice + itemDiscount;
            double tax = utils.calcAddon(itemNetPrice, data.taxAddonRate);
            double itemPrice = utils.round(itemNetPrice + tax, 2);

                makePostPayment(postingGUID, miId, itemPrice, -1*itemDiscount, tax);

                DocConfirmResponse response = docConfirmAction.docConfirm(
                        uniqueIDAction.generate(data.wsId),
                        postingGUID,
                        "",
                        null,
                        menuItemListAction.generate(miId, data.miPrice, itemDiscount, tax),
                        paymentItemListAction.generate(true, itemPrice),
                        taxItemListAction.generate(false, data.taxAddonRate, utils.calcAddon(itemNetPrice, data.taxAddonRate))
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








    private AcquireLoyaltyResponse makeAcquireLoyalty() {
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


    private PostPaymentResponse makePostPayment(String postingGUID, long miId, double amount, double miDiscount, double addonTax) {
            PostPaymentResponse response = postPaymentAction.postPayment(
                    "CID:" + data.profileCard,
                    postingGUID,
                    data.siteId,
                    uniqueIDAction.generate(data.wsId),
                    data.rvcNumber,
                    amount,
                    amount,
                    utils.generateDigits(4),
                    data.employeeId,
                    data.employeeName,
                    menuItemListAction.generate(miId, data.miPrice, -1*miDiscount, addonTax),
                    postPaymentAction.generatePaymentRestrictions()
            );
            postPaymentAction.checkResultStatus(response, ResultStatusFlag.SUCCESS);
            postPaymentAction.checkResultPaymentAmount(response, amount);
        return response;
    }





    @Autowired private DocConfirmAction docConfirmAction;
    @Autowired private AcquireLoyaltyAction acquireLoyaltyAction;
    @Autowired private PostPaymentAction postPaymentAction;
    @Autowired private PaymentOptionsTypeAction paymentOptionsTypeAction;
    @Autowired private UniqueIDAction uniqueIDAction;
    @Autowired private MenuItemListAction menuItemListAction;
    @Autowired private PaymentItemListAction paymentItemListAction;
    @Autowired private TaxItemListAction taxItemListAction;
}