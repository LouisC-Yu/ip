package dude;

import dude.storage.Storage;
import dude.task.TaskList;
import dude.ui.Ui;
import dude.task.*;
import dude.exceptions.*;

import java.util.*;
import java.io.*;

public class Dude {
    String[] commandarray = {"bye", "list", "delete", "todo", "deadline", "event", "mark", "unmark"};
    private List<String> commands = Arrays.asList(commandarray);

    private Storage storage;
    private TaskList taskList;
    private Ui ui;

    public Dude(String filepath) {
	this.ui = new Ui();
	this.storage = new Storage(filepath);
	try {
	    this.taskList = new TaskList(storage.load());
	} catch (FileNotFoundException e) {
	    this.taskList = new TaskList();
	}
    }

    public void bye() {
	this.ui.bye();
	try {
	    this.storage.save(this.taskList.getAll());
        } catch (IOException e) {
	    System.out.println("Error saving data");
	}
    }

    public void addList(Task t) {
	this.taskList.add(t);
	int s = this.taskList.size();
	this.ui.showTaskAdded(t, s);
    }

    public void mark(int i) {
	Task t = this.taskList.get(i-1);
	t.markDone();
	this.ui.showTaskMarked(t, true);
    }

    public void unmark(int i) {
	Task t = this.taskList.get(i-1);
	t.unmarkDone();
	this.ui.showTaskMarked(t, false);
    }

    public void delete(int i) {
	Task t = this.taskList.get(i-1);
	this.taskList.remove(i-1);
	int ts = this.taskList.size();
	this.ui.showTaskDeleted(t, ts);
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

    public void run() {
	this.ui.greet();
	Scanner scanner = new Scanner(System.in);

	while (true) {
	    if (!scanner.hasNextLine()) {
		break;
	    }

	    String input = scanner.nextLine().trim();

	    try {
		this.checkError(input);
	    } catch (commandException e1) {
		this.ui.showError(e1.toString());
		continue;
	    } catch(unknownException e2) {
		this.ui.showError(e2.toString());
		continue;
	    }

	    if (input.toLowerCase().equals("bye")) {
                this.bye();
            }

	    else if (input.toLowerCase().equals("list")) {
		this.ui.printList(this.taskList);
	    }

	    else if (input.toLowerCase().startsWith("mark ")) {
		int i = Integer.parseInt(input.split(" ")[1]);
		this.mark(i);
	    }
	    
	    else if (input.toLowerCase().startsWith("unmark ")) {
		int i = Integer.parseInt(input.split(" ")[1]);
		this.unmark(i);
	    }

	    else if (input.toLowerCase().startsWith("delete ")) {
		int i = Integer.parseInt(input.split(" ")[1]);
		this.delete(i);
	    }

	    else if (input.toLowerCase().startsWith("todo ")) {
		String desc = input.split(" ", 2)[1];
		Todo t = new Todo(desc);

		this.addList(t);
		
	    }

	    else if (input.toLowerCase().startsWith("deadline ")) {
		String desc = input.split(" ", 2)[1];
		String by = desc.split("/by ")[1];
		desc = desc.split(" /")[0];
		Deadline t = new Deadline(desc, by);

		this.addList(t);
	    }

	    else if (input.toLowerCase().startsWith("event ")) {
		String desc = input.split(" ", 2)[1];
		String from = desc.split(" /")[1].substring(5);
		String to = desc.split(" /to ")[1];
		desc = desc.split(" /")[0];
		Event t = new Event(desc, from, to);
		
		this.addList(t);
	    }
	}
	
	scanner.close();
    }
    
    public static void main(String[] args) {
	new Dude("./dude.txt").run();
    }
}
