package dude;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import dude.Dude;
import dude.exceptions.commandException;
import dude.exceptions.unknownException;

public class CommandsTest {
    @Test
    public void commandTestCases() throws unknownException, commandException {
	Dude dude = new Dude("./dude.txt");
	assertEquals(dude.getResponse("deadline abc /by abc"), 
"Dude, you need to input a valid date in yyyy-mm-dd format, dude!");

	assertEquals(dude.getResponse("todo"), 
"Dude! The todo command can't have an empty description, dude!");

	assertEquals(dude.getResponse("mark 0"), 
"Number must be 1 or above, dude!");
    }
}