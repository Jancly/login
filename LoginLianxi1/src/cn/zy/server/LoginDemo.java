package cn.zy.server;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;



import cn.zy.dao.Userdao;
import cn.zy.implement.RegistDao;
import cn.zy.instrument.MyConventer;
import cn.zy.model.User;
import cn.zy.utils.MD5Utils;

@WebServlet("/jsp/login")
public class LoginDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		String username = request.getParameter("username");
		String ps = request.getParameter("password");
		MD5Utils m = new MD5Utils();
		String password = m.md5(ps);
		System.out.println(username+"---"+password);
         
	User user = new User(username,password);
		
	
		Userdao u = new RegistDao();
		
	
		
		
			User use1 = null;
			try {
				use1 = u.userLogin(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		

		if (use1 == null) {

			response.sendRedirect("error.jsp");
			System.out.println(use1);
		} else {
			System.out.println(use1);
			response.sendRedirect("success.jsp");
		}
	}

}
