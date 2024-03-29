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
 * <p>Java class for BriefProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BriefProfile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfileID" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueID"/>
 *         &lt;element name="CardType" type="{http://www.hrs.ru/clubng/ws/common/types}CardType"/>
 *         &lt;element name="CardStatus" type="{http://www.hrs.ru/clubng/ws/common/types}CardStatus"/>
 *         &lt;element name="PersonName" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}PersonName" minOccurs="0"/>
 *         &lt;element name="BirthDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
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
@XmlType(name = "BriefProfile", namespace = "http://www.hrs.ru/clubng/ws/common/types", propOrder = {
    "profileID",
    "cardType",
    "cardStatus",
    "personName",
    "birthDate",
    "phone"
})
public class BriefProfile {

    @XmlElement(name = "ProfileID", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected UniqueID profileID;
    @XmlElement(name = "CardType", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected CardType cardType;
    @XmlElement(name = "CardStatus", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected CardStatus cardStatus;
    @XmlElement(name = "PersonName", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected PersonName personName;
    @XmlElement(name = "BirthDate", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected XMLGregorianCalendar birthDate;
    @XmlElement(name = "Phone", namespace = "http://www.hrs.ru/clubng/ws/common/types")
    protected Phone phone;

    /**
     * Gets the value of the profileID property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueID }
     *     
     */
    public UniqueID getProfileID() {
        return profileID;
    }

    /**
     * Sets the value of the profileID property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueID }
     *     
     */
    public void setProfileID(UniqueID value) {
        this.profileID = value;
    }

    /**
     * Gets the value of the cardType property.
     * 
     * @return
     *     possible object is
     *     {@link CardType }
     *     
     */
    public CardType getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardType }
     *     
     */
    public void setCardType(CardType value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the cardStatus property.
     * 
     * @return
     *     possible object is
     *     {@link CardStatus }
     *     
     */
    public CardStatus getCardStatus() {
        return cardStatus;
    }

    /**
     * Sets the value of the cardStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardStatus }
     *     
     */
    public void setCardStatus(CardStatus value) {
        this.cardStatus = value;
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
