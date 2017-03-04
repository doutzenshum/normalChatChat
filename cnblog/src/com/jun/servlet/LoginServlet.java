package com.jun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();//获取cookie对象
        String uname = "";
        String upwd = "";
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("remname")) {
                    uname = cookie.getValue();
                } else if (cookie.getName().equals("rempwd")) {
                    upwd = cookie.getValue();
                }
            }
        }
        //上面代码用来判断用户是否曾保存过登陆信息
        
        
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");    
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>登陆界面</title>");
        out.println("<body>");
        out.println("<div>");
        out.println("<form action='Main' method='post'");
        out.println("<p>用户名：<input type='text' name='username' value=" +uname+ "></p>");
        out.println("<p>密  码：<input type='password' name='password' value=" +upwd+ "></p>");
        out.println("<p>记住密码：<input type='checkbox' name='remember' value='true'>");
        out.println("<input type='submit' name='submit' value='登陆'>");
        out.println("<input type='reset' name='reset' value='重置'></p>");
        out.println("</div>");
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

}