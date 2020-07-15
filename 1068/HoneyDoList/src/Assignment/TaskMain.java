package Assignment;

public class TaskMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task doMyHW = new Task("finish 1068 homework", 3, 120);
		System.out.println(doMyHW);
		System.out.println(doMyHW.getName());
		System.out.println(doMyHW.getPriority());
		System.out.println(doMyHW.getEstMinsToComplete());
		doMyHW.setName("finish discrete math");
		System.out.println(doMyHW.getName());
	}

}
