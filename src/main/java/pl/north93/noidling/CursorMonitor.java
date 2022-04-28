package pl.north93.noidling;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;

public class CursorMonitor
{
    private Point lastLocation = new Point(0, 0);
    private Instant lastCheck = Instant.now();
    private Duration idleTime = Duration.ZERO;

    public Duration trackIdleTime()
    {
        final Instant currentTime = Instant.now();

        final Point newLocation = MouseInfo.getPointerInfo().getLocation();
        if (newLocation.equals(this.lastLocation))
        {
            this.idleTime = this.idleTime.plus(Duration.between(this.lastCheck, currentTime));
        }
        else
        {
            this.resetIdleTime();
            this.lastLocation = newLocation;
        }

        this.lastCheck = currentTime;
        return this.idleTime;
    }

    public void resetIdleTime()
    {
        this.idleTime = Duration.ZERO;
    }

    public Point getLastCursorPosition()
    {
        return this.lastLocation;
    }
}
