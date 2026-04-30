package todolist;
/**
 * Aamna D.
 */
import java.util.Iterator;

public class TaskManager {
	
	MyArrayList<String>tasks;
	
	public TaskManager() {
		this.tasks = new MyArrayList<>();
	}
	// Create methods for adding,removing etc.
	 
	public void addtask (String task) {
		
		tasks.add(task);
		
	}
	 public void remove(String task) {
		 tasks.remove(task);
		 
	 }
	 
	 public void taskFinished(String task, boolean status) {
		 // could isCompleted be used?
		 if (tasks.contains(task)) { // If the task is in the arraylist
			 if (status == true) {
				 tasks.remove(task);
				 System.out.println("Completed");
			 } else {
				 System.out.println("Still need to complete");
			 }
		 }
	 }
	public void displayTask(String task) {
		// Use iterator here
		Iterator<String>it = tasks.iterator();
		
		while(it.hasNext()==true)
			System.out.println(it.next());
	}
	
	public void filter() { // completion status, task type, priority
		
	}
	

 }

