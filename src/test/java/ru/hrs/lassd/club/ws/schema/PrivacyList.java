//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.11 at 04:49:31 PM YEKT 
//


package ru.hrs.lassd.club.ws.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrivacyList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrivacyList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PrivacyOption" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types}PrivacyOptionType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrivacyList", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types", propOrder = {
    "privacyOption"
})
public class PrivacyList {

    @XmlElement(name = "PrivacyOption", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected List<PrivacyOptionType> privacyOption;

    /**
     * Gets the value of the privacyOption property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the privacyOption property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrivacyOption().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrivacyOptionType }
     * 
     * 
     */
    public List<PrivacyOptionType> getPrivacyOption() {
        if (privacyOption == null) {
            privacyOption = new ArrayList<PrivacyOptionType>();
        }
        return this.privacyOption;
    }

}
