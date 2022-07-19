package com.accenture.lkm.dao;
import com.accenture.lkm.business.bean.LoginBean;
public class LoginDao {
	public String validateLogin(LoginBean loginBean) {
		String uname = loginBean.getUserName();
		String password = loginBean.getPassword();
		if(uname.eqauls("MSD") && password.equals("MSD@123")) {
			return "success";
		}
		else {
			return "failure";
		}
	}
}
