import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Deadline extends Task {
    protected String description;
    protected boolean isDone;
    protected LocalDate by;
    protected String byString;

    public Deadline(String description, String by) {
	super(description);
	this.by = LocalDate.parse(by);
	this.byString = by;
    }

    public String type() {
	return "D";
    }

    @Override
    public String getSaveData() {
	return "D/" + this.getStatusIcon() + "/" + this.getName() + "/" + this.byString;
    }

    @Override
    public String printTask() {
	return "[D]" + super.printTask() + " (by: " + this.by.format(DateTimeFormatter.ofPattern("d MMM yyyy")) + ")";
    }
}