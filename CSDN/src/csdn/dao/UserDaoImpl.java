package csdn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import csdn.model.User;
import csdn.model.article_type;
import csdn.model.aticle;
import csdn.util.DBUtils;

public class UserDaoImpl implements UserDao {

	private QueryRunner runner = null;// 查询运行器

	public UserDaoImpl() {
		runner = new QueryRunner();
	}

	/**
	 * 注册
	 */
	@Override
	public int insert(User user) throws SQLException {
       
		String sql = "insert into user(username,pwd,email,phone,qq,info)values(?,?,?,?,?,?)";
		int i = runner.update(DBUtils.getConnection(), sql, user.getUsername(), user.getPwd(), user.getEmail(), user.getPhone(),
				user.getQq(), user.getInfo());
		return i;

	}

	@Override
	public int update(String pwd,String name) throws SQLException {
		String[] params = {pwd,name};
		String sql = "UPDATE user SET pwd = ? where username=?";
		int i = runner.update(DBUtils.getConnection(), sql,params);
        return i;
	}
  //删除博文
	@Override
	public int delete(int id) throws SQLException {
		String sql = "delete from article where art_id=?";
        int i = runner.update(DBUtils.getConnection(), sql, id);
        return i;

	}

	@Override
	public User findById(int u_id) throws SQLException {
		String sql = "select * from user where id=?";
		User user = runner.query(DBUtils.getConnection(), sql, new BeanHandler<User>(User.class), u_id);
		return user;
	}
    /**
     *   查询所有博文
     */
	@Override
	public List<aticle> findAll() throws SQLException {
		String sql = "select article.*,user.username,aticle_type.type FROM article LEFT JOIN user on article.u_id = user.id LEFT JOIN aticle_type on article.a_type_id = aticle_type.a_type_id";
		List<aticle> list = (List<aticle>) runner.query(DBUtils.getConnection(), sql, new BeanListHandler<aticle>(aticle.class));
		return list;
	}

	

	/**
	 * 验证登陆,注册
	 */
	@Override
	public User QueryByName(String name) throws SQLException {
		String sql = "select * from user where username=?";
		User user = runner.query(DBUtils.getConnection(), sql, new BeanHandler<User>(User.class), name);
		return user;
	}

	/**
	 * 按照分类看博文
	 */
	@Override
	public List<aticle> findAll(int typeid) throws SQLException {
		String sql = "select article.*,user.username,aticle_type.type FROM article LEFT JOIN user on article.u_id = user.id LEFT JOIN aticle_type on article.a_type_id = aticle_type.a_type_id where article.a_type_id=?";
		List<aticle> list = (List<aticle>) runner.query(DBUtils.getConnection(), sql, new BeanListHandler<aticle>(aticle.class),typeid);
		return list;
	}
    /**
     * 查找所有类型
     *//*
	@Override
	public List<article_type> findAlltype() throws SQLException {
		String sql = "select * from aticle_type";
		List<article_type> list = (List<article_type>) runner.query(DBUtils.getConnection(), sql, new BeanListHandler<article_type>(article_type.class));
		return list;
	}*/

	
	 /**
	  * 搜索框查询
	  */
	@Override
	public List<aticle> findAlltype(String query) throws SQLException {
		
		String sql = "select article.*,user.username,aticle_type.type FROM article " + 
				"LEFT JOIN user on article.u_id = user.id " + 
				"LEFT JOIN aticle_type on article.a_type_id = aticle_type.a_type_id " + 
				"where CONCAT(pub_date,type,username,content,title) like '%"+query+"%'";
		List<aticle> list = runner.query(DBUtils.getConnection(), sql, new BeanListHandler<aticle>(aticle.class));
		return list;
	}
	/**
     * 查询博文总数
     */
	@Override
	 public Long aticleCount() throws SQLException{
		 String sql = "select count(*) from article";
		return runner.query(DBUtils.getConnection(),sql, new ScalarHandler<Long>());
	}
	/**
     * 分页查询显示
     */
	@Override
	public List<aticle> findArticles(int page, int count) throws SQLException {
	String sql = "select * from article limit page=?,count=?";
	List<aticle> aticle = new ArrayList<aticle>();
	aticle = runner.query(DBUtils.getConnection(), sql, new BeanListHandler<aticle>(aticle.class));
    
	
		return null;
	}

	@Override
	public List<aticle> findself_art(int id) throws SQLException {
		
		String sql = "select article.*,aticle_type.type FROM article LEFT JOIN user on article.u_id = user.id LEFT JOIN aticle_type on article.a_type_id = aticle_type.a_type_id where u_id = ?";
		List<aticle> list = runner.query(DBUtils.getConnection(), sql, new BeanListHandler<aticle>(aticle.class), id);
		
		return list;
	}

	@Override
	public List<aticle> findself_type(int id, String name) throws SQLException {
		
		String sql =  "select article.*,aticle_type.type FROM article LEFT JOIN user on article.u_id = user.id LEFT JOIN aticle_type on article.a_type_id = aticle_type.a_type_id where article.a_type_id=? and username = ?";
		List<aticle> list = runner.query(DBUtils.getConnection(), sql, new BeanListHandler<aticle>(aticle.class), id,name);
		return list;
	}
  //添加文章
	@Override
	public void add(aticle p) throws SQLException {
		String sql = "insert into article(title,content,pub_date,a_type_id,u_id)values(?,?,?,?,?)";
		runner.update(DBUtils.getConnection(),sql,p.getTitle(),p.getContent(),p.getPub_date(),p.getA_type_id(),p.getU_id());

		
	}
  //readmore
	@Override
	public aticle readmore(int art_id) throws SQLException {
	   String sql ="select article.*,username FROM article LEFT JOIN user on article.u_id = user.id where art_id=?";
	   aticle a = runner.query(DBUtils.getConnection(), sql, new BeanHandler<aticle>(aticle.class), art_id);
	   return a;
	}
 //根据id更新
	@Override
	public int updateById(int art_id, String title, String content, Date date) throws SQLException {
		String sql = "update article set title = ?,content = ?,pub_date=? where art_id =?";
		int i = runner.update(DBUtils.getConnection(), sql, title,content,date,art_id);
		return i;
	}

	
		
	}
	
	

	


