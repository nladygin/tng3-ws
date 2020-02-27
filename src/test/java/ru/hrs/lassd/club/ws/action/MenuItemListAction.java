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



    public MenuItemList generate(){
        return generate(1, 0.0);
    }

    public MenuItemList generate(Double discount) {
        return generate(1, discount);
    }


    public MenuItemList generate(int itemNumber, Double discount) {
        MenuItemList miList = new MenuItemList();
            for (int i = 0; i < itemNumber; i++) {
                miList.getMenuItem().add(menuItemAction.generateMenuItem(discount));
            }
        return miList;
    }




    @Autowired private MenuItemAction menuItemAction;
}