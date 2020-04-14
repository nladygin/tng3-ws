package ru.hrs.lassd.club.ws.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.config.Data;
import ru.hrs.lassd.club.ws.helper.Utils;
import ru.hrs.lassd.club.ws.schema.MenuItem;
import ru.hrs.lassd.club.ws.schema.PaymentListItem;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class PaymentItemAction {



    public PaymentListItem generatePaymentItem(
            double amount
    ){
        return createPaymentItem(
                data.tenderId,
                data.tenderName,
                amount,
                null
        );
    }


    public PaymentListItem generateDepositPaymentItem(
            double amount
    ){
        return createPaymentItem(
                data.depositTenderId,
                data.depositTenderName,
                amount,
                null
        );
    }





    public PaymentListItem createPaymentItem(
            int id,
            String name,
            double amount,
            Integer cashierShift
    ) {

        PaymentListItem paymentListItem = new PaymentListItem();

            paymentListItem.setId(id);
            paymentListItem.setName(name);
            paymentListItem.setAmout(amount);
            paymentListItem.setCashierShift(cashierShift);

        return paymentListItem;
    }





    @Autowired private Data data;
}
