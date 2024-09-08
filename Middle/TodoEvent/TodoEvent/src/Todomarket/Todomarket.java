package Todomarket;

import Todomarket.controller.TodoController;
import Todomarket.model.Iteminfo;
import Todomarket.model.MarketList;
import Todomarket.model.MyList;
import Todomarket.model.User;
import Todomarket.view.ConsoleView;

public class Todomarket {

	public static void main(String[] args) {

		// model 생성
		MyList list = new MyList();

		//user 정보 생성
		User user = new User(" ",0,"");



		// 임의 물품 설정
		Iteminfo iteminfo1 = new Iteminfo(1, "노트", 10);
		Iteminfo iteminfo2 = new Iteminfo(2, "텀블러", 10);
		Iteminfo iteminfo3 = new Iteminfo(3, "키보드" , 10);

		// 미리 지정한 값을 넣기위해 인스턴스 호출
		MarketList marketList = new MarketList();
		marketList.addmarketList(iteminfo1);
		marketList.addmarketList(iteminfo2);
		marketList.addmarketList(iteminfo3);

		// view 생성
		ConsoleView view = new ConsoleView();

		// controller 생성(model, view)ß
		TodoController controller = new TodoController(list,view,marketList,user);
		controller.start();

	}

}
