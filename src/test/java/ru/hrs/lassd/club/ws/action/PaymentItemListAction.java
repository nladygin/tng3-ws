package ru.hrs.lassd.club.ws.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.PaymentListType;

@Component
public class PaymentItemListAction {



    public PaymentListType generate(boolean isDeposit, double amount) {
        PaymentListType paymentListType = new PaymentListType();
            if (isDeposit) {
                paymentListType.getPaymentListItem().add(paymentItemAction.generateDepositPaymentItem(amount));
            } else {
                paymentListType.getPaymentListItem().add(paymentItemAction.generatePaymentItem(amount));
            }
        return paymentListType;
    }




    @Autowired private PaymentItemAction paymentItemAction;
}
