package todolistsystem;
/**
 * Aamna D.
 */
import java.util.Iterator;

public class TaskManager {
	
	private MyArrayList<Task> tasks;
	
	public TaskManager() {
		tasks = new MyArrayList<>();
	}
	// Create methods for adding,removing etc.
	 
	public void addtask (Task task) {
		
		tasks.add(task);
		
	}
	 public void removeTask(int index) {
		 tasks.remove(index);
		 
	 }
	 
	 public Task getTask(int index)

	 {
		 return tasks.get(index);
	 }
	 
	 public int size()
	 {
		 return tasks.size();
	 }
	 
	 /**
	  * public void markTaskComplete(int index){
	  * 
	  * Task task = tasks.get(index);
	  * task.markComplete();
	  * }
	  * 
	  */
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
	 
	 /**
	  * public void displayAllTasks(){
	  * 
	  * 	if(tasks.size()==0){
	  * 		print "no tasks available";
	  * 		return;
	  * }
	  * 
	  * for(int i =0; i<tasks.size(); i++){
	  * print(i + ": " + tasks.get(i);
	  * 
	  */
	public void displayAllTasks(String task) {
		// Use iterator here
		Iterator<String>it = tasks.iterator();
		
		while(it.hasNext()==true)
			System.out.println(it.next());
	}
	
	
	//filter by completion status
	public void filterByCompletion(//boolean completed )
	{ // completion status, task type, priority
		/**
		 * for(int i =0; i < tasks.size(); i++){
		 * 	Task t = tasks.get(i);
		 * if(t.isCompleted()==completed){
		 * System.out.println(i+ ": " + t);
		 * }}}
		 */
		
		
	}
	
	//Fileter by task type (simple, priority, recurring)
	public void filterByType()
	{
		
	}
	
	//Fileter by priority which only works for priotiry tasks
	public void filterByPriority()
	{
		
	}
	

 }

