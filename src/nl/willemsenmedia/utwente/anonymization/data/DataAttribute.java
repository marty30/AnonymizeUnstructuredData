package nl.willemsenmedia.utwente.anonymization.data;

/**
 * Created by Martijn on 8-3-2016.
 * <p>
 * All data attributes. An attribute contains a type and the real data.
 * Each field in a form would correspond to a DataAttribute.
 */
public class DataAttribute {
	private DataType dataType;
	private String data;
	private String name;

	public DataAttribute(DataType dataType, String data) {
		this(dataType, null, data);
	}

	public DataAttribute(DataType dataType, String name, String data) {
		this.dataType = dataType;
		this.name = name;
		this.data = data;
	}

	public DataType getDataType() {
		return dataType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		if (name != null)
			return name + ": " + data + " (" + dataType.toString() + ")";
		else
			return dataType.toString() + ": " + data;
	}
}
