package todolistsystem;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *  Adah Holt
 *  
 *  Menu style inerface where users can interact with the system
 *  
 *  it runs in a loop until the user chooses to exit.
 *  Input validation is used to prevent crashes and to make sure the program continues to run even with invalid input
 */
public class Main {

	/*
	 * Prints the menu for users
	 */
    public static void printMenu() {
        System.out.println("\n++++++ TO DO LIST ++++++++");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Complete Task");
        System.out.println("4. Remove Task");
        System.out.println("5. Undo Last Action");
        System.out.println("6. Load Today's Tasks");
        System.out.println("7. View Task Queue");
        System.out.println("8. Process Next Task");
        System.out.println("9. Filter Tasks");
        System.out.println("10. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Allows the user to select a task type and enter all required fields for it.
     * 
     * The created task is added to the TaskManager and recorded in the UndoStacl so it can be undone later.
     * @param input Scanner for user input
     * @param manager manages the list of tasks
     * @param undoStack stores actions for undo
     */
    public static void addTaskMenu(Scanner input, TaskManager manager, UndoStack undoStack) {

        System.out.println("Choose task type:");
        System.out.println("1. Simple Task");
        System.out.println("2. Priority Task");
        System.out.println("3. Recurring Task");

        int type;
        try {
            type = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input.");
            return;
        }

        System.out.println("Enter title:");
        String title = input.nextLine();

        System.out.println("Enter description:");
        String description = input.nextLine();

       
        LocalDate date = null;
        while (date == null) {
            System.out.print("Due date (YYYY-MM-DD): ");
            String inputDate = input.nextLine().trim();

            if (inputDate.isEmpty()) {
                System.out.println("Input cannot be empty.");
                continue;
            }

            try {
                date = LocalDate.parse(inputDate);
            } catch (Exception e) {
                System.out.println("Invalid format. Try again.");
            }
        }

        Task task = null;

        if (type == 1) {

            task = new SimpleTask(title, description, false, date, 0);

        } else if (type == 2) {

            System.out.println("Priority (1-3):");

            int priority;
            try {
                priority = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid priority.");
                return;
            }

            task = new PriorityTask(title, description, false, date, priority);

        } else if (type == 3) {

            System.out.println("Enter recurrence pattern:");
            String pattern = input.nextLine();

            task = new RecurringTask(title, description, false, date, 0, pattern);

        } else {
            System.out.println("Invalid task type.");
            return;
        }

        manager.addTask(task);
        undoStack.push(new UndoAction("add", task, manager.size() - 1));

        System.out.println("Task added successfully.");
    }

   /**
    * Marks a selected task as complete
    * 
    * Displays all tasks, allows the user to choose an index
    *  and updates the tasks completion status
    *  The action is recorded in the UndoStack for reversal
    * @param input Scanner for user input
    * @param manager manages tasks
    * @param undoStack stores undoActions
    */
    public static void completeTaskMenu(Scanner input, TaskManager manager, UndoStack undoStack) {

        manager.displayAllTasks();

        System.out.print("Enter task index to complete: ");

        int index;
        try {
            index = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input.");
            return;
        }

        if (index >= 0 && index < manager.size()) {
            Task task = manager.getTask(index);
            undoStack.push(new UndoAction("complete", task, index));
            task.markComplete();
            System.out.println("Task completed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    /**
     * Removes task from the list
     * 
     * Displays all tasks and allows the user to select by index. 
     * The removed task is stored in the UndoStack so it can be restored
     * @param input Scanner for user inut
     * @param manager manages tasks
     * @param undoStack stores undo action
     */
    public static void removeTaskMenu(Scanner input, TaskManager manager, UndoStack undoStack) {

        manager.displayAllTasks();

        System.out.print("Enter task index to remove: ");

        int index;
        try {
            index = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input.");
            return;
        }

        if (index >= 0 && index < manager.size()) {
            Task task = manager.getTask(index);
            undoStack.push(new UndoAction("remove", task, index));
            manager.removeTask(index);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

   /**
    * Reverses the most recent actionperformed by the user
    * 
    * Uses the UndoStack to retrive the last action and performs the opposite operation.
    * 
    * @param manager manages tasks
    * @param undoStack stores undo actions
    */
    public static void undoLastAction(TaskManager manager, UndoStack undoStack) {

        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        UndoAction action = undoStack.pop();

        if (action.getActionType().equals("add")) {
            manager.removeTask(action.getIndex());

        } else if (action.getActionType().equals("remove")) {
            manager.addTask(action.getTask());

        } else if (action.getActionType().equals("complete")) {
            action.getTask().setCompleted(false);
        }

        System.out.println("Undo successful.");
    }

    /**
     * Loads recurring tasks into the queue
     * 
     * clears the current queue and adds all RecurringTask objects from the main task list. 
     * This is what perpares the tasks for processing
     * @param manager manages tasks
     * @param queue queue used for processing tasks
     */
    public static void loadTodayTasks(TaskManager manager, TaskQueue queue) {

        queue.clear();

        for (int i = 0; i < manager.size(); i++) {
            Task task = manager.getTask(i);

            if (task instanceof RecurringTask) {
                queue.add(task);
            }
        }

        System.out.println("Today's tasks loaded into queue.");
    }

    /**
     * Processes the next task in the queue.
     * 
     * Removes the first task and displays it to user.
     * The user can choose to mark it as complete
     * @param input scanner for user input
     * @param queue queue of tasks to process
     */
    public static void processNextTask(Scanner input, TaskQueue queue) {

        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Task task = queue.processNext();

        System.out.println("Processing task:");
        System.out.println(task);

        System.out.print("Mark complete? (yes/no): ");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            task.markComplete();
            System.out.println("Task completed.");
        }
    }


    /**
     * Provides options to filter tasks
     * 
     * It allows filtering by completion status, task type, and priority level
     * 
     * Calls methods in TaskManager to display results
     * @param input Scanner for user input
     * @param managermanages tasks
     */
    public static void filterMenu(Scanner input, TaskManager manager) {

        System.out.println("\nFilter Options:");
        System.out.println("1. Completed Tasks");
        System.out.println("2. Incomplete Tasks");
        System.out.println("3. Simple Tasks");
        System.out.println("4. Priority Tasks");
        System.out.println("5. Recurring Tasks");
        System.out.println("6. Priority Level (1-3)");

        int choice;
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input.");
            return;
        }

        switch (choice) {
            case 1:
                manager.filterByCompletion(true);
                break;
            case 2:
                manager.filterByCompletion(false);
                break;
            case 3:
                manager.filterByType("SimpleTask");
                break;
            case 4:
                manager.filterByType("PriorityTask");
                break;
            case 5:
                manager.filterByType("RecurringTask");
                break;
            case 6:
                System.out.print("Enter priority (1-3): ");
                int p = Integer.parseInt(input.nextLine());
                manager.filterByPriority(p);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

   /**
    * Where users interact with program
    * 
    * Runs a loop that continuously displays the menu and processes user input
    * until the user chooses to exit
    * 
    * uses the try/catch and input vaidation to prevent crashes
    * because that was a problem I had to fix 
    * @param args
    */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TaskManager manager = new TaskManager();
        UndoStack undoStack = new UndoStack();
        TaskQueue queue = new TaskQueue();

        boolean running = true;

        while (running) {

            printMenu();

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:
                    addTaskMenu(input, manager, undoStack);
                    break;

                case 2:
                    manager.displayAllTasks();
                    break;

                case 3:
                    completeTaskMenu(input, manager, undoStack);
                    break;

                case 4:
                    removeTaskMenu(input, manager, undoStack);
                    break;

                case 5:
                    undoLastAction(manager, undoStack);
                    break;

                case 6:
                    loadTodayTasks(manager, queue);
                    break;

                case 7:
                    queue.displayQueue();
                    break;

                case 8:
                    processNextTask(input, queue);
                    break;

                case 9:
                    filterMenu(input, manager);
                    break;

                case 10:
                    running = false;
                    System.out.println("Bye Bye :3");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        input.close();
    }
}