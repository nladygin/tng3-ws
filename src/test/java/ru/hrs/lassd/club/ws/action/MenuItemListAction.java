package ru.hrs.lassd.club.ws.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.config.Data;
import ru.hrs.lassd.club.ws.helper.Utils;
import ru.hrs.lassd.club.ws.schema.MenuItem;
import ru.hrs.lassd.club.ws.schema.MenuItemList;

import javax.xml.datatype.XMLGregorianCalendar;

@Component
public class MenuItemListAction {



    public MenuItemList generate(Double price){
        return generate(1, price, 0.0);
    }

    public MenuItemList generate(Double price, Double discount) {
        return generate(1,  price, discount);
    }



    public MenuItemList generate(Double price, Double discount, Double tax) {
        MenuItemList miList = new MenuItemList();
            miList.getMenuItem().add(menuItemAction.generateMenuItem(price, discount, tax));
        return miList;
    }


    public MenuItemList generate(Long itemId, Double price, Double discount, Double tax) {
        MenuItemList miList = new MenuItemList();
        miList.getMenuItem().add(menuItemAction.generateMenuItem(itemId, price, discount, tax));
        return miList;
    }



    public MenuItemList generate(int itemNumber, Double price, Double discount) {
        MenuItemList miList = new MenuItemList();
            for (int i = 0; i < itemNumber; i++) {
                miList.getMenuItem().add(menuItemAction.generateMenuItem(price, discount));
            }
        return miList;
    }




    @Autowired private MenuItemAction menuItemAction;
}
