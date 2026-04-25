package todolistsystem;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
	
	private Queue<Task> queue = new LinkedList<>();
	
	public void clear()
	{
		queue.clear();
	}
	
	public void add(Task task)
	{
		//I could use offer here
		queue.add(task);
	}
	
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	public Task processNext()
	{
		return queue.poll();
	}
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
