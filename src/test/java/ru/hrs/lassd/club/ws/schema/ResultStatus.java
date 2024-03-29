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


/**
 * <p>Java class for ResultStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResultStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Text" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}TextList" minOccurs="0"/>
 *         &lt;element name="IDs" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}UniqueIDList" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="resultStatusFlag" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}ResultStatusFlag" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResultStatus", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types", propOrder = {
    "text",
    "iDs"
})
public class ResultStatus {

    @XmlElement(name = "Text", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected TextList text;
    @XmlElement(name = "IDs", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected UniqueIDList iDs;
    @XmlAttribute
    protected String code;
    @XmlAttribute
    protected ResultStatusFlag resultStatusFlag;

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link TextList }
     *     
     */
    public TextList getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextList }
     *     
     */
    public void setText(TextList value) {
        this.text = value;
    }

    /**
     * Gets the value of the iDs property.
     * 
     * @return
     *     possible object is
     *     {@link UniqueIDList }
     *     
     */
    public UniqueIDList getIDs() {
        return iDs;
    }

    /**
     * Sets the value of the iDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link UniqueIDList }
     *     
     */
    public void setIDs(UniqueIDList value) {
        this.iDs = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the resultStatusFlag property.
     * 
     * @return
     *     possible object is
     *     {@link ResultStatusFlag }
     *     
     */
    public ResultStatusFlag getResultStatusFlag() {
        return resultStatusFlag;
    }

    /**
     * Sets the value of the resultStatusFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultStatusFlag }
     *     
     */
    public void setResultStatusFlag(ResultStatusFlag value) {
        this.resultStatusFlag = value;
    }

}
