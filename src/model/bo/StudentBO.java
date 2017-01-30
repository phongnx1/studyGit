package model.bo;

import java.util.ArrayList;
import java.util.StringTokenizer;

import model.bean.Student;
import model.dao.StudentDAO;

public class StudentBO {
	StudentDAO studentDAO = new StudentDAO();

	public ArrayList<Student> getListStudent() {
		// TODO lay danh sach sinh vien
		return studentDAO.getListStudent();
	}

	public String getHobbies(String[] selectedHobbies) {
		// TODO tra ve chuoi cac so thich
		String hobbies = "";
		for (int i = 0; i < selectedHobbies.length; i++) {

			hobbies += selectedHobbies[i];
			if (i < selectedHobbies.length - 1) {
				hobbies += ", ";
			}
		}
		return hobbies;
	}

	public boolean insertStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.insertStudent(student);
	}

	public boolean deleteStudent(String studentID) {
		// TODO Auto-generated method stub
		return studentDAO.deleteStudent(studentID);
	}

	public String[] getSelectedHobbies(String hobbies) {
		// TODO Auto-generated method stub
		String[] selectedHobbies = new String[20];
		StringTokenizer token = new StringTokenizer(hobbies, ",");
		int i = 0;
		while (token.hasMoreTokens()) {
			selectedHobbies[i] = token.nextToken().trim();

			System.out.println(selectedHobbies[i]);
			i++;
		}

		return selectedHobbies;
	}

	public Student getStudentInfo(String studentID) {
		// TODO Auto-generated method stub
		return studentDAO.getStudentInfo(studentID);
	}

	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.updateStudent(student);
	}

}
