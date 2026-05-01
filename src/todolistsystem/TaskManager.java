package todolistsystem;
/**
 * Aamna D.
 */

public class TaskManager {
	
	private MyArrayList<Task> tasks; // Setting MyArrayList for tasks
	
	public TaskManager() { // Constructor
		tasks = new MyArrayList<>();
	}
	/**
	*Create methods for adding,removing getting tasks, size of the tasks Myarraylist
	*/ 
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
	/**
	* marking a task ad completed based on index 
	*/ 
 	public void markTaskComplete(int index) {
		 Task task = tasks.get(index);
		 task.markComplete();
	 }

	/**
	* displays (prints) all the tasks, and if there's no tasks a messege is displayed
	*/ 
	public void displayAllTasks() {
		 if (tasks.size() == 0) {
			 System.out.println("End of tasks, no tasks avalible");
		 return;
	}
		 for (int i =0; i < tasks.size();i++) 
			 System.out.println(i + ": " + tasks.get(i));
		 
	 }

	
	/**
	* filter by task completions status by looping through the tasks
	* prints tasks that are completed 
	*/ 
	public void filterByCompletion(boolean completed) { 
		for (int i =0; i < tasks.size(); i++) {
			Task t = tasks.get(i);
			if (t.isCompleted() == completed) {
				System.out.println(i + ": " + t);
			}
		}
	}
	
	//Fileter by task type (simple, priority, recurring)
	public void filterByType(String type) {
		
		for(int i =0; i< tasks.size(); i++)
		{
			Task t = tasks.get(i);
			
			if(t.getTaskType().equalsIgnoreCase(type))
			{
				System.out.println(i + ": " + t);
			}
		}
		
	}
	
	//Filters by priority which only works for priority tasks
	public void filterByPriority(int priority) {
		
		for(int i =0; i<tasks.size(); i++) {
			Task t = tasks.get(i);
		
		
		if(t instanceof PriorityTask)
		{
			if(t.getPriority()==priority)
			{
				System.out.println(i + ": " + t);
			}
		}
	}
}
		


