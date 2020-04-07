package ru.hrs.lassd.club.ws.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.config.Data;
import ru.hrs.lassd.club.ws.helper.Utils;
import ru.hrs.lassd.club.ws.schema.MenuItem;


import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class MenuItemAction {


/*
    public MenuItem generateMenuItem() {
        String salt = String.valueOf(utils.generateDigits(8));
        return createMenuItem(
                salt,
                "menu item " + salt,
                1,
                data.miPrice,
                data.miPrice,
                0.0,
                data.miSI,
                data.miFGrp,
                0.0,
                null,
                null,
                null
        );
    }
*/

    public MenuItem generateMenuItem(Double price, Double discount) {
        String salt = String.valueOf(utils.generateDigits(8));
        return createMenuItem(
                salt,
                "menu item " + salt,
                1,
                price,
                price,
                discount,
                data.miSI,
                data.miFGrp,
                0.0,
                null,
                null,
                null
        );
    }




    public MenuItem createMenuItem(
            String id,
            String name,
            int qty,
            double price,
            double extPrice,
            double discount,
            int majorGroup,
            int subGroup,
            double addonTax,
            XMLGregorianCalendar postingDate,
            String tickets,
            String reference
    ) {

        MenuItem mi = new MenuItem();

            mi.setId(id);
            mi.setName(name);
            mi.setQty(qty);
            mi.setPrice(price);
            mi.setExtPrice(extPrice);
            mi.setDiscount(discount);
            mi.setMajorGroup(majorGroup);
            mi.setSubGroup(subGroup);
            mi.setAddonTax(addonTax);
            mi.setPostingDate(postingDate);
            mi.setTickets(tickets);
            mi.setReference(reference);

        return mi;
    }





    @Autowired private Data data;
    @Autowired private Utils utils;
}
