package web.spittr.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This way of context initialization (extending from AbstractAnnotationConfigDispatcherServletInitializer)
 * is a alternative way of traditional initialization with WEB-INF/web.xml
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (11.05.18)
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Nullable
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //Config loaded by ContextLoaderListener
        //usually middle-tier and data-tier beans (not related to DispatcherServlet directly)
        //are registered here
        return new Class<?>[] {RootConfig.class};
    }

    @Nullable
    @Override
    protected Class<?>[] getServletConfigClasses() {
        //Config that should be used for initialization of application context
        //by DispatcherServlet (such as Controllers, View Resolvers, Handler Mapping)
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        //it specifies that this DispatcherServlet will be used as a default servlet in app
        return new String[]{"/"};
    }
}
