package pl.north93.noidling;

import java.time.Duration;
import java.util.Properties;

public class Configuration
{
    private final Duration idleTimeBeforeMouseMove;

    public Configuration(final Properties properties)
    {
        this.idleTimeBeforeMouseMove = parseDuration(properties.getProperty("idleTimeBeforeMouseMove", "210"));
    }

    public Duration getIdleTimeBeforeMouseMove()
    {
        return this.idleTimeBeforeMouseMove;
    }

    private static Duration parseDuration(final String seconds)
    {
        return Duration.ofSeconds(Integer.parseInt(seconds));
    }
}
