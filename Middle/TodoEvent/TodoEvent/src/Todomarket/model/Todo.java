package Todomarket.model;

public class Todo { // 목록 저장
	private int day;
	private String todo;
	private boolean selecttodo;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public boolean isSelecttodo() {
		return selecttodo;
	}

	public void setSelecttodo(boolean selecttodo) {
		this.selecttodo = selecttodo;
	}

	public void plusmethod() {
		System.out.println("기한 :" + day + "까지, " + "할일: " + todo);

	}

	public void pluscompletemethod() {
		System.out.println("[" + "기한 :" + day + ", 목록 :" + todo + "]");
	}

	public Todo(int day, String todo) {
		super();
		this.day = day;
		this.todo = todo;
	}

}
