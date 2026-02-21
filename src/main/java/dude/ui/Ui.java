package dude.ui;

import dude.task.TaskList;
import dude.task.*;

public class Ui {

    /*
	Outputs String of just lines. Deprecated
    */

    public String line() {
        return "____________________________________________________________";
    }

    /*
	Outputs String of start message
    */

    public String greet() {
        return line() + "Sup dude, I'm Dude!\nHow may I help, dude?";
    }

    /*
	Outputs String of closing message
    */

    public String bye() {
        return "Okay, bye dude!";
    }

    /*
	Outputs String of error message
    */

    public String showError(String message) {
        return message;
    }

    /*
	Outputs String of TaskList
    */

    public String printList(TaskList tasks) {
	String out = "";
        for (int i = 0; i < tasks.size(); i++) {
            out += (i + 1) + ". " + tasks.get(i).printTask() + "\n";
        }
        return out;
    }

    /*
	Outputs String of Task and mentions it was just added to TaskList
    */

    public String showTaskAdded(Task task, int size) {
        return "Sure dude! added:\n" +
            task.printTask() +
            "\nNow you have " + size + " task(s) in the list";
    }

    /*
	Outputs String of Task and mentions it was just deleted to TaskList
    */

    public String showTaskDeleted(Task task, int size) {
        return "Sure dude! Deleting this task:\n" + task.printTask() + 
            "\nNow you have " + size + " task(s) in the task list, dude!";
    }

    /*
	Outputs String of Task and mentions it was just marked or unmarked as done
    */

    public String showTaskMarked(Task task, boolean done) {
        if (done) {
            return "Sure dude! I'll mark that as done:\n" + task.printTask();
        } else {
            return "Sure dude! I'll unmark that as not done:\n" + task.printTask();
        }
    }
}
