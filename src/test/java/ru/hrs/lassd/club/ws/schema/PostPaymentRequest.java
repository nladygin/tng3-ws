//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.11 at 04:49:31 PM YEKT 
//


package ru.hrs.lassd.club.ws.schema;

import java.math.BigInteger;
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
 *         &lt;element name="Number" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ClientId" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID" minOccurs="0"/>
 *         &lt;element name="PostingGUID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VoidFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="PostPropertyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RegisterId" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID"/>
 *         &lt;element name="RevenueCenterId" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/>
 *         &lt;element name="MealPeriod" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="PaymentAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ServPeriod" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ChkTtl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CheckId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierEmpId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierEmpName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CashierOptMask" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CheckGuestCount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ServiceChargeAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="menuItemList" type="{http://www.hrs.ru/clubng/ws/common/types}MenuItemList"/>
 *         &lt;element name="Voucher" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentRestrictions">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Local" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Master" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Voucher" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Confirm" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
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
    "postingGUID",
    "voidFlag",
    "postPropertyId",
    "registerId",
    "revenueCenterId",
    "mealPeriod",
    "paymentAmount",
    "servPeriod",
    "chkTtl",
    "checkId",
    "checkNumber",
    "cashierEmpId",
    "cashierEmpName",
    "cashierOptMask",
    "checkGuestCount",
    "serviceChargeAmount",
    "menuItemList",
    "voucher",
    "paymentRestrictions",
    "confirm"
})
@XmlRootElement(name = "PostPaymentRequest")
public class PostPaymentRequest {

    @XmlElement(name = "Number")
    protected String number;
    @XmlElement(name = "ClientId")
    protected UniqueID clientId;
    @XmlElement(name = "PostingGUID")
    protected String postingGUID;
    @XmlElement(name = "VoidFlag")
    protected Boolean voidFlag;
    @XmlElement(name = "PostPropertyId", required = true)
    protected String postPropertyId;
    @XmlElement(name = "RegisterId", required = true)
    protected UniqueID registerId;
    @XmlElement(name = "RevenueCenterId", required = true)
    protected BigInteger revenueCenterId;
    @XmlElement(name = "MealPeriod")
    protected Long mealPeriod;
    @XmlElement(name = "PaymentAmount", required = true)
    protected String paymentAmount;
    @XmlElement(name = "ServPeriod", required = true)
    protected String servPeriod;
    @XmlElement(name = "ChkTtl", required = true)
    protected String chkTtl;
    @XmlElement(name = "CheckId")
    protected String checkId;
    @XmlElement(name = "CheckNumber", required = true)
    protected String checkNumber;
    @XmlElement(name = "CashierEmpId", required = true)
    protected String cashierEmpId;
    @XmlElement(name = "CashierEmpName", required = true)
    protected String cashierEmpName;
    @XmlElement(name = "CashierOptMask", required = true)
    protected String cashierOptMask;
    @XmlElement(name = "CheckGuestCount", required = true)
    protected String checkGuestCount;
    @XmlElement(name = "ServiceChargeAmount", required = true)
    protected String serviceChargeAmount;
    @XmlElement(required = true)
    protected MenuItemList menuItemList;
    @XmlElement(name = "Voucher")
    protected String voucher;
    @XmlElement(name = "PaymentRestrictions", required = true)
    protected PostPaymentRequest.PaymentRestrictions paymentRestrictions;
    @XmlElement(name = "Confirm")
    protected Boolean confirm;

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
     * Gets the value of the voidFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVoidFlag() {
        return voidFlag;
    }

    /**
     * Sets the value of the voidFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVoidFlag(Boolean value) {
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
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRevenueCenterId() {
        return revenueCenterId;
    }

    /**
     * Sets the value of the revenueCenterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRevenueCenterId(BigInteger value) {
        this.revenueCenterId = value;
    }

    /**
     * Gets the value of the mealPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMealPeriod() {
        return mealPeriod;
    }

    /**
     * Sets the value of the mealPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMealPeriod(Long value) {
        this.mealPeriod = value;
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
     * Gets the value of the servPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServPeriod() {
        return servPeriod;
    }

    /**
     * Sets the value of the servPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServPeriod(String value) {
        this.servPeriod = value;
    }

    /**
     * Gets the value of the chkTtl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChkTtl() {
        return chkTtl;
    }

    /**
     * Sets the value of the chkTtl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChkTtl(String value) {
        this.chkTtl = value;
    }

    /**
     * Gets the value of the checkId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckId() {
        return checkId;
    }

    /**
     * Sets the value of the checkId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckId(String value) {
        this.checkId = value;
    }

    /**
     * Gets the value of the checkNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckNumber() {
        return checkNumber;
    }

    /**
     * Sets the value of the checkNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckNumber(String value) {
        this.checkNumber = value;
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
     * Gets the value of the checkGuestCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckGuestCount() {
        return checkGuestCount;
    }

    /**
     * Sets the value of the checkGuestCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckGuestCount(String value) {
        this.checkGuestCount = value;
    }

    /**
     * Gets the value of the serviceChargeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceChargeAmount() {
        return serviceChargeAmount;
    }

    /**
     * Sets the value of the serviceChargeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceChargeAmount(String value) {
        this.serviceChargeAmount = value;
    }

    /**
     * Gets the value of the menuItemList property.
     * 
     * @return
     *     possible object is
     *     {@link MenuItemList }
     *     
     */
    public MenuItemList getMenuItemList() {
        return menuItemList;
    }

    /**
     * Sets the value of the menuItemList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MenuItemList }
     *     
     */
    public void setMenuItemList(MenuItemList value) {
        this.menuItemList = value;
    }

    /**
     * Gets the value of the voucher property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucher() {
        return voucher;
    }

    /**
     * Sets the value of the voucher property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucher(String value) {
        this.voucher = value;
    }

    /**
     * Gets the value of the paymentRestrictions property.
     * 
     * @return
     *     possible object is
     *     {@link PostPaymentRequest.PaymentRestrictions }
     *     
     */
    public PostPaymentRequest.PaymentRestrictions getPaymentRestrictions() {
        return paymentRestrictions;
    }

    /**
     * Sets the value of the paymentRestrictions property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostPaymentRequest.PaymentRestrictions }
     *     
     */
    public void setPaymentRestrictions(PostPaymentRequest.PaymentRestrictions value) {
        this.paymentRestrictions = value;
    }

    /**
     * Gets the value of the confirm property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConfirm() {
        return confirm;
    }

    /**
     * Sets the value of the confirm property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConfirm(Boolean value) {
        this.confirm = value;
    }


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
     *         &lt;element name="Local" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Master" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Voucher" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "local",
        "master",
        "voucher"
    })
    public static class PaymentRestrictions {

        @XmlElement(name = "Local", required = true, defaultValue = "F")
        protected String local;
        @XmlElement(name = "Master", required = true, defaultValue = "F")
        protected String master;
        @XmlElement(name = "Voucher", required = true, defaultValue = "F")
        protected String voucher;

        /**
         * Gets the value of the local property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLocal() {
            return local;
        }

        /**
         * Sets the value of the local property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLocal(String value) {
            this.local = value;
        }

        /**
         * Gets the value of the master property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMaster() {
            return master;
        }

        /**
         * Sets the value of the master property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMaster(String value) {
            this.master = value;
        }

        /**
         * Gets the value of the voucher property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVoucher() {
            return voucher;
        }

        /**
         * Sets the value of the voucher property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVoucher(String value) {
            this.voucher = value;
        }

    }

}
