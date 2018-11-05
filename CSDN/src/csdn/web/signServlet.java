package csdn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import csdn.dao.UserDao;
import csdn.dao.UserDaoImpl;
import csdn.model.User;

@WebServlet("/signServlet")
public class signServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public signServlet() {
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
		user.setUsername(request.getParameter("username"));
		user.setPwd(request.getParameter("Password"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		user.setQq(request.getParameter("qq"));
		user.setInfo(request.getParameter("info"));
		//System.out.println(user);
		try {
			if(userdao.QueryByName(request.getParameter("username"))!=null) {
				out.println("您已注册！3秒后进入登陆页面...");
				response.setHeader("Refresh", "3;url=login.jsp");
			}else {
				if(userdao.insert(user)!=0) {
					out.println("注册成功！3秒后进入登录页面...");
					response.setHeader("Refresh", "3;url=login.jsp");
				}else {			
					out.println("注册失败！3秒后返回注册页面...");
					response.setHeader("Refresh", "3;url=register.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
