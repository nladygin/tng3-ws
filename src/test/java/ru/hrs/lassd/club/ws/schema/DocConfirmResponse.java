//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.28 at 01:38:32 PM YEKT 
//


package ru.hrs.lassd.club.ws.schema;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Status" type="{http://htng.org/PWS/2008A/SingleGuestItinerary/Common/Types}ResultStatusFlag"/>
 *         &lt;element name="postingGUID" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Debug" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "postingGUID",
    "debug"
})
@XmlRootElement(name = "DocConfirmResponse")
public class DocConfirmResponse {

    @XmlElement(name = "Status", required = true)
    protected ResultStatusFlag status;
    @XmlElement(required = true)
    protected String postingGUID;
    @XmlElement(name = "Debug")
    protected String debug;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link ResultStatusFlag }
     *     
     */
    public ResultStatusFlag getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultStatusFlag }
     *     
     */
    public void setStatus(ResultStatusFlag value) {
        this.status = value;
    }

    /**
     * Gets the value of the postingGUID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostingGUID() {
        return postingGUID;
    }

    /**
     * Sets the value of the postingGUID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostingGUID(String value) {
        this.postingGUID = value;
    }

    /**
     * Gets the value of the debug property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebug() {
        return debug;
    }

    /**
     * Sets the value of the debug property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebug(String value) {
        this.debug = value;
    }

}
