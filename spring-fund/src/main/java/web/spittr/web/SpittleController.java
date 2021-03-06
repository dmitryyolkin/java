package web.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.spittr.web.dto.Spittle;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (15.05.18)
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    // запрос через Quesry парметер вида
    // "/spittles?max=132&count=50"

    // Общее правило - не рекомендуется использовать query параметры, когда
    // мы обращаемся к ресурсу (лучше в этом случае использовать Path параметры)
    @RequestMapping(method = RequestMethod.GET)
    public String spittles(
            @RequestParam(value = "max", defaultValue = "1000000000000000") long max,
            @RequestParam(value = "count", defaultValue = "20") int count,
            Model model) {
        model.addAttribute(
                "spittleList",
                spittleRepository.findSpittles(max, count)
        );
        return "spittles";
    }

    // запрос через Path парметер вида
    // "/spittles/132"

    @RequestMapping(
            value = "/{spittleId}",
            method = RequestMethod.GET
    )
    public String findSpittle(
            @PathVariable("spittleId") long spittleId,
            Model model
    ) {
        model.addAttribute(
                "spittle",
                spittleRepository.findOne(spittleId)
        );
        return "spittle";
    }

}
