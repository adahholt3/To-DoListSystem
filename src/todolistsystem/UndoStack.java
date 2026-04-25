package todolistsystem;

import java.util.Stack;

public class UndoStack {
	/**
	 * The undo works by if you add something and do undo, it removes it. If you remove something and do undo, it adds it back.
	 */
	private Stack<UndoAction> stack = new Stack<>();
	
	public void push(UndoAction action)
	{
		stack.push(action);
	}
	
	public boolean isEmpty()
	{
		return stack.isEmpty();
		
	}
	
	public UndoAction pop()
	{
		return stack.pop();
	}
	

}
