//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.28 at 01:38:32 PM YEKT 
//


package ru.hrs.lassd.club.ws.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentListItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentListItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Amout" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="CashierShift" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentListItem", namespace = "http://www.hrs.ru/clubng/ws/common/types", propOrder = {
    "id",
    "name",
    "amout",
    "cashierShift"
})
public class PaymentListItem {

    @XmlElement(name = "Id", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected int id;
    @XmlElement(name = "Name", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String name;
    @XmlElement(name = "Amout", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected double amout;
    @XmlElement(name = "CashierShift", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected Integer cashierShift;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the amout property.
     * 
     */
    public double getAmout() {
        return amout;
    }

    /**
     * Sets the value of the amout property.
     * 
     */
    public void setAmout(double value) {
        this.amout = value;
    }

    /**
     * Gets the value of the cashierShift property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCashierShift() {
        return cashierShift;
    }

    /**
     * Sets the value of the cashierShift property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCashierShift(Integer value) {
        this.cashierShift = value;
    }

}
