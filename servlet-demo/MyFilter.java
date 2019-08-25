
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MyFilter implements Filter {
    @SuppressWarnings("unused")
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        System.out.println("Filter init...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest) || !(response instanceof HttpServletResponse)) {
            throw new ServletException("FilterUtil just supports HTTP requests");
        }
        System.out.println("Filter doing....");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpRequest.setCharacterEncoding(this.filterConfig.getInitParameter("encoding"));
        httpResponse.setCharacterEncoding(this.filterConfig.getInitParameter("encoding"));
        chain.doFilter(httpRequest, httpResponse);
    }

    @Override
    public void destroy() {
        System.out.println("Filter destory..");
    }
}