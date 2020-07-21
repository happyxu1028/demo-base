package com.lagou.holder;

import javax.servlet.ServletRequest;

/**
 * @Description:
 * @Author: 长灵
 * @Date: 2020-07-19 22:08
 */
public class WebRequestHolder {


    private static  ThreadLocal<ServletRequest> THREAD_LOCAL = new ThreadLocal<>();


    /**
     * 绑定请求到线程的上下文中
     * @param request
     */
    public static void bindRequest(ServletRequest request){
        THREAD_LOCAL.set(request);
    }


    /**
     * 获取请求的上下文
     * @return
     */
    public static ServletRequest getServletRequest(){
        return  THREAD_LOCAL.get();
    }


    /**
     * 手动清空,防止内存泄露
     */
    public static void clean(){
        THREAD_LOCAL.remove();
    }

}
