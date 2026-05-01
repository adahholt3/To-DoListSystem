package todolistsystem;
/**
 * Adah Holt
 */
import java.util.Stack;

public class UndoStack {
	/**
	 * The undo works by if you add something and do undo, it removes it. If you remove something and do undo, it adds it back.
	 * 
	 * I use the stack because a stack is LIFO which is the easiest structure for Undo
	 */
	
	/**
	 * Stack storing all actions that can be undone
	 */
	private Stack<UndoAction> stack = new Stack<>();
	
	/**
	 * Adds an action to the undo stack
	 * @param action the action to be stored for potential undo
	 */
	public void push(UndoAction action)
	{
		stack.push(action);
	}
	
	/**
	 * Checks if there are any actions to undo
	 * @return true if stack empty but false otherwise
	 */
	public boolean isEmpty()
	{
		return stack.isEmpty();
		
	}
	
	/**
	 * Removes and returns the most recent actions
	 * 
	 * @return the last action performed to be undone
	 */
	public UndoAction pop()
	{
		return stack.pop();
	}
	

}
