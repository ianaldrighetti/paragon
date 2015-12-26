package org.paragon.paragon.data.type;

/**
 * An abstract class all Paragon data types must inherit.
 */
public abstract class DataType implements DataTypeIF
{
	public DataType()
	{
		setValue(null);
	}

	public DataType(final Object value)
	{
		setValue(value);
	}
}
