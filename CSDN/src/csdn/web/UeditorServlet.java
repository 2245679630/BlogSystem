package csdn.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

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

/**
 * Servlet implementation class UeditorServlet
 */
@WebServlet("/UeditorServlet")
public class UeditorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UeditorServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求和响应的编码统一为UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        Date date = new Date();

        //拿到编辑器的内容
        String content = request.getParameter("editorValue");
        String title = request.getParameter("title");
        int type_id = Integer.parseInt(request.getParameter("type"));
        HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println(user.getId());


        //如果不为空
        if(content != null&&title!=null&&(type_id==1||type_id==2||type_id==3)){
            aticle a = new aticle();
            UserDao dao = new UserDaoImpl();
            a.setTitle(title);
            a.setContent(content);
            a.setPub_date(date);
            a.setA_type_id(type_id);
            a.setU_id(user.getId());
            try {
				dao.add(a);
				//将内容设置进属性
	            request.setAttribute("content",content);
	            System.out.println(content);
	            request.getRequestDispatcher("blog.jsp").forward(request, response);
	            //转发到content.jsp
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
           
        }else{
            response.getWriter().append("内容为空!");
            System.out.println("内容为空");
            response.setHeader("refresh", "2;url=addblog.jsp");

        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
