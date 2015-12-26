package org.paragon.paragon.data;

import java.io.File;

/**
 * Represents a table within Paragon. A table pretty much just boils down to a directory on the filesystem where the
 * {@link Row}'s are stored.
 */
public class Table
{
	/**
	 * The name of the table.
	 */
	private final String name;

	/**
	 * The {@link File} object representing the table's root directory.
	 */
	private final File dir;

	/**
	 * Initializes the table.
	 *
	 * @param dir The root directory of this table.
	 */
	public Table(final File dir)
	{
		this.name = dir.getName();
		this.dir = dir;
	}

	/**
	 * Returns the name of the table.
	 *
	 * @return The table's name.
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns a {@link File} which represents the table's directory path.
	 *
	 * @return A {@link File} representing this table's root directory.
	 */
	public File getDir()
	{
		return new File(dir.getAbsolutePath());
	}
}
