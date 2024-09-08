package Todomarket.controller;

import Todomarket.model.*;
import Todomarket.view.ConsoleView;

import java.util.Scanner;

public class TodoController {

	MyList list;
	ConsoleView view;
	MarketList mlist;
	User user;

	String[] menuList = { "0. 종료", "1. 본인 정보 입력", "2. 해야 할 일 입력", "3. 해야 할일 보기", "4. 할일 완료 체크", "5. 완료한 일들 보기/삭제",
			"6. 현재 포인트 확인 하기", "7. 포인트 상점","8.관리자모드 "

	};

	public TodoController(MyList list, ConsoleView view, MarketList mlist, User user) {
		this.list = list;
		this.view = view;
		this.mlist = mlist;
		this.user = user;
	}

	public void start() {
		welecome();

		int menu;

		do {
			menu = view.selectMenu(menuList);

			switch (menu) {
				case 1 -> userinfo();
				case 2 -> addtodoList();
				case 3 -> showtodoList();
				case 4 -> completeTodo();
				case 5 -> displaycompletetodolist();
				case 6 -> countPoint(); // 현재 포인트
				case 7 -> SelectItem();
				case 8 -> adminMode();
				case 0 -> exit();
			}

		} while (menu != 0);

	}

	// 관리자 모드 메서드
	private void adminMode() {
		if (view.adminLogin()) {
			boolean exit = false;
			while (!exit) {
				int adminMenu = view.selectAdminMenu();
				switch (adminMenu) {
					case 1 -> {
						addItem();
						break;
					}
					case 2 -> {
						updateItem();
						break;
					}
					case 3 -> {
						deleteItem();
						break;
					}
					case 4 -> exit = true;
					default -> System.out.println("잘못된 선택입니다.");
				}
			}
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}

	private void addItem() {
		String name = view.inputItemName();
		int stock = view.inputItemStock();
		int price = view.inputItemPrice();
		mlist.addmarketList(new Iteminfo(price, name, stock));
		System.out.println(name + " 아이템이 추가되었습니다.");
	}

	//아이템 수정
	private void updateItem() {
		int index = view.inputItemIndex();//인덱스를 뷰에서 입력받고
		if (index >= 0 && index < mlist.marketList.size()) {
			String name = view.inputItemName();
			int stock = view.inputItemStock();
			int price = view.inputItemPrice();
			Iteminfo item = mlist.marketList.get(index);
			item.setItemName(name);
			item.setItemStock(stock);
			item.setItemPoint(price);
			System.out.println("아이템이 수정되었습니다.");
		} else {
			System.out.println("잘못된 인덱스입니다.");
		}
	}


	// 아이템 삭제 메서드
	private void deleteItem() {
		// 현재 아이템 리스트를 보여줌
		view.displayItemList(mlist);

		// 삭제할 아이템의 인덱스
		int index = view.inputItemIndex();

		// 인덱스 검사
		if (index >= 0 && index < mlist.marketList.size()) {
			Iteminfo removedItem = mlist.marketList.remove(index);
			System.out.println(removedItem.getItemName() + " 아이템이 삭제되었습니다.");
		} else {
			System.out.println("잘못된 인덱스입니다.");
		}
	}

	//유저 정보 입력
	private void userinfo(){
		String phonenumber = view.phonenumber();
		String username = view.username();
		user.setName(username); //유저 객체에 주소 정보 저장
		user.setPhonenumber(phonenumber);//유저 객체에 폰번호 저장
		System.out.println("유저 정보가 업데이트되었습니다");
	}

	// 할일 목록
	private void showtodoList() {
		view.displayTodoInfo(list);

	}
	// 할일 추가
	private void addtodoList() {
		String todo = view.inputTodo();
		int day = view.inputDay();
		list.addTodo(new Todo(day, todo));
	}
	//  할일 완료
	private void completeTodo() {
		int indexOfcompeletedTodo = view.CompletedTodo(list);
		Todo index = list.todoList.remove(indexOfcompeletedTodo);
		list.addCompeletedTodo(index);

	}
	// 할일 완료 목록
	private void displaycompletetodolist() {
		int selectIndex = view.DisplayCompleteTodoList(list);
		for (int i = 0; i < list.completedList.size(); i++) {
			if (selectIndex >= 0 && selectIndex < list.completedList.size()) {
				list.completedList.remove(selectIndex);
				System.out.println("선택한 항목이 삭제되었습니다");
			} else {
				System.out.println("잘못된 번호입니다");
			}
		}

	}

	// 현재 포인트가 몇개인지 확인 (하지만 배열에서 완료된 일을 삭제할 경우 그대로 포인트도 읽기 때문에 수정해야함)
	private void countPoint() {
		view.CountPoint(list);
	}

	private void SelectItem() {

		int select = view.itemInfo(mlist);
		Iteminfo selectedItem = mlist.marketList.get(select); // 아이템 선택
		int itemPoint = selectedItem.getItemPoint(); // 상품이 얼마인지 받아오기

		System.out.println("");
		if (list.getPoint() < itemPoint) {
			System.out.println("포인트가 부족합니다");
		} else {
			System.out.println("[" + select + "]번째 " + "아이템을 구매했습니다.");
			int remain = list.getPoint() - itemPoint;
			list.setPoint(remain); // setPoint 로 point값 업데이트
			System.out.println("현재" + "포인트는" + remain + "개 남았습니다.");

			// 배송지 입력받기
			Scanner sc = new Scanner(System.in);
			System.out.println("배송지를 입력해주세요");
			String address = sc.nextLine();
			System.out.println("배송지: " + address + "로 배송됩니다.");
		}

	}


	private void welecome() {
		view.displayWelcome();

	}

	private int exit(){
		System.out.println("프로그램을 종료합니다");
		return 0;
	}

}
