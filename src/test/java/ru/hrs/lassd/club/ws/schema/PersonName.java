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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PersonName complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonName">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NameTitle" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="NameSuffix" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="familiarName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nameOrdered" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonName", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types", propOrder = {
    "nameTitle",
    "firstName",
    "middleName",
    "lastName",
    "nameSuffix"
})
public class PersonName {

    @XmlElement(name = "NameTitle", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected List<String> nameTitle;
    @XmlElement(name = "FirstName", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected String firstName;
    @XmlElement(name = "MiddleName", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected List<String> middleName;
    @XmlElement(name = "LastName", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types", required = true)
    protected String lastName;
    @XmlElement(name = "NameSuffix", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected List<String> nameSuffix;
    @XmlAttribute
    protected String familiarName;
    @XmlAttribute
    protected String nameOrdered;

    /**
     * Gets the value of the nameTitle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameTitle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameTitle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNameTitle() {
        if (nameTitle == null) {
            nameTitle = new ArrayList<String>();
        }
        return this.nameTitle;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the middleName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMiddleName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMiddleName() {
        if (middleName == null) {
            middleName = new ArrayList<String>();
        }
        return this.middleName;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the nameSuffix property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameSuffix property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameSuffix().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNameSuffix() {
        if (nameSuffix == null) {
            nameSuffix = new ArrayList<String>();
        }
        return this.nameSuffix;
    }

    /**
     * Gets the value of the familiarName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFamiliarName() {
        return familiarName;
    }

    /**
     * Sets the value of the familiarName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFamiliarName(String value) {
        this.familiarName = value;
    }

    /**
     * Gets the value of the nameOrdered property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameOrdered() {
        return nameOrdered;
    }

    /**
     * Sets the value of the nameOrdered property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameOrdered(String value) {
        this.nameOrdered = value;
    }

}
