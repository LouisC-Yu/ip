package dude.ui;

import dude.task.TaskList;
import dude.task.*;

public class Ui {

    public String line() {
        return "____________________________________________________________";
    }

    public String greet() {
        return line() + "Sup dude, I'm Dude!\nHow may I help, dude?";
    }

    public String bye() {
        return "Okay, bye dude!";
    }

    public String showError(String message) {
        return message;
    }

    public String printList(TaskList tasks) {
	String out = "";
        for (int i = 0; i < tasks.size(); i++) {
            out += (i + 1) + ". " + tasks.get(i).printTask() + "\n";
        }
        return out;
    }

    public String showTaskAdded(Task task, int size) {
        return "Sure dude! added:\n" +
            task.printTask() +
            "\nNow you have " + size + " task(s) in the list";
    }

    public String showTaskDeleted(Task task, int size) {
        return "Sure dude! Deleting this task:\n" + task.printTask() + 
            "\nNow you have " + size + " task(s) in the task list, dude!";
    }

    public String showTaskMarked(Task task, boolean done) {
        if (done) {
            return "Sure dude! I'll mark that as done:\n" + task.printTask();
        } else {
            return "Sure dude! I'll unmark that as not done:\n" + task.printTask();
        }
    }
}
