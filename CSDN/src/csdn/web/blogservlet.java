package csdn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csdn.dao.UserDao;
import csdn.dao.UserDaoImpl;
import csdn.model.User;
import csdn.model.aticle;

@WebServlet("/blogservlet")
public class blogservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public blogservlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		UserDao userdao = null;
		try {
			   userdao = new UserDaoImpl();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		User user = (User) request.getSession().getAttribute("user");
		int i = user.getId();
		System.out.println(i);
		 try {
			List<aticle> list = userdao.findself_art(i);
			HttpSession session = request.getSession();
			  session.setAttribute("list", list);
			  request.getRequestDispatcher("/blog.jsp").forward(request, response);
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
