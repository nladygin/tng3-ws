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
 * <p>Java class for DescriptiveText complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DescriptiveText">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Text" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}TextList"/>
 *         &lt;element name="Image" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}anyURI"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DescriptiveText", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types", propOrder = {
    "text",
    "image",
    "url"
})
public class DescriptiveText {

    @XmlElement(name = "Text", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected TextList text;
    @XmlElement(name = "Image", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected String image;
    @XmlElement(name = "Url", namespace = "http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types")
    protected String url;

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
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImage(String value) {
        this.image = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

}