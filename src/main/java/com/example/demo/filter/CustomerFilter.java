package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import javax.servlet.Filter;

/**
 * @author laogao
 * @date 2021/12/6 14:43
 */
public class CustomerFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(CustomerFilter.class);
    private String name;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        name = filterConfig.getInitParameter("name");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Filter {} handle before", name);
        chain.doFilter(request, response);
        logger.info("Filter {} handle after", name);
    }

}
