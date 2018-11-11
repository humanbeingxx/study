package priv.cxs.springboot2.support.web;

import com.google.common.collect.Maps;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author humanbeingxx@sina.com
 * @date 2018/11/11 22:18
 */
public class JobSalaryEncryptFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new ParameterRequestWrapper(request), response);
    }

    @Override
    public void destroy() {

    }

    public static class ParameterRequestWrapper extends HttpServletRequestWrapper {

        private Map<String, String[]> parameter = Maps.newHashMap();

        /**
         * Constructs a request object wrapping the given request.
         *
         * @param request
         * @throws IllegalArgumentException if the request is null
         */
        public ParameterRequestWrapper(ServletRequest request) {
            super((HttpServletRequest) request);
            this.parameter.putAll(request.getParameterMap());
            encrypt();
        }

        private void encrypt() {
            String[] salaries = parameter.get("salary");
            if (salaries == null) {
                return;
            }
            String[] encrypted = new String[salaries.length];
            for (int i = 0; i < salaries.length; i++) {
                String encrypt = String.valueOf(Integer.parseInt(salaries[i]) / 2);
                encrypted[i] = encrypt;
            }
            parameter.put("salary", encrypted);
        }

        @Override
        public String getParameter(String name) {
            String[] value = this.parameter.get(name);
            if (value != null && value.length > 0) {
                return value[0];
            } else {
                return null;
            }
        }

        @Override
        public Map<String, String[]> getParameterMap() {
            return parameter;
        }

        @Override
        public Enumeration<String> getParameterNames() {
            return Collections.enumeration(parameter.keySet());
        }

        @Override
        public String[] getParameterValues(String name) {
            return parameter.get(name);
        }
    }
}
