package priv.cxs.springboot2.support;

import org.springframework.beans.factory.annotation.Autowired;
import priv.cxs.springboot2.service.JobService;

import javax.annotation.Resource;
import javax.servlet.*;
import java.io.IOException;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/5 下午5:46
 **/
public class TestFilter implements Filter {

    @Autowired
    private JobService jobService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(servletRequest.getParameter("name"));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
