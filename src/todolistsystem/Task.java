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
	
	
	 
	 /**
	  * public void markComplete(){
	  * 	completed = true;
	  * }
	  * 
	  * public void setCompleted(boolean completed){
	  * this.completed=completed;
	  * }
	  * 
	  * 
	  */
	// Concrete methods
	 public void markComplete(String task) { // String task - does this this take in a task 
		System.out.println("Task : " + completed); // is boolean field
		 
	 } 
	
	public String toString() {
		return getDescriptions(); //either descriptions or title because of string data type
	 }
	
	 // abstract methods
	 
	 abstract String getTaskType();
	 
	 abstract String getDetails();

}
