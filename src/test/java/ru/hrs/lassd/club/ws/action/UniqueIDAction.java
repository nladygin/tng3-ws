package ru.hrs.lassd.club.ws.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hrs.lassd.club.ws.config.Data;
import ru.hrs.lassd.club.ws.schema.UniqueID;

@Component
public class UniqueIDAction {


    public UniqueID generate(
            int value
    ){
        return generate(String.valueOf(value), "");
    }


    public UniqueID generate(
            int value,
            String source
    ){
        return generate(String.valueOf(value), source);
    }


    public UniqueID generate(
            String value
    ){
        return generate(value, "");
    }


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
