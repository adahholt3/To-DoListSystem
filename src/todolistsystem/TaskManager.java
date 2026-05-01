package todolistsystem;
/**
 * Aamna D.
 */


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

	 
	public void displayAllTasks() {
		 if (tasks.size() == 0) {
			 System.out.println("End of tasks, no tasks avalible");
		 return;
	}
		 for (int i =0; i < tasks.size();i++) 
			 System.out.println(i + ": " + tasks.get(i));
		 
	 }

	
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
	
	//Fileter by priority which only works for priotiry tasks
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
		


