package controller;


import model.Menu;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

public class MenuControllerTest  {


    @InjectMocks
    MenuController menuController;
    Map<String, Object> modelMap;

    @Mock
    Menu mockMenu;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void can_render_to_the_menu_view(){
        MenuController menuController = new MenuController();
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName = menuController.renderMenu(modelMap);

        assertThat((Menu)modelMap.get("myRestaurant"),is(mockMenu));
        assertThat(viewName,is("Menu"));
    }

    @Test
    public  void gives_back_xml_response_for_a_given_menu(){

        when(mockMenu.toString()).thenReturn("menu");

        String expectedResponse = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+"<menu><content>PandaSparkRestaurant</content></menu>";



        String actualResponse = menuController.xmlMenu();
        assertThat(actualResponse, is(expectedResponse));
    }



}

