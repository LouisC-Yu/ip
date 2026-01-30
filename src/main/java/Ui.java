public class Ui {

    public void line() {
        System.out.println("____________________________________________________________");
    }

    public void greet() {
	line();
        System.out.println("Sup dude, I'm Dude!\nHow may I help, dude?\n");
        line();
    }

    public void bye() {
        System.out.println("Okay, bye dude!");
        line();
    }

    public void showError(String message) {
        System.out.println(message);
        line();
    }

    public void printList(TaskList tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i).printTask());
        }
        line();
    }

    public void showTaskAdded(Task task, int size) {
        System.out.println(
            "Sure dude! added:\n" +
            task.printTask() +
            "\nNow you have " + size + " task(s) in the list"
        );
        line();
    }

    public void showTaskDeleted(Task task, int size) {
        System.out.println("Sure dude! Deleting this task:\n" + task.printTask());
        System.out.println("Now you have " + size + " task(s) in the task list, dude!");
        line();
    }

    public void showTaskMarked(Task task, boolean done) {
        if (done) {
            System.out.println("Sure dude! I'll mark that as done:\n" + task.printTask());
        } else {
            System.out.println("Sure dude! I'll unmark that as not done:\n" + task.printTask());
        }
        line();
    }
}
