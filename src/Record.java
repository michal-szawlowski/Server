import java.time.LocalDateTime;

public class Record {
    private final LocalDateTime time;
    private final String input;


    public Record(LocalDateTime time, String input) {
        this.time = time;
        this.input = input;
    }
}
