package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author laogao
 * @date 2021/12/6 15:08
 */
@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/intercept2/*", filterName = "annotateFilter")
public class AnnotateFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AnnotateFilter.class);
    private final String name = "annotateFilter";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Filter {} handle before", name);
        chain.doFilter(request, response);
        logger.info("Filter {} handle after", name);
    }
}
