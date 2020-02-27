package ru.hrs.lassd.club.ws.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.config.Data;
import ru.hrs.lassd.club.ws.schema.UniqueID;

@Component
public class UniqueIDAction {


    public UniqueID generate(
            String value,
            String source
    ){
        UniqueID uniqueID = new UniqueID();
            uniqueID.setValue(value);
            uniqueID.setSource(source);

        return uniqueID;
    }



    @Autowired private Data data;

}
