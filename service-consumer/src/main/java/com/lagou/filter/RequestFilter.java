package com.lagou.filter;


import com.lagou.holder.WebRequestHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Description:
 * @Author: 长灵
 * @Date: 2020-07-19 22:00
 */
@Component
public class RequestFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            WebRequestHolder.bindRequest(servletRequest);
            filterChain.doFilter(servletRequest,servletResponse);
        } finally {
            WebRequestHolder.clean();
        }
    }
}
