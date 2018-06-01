package web.spittr.web;

import org.springframework.lang.Nullable;
import web.spittr.web.dto.Spitter;
import web.spittr.web.dto.Spittle;

import java.util.List;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (15.05.18)
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
    @Nullable
    Spittle findOne(long id);

    Spitter save(Spitter spitter);
    Spittle save(Spittle spitter);
    Spitter findByUsername(String username);
}
