package com.jun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSuccessServlet
 */
@WebServlet("/LoginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();//
        String username = "";
        if (session.getAttribute("UserName") != null) {
            username = session.getAttribute("UserName").toString();
        }
     
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>聊天室</title>");
//        out.println("<style type='text/css'>#iframe1{width:600px;height:200px;}iframe{width:600px;height:200px;margin-bottom:20px;}</style>");
        out.println("</head>");
        out.println("<center><h2><b>欢迎使用聊天系统</b></h2>");
        out.println("<lable>当前用户：" + username
                + "</lable><a href=\"LoginOut\"> 退出登录</a><br>");
        out.println("<iframe src='Messagebox' id='iframe1'></iframe>");
        out.println("<br>");
        out.println("<iframe src='Talk'></iframe><br>");
        /*out.println("<frameset rows=\"50%,25%\">");
        out.println("<frame name=\"message\" src=\"Messagebox\" />");
        out.println("<frame name=\"uinput\" src=\"Talk\"/>");
        out.println("</frameset>");
        */
        out.println("</body></html>");
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

    }

}