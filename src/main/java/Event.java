public class Event extends Task {
    protected String description;
    protected boolean isDone;
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
	super(description);
	this.from = from;
	this.to = to;
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
	return "[E]" + super.printTask() + " (from: " + this.from + " to: " + this.to + ")";
    }
}