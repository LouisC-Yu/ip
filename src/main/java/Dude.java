import java.util.*;
import java.io.*;

public class Dude {

    private List<Task> taskList = new ArrayList<>();
    String[] commandarray = {"bye", "list", "delete", "todo", "deadline", "event", "mark", "unmark"};
    private List<String> commands = Arrays.asList(commandarray);

    public Dude() {
	this.taskList = taskList;
	try {
	File savedList = new File("./dude.txt");
	Scanner fReader = new Scanner(savedList);
	while (fReader.hasNextLine()) {
	    String[] data = fReader.nextLine().trim().split("/");

	    if (data[0].equals("T")) {
		Todo T = new Todo(data[2]);
		if (!data[1].equals("X")) {
		    T.markDone();
		}
		this.taskList.add(T);
	    }

	    else if (data[0].equals("D")) {
		Deadline D = new Deadline(data[2], data[3]);
		if (!data[1].equals("X")) {
		    D.markDone();
		}
		this.taskList.add(D);
	    }

	    else if (data[0].equals("E")) {
		Event E = new Event(data[2], data[3], data[4]);
		if (!data[1].equals("X")) {
		    E.markDone();
		}
		this.taskList.add(E);
	    }
	}
	fReader.close();  }
	catch (FileNotFoundException e) { 
	    File savedList = new File("./dude.txt");
	}
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
	String s = "";

	for (Task task : this.taskList) {
	    s += task.getSaveData();
	    s += "\n";
	}
	try {
	FileWriter fWriter = new FileWriter("./dude.txt");
	fWriter.write(s);
	fWriter.close(); 
	}
	catch (IOException e) { System.out.println("guh"); }
        line();
    }
    
    public void start() {
	line();
	greet();
    }

    public void printList() {
	for (int i = 0; i < this.taskList.size(); i++) {
	    System.out.println(String.valueOf(i+1) + ". " + this.taskList.get(i).printTask());
	}
	line();
    }

    public void addList(Task t) {
	this.taskList.add(t);
	System.out.println("Sure dude! added: \n" + t.printTask() + "\nNow you have " + String.valueOf(this.taskList.size()) + " task in the list");
	line();
    }

    public void mark(int i) {
	Task t = this.taskList.get(i-1);
	t.markDone();
	System.out.println("Sure dude! I'll mark that as done:\n" + t.printTask());
	line();
    }

    public void unmark(int i) {
	Task t = this.taskList.get(i-1);
	t.unmarkDone();
	System.out.println("Sure dude! I'll unmark that as not done:\n" + t.printTask());
	line();
    }

    public void delete(int i) {
	Task t = this.taskList.get(i-1);
	System.out.println("Sure dude! Deleting this task:\n" + t.printTask());
	this.taskList.remove(i-1);
	int ts = this.taskList.size();
	System.out.println("Now you have " + String.valueOf(ts) + " task(s) in the task list, dude!");	
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

	    else if (input.toLowerCase().startsWith("delete ")) {
		int i = Integer.parseInt(input.split(" ")[1]);
		dude.delete(i);
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
	}
	
	scanner.close();
    }
}
