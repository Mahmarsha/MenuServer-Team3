package model;


public class Dish {

    public String dishPrice;
    public String dishName;

    public Dish(String dishName) {
        this.dishName = dishName;
    }

    public Dish(String dishName, String dishPrice) {
        this.dishName=dishName;
        this.dishPrice=dishPrice;

    }

    @Override
    public String toString() {
        return dishName+dishPrice;
    }

    //Method returns three strings
    public String addMenuItem() {
        return dishName + dishPrice;
    }
}
