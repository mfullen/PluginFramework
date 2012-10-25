package com.pwf.plugin;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mfullen
 */
public class Example1
{
    private static final Logger logger = LoggerFactory.getLogger(Example1.class);

    public Example1()
    {
    }

    @Test
    public void testPluginManager()
    {
        PluginManager pluginManager = PluginManagerFactory.createPluginManager();

        DataPlugin dataPlugin = new DataService();
        logger.debug(dataPlugin.toString());

        assertNull(dataPlugin.getData());

        pluginManager.load(dataPlugin);

        assertEquals("My Data", dataPlugin.getData());

        DataPlugin plugin = pluginManager.getPlugin(DataPlugin.class);
        assertEquals(plugin, dataPlugin);

        DataService plugin2 = pluginManager.getPlugin(DataService.class);
        assertEquals(plugin2, dataPlugin);

        DataPlugin plugin3 = pluginManager.getPlugin(DataService.class);
        assertEquals(plugin3, dataPlugin);
    }
}
