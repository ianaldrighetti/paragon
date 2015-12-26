package org.paragon.paragon.data;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The table pool is a, well, pool of {@link Table}'s.
 */
public class TablePool
{
	/**
	 * A map, where the key is the lowercase name of the {@link Table}.
	 */
	private final Map<String, Table> pool;

	/**
	 * The data directory.
	 */
	private File dataDirectory;

	/**
	 * Initializes the table pool map.
	 */
	public TablePool()
	{
		pool = new LinkedHashMap<String, Table>();
	}

	/**
	 * Returns the {@link Table} based on the name.
	 *
	 * @param name The name of the table to fetch.
	 * @return Returns the {@link Table} if it exists, null otherwise.
	 */
	public Table getTable(final String name)
	{
		synchronized (pool)
		{
			return pool.get(StringUtils.lowerCase(name));
		}
	}

	public Table createTable(final String name)
	{
		if (name == null) {
			throw new IllegalArgumentException("The name must not be null.");
		}

		synchronized (pool)
		{
			if (pool.containsKey(name.toLowerCase())) {
				throw new IllegalArgumentException("The table already exists.");
			}

			final File dir = new File(dataDirectory, name);
			// TODO make the directory, add it to the pool, etc. name validation too?
			return null;
		}

	}

	/**
	 * Refreshes the table pool.
	 *
	 * @param dir The directory path to get the list of tables from.
	 */
	public void refresh(final File dir)
	{
		synchronized (pool)
		{
			dataDirectory = dir;
			final File[] files = dataDirectory.listFiles();
			pool.clear();

			for (final File file : files)
			{
				if (!file.isDirectory())
				{
					continue;
				}

				pool.put(file.getName().toLowerCase(), new Table(file));
			}
		}
	}
}
