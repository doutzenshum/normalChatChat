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

//WebFilter 3.0������ ������������ΪFirstFilter�����˵Ķ���Ϊ���е�ҳ��urlPatterns={"/*"} ������Ҫ�� / ��
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
        //������ǿ������ת����ʹ��request�����response����
        
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        arg2.doFilter(arg0, arg1);//��ҳ����ת֮ǰִ�д����ǰ��Ĵ��룬ִ����ҳ��Ĵ���֮����ִ�к�������
         }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }


}