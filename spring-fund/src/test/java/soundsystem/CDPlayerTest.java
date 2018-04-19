package soundsystem;

import soundsystem.config.separate.SoundSystemConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (10.04.18)
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = CDPlayerComponentScanConfig.class) - component scan
//@ContextConfiguration(classes = CDPlayerWithBeanConfig.class) // -- soundsystem.config with help of @Bean instead of @ComponentScan
@ContextConfiguration(classes = SoundSystemConfig.class) // -- autowiring from xml and JavaConf

// Active profile can be specified with @ActiveProfiles annotation or through web.xml condig
// see p. 71 - Spring in Action
@ActiveProfiles("prod")
public class CDPlayerTest {

    @Autowired
    private CD cd;

    @Autowired
    private CDPlayer cdPlayer;

    @Autowired(required = false)
    private USBPlayer usbPlayer;

    @Test
    public void testWiring() {
        Assert.assertNotNull(cdPlayer);
        Assert.assertNotNull(cd);

        // if we need to have usePlayer bean initialized - please set withUsbSupport = true
        // in UsbSupportedCondition
        Assert.assertNull(usbPlayer);
    }

    @Test
    public void testPlay() {
        cdPlayer.play();
    }

}
