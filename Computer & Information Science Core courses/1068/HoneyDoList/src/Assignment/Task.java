package Assignment;
public class Task {	
	private String name;
	
	private int priority;
	
	private int estMinsToComplete;

	public Task(String name, int priority, int estMinsToComplete) {
		this.name = name;
		this.priority = priority;
		this.estMinsToComplete = estMinsToComplete;
	}

	@Override
	public String toString() {
		return "Task [Name: " + name + ", Priority: " + priority + ", EstimatedMins: " + estMinsToComplete
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public int getPriority() {
		return priority;
	}

	public int getEstMinsToComplete() {
		return estMinsToComplete;
	}

	public void setEstMinsToComplete(int newEstMinsToComplete) {
		this.estMinsToComplete = newEstMinsToComplete;
	}

	public int increasePriority(int amount) {
		if(amount < 0) {
			return this.priority;
		}
		else {
			this.priority = priority + amount;
			return this.priority;
		}
	}
	
	public int decreasePriority(int amount) {
		if(amount > this.priority) {
			return 0;
		}
		else {
			this.priority = priority - amount;
			return this.priority;
		}
	}
	
}

