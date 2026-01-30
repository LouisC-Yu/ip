package dude.task;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markDone() {
	this.isDone = true;
    }

    public void unmarkDone() {
	this.isDone = false;
    }

    public String getName() {
	return this.description;
    }

    public String getSaveData() {
	return "T/" + this.getStatusIcon() + "/" + this.description;
    }

    public String printTask() {
	return "[" + this.getStatusIcon() + "] " + this.getName(); 
    }
}