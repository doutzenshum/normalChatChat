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
        HttpSession session = request.getSession(true);//�����Ự
        
        username = (String) request.getParameter("username");
        password = (String) request.getParameter("password");
        remember = (String) request.getParameter("remember");
        //�ڿ���̨��������������
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
            response.sendRedirect("LoginSuccessServlet");//��sendRedirectʵ��ҳ����ȫ��ת
        } else if (username != null && username.equals("201321091104") && password.equals("654321")) {
            if (remember != null && remember.equals("true")) {//���û���ѡ��ס���빦��ʱ�������뷵�ظ��ͻ��˱��棬�´η��ʵ�ʱ���ȴӿͻ��˻�ȡ���룬������ʵ���˼�ס���빦��
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
            response.sendRedirect("LoginFail.html");//ҳ����ȫ��ת�������������
        }
    }
 }