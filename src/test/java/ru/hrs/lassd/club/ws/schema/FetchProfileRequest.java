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
 *         &lt;element name="ProfileID" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID"/>
 *         &lt;element name="PropertyId" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID"/>
 *         &lt;element name="RegisterId" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID"/>
 *         &lt;element name="RevenueCenterId" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID" minOccurs="0"/>
 *         &lt;element name="CashierEmpName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CashierOptMask" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "profileID",
    "propertyId",
    "registerId",
    "revenueCenterId",
    "cashierEmpName",
    "cashierOptMask"
})
@XmlRootElement(name = "FetchProfileRequest")
public class FetchProfileRequest {

    @XmlElement(name = "ProfileID", required = true)
    protected UniqueID profileID;
    @XmlElement(name = "PropertyId", required = true)
    protected UniqueID propertyId;
    @XmlElement(name = "RegisterId", required = true)
    protected UniqueID registerId;
    @XmlElement(name = "RevenueCenterId")
    protected UniqueID revenueCenterId;
    @XmlElement(name = "CashierEmpName")
    protected String cashierEmpName;
    @XmlElement(name = "CashierOptMask")
    protected String cashierOptMask;

    /**
     * Gets the value of the profileID property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueID }
     *     
     */
    public UniqueID getProfileID() {
        return profileID;
    }

    /**
     * Sets the value of the profileID property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueID }
     *     
     */
    public void setProfileID(UniqueID value) {
        this.profileID = value;
    }

    /**
     * Gets the value of the propertyId property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueID }
     *     
     */
    public UniqueID getPropertyId() {
        return propertyId;
    }

    /**
     * Sets the value of the propertyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueID }
     *     
     */
    public void setPropertyId(UniqueID value) {
        this.propertyId = value;
    }

    /**
     * Gets the value of the registerId property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueID }
     *     
     */
    public UniqueID getRegisterId() {
        return registerId;
    }

    /**
     * Sets the value of the registerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueID }
     *     
     */
    public void setRegisterId(UniqueID value) {
        this.registerId = value;
    }

    /**
     * Gets the value of the revenueCenterId property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueID }
     *     
     */
    public UniqueID getRevenueCenterId() {
        return revenueCenterId;
    }

    /**
     * Sets the value of the revenueCenterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueID }
     *     
     */
    public void setRevenueCenterId(UniqueID value) {
        this.revenueCenterId = value;
    }

    /**
     * Gets the value of the cashierEmpName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashierEmpName() {
        return cashierEmpName;
    }

    /**
     * Sets the value of the cashierEmpName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashierEmpName(String value) {
        this.cashierEmpName = value;
    }

    /**
     * Gets the value of the cashierOptMask property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashierOptMask() {
        return cashierOptMask;
    }

    /**
     * Sets the value of the cashierOptMask property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashierOptMask(String value) {
        this.cashierOptMask = value;
    }

}
