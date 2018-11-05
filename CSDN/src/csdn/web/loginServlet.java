package csdn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import csdn.dao.UserDao;
import csdn.dao.UserDaoImpl;
import csdn.model.User;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public loginServlet() {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new User();
		String username = request.getParameter("username");
		String pwd = request.getParameter("Password");
		
		try {
			user = userdao.QueryByName(username);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user.getPwd().equals(pwd)) {
			try {
				user = userdao.QueryByName(username);
				HttpSession session = request.getSession();
				session.setAttribute("user",user);
				request.getRequestDispatcher("/blog.jsp").forward(request, response);
			
				out.println("登陸成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			
		}else{
			out.println("帐户名或密码错误，请重新登陆...");
			response.setHeader("Refresh", "3;url=login.jsp");
		}
		}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
