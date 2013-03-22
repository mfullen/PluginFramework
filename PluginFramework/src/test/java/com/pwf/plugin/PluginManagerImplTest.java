package com.pwf.plugin;

import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mfullen
 */
public class PluginManagerImplTest
{
    private static final Logger logger = LoggerFactory.getLogger(PluginManagerImplTest.class);

    public PluginManagerImplTest()
    {
    }

    @Test
    public void testPluginManager()
    {
        PluginManager pluginManager = PluginManagerFactory.createPluginManager();

        DataPlugin dataPlugin = new DataService();
        logger.debug(dataPlugin.toString());

        assertNull(dataPlugin.getData());

        pluginManager.addPlugin(dataPlugin);
        pluginManager.activate(dataPlugin);

        assertEquals("My Data", dataPlugin.getData());

        DataPlugin plugin = pluginManager.getPlugin(DataPlugin.class);
        assertEquals(plugin, dataPlugin);

        DataService plugin2 = pluginManager.getPlugin(DataService.class);
        assertEquals(plugin2, dataPlugin);

        DataPlugin plugin3 = pluginManager.getPlugin(DataService.class);
        assertEquals(plugin3, dataPlugin);
    }

    @Test
    public void testPluginManagerLoad()
    {
        PluginManager pluginManager = PluginManagerFactory.createPluginManager();
        assertTrue(pluginManager.getPlugins().isEmpty());
        pluginManager.loadAllPlugins();
        assertFalse(pluginManager.getPlugins().isEmpty());
        assertEquals(2, pluginManager.getPlugins().size());
        assertTrue(pluginManager.getPlugin(DataService.class) instanceof Plugin);
        assertTrue(pluginManager.getPlugin(PlainPlugin.class) instanceof Plugin);
    }
}
