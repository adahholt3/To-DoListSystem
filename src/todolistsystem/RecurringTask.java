package todolistsystem;

/**
 * Aamna D.
 */
import java.time.LocalDate;

public class RecurringTask extends Task implements Recurring {

	private String recurrencePattern;
	
	public RecurringTask(String title, String descriptions, boolean completed, LocalDate dueDate, int priority, String recurrencePattern) {
		
		super(title, descriptions, completed, dueDate, priority);
		this.recurrencePattern = recurrencePattern;
		
	}
	
// From recurring interface
	
	@Override
	public void setRecurrencePattern(String patterns) {
		this.recurrencePattern = patterns ;
	}

	@Override
	public String getRecurrencePattern() {
		return "This is a " + recurrencePattern + "task";
	}

// From tasks
	@Override
	public String getTaskType() {
		return "RecurringTask"; // Returns RecurringTask
	}

	@Override
	public String getDetails() {		
		return getDescriptions() + "(Repeats: "+recurrencePattern+ ")";
	}

}
