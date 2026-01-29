public class Deadline extends Task {
    protected String description;
    protected boolean isDone;
    protected String by;

    public Deadline(String description, String by) {
	super(description);
	this.by = by;
    }

    public String type() {
	return "D";
    }

    @Override
    public String getSaveData() {
	return "D/" + this.getStatusIcon() + "/" + this.getName() + "/" + this.by;
    }

    @Override
    public String printTask() {
	return "[D]" + super.printTask() + " (by: " + this.by + ")";
    }
}