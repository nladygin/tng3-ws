//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.10.11 at 04:49:31 PM YEKT 
//


package ru.hrs.lassd.club.ws.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Customer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Customer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonName" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}PersonName"/>
 *         &lt;element name="BusinessTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GovernmentIDList" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}GovernmentIDList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="birthDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="gender" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}Gender" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Customer", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types", propOrder = {
    "personName",
    "businessTitle",
    "governmentIDList"
})
public class Customer {

    @XmlElement(name = "PersonName", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types", required = true)
    protected PersonName personName;
    @XmlElement(name = "BusinessTitle", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected String businessTitle;
    @XmlElement(name = "GovernmentIDList", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected GovernmentIDList governmentIDList;
    @XmlAttribute
    protected XMLGregorianCalendar birthDate;
    @XmlAttribute
    protected Gender gender;

    /**
     * Gets the value of the personName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonName }
     *     
     */
    public PersonName getPersonName() {
        return personName;
    }

    /**
     * Sets the value of the personName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonName }
     *     
     */
    public void setPersonName(PersonName value) {
        this.personName = value;
    }

    /**
     * Gets the value of the businessTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessTitle() {
        return businessTitle;
    }

    /**
     * Sets the value of the businessTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessTitle(String value) {
        this.businessTitle = value;
    }

    /**
     * Gets the value of the governmentIDList property.
     * 
     * @return
     *     possible object is
     *     {@link GovernmentIDList }
     *     
     */
    public GovernmentIDList getGovernmentIDList() {
        return governmentIDList;
    }

    /**
     * Sets the value of the governmentIDList property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovernmentIDList }
     *     
     */
    public void setGovernmentIDList(GovernmentIDList value) {
        this.governmentIDList = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link Gender }
     *     
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gender }
     *     
     */
    public void setGender(Gender value) {
        this.gender = value;
    }

}
