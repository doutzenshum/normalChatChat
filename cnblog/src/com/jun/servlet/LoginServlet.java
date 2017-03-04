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
        Cookie[] cookies = request.getCookies();//��ȡcookie����
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
        //������������ж��û��Ƿ����������½��Ϣ
        
        
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");    
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>��½����</title>");
        out.println("<body>");
        out.println("<div>");
        out.println("<form action='Main' method='post'");
        out.println("<p>�û�����<input type='text' name='username' value=" +uname+ "></p>");
        out.println("<p>��  �룺<input type='password' name='password' value=" +upwd+ "></p>");
        out.println("<p>��ס���룺<input type='checkbox' name='remember' value='true'>");
        out.println("<input type='submit' name='submit' value='��½'>");
        out.println("<input type='reset' name='reset' value='����'></p>");
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