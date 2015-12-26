package org.paragon.paragon.server;

/**
 * This is a class which is used to configure the {@link ParagonServer}.
 */
public class ParagonServerOptions
{
	/**
	 * The path to a directory which contains the Paragon data.
	 */
	private String dataDirectory;

	/**
	 * Returns the path to the data directory.
	 *
	 * @return The data directory path.
	 */
	public String getDataDirectory()
	{
		return dataDirectory;
	}

	/**
	 * Sets the file path to the directory which is used to read and write Paragon data from. This points to the root
	 * directory where the table's reside.
	 *
	 * @param dataDirectory The path to the data directory.
	 */
	public void setDataDirectory(final String dataDirectory)
	{
		this.dataDirectory = dataDirectory;
	}
}
