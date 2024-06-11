package Todomarket.view;

import java.util.Scanner;

import Todomarket.model.MarketList;
import Todomarket.model.MyList;
import Todomarket.model.User;

public class ConsoleView {

	// 환영 인사 출력
	public void displayWelcome() {
		String welcome = "welcome to my TOdoList";
		System.out.println(welcome);

	}

	// 메뉴 번호 입력받기
	public int selectMenu(String[] menuList) {
		displayMenu(menuList);

		int menu;
		do {
			System.out.println("메뉴 선택 :");
			menu = readNumber();
			if (menu < 0 || menu >= menuList.length) {
				System.out.println("0 부터 " + (menuList.length - 1) + " 까지 입력바랍니다.");
			}
		} while (menu < 0 || menu >= menuList.length);
		return menu;

	}

	private int readNumber() { // 입력된텍스트가 숫자가 아니면 다시 입력받을수 있도록 함
		Scanner sc = new Scanner(System.in);
		try {
			int number = sc.nextInt();
			return number;
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요 : ");
			return readNumber();
		}

	}

	private void displayMenu(String[] menuList) {
		System.out.println("================");
		for (int i = 1; i < menuList.length; i++) {
			System.out.println(menuList[i]);
		}
		System.out.println(menuList[0]);
		System.out.println("===============");

	}

	//유저 정보 입력받기
	//이름
	public String username (){
		System.out.println("이름을 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		return name;
	}
	//폰번호
	public String phonenumber(){
		System.out.println("폰 번호 입력해주세요 : ");
		Scanner sc = new Scanner(System.in);
		String number = sc.nextLine();
		return number;
	}




	// 할 일 입력받기
	public String inputTodo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("할일 목록을 입력하세요 : ");
		String todo = sc.nextLine();
		return todo;
		// 이제 이걸 모델로 보내야하지만 중간 관리자인 컨트롤러를 거쳐야한다

		// new Todo(day,todo);

	}

	public int inputDay() {
		Scanner sc = new Scanner(System.in);
		int day = -1;
		boolean valid = false;

		while (!valid) {
			System.out.print("기한을 입력하세요: ");
			try {
				String input = sc.nextLine();
				if (input.isEmpty()) {
					throw new NumberFormatException("공백 입력은 허용되지 않습니다.");
				}
				day = Integer.parseInt(input); // 문자열을 정수로 변환
				valid = true; // 변환이 성공하면 valid를 true로 설정하여 루프를 종료
			} catch (NumberFormatException e) {
				System.out.println("유효한 숫자를 입력하세요");
			}
		}
		return day;
	}

	// 완료한 일들 체크

	public int CompletedTodo(MyList list) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < list.todoList.size(); i++) {
			System.out.print("번호" + "[" + i + "] ");
			list.todoList.get(i).plusmethod();

		}
		System.out.println(" 완료된 일의 번호를 입력하세요 :");
		int select = sc.nextInt();

		return select;

	}

	// 할일 목록 보여주기
	public void displayTodoInfo(MyList list) {
		for (int i = 0; i < list.todoList.size(); i++) {
			System.out.println("[해야할 일 :"+  list.todoList.get(i).getTodo()+ "]" + "[기한:" + list.todoList.get(i).getDay() +"까지]");
			System.out.println();
		}
	}

	// 완료한 일들 보여주기 / 삭제
	public int DisplayCompleteTodoList(MyList list) {

		Scanner sc = new Scanner(System.in);

		System.out.println("완료한 목록들");
		for (int i = 0; i < list.completedList.size(); i++) {
			System.out.print("["+ "번호 :" + i + "]");
			list.completedList.get(i).pluscompletemethod();
		}
		System.out.println("삭제할 일의 번호를 입력하세요");
		int selectindex = sc.nextInt();
		return selectindex;

	}

	// 현재 포인트 몇개인지 확인 하기
	public void CountPoint(MyList list) {
		System.out.println("현재 포인트는 :" + list.getPoint() + "개 있습니다");
	}

	// 마켓에서 상품고르기
	public int itemInfo(MarketList mlist) {

		Scanner sc = new Scanner(System.in);
		System.out.println("===================");
		System.out.println("상품 리스트");
		for (int i = 0; i < mlist.marketList.size(); i++) {
			System.out.println("[" + i + "] " + "[ " + mlist.getEls(i) + " ] ");
		}
		System.out.println("===================");

		int select = -1;
		Boolean Really = false;

		while (Really != true) {
			System.out.println("고르고 싶은 번호를 입력해주세요");
			select = sc.nextInt();
			if (select >= 0 && select < mlist.marketList.size()) {
				Really = true;

			} else {
				System.out.println("잘못된 입력입니다 다시 입력하세요");
				Really = false;
			}
		}
		return select;
	}

	//관리자 로그인
	public boolean adminLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("관리자 비밀번호를 입력하세요: ");
		String password = sc.nextLine();
		return "123".equals(password); // 간단한 비밀번호 검증
	}
	//관리자 메뉴
	public int selectAdminMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("관리자 메뉴를 선택하세요:");
		System.out.println("1. 아이템 추가");
		System.out.println("2. 아이템 수정");
		System.out.println("3. 아이템 삭제");
		System.out.println("4. 종료");
		return sc.nextInt();
	}

	//현재 아이템 리스트 (관리자)
	public void displayItemList(MarketList mlist) {
		System.out.println("현재 아이템 리스트:");
		for (int i = 0; i < mlist.marketList.size(); i++) {
			System.out.println("[" + i + "] " + mlist.marketList.get(i).toString());
		}
	}


	// 현재 아이템 인덱스 입력 (관리자)
	public int inputItemIndex() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 아이템 인덱스를 입력하세요: ");
		return sc.nextInt();
	}

	// 아이템 추가 (관리자)
	public String inputItemName(){
	  //현재 추가할 아이템 이름넣는 메서드
		Scanner sc= new Scanner(System.in);
		System.out.print("아이템 이름을 입력하세요: ");
		String ItemaName = sc.nextLine();
		return ItemaName;
	}

	//아이템 개수 설정(관리자)
	public int inputItemStock(){
		Scanner sc= new Scanner(System.in);
		System.out.print("아이템 재고 수량을 입력하세요: ");
		int ItemStock = sc.nextInt();
		return ItemStock;
	}

	//아이템 포인트 설정(관리자)
	public int inputItemPrice(){
		Scanner sc= new Scanner(System.in);
		System.out.print("아이템 가격을 입력하세요: ");
		int ItemPrice = sc.nextInt();
		return ItemPrice;
	}

	public String inputAddress(){
		Scanner sc = new Scanner(System.in);
		String address = sc.nextLine();
		return address;
	}

}
