package com.jun.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//WebFilter 3.0的特性 过滤器的名称为FirstFilter，过滤的对象为所有的页面urlPatterns={"/*"} ，必须要有 / 号
@WebFilter(filterName="FirstFilter",urlPatterns={"/*"})
public class FirstFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("destroy---FirstFilter");                          
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {

        HttpServletRequest request =(HttpServletRequest) arg0;
        HttpServletResponse response =(HttpServletResponse) arg1;
        //以上是强制内型转换，使用request对象和response对象
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        arg2.doFilter(arg0, arg1);//在页面跳转之前执行此语句前面的代码，执行完页面的代码之后，在执行后面的语句
         }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


}