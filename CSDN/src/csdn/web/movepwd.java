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

@WebServlet("/movepwd")
public class movepwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public movepwd() {
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
		User user=(User) request.getSession().getAttribute("user");
		
	
		String s = user.getPwd();
		String s0 = user.getUsername();
		String s1 = request.getParameter("pwd");
		String s2 = request.getParameter("password1");
		String s3 = request.getParameter("password2");
		System.out.print(s);
		System.out.print(s0);
		if(s1.equals(s)){
			if(s2.equals(s3)) {
				
				try {
					int i = userdao.update(s2,s0);
					out.println("修改成功，即将跳转到登陆界面！");
					response.setHeader("Refresh", "3;url=login.jsp");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			out.println("修改失败！");
			response.setHeader("Refresh", "3;url=info_self.jsp");
		}
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
