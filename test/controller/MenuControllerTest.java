package controller;


import model.Menu;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.spy;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;



public class MenuControllerTest  {


    @InjectMocks
    MenuController menuController;

    Map<String, Object> modelMap;

    @Mock
    Menu KololoCourts;
    @Mock
    Menu menuType;
    @Mock
    Menu menuType1;
    @Mock
    Menu menuType2;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        menuController = new MenuController();
    }
    @Test
    public void can_render_to_the_menu_view(){
        MenuController menuController = new MenuController();
        modelMap = new HashMap<String, Object>();
        String viewName = menuController.renderMenu(modelMap);
        System.out.print(modelMap.values());

        assertThat((Menu)modelMap.get("MyRestaurant"),is(KololoCourts));
        assertThat(viewName,is("PandaSpark"));
    }

    @Test
    public  void gives_back_xml_response_for_a_given_menu(){

        String expectedResponse = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+"<menu><content>renderMenu</content></menu>";



        String actualResponse = menuController.xmlMenu();
        assertThat(actualResponse, is(expectedResponse));
    }

     @Test

    public void displays_menu_item()
     {
        menuController = new MenuController();
        ModelMap model=new ModelMap();

        String expectedView ="PandaSpark";
        String actualView = menuController.renderMenuItem(model);

         assertThat(actualView,is(expectedView));
     }

    @Test
    public void render_to_an_image() throws IOException {
        MenuController spyMenuController = spy(menuController);
        byte[] expectedBytes = "Picture".getBytes();
        String picturePath = "WEB-INF/pages/images/pandaim7.jpg";

        Mockito.doReturn(expectedBytes).when(spyMenuController).getPicture(picturePath);

        assertThat(spyMenuController.renderPicture("pandaim7"),is(expectedBytes));
    }

}

