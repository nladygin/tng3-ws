//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.11 at 04:49:31 PM YEKT 
//


package ru.hrs.lassd.club.ws.schema;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for ReservationStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReservationStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CANCELLED"/>
 *     &lt;enumeration value="CHECKED_IN"/>
 *     &lt;enumeration value="CHECKED_OUT"/>
 *     &lt;enumeration value="RESERVED"/>
 *     &lt;enumeration value="WAITLISTED"/>
 *     &lt;enumeration value="OTHER"/>
 *     &lt;enumeration value="REVERSE_CHECKED_IN"/>
 *     &lt;enumeration value="REVERSE_CHECKED_OUT"/>
 *     &lt;enumeration value="NO_SHOW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum ReservationStatusType {

    CANCELLED,
    CHECKED_IN,
    CHECKED_OUT,
    RESERVED,
    WAITLISTED,
    OTHER,
    REVERSE_CHECKED_IN,
    REVERSE_CHECKED_OUT,
    NO_SHOW;

    public String value() {
        return name();
    }

    public static ReservationStatusType fromValue(String v) {
        return valueOf(v);
    }

}
