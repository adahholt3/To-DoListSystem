package todolistsystem;
/**
 * Aamna D.
 * subclass of (task) parent class
 */
import java.time.LocalDate;

public class SimpleTask extends Task {

	//Constructor for SimpleTask with the superclass attributes
	public SimpleTask(String title, String descriptions, boolean completed, LocalDate dueDate, int priority) {
		super(title, descriptions, completed, dueDate, priority);
	}

	
	//Override methods from Task class 
	@Override
	public String getTaskType() {
		return "SimpleTask"; // returns simple task string
	}

	@Override
	public String getDetails() {
		return getDescriptions(); // returns task details
	

	}
}
