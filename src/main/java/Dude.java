import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Dude {

    private List<Task> taskList = new ArrayList<>();

    public Dude() {
	this.taskList = taskList;
    }

    public void line() {
	System.out.println("____________________________________________________________");
    }

    public void greet() {
        System.out.println("Sup dude, I'm Dude!\nHow may I help, dude?\n");
	line();
    }

    public void bye() {
	System.out.println("Okay, bye dude!");
        line();
    }
    
    public void start() {
	line();
	greet();
    }

    public void printList() {
	for (int i = 0; i < this.taskList.size(); i++) {
	    System.out.println(String.valueOf(i) + ". " + this.taskList.get(i).printTask());
	}
	line();
    }

    public void addList(Task t) {
	this.taskList.add(t);
	System.out.println("Sure dude! added: \n" + t.printTask() + "\nNow you have " + String.valueOf(this.taskList.size()) + " task in the list");
	line();
    }

    public void mark(int i) {
	Task t = this.taskList.get(i);
	t.markDone();
	System.out.println("Sure dude! I'll mark that as done:\n" + t.printTask());
	line();
    }

    public void unmark(int i) {
	Task t = this.taskList.get(i);
	t.unmarkDone();
	System.out.println("Sure dude! I'll unmark that as not done:\n" + t.printTask());
	line();
    }

    public static void main(String[] args) {
	Dude dude = new Dude();
	dude.start();


	Scanner scanner = new Scanner(System.in);

	while (true) {
	    if (!scanner.hasNextLine()) {
		break;
	    }

	    String input = scanner.nextLine().trim();

	    if (input.toLowerCase().equals("bye")) {
                dude.bye();
                break;
            }

	    else if (input.toLowerCase().equals("list")) {
		dude.printList();
	    }

	    else if (input.toLowerCase().startsWith("mark ")) {
		int i = Integer.parseInt(input.split(" ")[1]);
		dude.mark(i);
	    }
	    
	    else if (input.toLowerCase().startsWith("unmark ")) {
		int i = Integer.parseInt(input.split(" ")[1]);
		dude.unmark(i);
	    }

	    else if (input.toLowerCase().startsWith("todo ")) {
		String desc = input.split(" ", 2)[1];
		Todo t = new Todo(desc);

		dude.addList(t);
		
	    }

	    else if (input.toLowerCase().startsWith("deadline ")) {
		String desc = input.split(" ", 2)[1];
		String by = desc.split("/by ")[1];
		desc = desc.split(" /")[0];
		Deadline t = new Deadline(desc, by);

		dude.addList(t);
	    }

	    else if (input.toLowerCase().startsWith("event ")) {
		String desc = input.split(" ", 2)[1];
		String from = desc.split(" /")[1].substring(5);
		String to = desc.split(" /to ")[1];
		desc = desc.split(" /")[0];
		Event t = new Event(desc, from, to);
		
		dude.addList(t);
	    }

	    else {
		System.out.println(input);
	    }
	}
	
	scanner.close();
    }
}
