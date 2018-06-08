package web.spittr.web;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import web.spittr.web.dto.Spitter;
import web.spittr.web.dto.Spittle;

import javax.annotation.PostConstruct;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (01.06.18)
 */
@Component
public class LocalSpittleRepositoryImpl implements SpittleRepository {
    private final List<Spitter> spitters = new ArrayList<>();
    private final List<Spittle> spittles = new ArrayList<>();

    @PostConstruct
    public void init() {
        // set some test data
        spitters.add(new Spitter(
                "john.doe",
                "john",
                "John", "Doe"
        ));

        spittles.add(new Spittle(
                "1st message",
                new Date()
        ));
    }

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
    public void uploadSpitterAvatar(Part avatar) throws IOException {
        // save in tmp dir whose name is specified in SpittrWebAppInitializer.TMP_SPITTR_UPLOADS_DIR
        avatar.write(avatar.getSubmittedFileName());
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
