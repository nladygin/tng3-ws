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
 * <p>Java class for ProfileLookup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProfileLookup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfileIDs" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueIDList" minOccurs="0"/>
 *         &lt;element name="PersonName" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}PersonName"/>
 *         &lt;element name="Membership" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}Membership" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}Address" minOccurs="0"/>
 *         &lt;element name="GovernmentIDs" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}GovernmentIDList" minOccurs="0"/>
 *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ResortId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}Phone" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProfileLookup", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types", propOrder = {
    "profileIDs",
    "personName",
    "membership",
    "address",
    "governmentIDs",
    "birthDate",
    "resortId",
    "phone"
})
public class ProfileLookup {

    @XmlElement(name = "ProfileIDs", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected UniqueIDList profileIDs;
    @XmlElement(name = "PersonName", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types", required = true)
    protected PersonName personName;
    @XmlElement(name = "Membership", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected Membership membership;
    @XmlElement(name = "Address", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected Address address;
    @XmlElement(name = "GovernmentIDs", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected GovernmentIDList governmentIDs;
    @XmlElement(namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(name = "ResortId", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected String resortId;
    @XmlElement(name = "Phone", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Name/Types")
    protected Phone phone;

    /**
     * Gets the value of the profileIDs property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueIDList }
     *     
     */
    public UniqueIDList getProfileIDs() {
        return profileIDs;
    }

    /**
     * Sets the value of the profileIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueIDList }
     *     
     */
    public void setProfileIDs(UniqueIDList value) {
        this.profileIDs = value;
    }

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
     * Gets the value of the membership property.
     * 
     * @return
     *     possible object is
     *     {@link Membership }
     *     
     */
    public Membership getMembership() {
        return membership;
    }

    /**
     * Sets the value of the membership property.
     * 
     * @param value
     *     allowed object is
     *     {@link Membership }
     *     
     */
    public void setMembership(Membership value) {
        this.membership = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the governmentIDs property.
     * 
     * @return
     *     possible object is
     *     {@link GovernmentIDList }
     *     
     */
    public GovernmentIDList getGovernmentIDs() {
        return governmentIDs;
    }

    /**
     * Sets the value of the governmentIDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link GovernmentIDList }
     *     
     */
    public void setGovernmentIDs(GovernmentIDList value) {
        this.governmentIDs = value;
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
     * Gets the value of the resortId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResortId() {
        return resortId;
    }

    /**
     * Sets the value of the resortId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResortId(String value) {
        this.resortId = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link Phone }
     *     
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Phone }
     *     
     */
    public void setPhone(Phone value) {
        this.phone = value;
    }

}
