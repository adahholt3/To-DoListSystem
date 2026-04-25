package todolistsystem;

public class UndoAction {
	
	private String actionType;
	private Task task;
	private int index;
	
	public UndoAction(String actionType, Task task, int index)
	{
		this.actionType = actionType;
		this.task = task;
		this.index=index;
	}
	
	public String getActionType()
	{
		return actionType;
	}
	
	public Task getTask()
	{
		return task;
	}
	
	public int getIndex()

	{
		return index;
	}
}
