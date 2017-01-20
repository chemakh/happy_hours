package com.ch.happyhours.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.*;

//TODO I've created this filter to simulate a current user
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@ConditionalOnProperty(prefix = "happy-hours.test", value = "enabled")
public class StubSecurityFilter implements Filter
{
    @Value("${happy-hours.test.token}")
    private String token;

    @Override
    public void destroy()
    {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) request;
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
//        String token = req.getHeader("Authorization") ;
        requestWrapper.addHeader("Authorization", "Bearer " + token);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    public class HeaderMapRequestWrapper extends HttpServletRequestWrapper
    {
        /**
         * construct a wrapper for this request
         *
         * @param request
         */
        public HeaderMapRequestWrapper(HttpServletRequest request)
        {
            super(request);
        }

        private Map<String, String> headerMap = new HashMap<String, String>();

        /**
         * add a header with given name and value
         *
         * @param name
         * @param value
         */
        public void addHeader(String name, String value)
        {
            headerMap.put(name, value);
        }

        @Override
        public String getHeader(String name)
        {
            String headerValue = super.getHeader(name);
            if (headerMap.containsKey(name))
            {
                headerValue = headerMap.get(name);
            }
            return headerValue;
        }

        /**
         * get the Header names
         */
        @Override
        public Enumeration<String> getHeaderNames()
        {
            List<String> names = Collections.list(super.getHeaderNames());
            for (String name : headerMap.keySet())
            {
                names.add(name);
            }
            return Collections.enumeration(names);
        }

        @Override
        public Enumeration<String> getHeaders(String name)
        {
            List<String> values = Collections.list(super.getHeaders(name));
            if (headerMap.containsKey(name))
            {
                values.add(headerMap.get(name));
            }
            return Collections.enumeration(values);
        }

    }
}
