package ru.hrs.lassd.club.ws.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.config.Data;
import ru.hrs.lassd.club.ws.schema.Tax;

@Component
public class TaxItemAction {


    public Tax generateVATTax(
        double rate,
        double amount
    ) {
        return createTax(
                data.taxVATId,
                data.taxVATName,
                "VAT",
                rate,
                amount
        );
    }


    public Tax generateAddonTax(
            double rate,
            double amount
    ) {
        return createTax(
                data.taxAddonId,
                data.taxAddonName,
                "Add-on",
                rate,
                amount
        );
    }







    public Tax createTax(
            int id,
            String name,
            String type,
            double rate,
            double amount
    ) {

        Tax tax = new Tax();

            tax.setId(id);
            tax.setName(name);
            tax.setType(type);
            tax.setRate(rate);
            tax.setAmount(amount);

        return tax;
    }





    @Autowired private Data data;
}
