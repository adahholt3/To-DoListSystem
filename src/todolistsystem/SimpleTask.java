package todolistsystem;
/**
 * Aamna D.
 */
import java.time.LocalDate;

public class SimpleTask extends Task {

	//Constructor for SimpleTask with the superClass attributes
	public SimpleTask(String title, String descriptions, boolean completed, LocalDate dueDate, int priority) {
		super(title, descriptions, completed, dueDate, priority);
	}

	
	//Override methods from Task class 
	@Override
	public String getTaskType() {
		return "SimpleTask";
		
		// Need to be fixed should return simple
		// returns task type would probably be (recurring, simple, priority)
	}

	@Override
	public String getDetails() {
		return getDescriptions();
	

	}
}
