import java.util.*;

public class Dude {

    private List<Task> taskList = new ArrayList<>();
    String[] commandarray = {"bye", "list", "todo", "deadline", "event", "mark", "unmark"};
    private List<String> commands = Arrays.asList(commandarray);

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

    public void checkError(String command) throws commandException, unknownException {
	String s = command.toLowerCase();

	if (!this.commands.contains(s.split(" ")[0])) {
	    throw new unknownException("Dude, I don't know what that's supposed to mean, dude ;-;");
	}

	if (s.startsWith("todo")) {
	    if(s.split(" ").length <= 1) {
	    	throw new commandException("Dude! The todo command can't have an empty description, dude!");
	    }
	}

	else if (s.startsWith("deadline")) {
	    if (s.split("/")[0].split(" ").length <= 1) {
	    	throw new commandException("Dude! The deadline command can't have an empty description, dude!");
	    }

	    if (!s.contains("/by ")) {
		throw new commandException("Dude! A deadline needs a, y'know, deadline (/by) dude!");
	    }
	}

	else if (s.startsWith("event")) {

	    if (s.split("/")[0].split(" ").length <= 1) {
	    	throw new commandException("Dude! The event command can't have an empty description, dude!");
	    }

	    if (!s.contains("/from ")) {
		throw new commandException("Dude! An event needs to have a start (/from) time, dude!");
	    }
	    else if (!s.contains("/to ")) {
		throw new commandException("Dude! An event needs to have an end (/to) time, dude!");
	    }
	}
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

	    try {
		dude.checkError(input);
	    } catch (commandException e1) {
		System.out.println(e1.toString());
		dude.line();
		continue;
	    } catch(unknownException e2) {
		System.out.println(e2.toString());
		dude.line();
		continue;
	    }

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
		System.out.println("Hi");
		String desc = input.split(" ", 2)[1];
		String by = desc.split("/by ")[1];
		desc = desc.split(" /")[0];
		Deadline t = new Deadline(desc, by);

		dude.addList(t);
	    }

	    else if (input.toLowerCase().startsWith("event ")) {
		System.out.println("Hiii");
		String desc = input.split(" ", 2)[1];
		String from = desc.split(" /")[1].substring(5);
		String to = desc.split(" /to ")[1];
		desc = desc.split(" /")[0];
		Event t = new Event(desc, from, to);
		
		dude.addList(t);
	    }
	}
	
	scanner.close();
    }
}
