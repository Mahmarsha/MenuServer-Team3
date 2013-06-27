package model;


public class Menu {
    //Declarations
    private String restaurantName;

     //One arg constructor takes name of Restaurant
    public Menu(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    //String method
    public String toString(){
        return restaurantName;
    }


}
