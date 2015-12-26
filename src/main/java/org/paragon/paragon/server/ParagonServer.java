package org.paragon.paragon.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;

/**
 * This is the Paragon server... But right now it is anything but a server :-).
 */
public class ParagonServer
{
	private static final Log logger = LogFactory.getLog(ParagonServer.class);

	/**
	 * Starts the Paragon server with the specified options.
	 *
	 * @param options A {@link ParagonServerOptions} object which tells Paragon how to configure itself to run.
	 */
	public void start(ParagonServerOptions options)
	{
		if (options == null) {
			options = getDefaultOptions();
		}

		final File dataDirectory = new File(options.getDataDirectory());
		if (!dataDirectory.exists() && !dataDirectory.mkdir())
		{
			throw new IllegalArgumentException("The specified directory path does not exist. An attempt to create the directory failed.");
		}
		else if (dataDirectory.isFile())
		{
			throw new IllegalArgumentException("The specified data directory resolves to a file.");
		}

		// Initialize the server, such as loading up the tables.
		initialize(options);
	}

	/**
	 * Initializes the servers required resources, such as the {@link org.paragon.paragon.data.TablePool}.
	 *
	 * @param options The {@link ParagonServerOptions} object.
	 */
	private void initialize(final ParagonServerOptions options)
	{
		final File dataDirectory = new File(options.getDataDirectory());


	}

	public ParagonServerOptions getDefaultOptions()
	{
		return new ParagonServerOptions();
	}
}
