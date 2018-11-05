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
	
	    // ����û�
	     public int insert(User user) throws SQLException;

	    // ���·���
	    public int update(String pwd,String name) throws SQLException;

	     // ɾ������
	    public int delete(int id) throws SQLException;
	    
	    // ����id����
	     public User findById(int id) throws SQLException;
	    
	     // ���û��Ƿ�ע��
	     public User QueryByName(String name) throws SQLException;
	    
	     // �����������в���
	     public List<aticle> findAll() throws SQLException;
	     
	    // ����������������
	     public List<aticle> findAlltype(String query) throws SQLException;
	     
	  // ���Ҹ��˷��಩��
	     public List<aticle> findself_type(int id,String name) throws SQLException;
	     
	  // ���Ҹ��˲���
	     public List<aticle> findself_art(int id) throws SQLException;
	   
	     //������Ҳ���
	     public List<aticle> findAll(int typeid) throws SQLException;
	     
	     // ��ѯ�м������ļ�¼
	     public Long aticleCount() throws SQLException;
	     
	     //��ҳ��ѯ
	     public List<aticle> findArticles(int page , int count) throws SQLException;
	     
	     //������½������ݿ�
	     public void add(aticle p) throws SQLException;
	     
	     //readmore
	     public aticle readmore(int art_id)  throws SQLException;
	     
	     //��������
	     public int updateById(int id,String title, String content, Date date) throws SQLException;
	  



	    
	 
	  
	
}