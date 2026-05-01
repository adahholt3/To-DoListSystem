package todolistsystem;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Main done by Adah Holt
 */
public class Main {

	public static void printMenu()
	{
		System.out.println("\n++++++ TO DO LIST ++++++++");
		System.out.println("1. Add Task");
		System.out.println("2. View All Tasks");
		System.out.println("3. Complete Task");
		System.out.println("4. Remove task");
		System.out.println("5. Undo Last Action");
		System.out.println("6. Load Today's Tasks");
		System.out.println("7. View the task Queue");
		System.out.println("8. Process Next Task");
		System.out.println("9. Filter Tasks");
		System.out.println("10. Exit");
		System.out.println("Choose an option: ");
	}
	
	public static void addTaskMenu(Scanner input, TaskManager manager, UndoStack undoStack)
{
		System.out.println("Choose task type:");
		System.out.println("1. Simple Task");
		System.out.println("2. Priority Task");
		System.out.println("3. Recurring Task");
		
		int type = input.nextInt();
		input.nextLine();
		
		System.out.println("Enter title: ");
		String title = input.nextLine();
		
		System.out.println("Enter description:");
		String description = input.nextLine();
		
		System.out.println("Due date(YYYY-MM-DD): ");
		
		//wut
		LocalDate date = LocalDate.parse(input.nextLine());
		
		Task task = null;
		
		if(type==1)
		{
			task = new SimpleTask(title, description, false, date, 0);
		}else if (type==2){
			System.out.println("Priority (1-3): ");
			int priority = input.nextInt();
			input.nextLine();
			
			task = new PriorityTask(title, description, false, date, priority);
		}else if(type==3)
		{
			System.out.println("Enter recurrence patter: ");
			String pattern = input.nextLine();
			
			//EDIT THIS
			task = new RecurringTask(title, description, false, date, 0, pattern);
		} else {
			System.out.println("Invalid task tyoe");
			return;
		}
		manager.addTask(task);
		undoStack.push(new UndoAction("add", task, manager.size()-1));
		System.out.println("task added");
	
}
	public static void completeTaskMenu(Scanner input, TaskManager manager, UndoStack undoStack)
	{
		manager.displayAllTasks();
		
		System.out.println("Enter task index to complete ");
		int index = input.nextInt();
		input.nextLine();
		
		if(index >= 0 && index < manager.size())
		{
			Task task = manager.getTask(index);
			
			undoStack.push(new UndoAction("complete", task, index));
			
			task.markComplete();
			
			System.out.println("Task completed");
		}else {
			System.out.println("Invalid index");
		}
	}
	
	public static void removeTaskMenu(Scanner input, TaskManager manager, UndoStack undoStack)
	{
		manager.displayAllTasks();
		
		System.out.println("Enter task index to remove:");
		int index = input.nextInt();
		input.nextLine();
		
		if(index>=0 && index < manager.size())
		{
			Task task = manager.getTask(index);
			undoStack.push(new UndoAction("remove", task, index));
			
			manager.removeTask(index);
			
			System.out.println("task removed");
			
		}else {
			System.out.println("Invalid index");
		}
	}

	public static void undoLastAction(TaskManager manager, UndoStack undoStack)
	{
		if(undoStack.isEmpty()) {
			System.out.println("Nothing to undo");
			return;
		}
		
		UndoAction action = undoStack.pop();
		
		if(action.getActionType().equals("add")){
			
			manager.removeTask(action.getIndex());
			System.out.println("Undo successful");
			
		}else if(action.getActionType().equals("remove"))
		{
			manager.addTask(action.getTask());
			System.out.println("Undo Successful.");
		}else if(action.getActionType().equals("complete"))
		{
			action.getTask().setCompleted(false); //requires fix
			System.out.println("Undo Successful");
		}
	}
	
	public static void loadTodayTasks(TaskManager manager, TaskQueue queue)
	{
		queue.clear();
		
		for(int i =0; i< manager.size(); i++)
		{
			Task task = manager.getTask(i);
			
			if(task instanceof RecurringTask)
			{
				queue.add(task);
			}
		}
		System.out.println("Topday's tasks loaded into queue");
	}
	
	public static void processNextTask(Scanner input, TaskQueue queue)
	{
		if(queue.isEmpty())
		{
			System.out.println("Queue is empty");
			return;
		}
		
		Task task = queue.processNext();
		
		System.out.println("Processing task");
		System.out.println(task);
		
		System.out.println("Mark complete? (yes/no):");
		String answer = input.nextLine();
		
		if(answer.equalsIgnoreCase("yes"))
		{
			task.markComplete();
			System.out.println("Task completed");
		}
	}
	
	public static void filterMenu(Scanner input, TaskManager manager)
	{
		System.out.println("Filter by:");
		System.out.println("1. Completed");
		System.out.println("2. Incomplete");
		
		
		int choice = input.nextInt();
		
		input.nextLine();
		
		boolean completed = (choice ==1);
		
		for(int i =0; i<manager.size(); i++)
		{
			Task t = manager.getTask(i);
			
			if(t.isCompleted()==completed)
			{
				System.out.println(t);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		TaskManager manager = new TaskManager();
		UndoStack undoStack = new UndoStack();
		TaskQueue queue = new TaskQueue();
		
		boolean running = true;
		
		while(running==true)
		{
			printMenu();
			
			if(input.hasNextInt()) {
				int choice = input.nextInt();
				input.nextLine();
				
				switch(choice)
				{
				case 1:
					System.out.println("Add Task Selected.");
					addTaskMenu(input, manager, undoStack);
					break;
				case 2:
					System.out.println("Display all Selected.");
					manager.displayAllTasks();
					break;
				case 3:
					System.out.println("Complete Task Selected.");
					completeTaskMenu(input, manager, undoStack);
					break;
				case 4:
					System.out.println("Remove Task Selected.");
					removeTaskMenu(input, manager, undoStack);
					break;
				case 5:
					System.out.println("Undo Selected.");
					undoLastAction(manager, undoStack);
					break;
				case 6:
					System.out.println("Load Queue Selected.");
					loadTodayTasks(manager, queue);
					break;
				case 7:
					queue.displayQueue();
					break;
				case 8:
					System.out.println("Process Next Selected.");
					processNextTask(input,queue);
					break;
				case 9:
					System.out.println("Filter Selected.");
					filterMenu(input, manager);
					break;
				case 10:
					running = false;
					System.out.println("Bye Bye :3!");
					break;
				default:
					System.out.println("Invalid!");	
				}
				
			}else {
				System.out.println("Please Enter a valid Numbe!");
				input.nextLine();
			}
		}
		input.close();
		
	}

}
