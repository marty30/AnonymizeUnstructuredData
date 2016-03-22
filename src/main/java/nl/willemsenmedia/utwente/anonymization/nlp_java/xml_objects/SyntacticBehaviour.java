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
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element ref="{}Complementation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}SyntacticSubcategorisationFrame" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}attlist.SyntacticBehaviour"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"complementation",
		"syntacticSubcategorisationFrame"
})
@XmlRootElement(name = "SyntacticBehaviour")
public class SyntacticBehaviour {

	@XmlElement(name = "Complementation")
	protected List<Complementation> complementation;
	@XmlElement(name = "SyntacticSubcategorisationFrame")
	protected List<SyntacticSubcategorisationFrame> syntacticSubcategorisationFrame;
	@XmlAttribute(name = "valency")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String valency;
	@XmlAttribute(name = "transitivity")
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	protected String transitivity;

	/**
	 * Gets the value of the complementation property.
	 * <p>
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the complementation property.
	 * <p>
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getComplementation().add(newItem);
	 * </pre>
	 * <p>
	 * <p>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link Complementation }
	 */
	public List<Complementation> getComplementation() {
		if (complementation == null) {
			complementation = new ArrayList<Complementation>();
		}
		return this.complementation;
	}

	/**
	 * Gets the value of the syntacticSubcategorisationFrame property.
	 * <p>
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the syntacticSubcategorisationFrame property.
	 * <p>
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getSyntacticSubcategorisationFrame().add(newItem);
	 * </pre>
	 * <p>
	 * <p>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link SyntacticSubcategorisationFrame }
	 */
	public List<SyntacticSubcategorisationFrame> getSyntacticSubcategorisationFrame() {
		if (syntacticSubcategorisationFrame == null) {
			syntacticSubcategorisationFrame = new ArrayList<SyntacticSubcategorisationFrame>();
		}
		return this.syntacticSubcategorisationFrame;
	}

	/**
	 * Gets the value of the valency property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getValency() {
		return valency;
	}

	/**
	 * Sets the value of the valency property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setValency(String value) {
		this.valency = value;
	}

	/**
	 * Gets the value of the transitivity property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getTransitivity() {
		return transitivity;
	}

	/**
	 * Sets the value of the transitivity property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setTransitivity(String value) {
		this.transitivity = value;
	}

}
