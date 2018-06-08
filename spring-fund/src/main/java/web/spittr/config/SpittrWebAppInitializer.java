package web.spittr.config;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import web.spittr.web.SpittlesFilter;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.io.File;

/**
 * This way of context initialization (extending from AbstractAnnotationConfigDispatcherServletInitializer)
 * is a alternative way of traditional initialization with webapp.WEB-INF/web.xml
 *
 * You don't need to register SpittrWebAppInitializer somewhere - it will be searched automatically
 * by Spring
 *
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (11.05.18)
 */
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String TMP_SPITTR_UPLOADS_DIR = "./tmp/spittr/uploads";

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

    @Nullable
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new SpittlesFilter()};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //set temp dir for multipart resolver that can be used for uploading files
        registration.setMultipartConfig(
                new MultipartConfigElement(
                        TMP_SPITTR_UPLOADS_DIR,
                        2097152, // max file part size = 2 MB
                        4194304, // max size of all parts shouldn't exceed 4 MB
                        0 // all parts should be written on disk in tmp dir
                )
        );
    }
}
