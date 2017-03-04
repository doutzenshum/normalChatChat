package com.jun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Talk
 */
@WebServlet("/Talk")
public class Talk extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Talk() {
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
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("UserName");// ����ȡ�Ķ���ǿ������ת��Ϊ�ַ���

        out.println("<html><body>");
        out.println("<lable>��ǰ�û���" + username + "</lable><br>");
        out.println("<form action=\"Talk\" method=\"post\">");
        out.println("<div><textarea name=\"userMessages\" cols=\"50\" style=\"height:100px;\"></textarea></div>");
        out.println("<div><input type=\"submit\" id=\"submit\" value=\"����\"/>");
        out.println("<input type=\"reset\" id=\"reset\" value=\"�������\"/></div>");
        out.println("</form>");
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        ServletContext application = this.getServletContext();// ��ȡ��������Ϣ

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ���ڸ�ʽ
        Date currentTime = new Date();// �õ���ǰ��ϵͳʱ��
        String str_date1 = formatter.format(currentTime);// ������ʱ���ʽ�� str_date1
        String username = (String) session.getAttribute("UserName");// ����ȡ�Ķ���ǿ������ת��Ϊ�ַ���

        PrintWriter out = response.getWriter();

        String mywords = request.getParameter("userMessages");// ��ȡ�ύ��Ϣ������
                                                                // mywords
        application.log(mywords);// �ڿ���̨�н��ύ��������ʾ����
        if (mywords == null) {
            mywords = "ϵͳ��ʾ����������";
            application.setAttribute("words", mywords + "\n");
        } else if (mywords != null) {
            // int len_mywords = mywords.length();
            // application.log("�ֽڳ��ȣ�"+len_mywords);
            mywords = username + ":" + mywords + ":" + str_date1;// ����������������Ϣ��
            application.log(mywords);//�ڿ���̨��Ϣ�в鿴����
            Object obj = application.getAttribute("words");// �����Ļ�ȡ �Ķ���һ������
            if (obj == null) {
                application.setAttribute("words", mywords + "\n");// ���ó�ȫ�ֱ���
            } else {
                application.setAttribute("words", obj.toString() + mywords
                        + "\n");// ����ȡ�������Ķ���Ϊ��ʱ����Ҫ��ǰ�����ϢҲ��ʾ����
            }
        }

        out.println("<html><body>");
        out.println("<lable>��ǰ�û���" + username + "</lable><br>");
        out.println("<form action=\"Talk\" method=\"post\">");
        out.println("<div><textarea name=\"userMessages\" cols=\"50\" style=\"height:100px;\"></textarea></div>");
        out.println("<div><input type=\"submit\" id=\"submit\" value=\"����\"/>");
        out.println("<input type=\"reset\" id=\"reset\" value=\"�������\"/></div>");
        out.println("</form>");
        out.println("</body></html>");

    }

}