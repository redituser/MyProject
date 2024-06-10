package Todomarket.model;

import java.util.ArrayList;

public class MyList {
	public ArrayList<Todo> todoList = new ArrayList<>();
	public ArrayList<Todo> completedList = new ArrayList<>();
	private int point;

	// 할일 목록 추가
	public void addTodo(Todo todo) {
		todoList.add(todo);

	}

	// 완료된 일 추가
	public void addCompeletedTodo(Todo todo) {
		completedList.add(todo);
		point++;

	}

	//현재 포인트 반환
	public int getPoint() {
		return point;

	}

	// 포인트 값 업데이트
	public  void setPoint(int points){
		this.point = points;
	}




}
