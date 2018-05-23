package web.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.spittr.web.dto.Spitter;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (22.05.18)
 */
@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {
    private SpittleRepository spittleRepository;

    @Autowired
    public SpitterController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(Spitter spitter) {
        spittleRepository.save(spitter);

        return "redirect:/spitter/" + spitter.getUserName();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String spitter(
            @PathVariable("username") String username,
            Model model) {
        Spitter spitter = spittleRepository.findByUsername(username);
        model.addAttribute("spitter", spitter);
        return "profile";
    }
}
