package dude;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import dude.Dude;
import dude.exceptions.commandException;
import dude.exceptions.unknownException;

public class DudeTest {
    @Test
    public void commandTestCases() throws unknownException, commandException {
	Dude dude = new Dude("./dude.txt");
	assertEquals(dude.getResponse("hi"), 
"Sup dude, I'm Dude!\nHow may I help, dude?");

	assertEquals(dude.getResponse("bye"), 
"Okay, bye dude!");
    }
}