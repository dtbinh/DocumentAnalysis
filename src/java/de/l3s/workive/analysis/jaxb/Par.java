//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.08.22 at 05:15:52 PM CEST 
//


package de.l3s.workive.analysis.jaxb;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlTransient;
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
 *         &lt;element ref="{}line" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="align" type="{http://www.w3.org/2001/XMLSchema}NCName" />
 *       &lt;attribute name="leftIndent" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="lineSpacing" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="rightIndent" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="startIndent" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "line",
        "sentence",
        "parwords"
})
@XmlRootElement(name = "par")
public class Par implements Serializable{

    
    /**
	 * 
	 */
	private static final long serialVersionUID = 797591981832917539L;
	@XmlElement(required = true)
    protected List<Line> line;
    @XmlElement(required = true)
    protected List<Sentences> sentence;
    @XmlElement(required = true)
    protected List<Words> parwords;
    
    @XmlAttribute(name = "align")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String align;
    @XmlAttribute(name = "leftIndent")
    protected Integer leftIndent;
    @XmlAttribute(name = "lineSpacing")
    protected Integer lineSpacing;
    @XmlAttribute(name = "rightIndent")
    protected Integer rightIndent;
    @XmlAttribute(name = "startIndent")
    protected Integer startIndent;
   @XmlTransient
	private Integer id;
   @XmlTransient
private int top;
   @XmlTransient
private int bottom;
   @XmlTransient
private String stringval;
   @XmlTransient
private String escapedstr;
   @XmlTransient
private int pagenr;

   public int getTop() {
	return top;
}
   public int getBottom() {
	return bottom;
}
   public String getStringval() {
	return stringval;
}public String getEscapedstr() {
	return escapedstr;
}
public Integer getId() {
	return id;
}
public int getPagenr() {
	return pagenr;
}
    /**
     * Gets the value of the line property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the line property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Line }
     * 
     * 
     */


    public List<Line> getLine() {
        if (line == null) {
            line = new ArrayList<Line>();
        }
        return this.line;
    }
    public List<Words> getParwords() {
		return parwords;
	}
	public void setParwords(List<Words> parwords) {
		this.parwords = parwords;
	}
	public void setSentence(List<Sentences> sentence) {
        this.sentence = sentence;
    }
    public List<Sentences> getSentence() {
        if (sentence == null) {
            sentence = new ArrayList<Sentences>();
        }
        return this.sentence;
    }

    /**
     * Gets the value of the align property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlign() {
        return align;
    }

    /**
     * Sets the value of the align property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlign(String value) {
        this.align = value;
    }

    /**
     * Gets the value of the leftIndent property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLeftIndent() {
        return leftIndent;
    }

    /**
     * Sets the value of the leftIndent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLeftIndent(Integer value) {
        this.leftIndent = value;
    }

    /**
     * Gets the value of the lineSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLineSpacing() {
        return lineSpacing;
    }

    /**
     * Sets the value of the lineSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLineSpacing(Integer value) {
        this.lineSpacing = value;
    }

    /**
     * Gets the value of the rightIndent property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRightIndent() {
        return rightIndent;
    }

    /**
     * Sets the value of the rightIndent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRightIndent(Integer value) {
        this.rightIndent = value;
    }

    /**
     * Gets the value of the startIndent property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStartIndent() {
        return startIndent;
    }

    /**
     * Sets the value of the startIndent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStartIndent(Integer value) {
        this.startIndent = value;
    }

	public void setId(int parnum) {
		this.id=parnum;
		
	}

	public void setTop(int paratop) {
		this.top=paratop;
		
	}

	public void setBottom(int parabottom) {
		this.bottom=parabottom;
		
	}

	public void setStringval(String string) {
		this.stringval=string;
		
	}

	public void setEscapedstrval(String escapeHtml) {
	this.escapedstr=escapeHtml;
		
	}
	public void setPage(int pagenr) {
		this.pagenr=pagenr;
		
	}
	public void setValid(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
