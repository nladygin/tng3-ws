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
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DepositItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DepositItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PostingGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PostingDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PostPropertyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegisterId" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID"/>
 *         &lt;element name="RevenueCenterId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierEmpId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierEmpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierOptMask" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LoanFlag" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ExpiryDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepositItem", namespace = "http://www.hrs.ru/clubng/ws/common/types", propOrder = {
    "postingGUID",
    "postingDate",
    "postPropertyId",
    "registerId",
    "revenueCenterId",
    "paymentAmount",
    "cashierEmpId",
    "cashierEmpName",
    "cashierOptMask",
    "loanFlag",
    "expiryDate",
    "description"
})
public class DepositItem {

    @XmlElement(name = "PostingGUID", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String postingGUID;
    @XmlElement(name = "PostingDate", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected XMLGregorianCalendar postingDate;
    @XmlElement(name = "PostPropertyId", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String postPropertyId;
    @XmlElement(name = "RegisterId", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected UniqueID registerId;
    @XmlElement(name = "RevenueCenterId", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String revenueCenterId;
    @XmlElement(name = "PaymentAmount", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String paymentAmount;
    @XmlElement(name = "CashierEmpId", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String cashierEmpId;
    @XmlElement(name = "CashierEmpName", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String cashierEmpName;
    @XmlElement(name = "CashierOptMask", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String cashierOptMask;
    @XmlElement(name = "LoanFlag", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String loanFlag;
    @XmlElement(name = "ExpiryDate", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected XMLGregorianCalendar expiryDate;
    @XmlElement(name = "Description", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected String description;

    /**
     * Gets the value of the postingGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostingGUID() {
        return postingGUID;
    }

    /**
     * Sets the value of the postingGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostingGUID(String value) {
        this.postingGUID = value;
    }

    /**
     * Gets the value of the postingDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPostingDate() {
        return postingDate;
    }

    /**
     * Sets the value of the postingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPostingDate(XMLGregorianCalendar value) {
        this.postingDate = value;
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
     * Gets the value of the paymentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAmount(String value) {
        this.paymentAmount = value;
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
     * Gets the value of the loanFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanFlag() {
        return loanFlag;
    }

    /**
     * Sets the value of the loanFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanFlag(String value) {
        this.loanFlag = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
