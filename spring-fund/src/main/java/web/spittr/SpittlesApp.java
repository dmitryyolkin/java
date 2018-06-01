package web.spittr;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (01.06.18)
 */
public class SpittlesApp {

    public static void main(String[] args) throws ServletException, LifecycleException {
        //location with views
        String webAppDirLocation = "src/main/resources";
        Tomcat tomcat = new Tomcat();

        //Set Port #
        tomcat.setPort(8080);

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webAppDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
