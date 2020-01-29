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
 *         &lt;element name="Status" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}ResultStatusFlag"/>
 *         &lt;element name="PostingGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PaymentAmount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Account" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PmsRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentInfo" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "status",
    "postingGUID",
    "paymentAmount",
    "account",
    "pmsRoom",
    "paymentInfo"
})
@XmlRootElement(name = "PostPaymentResponse")
public class PostPaymentResponse {

    @XmlElement(name = "Status", required = true)
    protected ResultStatusFlag status;
    @XmlElement(name = "PostingGUID", required = true)
    protected String postingGUID;
    @XmlElement(name = "PaymentAmount", required = true)
    protected String paymentAmount;
    @XmlElement(name = "Account", required = true)
    protected String account;
    @XmlElement(name = "PmsRoom")
    protected String pmsRoom;
    @XmlElement(name = "PaymentInfo", required = true)
    protected String paymentInfo;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ResultStatusFlag }
     *     
     */
    public ResultStatusFlag getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultStatusFlag }
     *     
     */
    public void setStatus(ResultStatusFlag value) {
        this.status = value;
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
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the pmsRoom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmsRoom() {
        return pmsRoom;
    }

    /**
     * Sets the value of the pmsRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmsRoom(String value) {
        this.pmsRoom = value;
    }

    /**
     * Gets the value of the paymentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentInfo() {
        return paymentInfo;
    }

    /**
     * Sets the value of the paymentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentInfo(String value) {
        this.paymentInfo = value;
    }

}