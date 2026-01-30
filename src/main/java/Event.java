import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Event extends Task {
    protected String description;
    protected boolean isDone;
    protected LocalDate from;
    protected String fromString;
    protected LocalDate to;
    protected String toString;

    public Event(String description, String from, String to) {
	super(description);
	this.from = LocalDate.parse(from);
	this.fromString = from;
	this.to = LocalDate.parse(to);
	this.toString = to;
    }

    public String type() {
	return "E";
    }

    @Override
    public String getSaveData() {
	return "E/" + this.getStatusIcon() + "/" + this.getName() + "/" + this.from + "/" + this.to;
    }

    @Override
    public String printTask() {
	return "[E]" + super.printTask() + " (from: " + this.from.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + " to: " + this.to.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")";
    }
}