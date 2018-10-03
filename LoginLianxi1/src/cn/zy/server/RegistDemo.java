package cn.zy.server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.ConvertUtils;

import cn.zy.dao.Userdao;
import cn.zy.implement.RegistDao;
import cn.zy.instrument.MyConventer;
import cn.zy.model.User;
import cn.zy.utils.MD5Utils;

@WebServlet("/jsp/regist")
public class RegistDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//super.doPost(req, resp);
		//request.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		String username = request.getParameter("username");
		String ps = request.getParameter("password");
		String nikename = request.getParameter("nikename");
		MD5Utils m = new MD5Utils();
		String password = m.md5(ps);

		User user = new User(username, password, nikename);
		//ConvertUtils.register(new MyConventer(), Date.class);
		Userdao userdao = new RegistDao();
		boolean b = false;

		try {
			b = userdao.userRegist(user);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(b) {
			response.sendRedirect("login.jsp");
		}else {
			response.sendRedirect("regist.jsp");
		}

	}
	
	
	

}
