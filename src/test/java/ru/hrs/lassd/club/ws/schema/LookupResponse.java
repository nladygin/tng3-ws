//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.11 at 04:49:31 PM YEKT 
//


package ru.hrs.lassd.club.ws.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Result" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}ResultStatus"/>
 *         &lt;element name="ProfileLookups" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types}ProfileLookupList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "result",
    "profileLookups"
})
@XmlRootElement(name = "LookupResponse", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
public class LookupResponse {

    @XmlElement(name = "Result", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types", required = true)
    protected ResultStatus result;
    @XmlElement(name = "ProfileLookups", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types", required = true)
    protected ProfileLookupList profileLookups;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link ResultStatus }
     *     
     */
    public ResultStatus getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultStatus }
     *     
     */
    public void setResult(ResultStatus value) {
        this.result = value;
    }

    /**
     * Gets the value of the profileLookups property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileLookupList }
     *     
     */
    public ProfileLookupList getProfileLookups() {
        return profileLookups;
    }

    /**
     * Sets the value of the profileLookups property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileLookupList }
     *     
     */
    public void setProfileLookups(ProfileLookupList value) {
        this.profileLookups = value;
    }

}
