package web.spittr.web;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author dmitry.yolkin (dmitry.yolkin@maxifier.com) (30.05.18)
 */
public class SpittlesFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SpittlesFilter.init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("SpittlesFilter.doFilter: " + request);

        // if you want to invoke your Controller that chain.doFilter MUST be invoked
        // it's similar with middleware functions next() in Node.js
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("SpittlesFilter.destroy");
    }
}
