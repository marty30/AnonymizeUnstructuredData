//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.22 at 01:30:51 PM CET 
//


package nl.willemsenmedia.utwente.anonymization.nlp_java.xml_objects;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{}attlist.Sentiment"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "Sentiment")
public class Sentiment {

	@XmlAttribute(name = "polarity", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String polarity;
	@XmlAttribute(name = "externalReference", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "NMTOKEN")
	protected String externalReference;

	/**
	 * Gets the value of the polarity property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getPolarity() {
		return polarity;
	}

	/**
	 * Sets the value of the polarity property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setPolarity(String value) {
		this.polarity = value;
	}

	/**
	 * Gets the value of the externalReference property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getExternalReference() {
		return externalReference;
	}

	/**
	 * Sets the value of the externalReference property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setExternalReference(String value) {
		this.externalReference = value;
	}

}
