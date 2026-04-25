package todolistsystem;

import java.util.Scanner;

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
	System.out.println("Enter title: ");
	String title = input.nextLine();
	
	System.out.println("Enter Description: ");
	String desc = input.nextLine();
	
	Task task = new SimpleTask(title, desc);
	
	manager.addTask(task);

	undoStack.push(new UndoAction("add", task, manager.size()-1));
	
	System.out.println("Task added!");
	
}
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		TaskManager manager = new TaskManager();
		UndoStack undoStack = new UndoStack();
		TaskQuque queue = new TaskQueue();
		
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
					addTaskMenu(input, manager, undoStack);
					break;
				case 2:
					manager.displayAllTasks();
					break;
				case 3:
					System.out.println("Complete Task Selected.");
					break;
				case 4:
					System.out.println("Remove Task Selected.");
					break;
				case 5:
					System.out.println("Undo Selected.");
					break;
				case 6:
					System.out.println("Load Queue Selected.");
					break;
				case 7:
					queue.displayQueue();
					break;
				case 8:
					System.out.println("Process Next Selected.");
					break;
				case 9:
					System.out.println("Filter Selected.");
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
