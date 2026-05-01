package todolistsystem;
/**
 * Aamna D.
 */

import java.time.LocalDate;

public class PriorityTask extends Task implements Prioritizable {

	public PriorityTask(String title, String descriptions, boolean completed, LocalDate dueDate, int priority) {
		super(title,descriptions,completed,dueDate,priority);
	}
	
	/**
	 * Implemented methods from the Prioritizable interface
	 */
	@Override
	public void setPriority (int priority) {
		
		if (priority == 1) {
			System.out.println("High Priority Task : Get Done!");
		}else if (priority == 2) {
			System.out.println("Medium Priority Task : Focus on after completion of High Priority Task!");
		}else if (priority == 3) {
			System.out.println("Low Priority Task : Spend some time later!");
		} else {
			System.out.println("Invaild : Not on Priority Scale");
		}
	}

	@Override
	public int getPriority() {
		return super.getPriority();
	}

	// Implemented from the Tasks parent class
	@Override
	String getTaskType() {
		return "PriorityTask"; // Return PriorityTask
	}

	@Override
	String getDetails() {
		return getDescriptions() + " (Priority: " + getPriority() + ")"; // prints details and priority
	}

}
