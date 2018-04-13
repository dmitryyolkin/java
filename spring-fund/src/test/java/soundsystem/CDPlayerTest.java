package soundsystem;

import config.CDPlayerComponentScanConfig;
import config.separate.SoundSystemConfig;
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
//@ContextConfiguration(classes = CDPlayerComponentScanConfig.class) - component scan
//@ContextConfiguration(classes = CDPlayerWithBeanConfig.class) // -- config with help of @Bean instead of @ComponentScan
@ContextConfiguration(classes = SoundSystemConfig.class) // -- autowiring from xml and JavaConf
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
