package model.bo;

import model.dao.CheckLoginDAO;

public class CheckLoginBO {
	CheckLoginDAO checkLoginDAO =new CheckLoginDAO();
	public int checkLogin(String userName, String password) {
		// TODO kiem tra account
		return checkLoginDAO.checkLogin(userName,password);
	}
	

}
