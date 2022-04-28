package pl.north93.noidling;

import java.awt.*;

public class CursorMover
{
    private final Robot robot;

    public CursorMover()
    {
        try
        {
            this.robot = new Robot();
        }
        catch (final AWTException e)
        {
            throw new RuntimeException("Failed to initialise Robot, so I can't produce fake inputs", e);
        }
    }

    public void doFakeMove(final Point originalLocation)
    {
        this.robot.mouseMove(originalLocation.x + 1, originalLocation.y + 1);
        this.robot.delay(50);
        this.robot.mouseMove(originalLocation.x, originalLocation.y);
    }
}
