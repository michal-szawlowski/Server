import java.time.LocalDateTime;

public class Timer {

    private long startServer;

    public void start() {
        startServer = System.currentTimeMillis();
    }
    public long workTimeInSeconds() {
        return (System.currentTimeMillis() - startServer) / 1000;
    }
}
