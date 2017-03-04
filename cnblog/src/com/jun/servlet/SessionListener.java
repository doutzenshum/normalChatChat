package com.jun.servlet;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
//��������ע��ʹ�÷�����ֱ����һ��ע����У�Ȼ����Ǵ�����ʵ�ּ������Ľӿڣ����Ǽ������ķ�����ʵ��Ӧ���е��߼�
@WebListener("����һ���û���Ϣ������")
public class SessionListener implements HttpSessionListener,
        HttpSessionAttributeListener {
    //������ʵ�ֵ������ӿڣ����ڼ�����������
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
         if(event.getName().equals("UserName"))
            {
                String current = (String) event.getSession().getServletContext().getAttribute("online");//��ȡ��ǰ�û�����
                String info = (String) event.getSession().getServletContext().getAttribute("Words");//��ǰ�û�����Ϣ
                if(info==null)info ="";
                if(current == null) current="0";
                int c=Integer.parseInt(current);
                c++;
                current = String.valueOf(c);
                event.getSession().getServletContext().setAttribute("online", current);
                //event.getSession().getServletContext().setAttribute("Words", info+event.getValue()+" ����������\n");
            }

    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
         if(event.getName().equals("UserName"))
            {
                String current = (String) event.getSession().getServletContext().getAttribute("online");
                String info = (String) event.getSession().getServletContext().getAttribute("Words");
                if(info==null)info ="";
                if(current==null)current = "0";
                int c = Integer.parseInt(current);
                c--;
                current = String.valueOf(c);
                event.getSession().getServletContext().setAttribute("online", current);
                event.getSession().getServletContext().setAttribute("Words", info+event.getValue()+" �뿪��������\n");
            }

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void sessionCreated(HttpSessionEvent event) {
         
     /*   String current = (String) event.getSession().getServletContext().getAttribute("online");//��ȡ��ǰ�û����� 
        if(current == null) current="0";
        int c=Integer.parseInt(current);
        c++;
        current = String.valueOf(c);
        event.getSession().getServletContext().setAttribute("online", current);*/
               
            

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
         
 /*       String current = (String) event.getSession().getServletContext().getAttribute("online");//��ȡ��ǰ�û����� 
        if(current == null) current="0";
        int c=Integer.parseInt(current);
        c++;
        current = String.valueOf(c);
        event.getSession().getServletContext().setAttribute("online", current);*/

    }

}