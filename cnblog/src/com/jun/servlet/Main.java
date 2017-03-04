package com.jun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Main
 */
@WebServlet(name = "Main", urlPatterns = { "/Main" })
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username, password, remember;
        HttpSession session = request.getSession(true);//开启会话
        
        username = (String) request.getParameter("username");
        password = (String) request.getParameter("password");
        remember = (String) request.getParameter("remember");
        //在控制台中输出，方便审查
        System.out.println("remember:" + remember);
        System.out.println(username);
        System.out.println(password);
        
        if (username != null && username.equals("201321091103") && password.equals("123456")) {
            if (remember != null && remember.equals("true")) {
                Cookie cookie1 = new Cookie("remname", username);
                Cookie cookie2 = new Cookie("rempwd", password);
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                
                
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            session.setAttribute("UserName", username);
            session.setAttribute("IsLogin", "true");
            response.sendRedirect("LoginSuccessServlet");//用sendRedirect实现页面完全跳转
        } else if (username != null && username.equals("201321091104") && password.equals("654321")) {
            if (remember != null && remember.equals("true")) {//当用户勾选记住密码功能时，将密码返回给客户端保存，下次访问的时候先从客户端获取密码，这样就实现了记住密码功能
                Cookie cookie1 = new Cookie("remname", username);
                Cookie cookie2 = new Cookie("rempwd", password);
                cookie1.setMaxAge(60 * 60 * 24 * 7);
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie1);
                response.addCookie(cookie2);
            }
            session.setAttribute("UserName", username);
            session.setAttribute("IsLogin", "true");
            response.sendRedirect("LoginSuccessServlet");
        } else {
            session.setAttribute("IsLogin", "false");
            response.sendRedirect("LoginFail.html");//页面完全跳转，不会出现乱码
        }
    }
 }