package dude.storage;

import dude.task.Task;
import dude.task.Todo;
import dude.task.Deadline;
import dude.task.Event;

import java.io.*;
import java.util.*;

public class Storage {

    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /*
	Returns a newly created TaskList from the saved data 
	in the file specified int this.filePath
    */

    public List<Task> load() throws FileNotFoundException {
        List<Task> tasks = new ArrayList<>();
        File file = new File(this.filePath);

        if (!file.exists()) {
            return tasks;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split("/");

                switch (data[0]) {
                    case "T":
                        Todo t = new Todo(data[2]);
                        if (data[1].equals("X")) {
			    t.markDone();
			}
                        tasks.add(t);
                        break;

                    case "D":
                        Deadline d = new Deadline(data[2], data[3]);
                        if (data[1].equals("X")) {
			    d.markDone();
			}
                        tasks.add(d);
                        break;

                    case "E":
                        Event e = new Event(data[2], data[3], data[4]);
                        if (data[1].equals("X")) {
			    e.markDone();
			}
                        tasks.add(e);
                        break;

                    default:
                        System.out.println("Save file corrupted dude, creating new blank save");
                }
            }
        } catch (FileNotFoundException e) {
            return tasks;
        }

        return tasks;
    }

    /*
	Takes the TaskList and saves it into the file specified in this.filePath
    */

    public void save(List<Task> tasks) throws IOException {
        String s = "";

        for (Task task : tasks) {
            s += task.getSaveData();
	    s += "\n";
        }

        try {
	    FileWriter fw = new FileWriter(filePath);
            fw.write(s);
	    fw.close();
        } catch (IOException e) {
	    System.out.println("Error saving data");
	}
    }
}
