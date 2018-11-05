package csdn.web;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csdn.dao.UserDao;
import csdn.dao.UserDaoImpl;

@WebServlet("/updateart")
public class updateart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public updateart() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); /*解决中文乱码问题*/
		   response.setContentType("text/html;charset=utf-8"); 
		   response.setCharacterEncoding("utf-8");
		   HttpSession session = request.getSession();
		   int id = (int) session.getAttribute("id");
		   System.out.println(id);
		   String title = request.getParameter("title");
		   String content =request.getParameter("editorValue");
		   System.out.println(content);
		   Date date = new Date(); //获取系统时间 
		   UserDao dao = new UserDaoImpl();
		   int i;
		try {
			i = dao.updateById(id, title, content, date);
			 System.out.println("i"+i);
			   if(i == 0) {
				   response.getWriter().append("修改失败!");
			   }
			   request.getRequestDispatcher("blog.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
