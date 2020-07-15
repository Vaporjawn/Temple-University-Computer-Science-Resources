package Assignment;

import java.util.Arrays;

public class HoneyDoList 
{
	private Task[] tasks;
	
	private int numTasks;
	
	private int INITIAL_CAPACITY;

	public HoneyDoList(int INITIAL_CAPACITY) 
	{
		tasks = new Task[INITIAL_CAPACITY];
		this.numTasks = 0;
		
	}

	
	
	@Override
	public String toString() 
	{
		String allTasks = "";
		for(int i = 0; tasks.length > i; i++)
		{
			if(tasks[i] != null)
			{
				allTasks += tasks[i];
			}
		}
		return allTasks;
	}
	
	
	
	public int find(String name) 
	{
		for(int i = 0; tasks.length > i; i++) 
		{
			if(tasks[i] != null && name.equalsIgnoreCase(tasks[i].getName())) 
			{
				return i;
			}		
		}
		return -1;
	}
	
	
	
	public void addTask(Task newTask) 
	{
		for(int i = 0; tasks.length > i; i++)
		{
			if(tasks[i] == null)
			{
				tasks[i] = newTask;
				return;
			}
		}
		Task[] biggerTasks = new Task[tasks.length + 1];
			for(int a = 0; tasks.length > a; a++)
			{
				biggerTasks[a] = tasks[a];
			}
			biggerTasks[biggerTasks.length-1] = newTask;
			tasks = biggerTasks;
	}
	
	public int totalTime()
	{
		int total = 0;
		for(int i = 0; tasks.length > i; i++)
		{
			if(tasks[i] != null)
			{
				total += tasks[i].getEstMinsToComplete();
			}
		}
		return total;
	}
	
	public int shortestTime()
	{
		int shortest = 0;
		for(int i = 1; tasks.length > i; i++)
		{
				if(tasks[i] != null && tasks[shortest].getEstMinsToComplete() > tasks[i].getEstMinsToComplete())
				{
					shortest = i;
				}
				
		}
		return shortest;
	}
	
	public Task completeTask(int index)
	{
		if(index > tasks.length)
		{
			return null;
		}
		Task out = tasks[index];
		tasks[index] = null;	
		return out;
	}
	
}