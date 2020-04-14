package ru.hrs.lassd.club.ws.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.schema.MenuItemList;
import ru.hrs.lassd.club.ws.schema.TaxListType;

@Component
public class TaxItemListAction {





    public TaxListType generate(boolean isVAT, double rate, double amount) {
        TaxListType taxListType = new TaxListType();
        if (isVAT) {
            taxListType.getTaxList().add(taxItemAction.generateVATTax(rate, amount));
        } else {
            taxListType.getTaxList().add(taxItemAction.generateAddonTax(rate,amount));
        }
        return taxListType;
    }




    @Autowired private TaxItemAction taxItemAction;
}
