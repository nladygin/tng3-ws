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
 * <p>Java class for LoyaltyMenuItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyMenuItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="redeem" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="bonus" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="subscription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MajorGroup" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SubGroup" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="points" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyMenuItem", namespace = "http://www.hrs.ru/clubng/ws/common/types", propOrder = {
    "id",
    "qty",
    "discount",
    "redeem",
    "bonus",
    "subscription",
    "majorGroup",
    "subGroup",
    "points"
})
public class LoyaltyMenuItem {

    @XmlElement(namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String id;
    @XmlElement(namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected int qty;
    @XmlElement(namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected double discount;
    @XmlElement(namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected double redeem;
    @XmlElement(namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected double bonus;
    @XmlElement(namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected String subscription;
    @XmlElement(name = "MajorGroup", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected int majorGroup;
    @XmlElement(name = "SubGroup", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected int subGroup;
    @XmlElement(namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected double points;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the qty property.
     * 
     */
    public int getQty() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     */
    public void setQty(int value) {
        this.qty = value;
    }

    /**
     * Gets the value of the discount property.
     * 
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Sets the value of the discount property.
     * 
     */
    public void setDiscount(double value) {
        this.discount = value;
    }

    /**
     * Gets the value of the redeem property.
     * 
     */
    public double getRedeem() {
        return redeem;
    }

    /**
     * Sets the value of the redeem property.
     * 
     */
    public void setRedeem(double value) {
        this.redeem = value;
    }

    /**
     * Gets the value of the bonus property.
     * 
     */
    public double getBonus() {
        return bonus;
    }

    /**
     * Sets the value of the bonus property.
     * 
     */
    public void setBonus(double value) {
        this.bonus = value;
    }

    /**
     * Gets the value of the subscription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubscription() {
        return subscription;
    }

    /**
     * Sets the value of the subscription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubscription(String value) {
        this.subscription = value;
    }

    /**
     * Gets the value of the majorGroup property.
     * 
     */
    public int getMajorGroup() {
        return majorGroup;
    }

    /**
     * Sets the value of the majorGroup property.
     * 
     */
    public void setMajorGroup(int value) {
        this.majorGroup = value;
    }

    /**
     * Gets the value of the subGroup property.
     * 
     */
    public int getSubGroup() {
        return subGroup;
    }

    /**
     * Sets the value of the subGroup property.
     * 
     */
    public void setSubGroup(int value) {
        this.subGroup = value;
    }

    /**
     * Gets the value of the points property.
     * 
     */
    public double getPoints() {
        return points;
    }

    /**
     * Sets the value of the points property.
     * 
     */
    public void setPoints(double value) {
        this.points = value;
    }

}