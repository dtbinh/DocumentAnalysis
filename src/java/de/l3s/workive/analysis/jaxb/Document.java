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

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}page" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="pagesCount" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="producer" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "page" })
@XmlRootElement(name = "document")
public class Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6582612041206873733L;
	@XmlElement(required = true)
	protected List<Page> page;
	@XmlAttribute(name = "pagesCount", required = true)
	protected Integer pagesCount;
	@XmlAttribute(name = "producer", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String producer;
	@XmlAttribute(name = "version", required = true)
	protected BigDecimal version;

	/**
	 * Gets the value of the page property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the page property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPage().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Page }
	 * 
	 * 
	 */
	public List<Page> getPage() {
		if (page == null) {
			page = new ArrayList<Page>();
		}
		return this.page;
	}

	/**
	 * Gets the value of the pagesCount property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getPagesCount() {
		return pagesCount;
	}

	/**
	 * Sets the value of the pagesCount property.
	 * 
	 * @param value
	 *            allowed object is {@link Integer }
	 * 
	 */
	public void setPagesCount(Integer value) {
		this.pagesCount = value;
	}

	/**
	 * Gets the value of the producer property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * Sets the value of the producer property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setProducer(String value) {
		this.producer = value;
	}

	/**
	 * Gets the value of the version property.
	 * 
	 * @return possible object is {@link BigDecimal }
	 * 
	 */
	public BigDecimal getVersion() {
		return version;
	}

	/**
	 * Sets the value of the version property.
	 * 
	 * @param value
	 *            allowed object is {@link BigDecimal }
	 * 
	 */
	public void setVersion(BigDecimal value) {
		this.version = value;
	}

	public List<String> traverse() {
		List<String> paragraphs=new ArrayList<String>();
		
		for (Page p : getPage()) {
			for (Block b : p.getBlock()) {
				if (b.isTexttype()) {
					for (Par par : b.getText().getPar()) {
						StringBuilder sb=new StringBuilder();
						for (Line line : par.getLine()) {
							
							for(Formatting formatting:line.getFormatting())
							{
								for(CharParams cp:formatting.getCharParams())
								{
									String curchar = cp.getContent();
									sb.append(curchar);
								}
								sb.append(" ");
								
							}
							sb.append("\n");
							
							
							
						}
						paragraphs.add(sb.toString());
					}
				}

			}
		}
		return paragraphs;

	}

}
