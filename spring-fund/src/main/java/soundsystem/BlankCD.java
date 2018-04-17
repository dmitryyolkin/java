package soundsystem;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (13.04.18)
 */
@Component
// @Profile("prod") - - Profile can  be specified as annotation or in spring config
public class BlankCD implements CD{
    private String title;
    private String artist;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void play() {
        System.out.println(getClass().getSimpleName() + " plays");
        System.out.println("Playing " + title + " by " + artist);
    }
}
