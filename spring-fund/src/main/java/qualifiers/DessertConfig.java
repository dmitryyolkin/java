package qualifiers;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (17.04.18)
 */
@Configuration
public class DessertConfig {

    @Bean
    @Cold
    public Dessert iceCream() {
        return new IceCream();
    }

    @Bean
    @Crispy
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // singleton
    // @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // new instance for each inject
    public Dessert cookies() {
        return new Cookies();
    }

}
