import java.util.Scanner;

public class Dude {
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
    
    public void start(){
	line();
	greet();
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
		
		System.out.println(input);
	}
	
	scanner.close();
    }
}
