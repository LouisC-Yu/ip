public class Todo extends Task {
    protected String description;
    protected boolean isDone;

    public Todo(String description) {
	super(description);
    }

    @Override
    public String printTask() {
	return "[T]" + super.printTask();
    }
}