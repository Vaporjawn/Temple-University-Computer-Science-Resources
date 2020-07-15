package Assignment;

public class HoneyDoMain {

	public static void main(String[] args) {
		HoneyDoList honeydo = new HoneyDoList(2);
		System.out.println(honeydo);
		System.out.println(honeydo.find("Hello"));
		honeydo.addTask(new Task("Hello", 2, 500));
		System.out.println(honeydo);
		System.out.println(honeydo.find("Hello"));
		System.out.println(honeydo.totalTime());
		honeydo.addTask(new Task("High Five", 4, 100));
		honeydo.addTask(new Task("Goodbye", 3, 50));
		honeydo.addTask(new Task("Low Five", 5, 10));
		System.out.println(honeydo.totalTime());
		System.out.println(honeydo);
		System.out.println(honeydo.shortestTime());
		System.out.println(honeydo.completeTask(1));
		System.out.println(honeydo);
		System.out.println(honeydo.completeTask(6));

	}
	
}
