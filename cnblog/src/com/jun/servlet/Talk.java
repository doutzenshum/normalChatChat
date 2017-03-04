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
        String username = (String) session.getAttribute("UserName");// 将获取的对象强制类型转换为字符串

        out.println("<html><body>");
        out.println("<lable>当前用户：" + username + "</lable><br>");
        out.println("<form action=\"Talk\" method=\"post\">");
        out.println("<div><textarea name=\"userMessages\" cols=\"50\" style=\"height:100px;\"></textarea></div>");
        out.println("<div><input type=\"submit\" id=\"submit\" value=\"发送\"/>");
        out.println("<input type=\"reset\" id=\"reset\" value=\"清空输入\"/></div>");
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
        ServletContext application = this.getServletContext();// 获取上下文信息

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 日期格式
        Date currentTime = new Date();// 得到当前的系统时间
        String str_date1 = formatter.format(currentTime);// 将日期时间格式化 str_date1
        String username = (String) session.getAttribute("UserName");// 将获取的对象强制类型转换为字符串

        PrintWriter out = response.getWriter();

        String mywords = request.getParameter("userMessages");// 获取提交信息的内容
                                                                // mywords
        application.log(mywords);// 在控制台中将提交的内容显示出来
        if (mywords == null) {
            mywords = "系统提示：可以聊天";
            application.setAttribute("words", mywords + "\n");
        } else if (mywords != null) {
            // int len_mywords = mywords.length();
            // application.log("字节长度："+len_mywords);
            mywords = username + ":" + mywords + ":" + str_date1;// 给内容添上其他信息。
            application.log(mywords);//在控制台信息中查看内容
            Object obj = application.getAttribute("words");// 上下文获取 的都是一个对象
            if (obj == null) {
                application.setAttribute("words", mywords + "\n");// 设置成全局变量
            } else {
                application.setAttribute("words", obj.toString() + mywords
                        + "\n");// 当获取的上下文对象不为空时，需要将前面的信息也显示出来
            }
        }

        out.println("<html><body>");
        out.println("<lable>当前用户：" + username + "</lable><br>");
        out.println("<form action=\"Talk\" method=\"post\">");
        out.println("<div><textarea name=\"userMessages\" cols=\"50\" style=\"height:100px;\"></textarea></div>");
        out.println("<div><input type=\"submit\" id=\"submit\" value=\"发送\"/>");
        out.println("<input type=\"reset\" id=\"reset\" value=\"清空输入\"/></div>");
        out.println("</form>");
        out.println("</body></html>");

    }

}