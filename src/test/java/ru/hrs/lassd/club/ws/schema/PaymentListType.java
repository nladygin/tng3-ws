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
 * <p>Java class for PaymentListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PaymentListItem" type="{http://www.hrs.ru/clubng/ws/common/types}PaymentListItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentListType", namespace = "http://www.hrs.ru/clubng/ws/common/types", propOrder = {
    "paymentListItem"
})
public class PaymentListType {

    @XmlElement(name = "PaymentListItem", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected List<PaymentListItem> paymentListItem;

    /**
     * Gets the value of the paymentListItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentListItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentListItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentListItem }
     * 
     * 
     */
    public List<PaymentListItem> getPaymentListItem() {
        if (paymentListItem == null) {
            paymentListItem = new ArrayList<PaymentListItem>();
        }
        return this.paymentListItem;
    }

}
