//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.28 at 01:38:32 PM YEKT 
//


package ru.hrs.lassd.club.ws.schema;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="Lookup" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types}ProfileLookup"/>
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
    "lookup"
})
@XmlRootElement(name = "LookupRequest", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
public class LookupRequest {

    @XmlElement(name = "Lookup", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types", required = true)
    protected ProfileLookup lookup;

    /**
     * Gets the value of the lookup property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileLookup }
     *     
     */
    public ProfileLookup getLookup() {
        return lookup;
    }

    /**
     * Sets the value of the lookup property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileLookup }
     *     
     */
    public void setLookup(ProfileLookup value) {
        this.lookup = value;
    }

}
