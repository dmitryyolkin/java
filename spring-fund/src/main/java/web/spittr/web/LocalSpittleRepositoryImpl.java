package web.spittr.web;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import web.spittr.web.dto.Spitter;
import web.spittr.web.dto.Spittle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (01.06.18)
 */
@Component
public class LocalSpittleRepositoryImpl implements SpittleRepository {
    private final List<Spitter> spitters = new ArrayList<>();
    private final List<Spittle> spittles = new ArrayList<>();

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return spittles
                .stream()
                .filter(s -> {
                    Long sId = s.getId();
                    return sId == null || sId <= max;
                })
                .limit(count)
                .collect(Collectors.toList());
    }

    @Nullable
    @Override
    public Spittle findOne(long id) {
        return spittles
                .stream()
                .filter(s -> s.getId() != null && s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Spittle save(Spittle spitter) {
        spittles.add(spitter);
        return spitter;
    }

    @Override
    public Spitter save(Spitter spitter) {
        spitters.add(spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return spitters
                .stream()
                .filter(s -> s.getUserName().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }
}
