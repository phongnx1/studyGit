package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.ConnectDB;

public class CheckLoginDAO {
	Connection conn = null;
	ResultSet rs = null;

	public int checkLogin(String userName, String password) {
		// TODO Auto-generated method stub
		conn = ConnectDB.connectDatabase();
		String call = "{call sp_checkAccount(?,?)}";
		int access = 0;
		try {
			CallableStatement callableStatement = conn.prepareCall(call);
			callableStatement.setString(1, userName);
			callableStatement.setString(2, password);
			rs = callableStatement.executeQuery();
			while (rs.next()) {
				access= rs.getInt(3);
			}
		} catch (SQLException e) {
			// loi kiem tra tai khoan
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return access;
	}

}
