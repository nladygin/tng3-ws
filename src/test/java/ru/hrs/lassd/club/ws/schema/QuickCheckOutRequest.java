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
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ClientId" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID" minOccurs="0"/>
 *         &lt;element name="VoidFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PostPropertyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegisterId" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID"/>
 *         &lt;element name="RevenueCenterId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BookingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="KeyNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MealPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierEmpId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierEmpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierOptMask" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Info" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProcessOvertime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LockerNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "number",
    "clientId",
    "voidFlag",
    "postPropertyId",
    "registerId",
    "revenueCenterId",
    "bookingNumber",
    "keyNumber",
    "mealPeriod",
    "cashierEmpId",
    "cashierEmpName",
    "cashierOptMask",
    "info",
    "processOvertime",
    "lockerNum"
})
@XmlRootElement(name = "QuickCheckOutRequest")
public class QuickCheckOutRequest {

    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "ClientId")
    protected UniqueID clientId;
    @XmlElement(name = "VoidFlag")
    protected String voidFlag;
    @XmlElement(name = "PostPropertyId", required = true)
    protected String postPropertyId;
    @XmlElement(name = "RegisterId", required = true)
    protected UniqueID registerId;
    @XmlElement(name = "RevenueCenterId", required = true)
    protected String revenueCenterId;
    @XmlElement(name = "BookingNumber")
    protected String bookingNumber;
    @XmlElement(name = "KeyNumber")
    protected String keyNumber;
    @XmlElement(name = "MealPeriod", required = true)
    protected String mealPeriod;
    @XmlElement(name = "CashierEmpId", required = true)
    protected String cashierEmpId;
    @XmlElement(name = "CashierEmpName", required = true)
    protected String cashierEmpName;
    @XmlElement(name = "CashierOptMask", required = true)
    protected String cashierOptMask;
    @XmlElement(name = "Info")
    protected String info;
    @XmlElement(name = "ProcessOvertime")
    protected String processOvertime;
    @XmlElement(name = "LockerNum")
    protected String lockerNum;

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the clientId property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueID }
     *     
     */
    public UniqueID getClientId() {
        return clientId;
    }

    /**
     * Sets the value of the clientId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueID }
     *     
     */
    public void setClientId(UniqueID value) {
        this.clientId = value;
    }

    /**
     * Gets the value of the voidFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoidFlag() {
        return voidFlag;
    }

    /**
     * Sets the value of the voidFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoidFlag(String value) {
        this.voidFlag = value;
    }

    /**
     * Gets the value of the postPropertyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostPropertyId() {
        return postPropertyId;
    }

    /**
     * Sets the value of the postPropertyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostPropertyId(String value) {
        this.postPropertyId = value;
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
     *     {@link String }
     *     
     */
    public String getRevenueCenterId() {
        return revenueCenterId;
    }

    /**
     * Sets the value of the revenueCenterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevenueCenterId(String value) {
        this.revenueCenterId = value;
    }

    /**
     * Gets the value of the bookingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingNumber() {
        return bookingNumber;
    }

    /**
     * Sets the value of the bookingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingNumber(String value) {
        this.bookingNumber = value;
    }

    /**
     * Gets the value of the keyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyNumber() {
        return keyNumber;
    }

    /**
     * Sets the value of the keyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyNumber(String value) {
        this.keyNumber = value;
    }

    /**
     * Gets the value of the mealPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMealPeriod() {
        return mealPeriod;
    }

    /**
     * Sets the value of the mealPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMealPeriod(String value) {
        this.mealPeriod = value;
    }

    /**
     * Gets the value of the cashierEmpId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashierEmpId() {
        return cashierEmpId;
    }

    /**
     * Sets the value of the cashierEmpId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashierEmpId(String value) {
        this.cashierEmpId = value;
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

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
    }

    /**
     * Gets the value of the processOvertime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessOvertime() {
        return processOvertime;
    }

    /**
     * Sets the value of the processOvertime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessOvertime(String value) {
        this.processOvertime = value;
    }

    /**
     * Gets the value of the lockerNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLockerNum() {
        return lockerNum;
    }

    /**
     * Sets the value of the lockerNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLockerNum(String value) {
        this.lockerNum = value;
    }

}
