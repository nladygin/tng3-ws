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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for DataItemListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataItemListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataItemList" type="{http://www.hrs.ru/clubng/ws/common/types}DataItem" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataItemListType", namespace = "http://www.hrs.ru/clubng/ws/common/types", propOrder = {
    "dataItemList"
})
public class DataItemListType {

    @XmlElement(name = "DataItemList", namespace = "http://www.hrs.ru/clubng/ws/common/types", required = true)
    protected List<DataItem> dataItemList;

    /**
     * Gets the value of the dataItemList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataItemList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataItemList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataItem }
     * 
     * 
     */
    public List<DataItem> getDataItemList() {
        if (dataItemList == null) {
            dataItemList = new ArrayList<DataItem>();
        }
        return this.dataItemList;
    }

}