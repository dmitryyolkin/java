package soundsystem;

import config.CDPlayerConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (10.04.18)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private CD cd;

    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void testWiring() {
        Assert.assertNotNull(cdPlayer);
        Assert.assertNotNull(cd);
    }

    @Test
    public void testPlay() {
        cdPlayer.play();
    }

}
