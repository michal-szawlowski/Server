import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class History {
    private final List<Record> records = new ArrayList<>();

    public void add(String input) {
        records.add(new Record(LocalDateTime.now(), input));
    }
}
