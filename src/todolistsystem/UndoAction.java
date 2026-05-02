package todolistsystem;

/**
 * Adah Holt
 * 
 * Each undoaction object stores info about an actions so it may be reversed later
 */
public class UndoAction {
	/**
	 * 
	 */
	
	private String actionType;
	private Task task;
	private int index;
	
	
	public UndoAction(String actionType, Task task, int index)
	{
		//Type of action perfornmed
		this.actionType = actionType;
		
		//The task involved in the action
		this.task = task;
		
		//The index of the task in the list
		this.index=index;
	}
	
	/**
	 * Gets the type of action
	 * @return action type
	 */
	public String getActionType()
	{
		return actionType;
	}
	
	/**
	 * Gets task associated with the action
	 * @return task
	 */
	public Task getTask()
	{
		return task;
	}
	
	/**
	 * Gets index of task
	 * @return index of the task in the list
	 */
	public int getIndex()

	{
		return index;
	}
}
