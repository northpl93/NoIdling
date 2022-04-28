package pl.north93.noidling;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationFactory
{
    public static Configuration loadConfiguration()
    {
        final Properties properties = new Properties();
        try
        {
            properties.load(new FileInputStream("config.properties"));
        }
        catch (final IOException e)
        {
            System.out.println("No configuration found, will continue with default options");
        }

        return new Configuration(properties);
    }
}
