package controller;


import model.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MenuController {
    Menu menu;

    @RequestMapping(value="/", method= RequestMethod.GET)
    String renderMenu(Map<String, Object> model){
        menu.put("MyRestaurant",menu);
        return "Panda Spark";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, headers={"Accept=application/xml"})

    @ResponseBody
    public String  xmlMenu(){

        return "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+"<menu><content>PandaSparkRestaurant</content></menu>";
    }

}
