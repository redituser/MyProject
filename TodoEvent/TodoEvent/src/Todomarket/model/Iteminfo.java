package Todomarket.model;

public class Iteminfo {
    private int itemPoint;
    private String itemName;
    private int itemStock;



    public Iteminfo(int itemPoint , String itemName , int itemStock){
        this.itemPoint = itemPoint;
        this.itemName = itemName;
        this.itemStock =  itemStock;

    }


    public int getItemPoint() {

        return itemPoint;
    }

    public void setItemPoint(int itemPoint) {

        this.itemPoint = itemPoint;
    }

    public String getItemName(){

        return itemName;

    }

    public void setItemName(String itemName) {

        this.itemName = itemName;
    }

    public int getItemStock() {

        return itemStock;

    }

    public void setItemStock(int itemStock) {

        this.itemStock = itemStock;

    }

    public String toString(){
        return "포인트:" + itemPoint +","+ "제품"  + itemName + "," + " 현재 남은 제품 "+ itemStock + "개";
    }

}
