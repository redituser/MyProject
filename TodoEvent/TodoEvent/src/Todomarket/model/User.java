package Todomarket.model;

public class User {
    private String address;
    private int point;

    public User(String address, int point){
        this.address = address;
        this.point = point;
    }


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
