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
 *       &lt;sequence>
 *         &lt;element ref="{}Meta" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}attlist.SynsetRelation"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"meta"
})
@XmlRootElement(name = "SynsetRelation")
public class SynsetRelation {

	@XmlElement(name = "Meta")
	protected Meta meta;
	@XmlAttribute(name = "relType")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String relType;
	@XmlAttribute(name = "target", required = true)
	@XmlSchemaType(name = "anySimpleType")
	protected String target;
	@XmlAttribute(name = "provenance")
	@XmlSchemaType(name = "anySimpleType")
	protected String provenance;

	/**
	 * Gets the value of the meta property.
	 *
	 * @return possible object is
	 * {@link Meta }
	 */
	public Meta getMeta() {
		return meta;
	}

	/**
	 * Sets the value of the meta property.
	 *
	 * @param value allowed object is
	 *              {@link Meta }
	 */
	public void setMeta(Meta value) {
		this.meta = value;
	}

	/**
	 * Gets the value of the relType property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getRelType() {
		return relType;
	}

	/**
	 * Sets the value of the relType property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setRelType(String value) {
		this.relType = value;
	}

	/**
	 * Gets the value of the target property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getTarget() {
		return target;
	}

	/**
	 * Sets the value of the target property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setTarget(String value) {
		this.target = value;
	}

	/**
	 * Gets the value of the provenance property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getProvenance() {
		return provenance;
	}

	/**
	 * Sets the value of the provenance property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setProvenance(String value) {
		this.provenance = value;
	}

}
