//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.22 at 01:30:51 PM CET 
//


package nl.willemsenmedia.utwente.anonymization.nlp_java.xml_objects;

import javax.xml.bind.annotation.*;
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
 *         &lt;element ref="{}SynsetRelation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"synsetRelation"
})
@XmlRootElement(name = "SynsetRelations")
public class SynsetRelations {

	@XmlElement(name = "SynsetRelation")
	protected List<SynsetRelation> synsetRelation;

	/**
	 * Gets the value of the synsetRelation property.
	 * <p>
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the synsetRelation property.
	 * <p>
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getSynsetRelation().add(newItem);
	 * </pre>
	 * <p>
	 * <p>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link SynsetRelation }
	 */
	public List<SynsetRelation> getSynsetRelation() {
		if (synsetRelation == null) {
			synsetRelation = new ArrayList<SynsetRelation>();
		}
		return this.synsetRelation;
	}

}
