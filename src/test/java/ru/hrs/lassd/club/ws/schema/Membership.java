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
 * <p>Java class for Membership complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Membership">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MembershipType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MembershipNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MembershipLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MemberName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CurrentPoints" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Membership", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types", propOrder = {
    "membershipType",
    "membershipNumber",
    "membershipLevel",
    "memberName",
    "effectiveDate",
    "expirationDate",
    "currentPoints"
})
public class Membership {

    @XmlElement(name = "MembershipType", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected String membershipType;
    @XmlElement(name = "MembershipNumber", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types", required = true)
    protected String membershipNumber;
    @XmlElement(name = "MembershipLevel", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected String membershipLevel;
    @XmlElement(name = "MemberName", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected String memberName;
    @XmlElement(name = "EffectiveDate", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected XMLGregorianCalendar effectiveDate;
    @XmlElement(name = "ExpirationDate", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "CurrentPoints", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected Long currentPoints;

    /**
     * Gets the value of the membershipType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMembershipType() {
        return membershipType;
    }

    /**
     * Sets the value of the membershipType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMembershipType(String value) {
        this.membershipType = value;
    }

    /**
     * Gets the value of the membershipNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMembershipNumber() {
        return membershipNumber;
    }

    /**
     * Sets the value of the membershipNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMembershipNumber(String value) {
        this.membershipNumber = value;
    }

    /**
     * Gets the value of the membershipLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMembershipLevel() {
        return membershipLevel;
    }

    /**
     * Sets the value of the membershipLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMembershipLevel(String value) {
        this.membershipLevel = value;
    }

    /**
     * Gets the value of the memberName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * Sets the value of the memberName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMemberName(String value) {
        this.memberName = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the currentPoints property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCurrentPoints() {
        return currentPoints;
    }

    /**
     * Sets the value of the currentPoints property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCurrentPoints(Long value) {
        this.currentPoints = value;
    }

}
