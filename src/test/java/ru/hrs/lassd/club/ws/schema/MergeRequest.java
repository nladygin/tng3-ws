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
 *         &lt;element name="DestinationProfile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="SourceProfiles" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}SourceList" minOccurs="0"/>
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
    "destinationProfile",
    "sourceProfiles"
})
@XmlRootElement(name = "MergeRequest")
public class MergeRequest {

    @XmlElement(name = "DestinationProfile", required = true)
    protected String destinationProfile;
    @XmlElement(name = "SourceProfiles")
    protected SourceList sourceProfiles;

    /**
     * Gets the value of the destinationProfile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationProfile() {
        return destinationProfile;
    }

    /**
     * Sets the value of the destinationProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationProfile(String value) {
        this.destinationProfile = value;
    }

    /**
     * Gets the value of the sourceProfiles property.
     * 
     * @return
     *     possible object is
     *     {@link SourceList }
     *     
     */
    public SourceList getSourceProfiles() {
        return sourceProfiles;
    }

    /**
     * Sets the value of the sourceProfiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceList }
     *     
     */
    public void setSourceProfiles(SourceList value) {
        this.sourceProfiles = value;
    }

}
