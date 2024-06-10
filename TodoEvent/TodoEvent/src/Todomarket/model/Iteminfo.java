package Todomarket.model;

public class Iteminfo {
    private int itemPoint;
    private String itemName;

    public Iteminfo(int itemPoint , String itemName){
        this.itemPoint = itemPoint;
        this.itemName = itemName;

    }


    public int getItemPoint() {
        return itemPoint;
    }

    public void setItemPoint(int itemPoint) {
        this.itemPoint = itemPoint;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


}
