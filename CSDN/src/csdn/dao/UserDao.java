package csdn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import csdn.model.User;
import csdn.model.article_type;
import csdn.model.aticle;

public interface UserDao {
	
	    // 添加用户
	     public int insert(User user) throws SQLException;

	    // 更新方法
	    public int update(String pwd,String name) throws SQLException;

	     // 删除方法
	    public int delete(int id) throws SQLException;
	    
	    // 根据id查找
	     public User findById(int id) throws SQLException;
	    
	     // 看用户是否注册
	     public User QueryByName(String name) throws SQLException;
	    
	     // 查找网上所有博文
	     public List<aticle> findAll() throws SQLException;
	     
	    // 查找网上所有类型
	     public List<aticle> findAlltype(String query) throws SQLException;
	     
	  // 查找个人分类博文
	     public List<aticle> findself_type(int id,String name) throws SQLException;
	     
	  // 查找个人博文
	     public List<aticle> findself_art(int id) throws SQLException;
	   
	     //分类查找博文
	     public List<aticle> findAll(int typeid) throws SQLException;
	     
	     // 查询有几条博文记录
	     public Long aticleCount() throws SQLException;
	     
	     //分页查询
	     public List<aticle> findArticles(int page , int count) throws SQLException;
	     
	     //添加文章进入数据库
	     public void add(aticle p) throws SQLException;
	     
	     //readmore
	     public aticle readmore(int art_id)  throws SQLException;
	     
	     //更新文章
	     public int updateById(int id,String title, String content, Date date) throws SQLException;
	  



	    
	 
	  
	
}