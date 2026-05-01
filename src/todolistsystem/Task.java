package todolistsystem;

import java.time.LocalDate;

/**
 * Aamna D.
 * Setting up the attributes
 */
public abstract class Task {
	
	private String title;
	private String descriptions;
	private boolean completed;
	private LocalDate dueDate;
	private int priority;
	
	//Constructor 
	public Task (String title, String descriptions, boolean completed, LocalDate dueDate, int priority) {
		this.title = title;
		this.descriptions = descriptions;
		this.completed = completed;
		this.dueDate = dueDate;
		this.priority = priority;
	}
	
	/**
	 * Getters for attributes
	 */
	public String getTitle() {
		return title;
	 	 }
	public String getDescriptions() {
		return descriptions;
	 	 }
	public boolean isCompleted() {
		return completed;
		 }
	 public LocalDate getDueDate() {
			return dueDate;
	 	 }
	 public int getPriority() {
			return priority;
		 }
	
	
	// Concrete methods
	 public void markComplete() { 
		completed = true; // is boolean field
	 } 
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public String toString() {
		return "[" + getTaskType() + "]" + getTitle() + " -" + getDescriptions() + "| completed: " + isCompleted();
	 }
	
	 // abstract methods
	 
	 abstract String getTaskType();
	 
	 abstract String getDetails();

}
