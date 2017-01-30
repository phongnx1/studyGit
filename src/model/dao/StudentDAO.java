package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import common.ConnectDB;
import common.Convert;
import model.bean.Student;

public class StudentDAO {
	Connection conn = null;
	ResultSet rs = null;

	public ArrayList<Student> getListStudent() {
		// TODO lay danh sach sinh vien
		conn = ConnectDB.connectDatabase();
		String call = "{call sp_getListStudent()}";
		ArrayList<Student> listStudent = new ArrayList<Student>();

		Student student = null;
		try {
			CallableStatement callableStatement = conn.prepareCall(call);

			rs = callableStatement.executeQuery();

			while (rs.next()) {
				student = new Student();
				student.setStudentID(rs.getString(1));
				student.setFullName(rs.getString(2));
				student.setBirthday(Convert.convertDateToString(rs.getDate(3)));
				student.setSex(rs.getString(4));
				student.setClass_name(rs.getString(5));
				student.setHobbies(rs.getString(6));

				listStudent.add(student);

			}
		} catch (SQLException e) {
			System.out.println("loi lay danh sach sinh vien");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listStudent;
	}

	public boolean insertStudent(Student student) {
		// TODO them moi sinh vien
		conn = ConnectDB.connectDatabase();
		String call = "{call sp_insertStudent(?,?,?,?,?,?)}";
		try {
			CallableStatement callableStatement = conn.prepareCall(call);
			callableStatement.setString(1, student.getStudentID());
			callableStatement.setString(2, student.getFullName());
			callableStatement.setString(3, student.getBirthday());
			callableStatement.setString(4, student.getSex());
			callableStatement.setString(5, student.getClass_name());
			callableStatement.setString(6, student.getHobbies());
			callableStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("loi insert sinh vien");
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean deleteStudent(String studentID) {
		// TODO xoa sinh vien
		conn = ConnectDB.connectDatabase();
		String call = "{call sp_deleteStudent(?)}";
		try {
			CallableStatement callableStatement = conn.prepareCall(call);
			callableStatement.setString(1, studentID);

			callableStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("loi delete sinh vien");
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public Student getStudentInfo(String studentID) {
		// TODO Lay thong tin sinh vien
		conn = ConnectDB.connectDatabase();
		String call = "{call sp_getStudentInfo(?)}";

		Student student = null;
		try {
			CallableStatement callableStatement = conn.prepareCall(call);
			callableStatement.setString(1, studentID);
			rs = callableStatement.executeQuery();

			while (rs.next()) {
				student = new Student();
				student.setStudentID(rs.getString(1));
				student.setFullName(rs.getString(2));
				student.setBirthday(Convert.convertDateToString(rs.getDate(3)));
				student.setSex(rs.getString(4));
				student.setClass_name(rs.getString(5));
				student.setHobbies(rs.getString(6));

			}
		} catch (SQLException e) {
			System.out.println("loi lay thong tin sinh vien");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return student;
	}

	public boolean updateStudent(Student student) {
		// TODO Cap nhat thong tin nhan vien
		conn = ConnectDB.connectDatabase();
		String call = "{call sp_updateStudent(?,?,?,?,?,?)}";
		try {
			CallableStatement callableStatement = conn.prepareCall(call);
			callableStatement.setString(1, student.getStudentID());
			callableStatement.setString(2, student.getFullName());
			callableStatement.setString(3, student.getBirthday());
			callableStatement.setString(4, student.getSex());
			callableStatement.setString(5, student.getClass_name());
			callableStatement.setString(6, student.getHobbies());
			callableStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("loi update sinh vien");
			e.printStackTrace();
			return false;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
