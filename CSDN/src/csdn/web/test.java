package csdn.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import csdn.dao.UserDao;
import csdn.dao.UserDaoImpl;
import csdn.model.User;
import csdn.model.aticle;

public class test {

	public static void main(String[] args) throws SQLException {
		
		UserDao dao = new UserDaoImpl();
		User user = dao.QueryByName("Ù»Âé×Ó");
		
		 System.out.println(user.getId());
	}

}
