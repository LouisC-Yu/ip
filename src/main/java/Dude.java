import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Dude {

    private List<String> taskList = new ArrayList<>();

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
	    System.out.println(String.valueOf(i) + ". " + taskList.get(i));
	}
	line();
    }

    public void addList(String s) {
	this.taskList.add(s);
	System.out.println("added: " + s);
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

	    if (input.equalsIgnoreCase("bye")) {
                dude.bye();
                break;
            }

	    if (input.equalsIgnoreCase("list")) {
		dude.printList();
	    }

	    else {
		dude.addList(input);
	    }
	}
	
	scanner.close();
    }
}
