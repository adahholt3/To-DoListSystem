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
	 
	public void addTask (Task task) {
		
		tasks.add(task);
		
	}
	 public void removeTask(int index) {
		 tasks.remove(index);
		 
	 }
	 
	 public Task getTask(int index)

	 {
		 return tasks.get(index);
	 }
	 
	 public int size() {
		 return tasks.size();
	 }
	 
 	public void markTaskComplete(int index) {
		 Task task = tasks.get(index);
		 task.markComplete();
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
	 
	public void displayAllTask() {
		 if (tasks.size() == 0) 
			 System.out.println("End of tasks, no tasks avalible");
		 for (int i =0; i < tasks.size();i++) 
			 System.out.println(i + ": " + tasks.get(i));
		 
	 }
	
	 // public void displayAllTasks(Task task) {		IDK, if you want to keep this?
		// 	// Use iterator here
		// 	Iterator<Task>it = tasks.iterator();
			
		// 	while(it.hasNext()==true)
		// 		System.out.println(it.next());
		// 	if (it.hasNext() == false) {
		// 		System.out.println("End of Tasks");
		// 	}
		// }
	 
	
	
	//filter by completion status
	public void filterByCompletion(boolean completed) { // completion status, task type, priority
		for (int i =0; i < tasks.size(); i++) {
			Task t = tasks.get(i);
			if (t.isCompleted() == completed) {
				System.out.println(i + ": " + t);
			}
		}
	}
	
	//Fileter by task type (simple, priority, recurring)
	public void filterBytype(Task task) {
		// loop thorough tasks and use getTaskType method
		for (int i =0; i<tasks.size(); i++) {
			Task t = tasks.get(i);
			if (t.getTaskType().equals("SimpleTask")) {
				System.out.println("Task Type : Simple");
			} else if (t.getTaskType().equals("PriorityTask")) {
				System.out.println("Task Type : Priority");
			} else if (t.getTaskType().equals("RecurringTask")) {
				System.out.println("Task Type : Recurring");
			}	
		}
	}
	
	//Fileter by priority which only works for priotiry tasks
	public void filterBypriority(Task task) {
		
		for (int i =0; i < tasks.size(); i++) {
			Task t = tasks.get(i);
			if (t.getPriority() == 1) {
				System.out.println("High");
			} else if (t.getPriority() == 2) {
				System.out.println("Medium");
			} else if (t.getPriority()==3) {
				System.out.println("Low");
				
			}
		}
	}

 }

