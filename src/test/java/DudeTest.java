package dude;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import dude.Dude;
import dude.exceptions.commandException;
import dude.exceptions.unknownCommandException;

public class DudeTest {
    @Test
    public void commandTestCases() {
	private Dude dude = new Dude("./dude.txt");
	try {
	    assertEquals(dude.getResponse("hi"), 
"Sup dude, I'm Dude!\nHow may I help, dude?");

	    assertEquals(dude.getResponse("bye"), 
"Okay, bye dude!");
	} catch (commandException e1) {
	    assertEquals(e1.toString(), "commandException thrown");
	} catch (unknownException e2) {
	    assertEquals(e2.toString(), "unknownException thrown");
	}
    }
}