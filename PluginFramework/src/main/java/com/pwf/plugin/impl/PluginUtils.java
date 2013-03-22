package com.pwf.plugin.impl;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mfullen
 */
public final class PluginUtils
{
    private static final Logger logger = LoggerFactory.getLogger(PluginUtils.class);

    private PluginUtils()
    {
    }

    public static List<URL> getJarFilesonClasspathUrl(String directory)
    {
        URL[] urls = new URL[0];
        try
        {
            File file = new File(directory);
            File[] listFiles = file.listFiles(new FileFilter()
            {
                @Override
                public boolean accept(File pathname)
                {
                    return pathname.getName().endsWith(".jar");
                }
            });

            urls = new URL[listFiles.length];

            for (int i = 0; i < urls.length; i++)
            {
                urls[i] = listFiles[i].toURI().toURL();
            }
        }
        catch (MalformedURLException ex)
        {
            logger.error("Error getfiles on classpath", ex);
        }
        finally
        {
            return Arrays.asList(urls);
        }
    }
}
