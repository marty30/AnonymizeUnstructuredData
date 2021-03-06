//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.22 at 01:30:51 PM CET 
//


package nl.willemsenmedia.utwente.anonymization.nlp.xml_objects;

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
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element ref="{}canonicalForm"/>
 *         &lt;element ref="{}Pragmatics"/>
 *         &lt;element ref="{}Semantics_ex"/>
 *         &lt;element ref="{}Syntax_ex"/>
 *         &lt;element ref="{}textualForm"/>
 *       &lt;/choice>
 *       &lt;attGroup ref="{}attlist.SenseExample"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
		"canonicalFormOrPragmaticsOrSemanticsEx"
})
@XmlRootElement(name = "SenseExample")
public class SenseExample {

	@XmlElements({
			@XmlElement(name = "canonicalForm", type = CanonicalForm.class),
			@XmlElement(name = "Pragmatics", type = Pragmatics.class),
			@XmlElement(name = "Semantics_ex", type = SemanticsEx.class),
			@XmlElement(name = "Syntax_ex", type = SyntaxEx.class),
			@XmlElement(name = "textualForm", type = TextualForm.class)
	})
	protected List<Object> canonicalFormOrPragmaticsOrSemanticsEx;
	@XmlAttribute(name = "id", required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "NMTOKEN")
	protected String id;

	/**
	 * Gets the value of the canonicalFormOrPragmaticsOrSemanticsEx property.
	 * <p>
	 * <p>
	 * This accessor method returns a reference to the live list,
	 * not a snapshot. Therefore any modification you make to the
	 * returned list will be present inside the JAXB object.
	 * This is why there is not a <CODE>set</CODE> method for the canonicalFormOrPragmaticsOrSemanticsEx property.
	 * <p>
	 * <p>
	 * For example, to add a new item, do as follows:
	 * <pre>
	 *    getCanonicalFormOrPragmaticsOrSemanticsEx().add(newItem);
	 * </pre>
	 * <p>
	 * <p>
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link CanonicalForm }
	 * {@link Pragmatics }
	 * {@link SemanticsEx }
	 * {@link SyntaxEx }
	 * {@link TextualForm }
	 */
	public List<Object> getCanonicalFormOrPragmaticsOrSemanticsEx() {
		if (canonicalFormOrPragmaticsOrSemanticsEx == null) {
			canonicalFormOrPragmaticsOrSemanticsEx = new ArrayList<Object>();
		}
		return this.canonicalFormOrPragmaticsOrSemanticsEx;
	}

	/**
	 * Gets the value of the id property.
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the value of the id property.
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setId(String value) {
		this.id = value;
	}

}
