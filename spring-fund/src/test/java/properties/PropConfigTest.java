package properties;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (19.04.18)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PropConfig.class)
public class PropConfigTest {

    @Autowired
    private Environment environment;

    @Test
    public void testProp() {
        Assert.assertEquals(environment.getProperty("app.name"), "Test App");
        Assert.assertEquals(environment.getProperty("app.version"), "1.0.0");
    }

}
