package com.jun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Messagebox
 */
@WebServlet("/Messagebox")
public class Messagebox extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
    
            String temp = (String) getServletConfig().getServletContext()
                    .getAttribute("online");
            if (temp == null)
                temp = "0";
            ServletContext application = this.getServletContext();// ��ȡ��������Ϣ
            String words = (String) application.getAttribute("words");//��д�Ļ�ȡ�ı������Ƕ������Ҫ����ǿ������ת��֮�����ʹ��
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet messagebox</title>");
            out.println("<meta http-equiv=\"refresh\" content =\"2;url=Messagebox\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<p>��ǰ���ߣ�");
            out.println(temp);
            out.println("��</p>");
            out.println("<textarea name=\"messagebox\" cols=\"100\" words=\"400\" style=\"height:400px;\">");
            out.println(words);
            out.println("</textarea>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}