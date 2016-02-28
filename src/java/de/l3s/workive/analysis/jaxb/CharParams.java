//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.22 at 05:15:52 PM CEST 
//


package de.l3s.workive.analysis.jaxb;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="b" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="charConfidence" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="l" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="meanStrokeWidth" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="r" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="serifProbability" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="suspicious" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="t" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="wordFromDictionary" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="wordIdentifier" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="wordNormal" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="wordNumeric" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="wordPenalty" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="wordStart" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "content"
})
@XmlRootElement(name = "charParams")
public class CharParams implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5421711408012274866L;
	@XmlValue
    protected String content;
    @XmlAttribute(name = "b", required = true)
    protected Integer b;
    @XmlAttribute(name = "charConfidence", required = true)
    protected Integer charConfidence;
    @XmlAttribute(name = "l", required = true)
    protected Integer l;
    @XmlAttribute(name = "meanStrokeWidth", required = true)
    protected Integer meanStrokeWidth;
    @XmlAttribute(name = "r", required = true)
    protected Integer r;
    @XmlAttribute(name = "serifProbability", required = true)
    protected Integer serifProbability;
    @XmlAttribute(name = "suspicious")
    protected Boolean suspicious;
    @XmlAttribute(name = "t", required = true)
    protected Integer t;
    @XmlAttribute(name = "wordFromDictionary", required = true)
    protected boolean wordFromDictionary;
    @XmlAttribute(name = "wordIdentifier", required = true)
    protected boolean wordIdentifier;
    @XmlAttribute(name = "wordNormal", required = true)
    protected boolean wordNormal;
    @XmlAttribute(name = "wordNumeric", required = true)
    protected boolean wordNumeric;
    @XmlAttribute(name = "wordPenalty", required = true)
    protected Integer wordPenalty;
    @XmlAttribute(name = "wordStart", required = true)
    protected boolean wordStart;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the b property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getB() {
        return b;
    }

    /**
     * Sets the value of the b property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setB(Integer value) {
        this.b = value;
    }

    /**
     * Gets the value of the charConfidence property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCharConfidence() {
        return charConfidence;
    }

    /**
     * Sets the value of the charConfidence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCharConfidence(Integer value) {
        this.charConfidence = value;
    }

    /**
     * Gets the value of the l property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getL() {
        return l;
    }

    /**
     * Sets the value of the l property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setL(Integer value) {
        this.l = value;
    }

    /**
     * Gets the value of the meanStrokeWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMeanStrokeWidth() {
        return meanStrokeWidth;
    }

    /**
     * Sets the value of the meanStrokeWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMeanStrokeWidth(Integer value) {
        this.meanStrokeWidth = value;
    }

    /**
     * Gets the value of the r property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getR() {
        return r;
    }

    /**
     * Sets the value of the r property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setR(Integer value) {
        this.r = value;
    }

    /**
     * Gets the value of the serifProbability property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSerifProbability() {
        return serifProbability;
    }

    /**
     * Sets the value of the serifProbability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSerifProbability(Integer value) {
        this.serifProbability = value;
    }

    /**
     * Gets the value of the suspicious property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSuspicious() {
        return suspicious;
    }

    /**
     * Sets the value of the suspicious property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSuspicious(Boolean value) {
        this.suspicious = value;
    }

    /**
     * Gets the value of the t property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getT() {
        return t;
    }

    /**
     * Sets the value of the t property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setT(Integer value) {
        this.t = value;
    }

    /**
     * Gets the value of the wordFromDictionary property.
     * 
     */
    public boolean isWordFromDictionary() {
        return wordFromDictionary;
    }

    /**
     * Sets the value of the wordFromDictionary property.
     * 
     */
    public void setWordFromDictionary(boolean value) {
        this.wordFromDictionary = value;
    }

    /**
     * Gets the value of the wordIdentifier property.
     * 
     */
    public boolean isWordIdentifier() {
        return wordIdentifier;
    }

    /**
     * Sets the value of the wordIdentifier property.
     * 
     */
    public void setWordIdentifier(boolean value) {
        this.wordIdentifier = value;
    }

    /**
     * Gets the value of the wordNormal property.
     * 
     */
    public boolean isWordNormal() {
        return wordNormal;
    }

    /**
     * Sets the value of the wordNormal property.
     * 
     */
    public void setWordNormal(boolean value) {
        this.wordNormal = value;
    }

    /**
     * Gets the value of the wordNumeric property.
     * 
     */
    public boolean isWordNumeric() {
        return wordNumeric;
    }

    /**
     * Sets the value of the wordNumeric property.
     * 
     */
    public void setWordNumeric(boolean value) {
        this.wordNumeric = value;
    }

    /**
     * Gets the value of the wordPenalty property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWordPenalty() {
        return wordPenalty;
    }

    /**
     * Sets the value of the wordPenalty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWordPenalty(Integer value) {
        this.wordPenalty = value;
    }

    /**
     * Gets the value of the wordStart property.
     * 
     */
    public boolean isWordStart() {
        return wordStart;
    }

    /**
     * Sets the value of the wordStart property.
     * 
     */
    public void setWordStart(boolean value) {
        this.wordStart = value;
    }

}
