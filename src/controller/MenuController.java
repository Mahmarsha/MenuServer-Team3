package controller;


import model.Menu;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Controller
public class MenuController {
    @Autowired
    ServletContext servletContext;

    Menu restaurantName = new Menu("KololoCourts");

    //Menu categories ...
    Menu menuType  = new Menu("Main Course");
    Menu menuType1 = new Menu("Starter");
    Menu menuType2 = new Menu("Sweets");

    @RequestMapping(value="/", method= RequestMethod.GET)
	String renderMenu(Map<String, Object> model){
		model.put("MyRestaurant",restaurantName);
		return "PandaSpark";
	}

    @RequestMapping(value = "/mainCourse", method = RequestMethod.GET)
    public String renderMenuItem(ModelMap model) {
        model.put("menuType",menuType);
        model.addAttribute("menuItem","Fried Beef");
        model.addAttribute("price", "UGX 10000");
        return "PandaSpark";
    }

    @RequestMapping(value = "/starter", method = RequestMethod.GET)
    public String renderMenuItem1(ModelMap model) {
        model.put("menuType",menuType1);
        model.addAttribute("menuItem","Mushroom soup");
        model.addAttribute("price", "UGX 15000");
        return "PandaSpark";
    }

    @RequestMapping(value = "/sweets", method = RequestMethod.GET)
    public String renderMenuItem2(ModelMap model) {
        model.put("menuType",menuType2);
        model.addAttribute("menuItem","Ice Cream");
        model.addAttribute("price", "UGX 6000");
        return "PandaSpark";
    }

	@RequestMapping(value = "/Panda", method = RequestMethod.GET, headers={"Accept=application/xml"})

	@ResponseBody
	public String  xmlMenu(){

		return "<?xml version=\"1.0\" encoding=\"utf-8\"?>"+"<menu><content>renderMenu</content></menu>";
	}

    @RequestMapping(value = "/image/{name}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] renderPicture(@PathVariable("name") String picture) throws IOException {
        String picturePath = "WEB-INF/pages/images/"+picture+".jpg";
        return getPicture(picturePath);
    }

    public byte[] getPicture(String path) throws IOException {
        InputStream resourceAsStream;
        resourceAsStream = servletContext.getResourceAsStream(path);

        return IOUtils.toByteArray(resourceAsStream);
    }
}
