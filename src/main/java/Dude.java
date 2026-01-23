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
	    System.out.println(String.valueOf(i) + ". [" + taskList.get(i).getStatusIcon() + "]" + taskList.get(i).getName());
	}
	line();
    }

    public void addList(String s) {
	Task t = new Task(s);
	this.taskList.add(t);
	System.out.println("added: " + s);
	line();
    }

    public void mark(int i) {
	Task t = this.taskList.get(i);
	t.markDone();
	System.out.println("Sure dude! I'll mark that as done:\n[" + t.getStatusIcon() + "] " + t.getName());
	line();
    }

    public void unmark(int i) {
	Task t = this.taskList.get(i);
	t.markDone();
	System.out.println("Sure dude! I'll unmark that as not done:\n[" + t.getStatusIcon() + "] " + t.getName());
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

	    if (input.toLowerCase().equals("list")) {
		dude.printList();
	    }

	    if (input.toLowerCase().startsWith("mark ")) {
		int i = Integer.parseInt(input.split(" ")[1]);
		dude.mark(i);
	    }
	    
	    if (input.toLowerCase().startsWith("unmark ")) {
		int i = Integer.parseInt(input.split(" ")[1]);
		dude.unmark(i);
	    }

	    else {
		dude.addList(input);
	    }
	}
	
	scanner.close();
    }
}
