//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.22 at 05:15:52 PM CEST 
//


package de.l3s.workive.analysis.jaxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{}charParams" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="bold" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ff" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="fs" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="italic" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="lang" use="required" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="scaling" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="spacing" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="subscript" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="superscript" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="underline" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "charParams"
})
@XmlRootElement(name = "formatting")
public class Formatting implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4252623317570106825L;
	@XmlElement(required = true)
    protected List<CharParams> charParams;
    @XmlAttribute(name = "bold")
    protected Boolean bold;
    @XmlAttribute(name = "ff", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String ff;
    @XmlAttribute(name = "fs", required = true)
    protected BigDecimal fs;
    @XmlAttribute(name = "italic")
    protected Boolean italic;
    @XmlAttribute(name = "lang", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String lang;
    @XmlAttribute(name = "scaling")
    protected Integer scaling;
    @XmlAttribute(name = "spacing")
    protected Integer spacing;
    @XmlAttribute(name = "subscript")
    protected Boolean subscript;
    @XmlAttribute(name = "superscript")
    protected Boolean superscript;
    @XmlAttribute(name = "underline")
    protected Boolean underline;

    /**
     * Gets the value of the charParams property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the charParams property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharParams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CharParams }
     * 
     * 
     */
    public List<CharParams> getCharParams() {
        if (charParams == null) {
            charParams = new ArrayList<CharParams>();
        }
        return this.charParams;
    }

    /**
     * Gets the value of the bold property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBold() {
        return bold;
    }

    /**
     * Sets the value of the bold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBold(Boolean value) {
        this.bold = value;
    }

    /**
     * Gets the value of the ff property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFf() {
        return ff;
    }

    /**
     * Sets the value of the ff property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFf(String value) {
        this.ff = value;
    }

    /**
     * Gets the value of the fs property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFs() {
        return fs;
    }

    /**
     * Sets the value of the fs property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFs(BigDecimal value) {
        this.fs = value;
    }

    /**
     * Gets the value of the italic property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isItalic() {
        return italic;
    }

    /**
     * Sets the value of the italic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setItalic(Boolean value) {
        this.italic = value;
    }

    /**
     * Gets the value of the lang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the scaling property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getScaling() {
        return scaling;
    }

    /**
     * Sets the value of the scaling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setScaling(Integer value) {
        this.scaling = value;
    }

    /**
     * Gets the value of the spacing property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSpacing() {
        return spacing;
    }

    /**
     * Sets the value of the spacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSpacing(Integer value) {
        this.spacing = value;
    }

    /**
     * Gets the value of the subscript property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSubscript() {
        return subscript;
    }

    /**
     * Sets the value of the subscript property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSubscript(Boolean value) {
        this.subscript = value;
    }

    /**
     * Gets the value of the superscript property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuperscript() {
        return superscript;
    }

    /**
     * Sets the value of the superscript property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuperscript(Boolean value) {
        this.superscript = value;
    }

    /**
     * Gets the value of the underline property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUnderline() {
        return underline;
    }

    /**
     * Sets the value of the underline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUnderline(Boolean value) {
        this.underline = value;
    }

}
