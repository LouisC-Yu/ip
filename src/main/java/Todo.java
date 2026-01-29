public class Todo extends Task {
    protected String description;
    protected boolean isDone;

    public Todo(String description) {
	super(description);
    }

    public String type() {
	return "T";
    }

    @Override
    public String getSaveData() {
	return "T/" + this.getStatusIcon() + "/" + this.getName();
    }

    @Override
    public String printTask() {
	return "[T]" + super.printTask();
    }
}