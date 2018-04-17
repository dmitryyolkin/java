package qualifiers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public Dessert cookies() {
        return new Cookies();
    }

}
