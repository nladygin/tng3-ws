package ru.hrs.lassd.club.ws.action;


import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.PaymentOptionsType;

@Component
public class PaymentOptionsTypeAction {



    public PaymentOptionsType generate(){
        return generate(
                false,
                false,
                false,
                true,
                true,
                false,
                true
        );
    }



    public PaymentOptionsType generate(
            boolean subscriptionRedeem,
            boolean bonusRedeem,
            boolean discountRedeem,
            boolean discountRules,
            boolean bonusRules,
            boolean subscriptionPurchase,
            boolean bonusTriggers
    ){
        PaymentOptionsType pot = new PaymentOptionsType();
            pot.setSubscriptionRedeem(subscriptionRedeem ? "T" : "F");
            pot.setBonusRedeem(bonusRedeem ? "T" : "F");
            pot.setDiscountRedeem(discountRedeem ? "T" : "F");
            pot.setDiscountRules(discountRules ? "T" : "F");
            pot.setBonusRules(bonusRules ? "T" : "F");
            pot.setSubscriptionPurchase(subscriptionPurchase ? "T" : "F");
            pot.setBonusTriggers(bonusTriggers ? "T" : "F");

        return pot;
    }




}
