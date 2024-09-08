package Todomarket.model;

public class User {
    private String name;
    private int point;
    private String phonenumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public User(String name, int point , String phonnumber){
        this.name = name;
        this.point = point;
        this.phonenumber = phonnumber;

    }


    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }


}
