package org.paragon.paragon.data.type;

/**
 * A simple string type.
 */
public class StringType extends DataType
{
	private String value;

	public void setValue(final Object value)
	{
		if (value instanceof CharSequence)
		{
			this.value = value.toString();
		}
		else
		{
			this.value = null;
		}
	}

	public Object getObject()
	{
		return value;
	}
}