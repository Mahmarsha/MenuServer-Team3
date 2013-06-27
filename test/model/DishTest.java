package model;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;


public class DishTest {

    @Test

    public void should_display_dish_name()
    {

        Dish dish = new Dish("Sushi");

        String dishName = dish.toString();

        assertThat(dishName,is("Sushi"));
    }

    @Test

    public void should_display_dish_name_price_picturePath()
    {
        Dish dish = new Dish("Sushi", "100000");

        String menuItem = dish.addMenuItem();

        assertThat(menuItem,is("Sushi" + "100000"));
    }


}
