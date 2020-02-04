package ru.hrs.lassd.club.ws.entity;

public class Fault {

    private String faultString;


    public Fault() {
    }

    public Fault(String faultString) {
        this.faultString = faultString;
    }



    public String getFaultString() {
        return faultString;
    }

    public void setFaultString(String faultString) {
        this.faultString = faultString;
    }
}
