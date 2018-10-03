package cn.zy.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.zy.dao.Userdao;
import cn.zy.model.User;
import cn.zy.utils.DataSourceUtils;

/*
 * 实现Userdao接口,重写接口里的方法
 * */
public class RegistDao implements Userdao {

	// 注册方法
	@Override
	public boolean userRegist(User user) throws SQLException {
		// 创建QueryRunner类
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user (username,password,nikename) values(?,?,?)";

		String username = user.getUsername();
		String password = user.getPassword();
		String nikename = user.getNikename();
		Object[] ob = { username, password, nikename };
		int b = qr.update(sql,ob);
		if (b > 0) {

			return true;
		}

		return false;

	}

	// 重写接口的登录方法
	@Override
	public User userLogin(User user) throws Exception {
		User user2 = null;
		ComboPooledDataSource ds = new ComboPooledDataSource();
		Connection conn = ds.getConnection();
		String sql = "select id,username,password,nikename,createDate from user where username =? and password =?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, user.getUsername());
		st.setString(2, user.getPassword());
		ResultSet rs = (ResultSet) st.executeQuery();
		while (rs.next()) {
			user2 = new User();
			user2.setUsername(rs.getString("username"));
			user2.setPassword(rs.getString("password"));
			user2.setNikename(rs.getString("nikename"));
		}
		if (rs != null) {
			rs.close();
		}
		if (conn != null) {
			conn.close();
		}
		if (st != null) {
			st.close();
		}

		return user2;
	}



	
	
	
	
	
	
	
	/* //重写接口的登录方法
		@Override
		public User userLogin(String username ,String password) throws Exception {
			QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select * from user where username =? and password =?";
			
			
			return qr.query(sql, new BeanHandler<>(User.class), username,password);
		}*/
	
	
	
	
	
	
	/*@Test
public void Text() throws SQLException {
	boolean pp= userRegist(new User("123454","44444","hhhh"));
	   System.out.println(pp);
	}*/
}
