package web.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.spittr.web.dto.Spitter;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;


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
    public String processRegister(
            @RequestPart(value = "profilePicture", required = false) Part profilePicture, // byte[] can be used instead of Part
            @Valid Spitter spitter,
            Errors errors, // it's important that Errors object was put after ab object validated by Error

            RedirectAttributes model
    ) {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        try {
            //upload picture
            spittleRepository.uploadSpitterAvatar(profilePicture);

            //save object in repo
            spittleRepository.save(spitter);

            // model registration is alternative for String concatination in redirect
            model.addAttribute("username", spitter.getUserName());
            model.addAttribute("spitterId", spitter.getId());

            // flash attributes survives after redirect
            // they put into a session before redirect
            // and restored from the session to a model after redirect
            // If we don't put spitter in Flash attr then by default it can not be converted to query string
            model.addFlashAttribute("spitter", spitter);

            // as long as mapping to spitterId is absent it will be added as query param
            // smth like /spitter/{username}?spitterId={spitterId}
            return "redirect:/spitter/{username}";
        } catch (IOException e) {
            model.addAttribute("error", e.getMessage());
            return "registerForm";
        }
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String spitter(
            @PathVariable("username") String username,
            Model model) {
        Spitter spitter;
        if (!model.containsAttribute("spitter")) {
            spitter = spittleRepository.findByUsername(username);
            model.addAttribute("spitter", spitter);
        }
        return "profile";
    }
}
