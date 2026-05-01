package todolistsystem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Adah Holt
 * 
 * Manages a queue pf tasks that are ready to be processed
 */
public class TaskQueue {
	
	/**
	 * Queue storing tasks to be processed in FIFO order
	 */
	private Queue<Task> queue = new LinkedList<>();
	
	/**
	 * Clears all tasks from the queue
	 * Used when reloading todays tasks
	 */
	public void clear()
	{
		queue.clear();
	}
	
	/**
	 * Adds task to the queue
	 * @param task the task to be added to the queue
	 */
	public void add(Task task)
	{
		//I could use offer() here
		queue.add(task);
	}
	
	/**
	 * Checks if the queeu is empty
	 * @return true if the queue has no tasks, false if otherwise
	 */
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	/**
	 * Removes and returns the nest task in the queue
	 * @return the nest task to process, or null if the queue is empty
	 */
	public Task processNext()
	{
		return queue.poll();
	}
	/**
	 * Displays all tasks currently in the queue in order
	 */
	public void displayQueue()
	{
		if(queue.isEmpty()
				) {
			System.out.println("Queue is empty. Sorry bro.");
			return;
		}
		for(Task t : queue)
		{
			System.out.println(t);
		}
	}

}
