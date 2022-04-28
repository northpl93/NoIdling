package pl.north93.noidling;

import static pl.north93.noidling.ConfigurationFactory.loadConfiguration;


import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NoIdling
{
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final CursorMonitor cursorMonitor = new CursorMonitor();
    private final CursorMover cursorMover = new CursorMover();
    private final Configuration configuration;

    public NoIdling(final Configuration configuration)
    {
        this.configuration = configuration;
    }

    public void scheduleWorker()
    {
        this.executorService.scheduleAtFixedRate(this::checkAndMoveCursor, 1, 1, TimeUnit.SECONDS);
    }

    private void checkAndMoveCursor()
    {
        final Duration idleTime = this.cursorMonitor.trackIdleTime();
        if (idleTime.compareTo(this.configuration.getIdleTimeBeforeMouseMove()) < 0)
        {
            return;
        }

        System.out.println("Idle timeout, moving cursor...");
        this.cursorMover.doFakeMove(this.cursorMonitor.getLastCursorPosition());
        this.cursorMonitor.resetIdleTime();
    }

    public static void main(final String[] args)
    {
        new NoIdling(loadConfiguration()).scheduleWorker();
    }
}
