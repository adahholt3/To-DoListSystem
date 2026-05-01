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
		
		/**
		 * 
		 * I fixed the filter methods because they were throwing errors,this is ur original code if u wanna delete
		 */
//		// loop thorough tasks and use getTaskType method
//		for (int i =0; i<tasks.size(); i++) {
//			Task t = tasks.get(i);
//			if (t.getTaskType().equals("SimpleTask")) {
//				System.out.println("Task Type : Simple");
//			} else if (t.getTaskType().equals("PriorityTask")) {
//				System.out.println("Task Type : Priority");
//			} else if (t.getTaskType().equals("RecurringTask")) {
//				System.out.println("Task Type : Recurring");
//			}	
//		}
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
		
//		
	//for (int i =0; i < tasks.size(); i++) {
//			Task t = tasks.get(i);
//			if (t.getPriority() == 1) {
//				System.out.println("High");
//			} else if (t.getPriority() == 2) {
//				System.out.println("Medium");
//			} else if (t.getPriority()==3) {
//				System.out.println("Low");
//				
//			}
//		}
//	}

}

