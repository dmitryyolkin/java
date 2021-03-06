package web.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (14.05.18)
 */
@Controller
@RequestMapping(value = {"/", "/homepage"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        //return View with name 'home' - according to ViewResolver specified at ViewResolver
        //this view will be searched in webapp.WEB-INF/views
        return "home";
    }
}
