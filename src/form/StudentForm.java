package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Student;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class StudentForm extends ActionForm{
	private String studentID;
	private String fullName;
	private String birthday;
	private String sex;
	private String class_name;
	private ArrayList<Student> listStudent=null;
	private String[] hobbies = {"Xem Phim","Cầu Lông","Bóng Chuyền","Bóng Đá","Mua Sắm"};
	private String[] selectedHobbies =null;
	
	
	
	
	
	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	

	public String[] getSelectedHobbies() {
		return selectedHobbies;
	}

	public void setSelectedHobbies(String[] selectedHobbies) {
		this.selectedHobbies = selectedHobbies;
	}

	public ArrayList<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(ArrayList<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	

	private static final long serialVersionUID = 1L;

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors actionErrors = new ActionErrors();

		return actionErrors;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		studentID="";
		fullName="";
		birthday="";
		sex="";
		class_name="";
		selectedHobbies=null;
	}
}
